package com.transactions.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.transactions.model.TransactionResponseFailureModel;

@FeignClient(name = "backendserver2", url = "${backendserver2.url}")
public interface FailureTransactionsClient {
	 @GetMapping("/backendserver2/failure/{accountNumber}")
	 TransactionResponseFailureModel getFailureTransactions(@PathVariable String accountNumber);
}
	