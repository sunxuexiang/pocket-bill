package com.cloudfly.start.bill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloudfly.start.bill.contants.CommonContant;
import com.cloudfly.start.bill.entity.BillBookInfoEntity;
import com.cloudfly.start.bill.entity.BillBookInfo;
import com.cloudfly.start.bill.entity.BillUser;
import com.cloudfly.start.bill.mapper.BillBookInfoMapper;
import com.cloudfly.start.bill.remoteapi.UserFeignService;
import com.cloudfly.start.bill.service.BillBookInfoService;
import com.cloudfly.start.bill.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<BillBookInfoEntity> billBookInfos=billBookInfoMapper.queryBillDetailsCustomize(bookId,infoRemark,startTime,
                endTime, startMoney, endMoney,userName);
        BigDecimal totalIn = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalOut = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        Map<String,Object> details=new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String,Object>> detailsList=new ArrayList<>();
        List<BillBookInfoEntity> bbiList=new ArrayList<>();
        //处理只有一条数据的
        if(billBookInfos.size()==1){
            BillBookInfoEntity billBookInfoEntity=billBookInfos.get(0);
            if(billBookInfoEntity.getInfoPayType()==1){
                totalIn=totalIn.add(billBookInfoEntity.getInfoMoney());
            }else{
                totalOut=totalOut.add(billBookInfoEntity.getInfoMoney());
            }
            details.put("dayIn",new BigDecimal(0));
            details.put("dayOut",new BigDecimal(0));
            concatDayInOrOut(billBookInfoEntity,details);
            bbiList.add(billBookInfoEntity);
            details.put("infoDate",billBookInfoEntity.getInfoDate());
            details.put("bookInfos",bbiList);
            detailsList.add(details);
        }else{
            for(int i=0;i<billBookInfos.size()-1;i++){
                //取上一条数据
                BillBookInfoEntity bbis=billBookInfos.get(i);
                //取下一条数据
                BillBookInfoEntity bbid=billBookInfos.get(i+1);
                String bbisDay=sdf.format(bbis.getInfoDate());
                String bbidDay=sdf.format(bbid.getInfoDate());
                //计算当前总收入或指出
                if(bbis.getInfoPayType()==1){
                    totalIn=totalIn.add(bbis.getInfoMoney());
                }else{
                    totalOut=totalOut.add(bbis.getInfoMoney());
                }
                //初始化dayIn和dayOut 避免后续计算没有初始化报错
                if(details.get("dayIn") == null || details.get("dayOut") == null){
                    details.put("dayIn",new BigDecimal(0));
                    details.put("dayOut",new BigDecimal(0));
                }

                if(StringUtils.isNotEmpty(bbisDay)&&bbisDay.equals(bbidDay)){
                    //如果上一条和下一条相等 直接计算dayIn或者dayOut
                    concatDayInOrOut(bbis,details);
                    bbiList.add(bbis);
                }else{
                    //如果不相等，则直接将上一条数据汇
                    concatDayInOrOut(bbis,details);
                    bbiList.add(bbis);
                    details.put("infoDate",bbis.getInfoDate());
                    details.put("bookInfos",bbiList);
                    detailsList.add(details);
                    //重新初始化存储数据的对象
                    bbiList=new ArrayList<>();
                    details=new HashMap<>();
                }
                //处理最后一条数据
                if(i==billBookInfos.size()-2){
                    if(bbid.getInfoPayType()==1){
                        totalIn=totalIn.add(bbid.getInfoMoney());
                    }else{
                        totalOut=totalOut.add(bbid.getInfoMoney());
                    }
                    if(StringUtils.isNotEmpty(bbisDay)&&bbisDay.equals(bbidDay)){
                        concatDayInOrOut(bbid,details);
                    }else{
                        //如果最后一条数据和前一条不相等 就重新生成一条信数据包含列表
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
        }

        Map<String,Object> result=new HashMap<>();
        result.put("totalIn", totalIn);
        result.put("totalOut", totalOut);
        result.put("balance", totalIn.subtract(totalOut));
        result.put(CommonContant.DATA_FIELD,detailsList);
        return result;
    }

    private void concatDayInOrOut(BillBookInfoEntity bbi, Map<String,Object> details){
        if(bbi.getInfoPayType()==1){
            details.put("dayIn",((BigDecimal)details.get("dayIn")).add(bbi.getInfoMoney()));
        }else{
            details.put("dayOut",((BigDecimal)details.get("dayOut")).add(bbi.getInfoMoney()));
        }
    }

    private void dealLastData(){

    }
}
