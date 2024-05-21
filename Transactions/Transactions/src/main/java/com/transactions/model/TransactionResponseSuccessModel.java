package com.transactions.model;

public class TransactionResponseSuccessModel {
	
	private String accountNumber;
	private Transaction[] success;

	public TransactionResponseSuccessModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionResponseSuccessModel(String accountNumber, Transaction[] success) {
		super();
		this.accountNumber = accountNumber;
		this.success = success;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Transaction[] getSuccess() {
		return success;
	}

	public void setSuccess(Transaction[] success) {
		this.success = success;
	}

}
