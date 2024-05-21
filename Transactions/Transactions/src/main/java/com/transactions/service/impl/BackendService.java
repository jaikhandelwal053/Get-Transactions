package com.transactions.service.impl;

import com.transactions.model.Transaction;

public interface BackendService {
	Transaction[] fetchTransactionsData(String accountNumber);

}
