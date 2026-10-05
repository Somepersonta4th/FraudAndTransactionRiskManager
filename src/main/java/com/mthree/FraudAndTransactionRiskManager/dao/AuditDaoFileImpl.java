package com.mthree.FraudAndTransactionRiskManager.dao;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@Repository
public class AuditDaoFileImpl implements AuditDao {

    private final String FILE_PATH = "AuditLog.txt";

    @Override
    public void writeToAudit(String auditLog) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH,true));
            writer.println(auditLog);
            writer.flush();

            // write file hash
            writer.println(getFileHash());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not create audit file.");
        }
    }

    private String getFileHash() {
        MessageDigest digest;

        try {
            InputStream data = new FileInputStream(FILE_PATH);

            digest = MessageDigest.getInstance("SHA-256");

            byte[] buffer = new byte[8192];
            int bytesRead;

            // read file in chunks
            while ((bytesRead = data.read()) != -1) {
                digest.update(buffer, 0, bytesRead);
            }

        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }

        // compute hash
        byte[] hashBytes = digest.digest();

        // convert to hex
        StringBuilder hashString = new StringBuilder();
        for (byte b : hashBytes) {
            hashString.append(String.format("%02x",b));
        }
        return hashString.toString();
    }
}
