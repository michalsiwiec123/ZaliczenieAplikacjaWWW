package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.CurrencyConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {


    @GetMapping("/")
    public String showConverterForm() {
        return "converter"; // Zwraca nazwę widoku (template)
    }


    @PostMapping("/convert")
    public String convertCurrency(@RequestParam String fromCurrency,
                                  @RequestParam String toCurrency,
                                  @RequestParam double amount,
                                  Model model) {

        double result = CurrencyConverter.convert(fromCurrency, toCurrency, amount);


        model.addAttribute("amount", amount);
        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        model.addAttribute("result", result);

        return "result"; // Zwraca nazwę widoku (template)
    }
}
