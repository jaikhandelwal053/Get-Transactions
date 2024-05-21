package com.backendServer1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backendServer1.service.impl.BackendServer1_ServiceImpl;

@RestController
//@RequestMapping("/backendserver1")
public class BackendServer1_Controller {

    @Autowired
    private BackendServer1_ServiceImpl transactionService;

    @GetMapping("/")
    public String test(){
    	return "Hello Jai";
    }
    
    @GetMapping("/backendserver1/success/{accountNumber}")
    public Map<String, Object> getSuccessTransactions(@PathVariable String accountNumber) {
        return transactionService.getSuccessTransactions(accountNumber);
    }
    
}
