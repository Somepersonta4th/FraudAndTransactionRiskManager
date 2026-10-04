package com.mthree.FraudAndTransactionRiskManager;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.SQLException;

public class DataSource {

    public static MysqlDataSource getDataSource() throws SQLException {

        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("FraudDB");
        ds.setUser("root");
        //Will need to be changed for other computers!!!
        ds.setPassword("root");
        ////////////////////////////////////////////
        ds.setAllowPublicKeyRetrieval(true);
        return ds;
    }

}
