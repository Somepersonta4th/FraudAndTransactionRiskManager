package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dao.Mappers.CaseMapper;
import com.mthree.FraudAndTransactionRiskManager.dao.Mappers.CaseTransactionMapper;
import com.mthree.FraudAndTransactionRiskManager.dao.Mappers.TransactionMapper;
import com.mthree.FraudAndTransactionRiskManager.dto.Case;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CaseDaoImpl implements CaseDao{

    JdbcTemplate jdbc;

    CaseDaoImpl(JdbcTemplate j){
        jdbc = j;
    }

    //Adding a case to the database will assign it with a new id!!!
    //It will return a new Case object with that id
    @Override
    public Case createCase(Case fraudCase) {
        jdbc.update("INSERT INTO case(account_id, status, score, description, open_date, close_date) VALUES ('" + fraudCase.getAccountId() + "', '" + fraudCase.getStatus() + "', '" + fraudCase.getScore() + "', '" + fraudCase.getDescription() + "', '" + fraudCase.getOpenedAtString() + "', '" + fraudCase.getClosedAtString() + "')");
        Case ob = jdbc.query("SELECT * FROM cases WHERE id = (SELECT MAX(id) FROM cases);", new CaseMapper()).get(0);
        ArrayList<String> tList = (ArrayList<String>)fraudCase.getTransactionIds();

        for (String id : tList) {
            jdbc.update("INSERT INTO case_transaction(case_id, transaction_id) VALUES( '" + ob.getCaseId() + "', '" + id + "')");
        }
        ob.setTransactions(fraudCase.getTransactions());

        return ob;
    }

    @Override
    public Case findCaseById(int caseId) {
        Case c = jdbc.query("SELECT * FROM cases WHERE id = " + caseId, new CaseMapper()).get(0);

        ArrayList<Transaction> tList = new ArrayList<>();
        List<List<String>> ids = jdbc.query("SELECT * FROM case_transaction WHERE case_id = " + caseId + ";", new CaseTransactionMapper());

        for (List<String> pair : ids){

            Transaction t = jdbc.query("SELECT * FROM transaction WHERE id = " + pair.get(1), new TransactionMapper()).get(0);
            tList.add(t);
        }

        c.setTransactions(tList);
        return c;

    }

    @Override
    public List<Case> findOpenCaseByAccountId(int accountId) {
        ArrayList<Case> cList = (ArrayList<Case>) jdbc.query("SELECT * FROM cases WHERE account_id = " + accountId, new CaseMapper());
        ArrayList<Case> returnList = new ArrayList<>();
        for (Case c : cList){
            if(!(c.getStatus().equals("CLOSED_SAFE") || c.getStatus().equals("CLOSED_FRAUD"))){
                returnList.add(c);
            }
        }
        return returnList;
    }

    @Override
    public void updateCaseScore(int caseId, int score) {
        jdbc.update("UPDATE cases SET score = " + score + " WHERE id = " + caseId +";");
    }
}
