package com.transactions.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.transactions.model.TransactionResponseSuccessModel;

@FeignClient(name = "backendserver1", url = "${backendserver1.url}")
public interface SuccessTransactionsClient {
	
    @GetMapping("/backendserver1/success/{accountNumber}")
    TransactionResponseSuccessModel getSuccessTransactions(@PathVariable String accountNumber);
}

