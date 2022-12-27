package com.payment.PaymentIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PaymentIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentIntegrationApplication.class, args);
	}

}
