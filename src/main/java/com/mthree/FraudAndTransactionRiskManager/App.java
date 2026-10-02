package com.mthree.FraudAndTransactionRiskManager;

import com.mthree.FraudAndTransactionRiskManager.controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//unfinished
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}