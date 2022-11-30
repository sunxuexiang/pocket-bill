package com.cloudfly.start.bill.service;


import com.cloudfly.start.bill.entity.BillBook;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="bill-gather")
public interface RemoteGatherServiceImpl {

    @RequestMapping("/gatherController/getGather")
    public String getGather();
}
