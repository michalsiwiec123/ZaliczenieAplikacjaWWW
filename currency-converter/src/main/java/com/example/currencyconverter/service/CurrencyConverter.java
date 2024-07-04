package com.example.currencyconverter.service;

import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;
public class CurrencyConverter {


    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.90);
        Double gbp = exchangeRates.put("GBP", 0.76);

    }

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = exchangeRates.getOrDefault(fromCurrency, 1.0);
        double toRate = exchangeRates.getOrDefault(toCurrency, 1.0);


        double result = (amount / fromRate) * toRate;

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedResult = df.format(result);

        return result;
    }
}
