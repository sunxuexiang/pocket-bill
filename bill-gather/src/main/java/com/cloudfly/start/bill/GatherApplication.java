package com.cloudfly.start.bill;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import com.cloudfly.start.bill.controller.BillBookAnnualSummaryController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
@MapperScan("com.cloudfly.start.bill.mapper")
public class GatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatherApplication.class, args);
	}

}
