package com.backendServer2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendServer2.service.impl.BackendServer2_ServiceImpl;

@RestController
@RequestMapping("/backendserver2")
public class BackendServer2_Controller {

    @Autowired
    private BackendServer2_ServiceImpl service;
    
    
    @GetMapping("/failure/{accountNumber}")
    public Map<String, Object> getFailureTransactions(@PathVariable String accountNumber) {
        return service.getFailureTransactions(accountNumber);
    }
    
}
