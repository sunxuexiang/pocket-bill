package com.cloudfly.start.bill.remoteapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="bill-gather")
public interface GatherFeignService {


    @RequestMapping("/gatherController/getGather")
    String getGather();

}
