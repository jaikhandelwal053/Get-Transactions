package com.transactions.service.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactions.feignclient.PendingTransactionsClient;
import com.transactions.model.Transaction;

@Service
public class PendingBackendService implements BackendService {
	@Autowired
	PendingTransactionsClient pendingTransactionsClient;

	private final ExecutorService executor = Executors.newFixedThreadPool(1);

	@Override
	public Transaction[] fetchTransactionsData(String accountNumber) {
		
		CompletableFuture<Transaction[]> pendingTransactionList = CompletableFuture.supplyAsync(
				() -> (pendingTransactionsClient.getPendingTransactions(accountNumber)).getPending(), executor);
		
		Transaction[] pendingTransactionListResult = pendingTransactionList.join();		
		return pendingTransactionListResult;
	}

}