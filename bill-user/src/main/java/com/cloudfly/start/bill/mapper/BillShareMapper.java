package com.cloudfly.start.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudfly.start.bill.entity.BillAndUser;
import com.cloudfly.start.bill.entity.BillBook;
import com.cloudfly.start.bill.entity.BillShare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BillShareMapper extends BaseMapper<BillShare>{

    BillAndUser queryByBillAndUserId(@Param("billBookId") Integer billBookId);

    BillBook queryBillByBookIdAndUserId(@Param("bookId") Integer bookId,@Param("userId")Integer userId);

    void updateShareBillBatch(@Param("bookId")Integer bookId,@Param("sharePower")Integer sharePower);

    List<Map<String,String>> queryUserByBookId(@Param("bookId")Integer bookId);

    void updateUserBillPermession(Integer shareId,Integer sharePower,Integer currentUser);
}
