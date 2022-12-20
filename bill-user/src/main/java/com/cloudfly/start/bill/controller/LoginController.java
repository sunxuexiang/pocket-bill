package com.cloudfly.start.bill.controller;

import com.cloudfly.start.bill.entity.BillUser;
import com.cloudfly.start.bill.service.BillUserService;
import com.cloudfly.start.bill.utils.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill-user")
public class LoginController {

    @Autowired
    private BillUserService billUserService;

    @RequestMapping("/login")
    public R login(@Param("code") String code) throws Exception{
        return billUserService.Login(code);
    }

    @RequestMapping("/addUser")
    public R addUser(@RequestBody BillUser billUser) {
        return billUserService.addUser(billUser);
    }

    @RequestMapping("/queryUser")
    public R queryUser(){
        return billUserService.queryUserInfo();
    }

    @RequestMapping("/send")
    public R send() {
        System.out.println("sss");
        return R.ok();
    }
}
