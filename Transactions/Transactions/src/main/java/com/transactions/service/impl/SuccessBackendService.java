package com.transactions.service.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactions.feignclient.SuccessTransactionsClient;
import com.transactions.model.Transaction;

@Service
public class SuccessBackendService implements BackendService {

	@Autowired
	SuccessTransactionsClient successTransactionsClient;

	private final ExecutorService executor = Executors.newFixedThreadPool(1);

	@Override
	public Transaction[] fetchTransactionsData(String accountNumber) {
		
		CompletableFuture<Transaction[]> successTransactionList = CompletableFuture.supplyAsync(
				() -> (successTransactionsClient.getSuccessTransactions(accountNumber)).getSuccess(), executor);
		
		Transaction[] successTransactionListResult = successTransactionList.join();
		return successTransactionListResult;
	}
}
