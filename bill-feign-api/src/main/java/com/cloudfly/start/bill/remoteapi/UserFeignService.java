package com.cloudfly.start.bill.remoteapi;

import com.cloudfly.start.bill.entity.BillUser;
import com.cloudfly.start.bill.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="bill-user")
public interface UserFeignService {


    @RequestMapping("/bill-user/feignQueryUser")
    BillUser queryUser();

    @RequestMapping("/bill-user/addUser")
    void addUser(BillUser billUser);

}
