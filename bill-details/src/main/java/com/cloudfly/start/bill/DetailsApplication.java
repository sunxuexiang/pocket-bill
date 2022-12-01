package com.cloudfly.start.bill;

import com.cloudfly.start.bill.config.CommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CommonConfig.class})
@EnableFeignClients
public class DetailsApplication {

	public static void main(String[] args) {

		SpringApplication.run(DetailsApplication.class, args);
	}

}
