package com.backendServer1.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.backendServer1.entity.TransactionEntity;
import com.backendServer1.service.BackendServer1_Service;

@Service
public class BackendServer1_ServiceImpl implements BackendServer1_Service {
	
	@Override
	public Map<String, Object> getSuccessTransactions(String accountNumber) {
		Map<String, Object> mapResult = new LinkedHashMap<>();
		
		if("12233300011001".equals(accountNumber)) {
			List<TransactionEntity> successTransactions = new ArrayList<>();
			
			successTransactions.add(new TransactionEntity("123456789", "success", "500", "11-05-2023"));
			successTransactions.add(new TransactionEntity("789566233", "success", "100", "12-05-2023"));
			successTransactions.add(new TransactionEntity("789566888", "success", "1000", "13-05-2023"));

			mapResult.put("AccountNumber", accountNumber);
			mapResult.put("success", successTransactions);
		} else {
			mapResult.put("Error", "404");
			mapResult.put("message", "Account Number does not exist");
		}
		return mapResult;
	}
}