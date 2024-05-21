package com.transactions.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transactions.service.impl.BackendService;
import com.transactions.service.impl.FailureBackendService;
import com.transactions.service.impl.PendingBackendService;
import com.transactions.service.impl.SuccessBackendService;


@Component
public class BackendServiceFactory {

    @Autowired
    private SuccessBackendService successBackendService;

    @Autowired
    private PendingBackendService pendingBackendService;

    @Autowired
    private FailureBackendService failureBackendService;

    public BackendService getBackendService(String status) {
        switch (status.toUpperCase()) {
            case "SUCCESS":
                return successBackendService;
            case "PENDING":
                return pendingBackendService;
            case "FAILURE":
                return failureBackendService;
            default:
                throw new IllegalArgumentException();
        }
    }
}
