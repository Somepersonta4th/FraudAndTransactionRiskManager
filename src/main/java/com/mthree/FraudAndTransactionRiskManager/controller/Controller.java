package com.mthree.FraudAndTransactionRiskManager.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/FTRM")
//unfinished
public class Controller {
    @GetMapping("/{testString}")
    public String test(@PathVariable String testString) {
        return testString + "test";
    }
}
