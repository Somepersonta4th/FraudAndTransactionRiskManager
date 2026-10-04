package com.mthree.FraudAndTransactionRiskManager.Import;

import org.json.simple.parser.ParseException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public interface Import {

    public void importData() throws ParseException, SQLException;

}
