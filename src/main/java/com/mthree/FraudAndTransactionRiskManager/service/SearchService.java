package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.List;

public interface SearchService {
    public List<?> searchObjectsBy(String searchString, List<?> objects);

}
