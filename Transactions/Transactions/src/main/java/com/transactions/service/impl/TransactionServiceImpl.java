package com.transactions.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactions.model.Transaction;
import com.transactions.service.TransactionService;
import com.transactions.utill.BackendServiceFactory;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private BackendServiceFactory backendServiceFactory;
	@Autowired
	private SuccessBackendService successBackendService;

	@Autowired
	private PendingBackendService pendingBackendService;

	@Autowired
	private FailureBackendService failureBackendService;

	private final ExecutorService executorService = Executors.newFixedThreadPool(3);

	@Override
	public Map<String, Object> getTransactions(String accountNumber, String status) {
		Map<String, Object> response = new HashMap<>();

		try {
			if(!accountNumber.equals("12233300011001")) {
				throw new IllegalArgumentException();
			}
			BackendService backendService = backendServiceFactory.getBackendService(status);
			Transaction[] fatchTransactionslist = backendService.fetchTransactionsData(accountNumber);

			response.put(status.toLowerCase(), fatchTransactionslist);
			return response;
			
		} catch (IllegalArgumentException e) {
			response.put("error", "Oops! Something went wrong");
			response.put("message", "Please provide a valid Account Number or Status "); 
			return response;
		}
	}

	@Override
	public Map<String, Object> getTransactions(String accountNumber) {
		Map<String, Object> response = new HashMap<>();

		CompletableFuture<Transaction[]> successFuture = CompletableFuture
				.supplyAsync(() -> successBackendService.fetchTransactionsData(accountNumber), executorService);

		CompletableFuture<Transaction[]> failureFuture = CompletableFuture
				.supplyAsync(() -> failureBackendService.fetchTransactionsData(accountNumber), executorService);

		CompletableFuture<Transaction[]> pendingFuture = CompletableFuture
				.supplyAsync(() -> pendingBackendService.fetchTransactionsData(accountNumber), executorService);

		CompletableFuture.allOf(successFuture, failureFuture, failureFuture).join();
		
		response.put("success", successFuture.join());
		response.put("failure", failureFuture.join());
		response.put("pending", pendingFuture.join());

		return response;

	}
}