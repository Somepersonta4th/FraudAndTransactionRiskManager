package com.mthree.FraudAndTransactionRiskManager.Import;

import com.mthree.FraudAndTransactionRiskManager.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class ImportJDBC implements Import{
    private final JdbcTemplate jdbc;

    String accessToken = "access-sandbox-c039b666-c7f2-4d72-bc90-307be82658a2";
    String clientId = "6abe5bd3bd2ff7000ee3b762";
    String secret = "3f51e8e6aaf3eac45344515edc0be5";

    String password;

    public ImportJDBC(JdbcTemplate j) throws SQLException {
        jdbc = j;
    }

    @Override
    public void importData() throws ParseException, SQLException {

        String jsonString = getBody();


        JSONObject jObject = (JSONObject) new JSONParser().parse(jsonString);

        //String accounts = (String) jObject.get("accounts");

        deleteAllTransactions();
        deleteAllAccounts();
        accountSetter(jObject);

        transactionSetter(jObject);
    }



    private void deleteAllTransactions(){
        jdbc.update("DELETE FROM Transactions");
    }

    private void deleteAllAccounts(){
        jdbc.update("DELETE FROM Accounts");
    }

    private void transactionSetter(JSONObject json){



        JSONArray transactions = (JSONArray) json.get("added");

        for (Object tran : transactions) {
            JSONObject ob = (JSONObject) tran;
            String id = (String) ob.get("transaction_id");
            String accountId = (String) ob.get("account_id");
            String amount = "0";
            try{amount = Double.toString((Double) ob.get("amount"));}
            catch(Exception e){
                amount = Long.toString((Long) ob.get("amount"));
            }
            String currencyCode = (String) ob.get("iso_currency_code");
            String description = (String) ob.get("description");

            JSONObject PFC = (JSONObject) ob.get("personal_finance_category");
            String primaryCategory = (String) PFC.get("primary");
            String detailedCategory = (String) PFC.get("detailed");

            String channel = (String) ob.get("payment_channel");
            //yyyy-mm-dd
            //String dateTransaction = "1970-01-01";
            String dateTransaction = (String) ob.get("date");
            if (dateTransaction == null){
                dateTransaction = "1970-01-01";
            }

            String dateAuthorised = (String) ob.get("authorized_date");
            if (dateAuthorised == null){
                dateAuthorised = "1970-01-01";
            }

            JSONObject location = (JSONObject) ob.get("location");
            String city = (String) location.get("city");
            String country = (String) location.get("country");

            Boolean pend = (Boolean) ob.get("pending");
            int pending = 0;
            if (pend) {
                pending = 1;
            }

            String merchantName = (String) ob.get("merchant_name");
            String merchantEntityId = (String) ob.get("merchant_entity_id");
            String merchantCategoryCode = (String) ob.get("merchant_category_code");


            //String sql = "INSERT INTO transactions(id, account_id, amount, iso_currency_code, description,primary_category, detailed_category, payment_channel, date_transaction, date_authorised, city, country, pending, merchant_name) VALUES('" + id + "', '" + accountId + "', '" + amount + "', '" + currencyCode + "', '" + description + "', '" + primaryCategory + "', '" + detailedCategory + "', '" + channel + "', '" + dateTransaction + "', '" + dateAuthorised + "', '" + city + "', '" + country + "', '" + pending + "'," + "')";
            //jdbc.update(sql);

            String sql = "INSERT INTO transactions(id, account_id, amount, iso_currency_code, description, "
                    + "primary_category, detailed_category, payment_channel, date_transaction, date_authorised, "
                    + "city, country, pending, merchant_name, merchant_entity_id, merchant_category_code) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            jdbc.update(sql,
                    id, accountId, amount, currencyCode, description,
                    primaryCategory, detailedCategory, channel, dateTransaction, dateAuthorised,
                    city, country, pending, merchantName, merchantEntityId, merchantCategoryCode);



        }
    }

    private void accountSetter(JSONObject json) throws ParseException {

        JSONArray accounts = (JSONArray) json.get("accounts");

        for (Object acc : accounts){
            JSONObject jObject = (JSONObject) acc;
            String accountID = (String) jObject.get("account_id");
            String name = (String) jObject.get("name");

            JSONObject balanceObject = (JSONObject) jObject.get("balances");
            String available = "0";
            if (balanceObject.get("available") != null){
                available = Long.toString((long) balanceObject.get("available"));
            }
            String current = "0";
            if (balanceObject.get("available") != null){
                current = Long.toString((long) balanceObject.get("current"));
            }
            String currencyCode = (String) balanceObject.get("iso_currency_code");

            String mask = (String) jObject.get("mask");
            String type = (String) jObject.get("type");
            String subType = (String) jObject.get("subType");


            String sql = "INSERT INTO accounts(id, account_name, available, current, iso_currency_code, mask, account_type, account_subtype) VALUES('" + accountID + "', '" + name + "', '" + available + "', '" + current + "', '" + currencyCode + "', '" + mask + "', '" + type + "', '" + subType + "')";
            jdbc.update(sql);

        }
    }




    private String getBody(){
        String requestBody = "{\"client_id\": \"" + clientId + "\",\n \"secret\": \"" + secret + "\",\n  \"access_token\": \"" + accessToken + "\" }";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.plaid.com/transactions/sync"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if (response.statusCode() != 200){
            throw new ImportFalureException("Import failed with error code: " + response.statusCode());
        }
        return response.body();
    }
}
