package com.transactions.service.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactions.feignclient.FailureTransactionsClient;
import com.transactions.model.Transaction;

@Service
public class FailureBackendService implements BackendService {
	@Autowired
	FailureTransactionsClient failureTransactionsClient;

	private final ExecutorService executor = Executors.newFixedThreadPool(1);

	@Override
	public Transaction[] fetchTransactionsData(String accountNumber) {

		CompletableFuture<Transaction[]> failureTransactionList = CompletableFuture.supplyAsync(
				() -> (failureTransactionsClient.getFailureTransactions(accountNumber)).getFailure(), executor);

		Transaction[] failureTransactionListResult = failureTransactionList.join();
		return failureTransactionListResult;
	}
}
