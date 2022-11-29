package com.cloudfly.start.bill;

import com.cloudfly.start.bill.config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DataSourceConfig.class})
public class DetailsApplication {

	public static void main(String[] args) {

		SpringApplication.run(DetailsApplication.class, args);
	}

}
