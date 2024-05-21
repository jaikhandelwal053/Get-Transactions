package com.transactions.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.transactions.model.TransactionResponsePendingModel;

@FeignClient(name = "backendserver3", url = "${backendserver3.url}")
public interface PendingTransactionsClient {
	
	 @GetMapping("/backendserver3/pending/{accountNumber}")
	 TransactionResponsePendingModel getPendingTransactions(@PathVariable String accountNumber);
}
