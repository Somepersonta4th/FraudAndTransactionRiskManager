package com.mthree.FraudAndTransactionRiskManager.Import;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PlaidImport {
    String accessToken = "access-sandbox-c039b666-c7f2-4d72-bc90-307be82658a2";
    String clientId = "6abe5bd3bd2ff7000ee3b762";
    String secret = "3f51e8e6aaf3eac45344515edc0be5";

    @Autowired
    private JdbcTemplate jdbc;

    public void importData() throws ParseException {

        String jsonString = getBody();

        JSONObject jObject = (JSONObject) new JSONParser().parse(jsonString);

        String accounts = (String) jObject.get("accounts");

        accountSetter(accounts);
    }

    private void accountSetter(String accounts){

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

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());

        if (response.statusCode() != 200){
            throw new ImportFalureException("Import failed with error code: " + response.statusCode());
        }
        return response.body();
    }
}
