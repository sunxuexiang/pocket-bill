package com.cloudfly.start.bill.controller;


import com.cloudfly.start.bill.entity.BillBookInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bookKeeping")
@RestController
public class BookKeepingController {

    @RequestMapping("/addBookInfo")
    public void addBookInfo(@RequestBody BillBookInfo billBookInfo){

    }

    @RequestMapping("/updateBookInfo")
    public void updateBookInfo(@RequestParam("bookInfoId") String bookInfoId){

    }

    @RequestMapping("/removeBookInfo")
    public void removeBookInfo(@RequestParam("bookInfoId") String bookInfoId){

    }


}
