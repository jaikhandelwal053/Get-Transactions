package com.backendServer3.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendServer3.service.impl.BackendServer3_ServiceImpl;

@RestController
@RequestMapping("/backendserver3")
public class BackendServer3_Controller {

    @Autowired
    private BackendServer3_ServiceImpl service;
    
    @GetMapping("/pending/{accountNumber}")
    public Map<String, Object> getpendingTransactions(@PathVariable String accountNumber) {
        return service.getPendingTransactions(accountNumber);
    }
    
}
