package com.cloudfly.start.bill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.dao.BillBookInfoDao;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.entity.BillUser;
import com.cloudfly.start.bill.mapper.BillBookInfoMapper;
import com.cloudfly.start.bill.remoteapi.UserFeignService;
import com.cloudfly.start.bill.service.BillBookInfoService;
import com.cloudfly.start.bill.utils.JwtUtils;
import com.cloudfly.start.bill.utils.R;
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

    @Autowired
    private UserFeignService userFeignService;

    /**
     * @param billBookInfo
     */
    @Override
    public void addBookInfo(BillBookInfo billBookInfo) {
        billBookInfo.setUserId(JwtUtils.getCurrentLoginUser());
        if (this.save(billBookInfo)) {
            // 修改记账次数和记账天数
            BillUser billUser = userFeignService.queryUser();
            billUser.setBillCount(billUser.getBillCount()==null?1:billUser.getBillCount()+1);
            int i = billBookInfoMapper.queryCurrentData();
            if (i == 0) {
                billUser.setBillDay(billUser.getBillDay()==null?1:billUser.getBillDay()+1);
            }
            userFeignService.addUser(billUser);
        }
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
        List<BillBookInfoDao> billBookInfos=billBookInfoMapper.queryBillDetailsCustomize(bookId,infoRemark,startTime,
                endTime, startMoney, endMoney,userName);
        BigDecimal totalIn = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalOut = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        BigDecimal balance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        Map<String,Object> details=new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String,Object>> detailsList=new ArrayList<>();
        List<BillBookInfoDao> bbiList=new ArrayList<>();
        for(int i=0;i<billBookInfos.size()-1;i++){
            BillBookInfoDao bbis=billBookInfos.get(i);
            BillBookInfoDao bbid=billBookInfos.get(i);
            String bbisDay=sdf.format(bbis.getInfoDate());
            String bbidDay=sdf.format(bbid.getInfoDate());
            if(bbis.getInfoPayType()==1){
                totalIn=totalIn.add(bbis.getInfoMoney());
            }else{
                totalOut=totalOut.add(bbis.getInfoMoney());
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
                if(bbis.getInfoPayType()==1){
                    totalIn=totalIn.add(bbis.getInfoMoney());
                }else{
                    totalOut=totalOut.add(bbis.getInfoMoney());
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
        result.put("totalIn", totalIn);
        result.put("totalOut", totalOut);
        result.put("totalOut", totalIn.subtract(totalOut));
        result.put(CommonContant.DATA_FIELD,detailsList);
        return result;
    }

    private void concatDayInOrOut(BillBookInfoDao bbi,Map<String,Object> details){
        if(bbi.getInfoPayType()==1){
            details.put("dayIn",((BigDecimal)details.get("dayIn")).add(bbi.getInfoMoney()));
        }else{
            details.put("dayOut",((BigDecimal)details.get("dayOut")).add(bbi.getInfoMoney()));
        }
    }
}
