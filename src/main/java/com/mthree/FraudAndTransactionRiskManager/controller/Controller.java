package com.mthree.FraudAndTransactionRiskManager.controller;

import com.mthree.FraudAndTransactionRiskManager.dto.*;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;
import com.mthree.FraudAndTransactionRiskManager.service.ApplicationService;
import com.mthree.FraudAndTransactionRiskManager.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/FTRM")
//unfinished
public class Controller {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    AuditService auditService;




    // retrieve all transactions
    @GetMapping("/transactions/all")
    public List<Transaction> getAllTransaction() {
        auditService.writeToAudit("getAllTransaction");
        return applicationService.getTransactions();
    }

    // retrieve transaction with id
    @GetMapping("/transactions/{transactionID}")
    public Transaction getTransaction(@PathVariable String transactionID) {
        auditService.writeToAudit("getTransaction:" + transactionID);
        return applicationService.getTransaction(transactionID);
    }

    /*
    // retrieve transaction risk flags with transaction id
    @GetMapping("/transactions/{transactionID}/flags")
    public List<RiskFlag> getTransactionFlags(@PathVariable String transactionID) {
        auditService.writeToAudit("getTransactionFlags:" + transactionID);
        return applicationService.getTransactionFlags(transactionID);
    }

    // retrieve transaction and related data with id
    @GetMapping("/transactions/{transactionID}/info")
    public TransactionWrapper getTransactionInfo(@PathVariable String transactionID) {
        auditService.writeToAudit("getTransactionInfo:" + transactionID);
        return applicationService.getTransactionInfo(transactionID);
        
    }
    */

    // retrieve transactions with search
    @GetMapping("/transactions/search")
    public List<Transaction> searchTransactions(String searchString) {
        auditService.writeToAudit("searchTransactions:" + searchString);
        return applicationService.searchTransactions(searchString);
    }




    // retrieve all account
    @GetMapping("/accounts/all")
    public List<Account> getAllTransactions() {
        auditService.writeToAudit("getAllTransactions");
        return applicationService.getAccounts();
    }

    // retrieve account with id
    @GetMapping("/accounts/{accountID}")
    public Account getAccount(@PathVariable String accountID) {
        auditService.writeToAudit("getAccount:" + accountID);
        return applicationService.getAccount(accountID);
    }

    // retrieve accounts with search
    @GetMapping("/accounts/search")
    public List<Account> searchAccounts(String searchString) {
        auditService.writeToAudit("searchAccounts:" + searchString);
        return applicationService.searchAccounts(searchString);
    }

    // retrieve transactions relating to account
    @GetMapping("/accounts/{accountID}/transactions")
    public List<Transaction> getAccountTransactions(@PathVariable String accountID) {
        auditService.writeToAudit("getAccountTransactions:" + accountID);
        return applicationService.getTransactionsForAccount(accountID);
    }



    /*
    // retrieve all risk rules
    @GetMapping("/risk-rules/all")
    public List<RiskRule> getRiskRules() {
        auditService.writeToAudit("getRiskRules");
        return applicationService.getRiskRules();
    }

    // retrieve risk rules by code
    @GetMapping("/risk-rules/{ruleCode}")
    public RiskRule getRiskRule(@PathVariable String ruleCode) {
        auditService.writeToAudit("getRiskRule:" + ruleCode);
        return applicationService.getRiskRule(ruleCode);
    }
    */


    // retrieve all cases
    @GetMapping("/cases/all")
    public List<Case> getAllCases() {
        auditService.writeToAudit("getAllCases");
        throw new UnsupportedOperationException();
    }

    // retrieve case by id
    @GetMapping("/cases/{caseID}")
    public Case getCase(@PathVariable int caseID) {
        auditService.writeToAudit("getCase:" + caseID);
        return applicationService.getCase(caseID);
    }

    // updates case score
    @PutMapping("/cases/{caseID}/score")
    public Case setCaseScore(@PathVariable int caseID, int score, String priority) {
        auditService.writeToAudit("setCaseScore:" + caseID + ":" + score + ":" + priority);
        return applicationService.setCaseScore(caseID,score,priority);
    }

    // creates new case from accountID
    @PostMapping("accounts/{accountID}/cases")
    public Case addCaseForAccount(@PathVariable String accountID) {
        auditService.writeToAudit("addCaseForAccount:" + accountID);
        return applicationService.addCaseForAccount(accountID);
    }

    // gets case from accountID
    @GetMapping("accounts/{accountID}/cases")
    public List<Case> getCaseForAccount(@PathVariable String accountID) {
        auditService.writeToAudit("getCaseForAccount:" + accountID);
        return applicationService.getCasesForAccount(accountID);
    }






    @GetMapping("/{testString}")
    public String test(@PathVariable String testString) {
        return testString + "test";
    }
}
