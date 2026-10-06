package com.mthree.FraudAndTransactionRiskManager.service.appServices;

import java.util.List;

public interface SearchService {
    public List<?> searchObjectsBy(String searchString, List<?> objects);

}
