package com.transactions.model;

public class TransactionResponsePendingModel {

	private String accountNumber;
	private Transaction[] pending;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Transaction[] getPending() {
		return pending;
	}

	public void setPending(Transaction[] pending) {
		this.pending = pending;
	}

	public TransactionResponsePendingModel(String accountNumber, Transaction[] pending) {
		super();
		this.accountNumber = accountNumber;
		this.pending = pending;
	}

}
