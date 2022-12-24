package com.cloudfly.start.bill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.mapper.BillBookInfoMapper;
import com.cloudfly.start.bill.service.BillBookInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BillBookInfoServiceImpl extends ServiceImpl<BillBookInfoMapper, BillBookInfo> implements BillBookInfoService  {


    @Autowired
    private BillBookInfoMapper billBookInfoMapper;

    /**
     * @param billBookInfo
     */
    @Override
    public void addBookInfo(BillBookInfo billBookInfo) {
        this.save(billBookInfo);
    }

    /**
     * @param billBookInfo
     */
    @Override
    public void updateBookInfoById(BillBookInfo billBookInfo) {
        this.updateById(billBookInfo);
    }

    /**
     * @param bookInfoId
     */
    @Override
    public void removeBookInfoById(String bookInfoId) {
        this.removeById(bookInfoId);
    }

    @Override
    public Map<String,Object> queryBillDetailsCustomize(Integer bookId, String infoRemark,Date startTime, Date endTime,
                                                        BigDecimal startMoney, BigDecimal endMoney,String userName) {
        List<BillBookInfo> billBookInfos=billBookInfoMapper.queryBillDetailsCustomize(bookId,infoRemark,startTime,
                endTime, startMoney, endMoney,userName);
        BigDecimal monthIn = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        BigDecimal monthOut = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        Map<String,Object> details=new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String,Object>> detailsList=new ArrayList<>();
        List<BillBookInfo> bbiList=new ArrayList<>();
        for(int i=0;i<billBookInfos.size()-1;i++){
            BillBookInfo bbis=billBookInfos.get(i);
            BillBookInfo bbid=billBookInfos.get(i);
            String bbisDay=sdf.format(bbis.getInfoDate());
            String bbidDay=sdf.format(bbid.getInfoDate());
            if(bbis.getInfoRapType()==1){
                monthIn=monthIn.add(bbis.getInfoMoney());
            }else{
                monthOut=monthOut.add(bbis.getInfoMoney());
            }
            if(details.get("dayIn") == null || details.get("dayOut") == null){
                details.put("dayIn",new BigDecimal(0));
                details.put("dayOut",new BigDecimal(0));
            }
            if(StringUtils.isNotEmpty(bbisDay)&&bbisDay.equals(bbidDay)){
                concatDayInOrOut(bbis,details);
                bbiList.add(bbis);
            }else{
                concatDayInOrOut(bbis,details);
                bbiList.add(bbis);
                details.put("infoDate",bbis.getInfoDate());
                details.put("bookInfos",bbiList);
                detailsList.add(details);
                bbiList=new ArrayList<>();
                details=new HashMap<>();
            }
            if(i==billBookInfos.size()-2){
                if(bbis.getInfoRapType()==1){
                    monthIn=monthIn.add(bbis.getInfoMoney());
                }else{
                    monthOut=monthOut.add(bbis.getInfoMoney());
                }
                if(StringUtils.isNotEmpty(bbisDay)&&bbisDay.equals(bbidDay)){
                    concatDayInOrOut(bbid,details);
                }else{
                    details.put("dayIn",new BigDecimal(0));
                    details.put("dayOut",new BigDecimal(0));
                    concatDayInOrOut(bbid,details);
                }
                bbiList.add(bbid);
                details.put("infoDate",bbid.getInfoDate());
                details.put("bookInfos",bbiList);
                detailsList.add(details);
            }
        }
        Map<String,Object> result=new HashMap<>();
        result.put("monthIn", monthIn);
        result.put("monthOut", monthOut);
        result.put(CommonContant.DATA_FIELD,detailsList);
        return result;
    }

    private void concatDayInOrOut(BillBookInfo bbi,Map<String,Object> details){
        if(bbi.getInfoRapType()==1){
            details.put("dayIn",((BigDecimal)details.get("dayIn")).add(bbi.getInfoMoney()));
        }else{
            details.put("dayOut",((BigDecimal)details.get("dayOut")).add(bbi.getInfoMoney()));
        }
    }
}
