package com.mthree.FraudAndTransactionRiskManager;

import com.mthree.FraudAndTransactionRiskManager.Import.Import;
import com.mthree.FraudAndTransactionRiskManager.Import.PlaidImport;
import com.mthree.FraudAndTransactionRiskManager.controller.Controller;
import com.mthree.FraudAndTransactionRiskManager.dao.AccountDaoImpl;
import com.mthree.FraudAndTransactionRiskManager.dao.TransactionDaoImpl;
import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//unfinished

public class App {

    public static void main(String[] args) throws ParseException, SQLException {

        Import imp = new PlaidImport();

        imp.importData();

        SpringApplication.run(App.class, args);



    }





}

