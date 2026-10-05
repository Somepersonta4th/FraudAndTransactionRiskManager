package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class SearchServiceImpl implements SearchService {

    private final NormalizedLevenshtein LEVENSHTEIN = new NormalizedLevenshtein();
    private final double LEVENSHTEIN_THRESHOLD = 0.75;

    /*
    * fuzzy mapping with replacing terms

    private static final Map<String,List<String>> fuzzyMapping = new HashMap<>();

    static {
        registerFuzzyMapping("l","1");
        registerFuzzyMapping("e","3");
        registerFuzzyMapping("s","5");
        registerFuzzyMapping("i","y");
        registerFuzzyMapping("inc","corp");
        registerFuzzyMapping("inc","ltd");
        registerFuzzyMapping("inc","co");
        registerFuzzyMapping("inc","llc");
    }

    private static void registerFuzzyMapping(String value1, String value2) {
        fuzzyMapping.computeIfAbsent(value1,k->new ArrayList<>()).add(value2);
        fuzzyMapping.computeIfAbsent(value2,k->new ArrayList<>()).add(value1);
    }

     */

    @Override
    public List<?> searchObjectsBy(String searchString, List<?> objects) {
        if (searchString == null || searchString.trim().isEmpty() || searchString.trim().equals("*"))
        {
            return objects;
        }
        String[] terms = searchString.toLowerCase(Locale.ROOT).split(" ");

        for (String term : terms) {

            String[] fieldValue = term.split(":");

            if (fieldValue.length == 2){
                // search one field and refine results
                objects = searchByTerm(fieldValue[1],objects,fieldValue[0]);
            } else {
                // search all field and refine results
                objects = searchByTerm(term,objects);
            }

        }

        return objects;
    }

    // search all fields
    private List<?> searchByTerm(String searchTerm, List<?> items) {
        // if fuzzy search
        if (searchTerm.startsWith("*")) {
            List<Object> results = new ArrayList<>();
            searchTerm = searchTerm.substring(1);
            for (Object item : items) {
                if (doesContainFuzzy(item,searchTerm)) {
                    results.add(item);
                }
            }
            return results;
        }

        // not fuzzy search with empty field
        return searchByTerm(searchTerm, (List<Object>) items,"");
    }

    // search given field
    private List<?> searchByTerm(String searchTerm, List<?> items, String field) {
        List<Object> results = new ArrayList<>();

        // if fuzzy search
        if (searchTerm.startsWith("*")) {
            searchTerm = searchTerm.substring(1);
            for (Object item : items) {
                if (doesContainFuzzy(item,searchTerm,field)) {
                    results.add(item);
                }
            }
            return results;
        }

        // not fuzzy
        for (Object item : items) {
            if (doesContain(item,searchTerm,field)) {
                results.add(item);
            }
        }

        return results;
    }

    private boolean doesContainFuzzy(Object item, String value) {
        String cleanItem = trimFields(item.toString()).toLowerCase(Locale.ROOT);
        String term = value.toLowerCase(Locale.ROOT);

        // perfect match
        if (cleanItem.contains(term)) {
            return true;
        }

        // slide window of length value over each word
        int windowSize = term.length();
        String[] words = cleanItem.split(" ");
        return Arrays.stream(cleanItem.split(" "))
                .anyMatch( word -> {
                    for (int i = 0; i <= word.length() - windowSize; i++) {
                        String chunk = word.substring(i,i + windowSize);
                        if (LEVENSHTEIN.distance(chunk, term) <= LEVENSHTEIN_THRESHOLD){
                            return true;
                        }
                    }
                    return false;
                });


    }

    private boolean doesContainFuzzy(Object item, String value, String field) {
        // cut item down to relevant field
        String[] itemFields = item.toString().toLowerCase(Locale.ROOT).split(" ");
        for (String itemField : itemFields) {
            if (itemField.startsWith(field)) {
                //target field

                String data = itemField.split("=")[1];
                String term = value.toLowerCase(Locale.ROOT);

                // perfect match
                if (data.contains(term)) {
                    return true;
                }

                // sliding search window
                for (int i = 0; i <= data.length() - term.length(); i++) {
                    String chunk = data.substring(i,i + term.length());
                    if (LEVENSHTEIN.distance(chunk,term) <= LEVENSHTEIN_THRESHOLD){
                        return true;
                    }
                }

                // not in target field
                return false;
            }
        }

        // no such field
        return false;
    }

    //check if object contains value in any field
    private boolean doesContain(Object item, String value) {
        // check with empty field
        return doesContain(item,value,"");
    }

    //check if object contains value at given field
    private boolean doesContain(Object item, String value, String field) {
        Boolean doesContain = false;

        doesContain = item.toString().toLowerCase(Locale.ROOT).replace("'","").contains(field + "=" + value);

        return doesContain;

    }

    private String trimFields(String raw){
        String[] words = raw.split(" ");

        StringBuilder out = new StringBuilder();
        for (String word : words) {
            String[] keyValue = word.split("=");
            if (keyValue.length == 2) {
                out.append(keyValue[1]).append(" ");
            } else {
                out.append(word).append(" ");
            }
        }

        return out.toString();
    }
}
