package com.example.transaction_demo_propagation_rollback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.transaction_demo_propagation_rollback.exception.CustomCheckedException;

import com.example.transaction_demo_propagation_rollback.service.TransactionServiceRequiredNew;

@Component
public class DemoRunnerWithRequiredNewPropagation implements CommandLineRunner {
    private final TransactionServiceRequiredNew transactionService;

    public DemoRunnerWithRequiredNewPropagation(TransactionServiceRequiredNew transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public void run(String... args)  {
        try {
            transactionService.performTransactionalOperation();
        } catch (CustomCheckedException e) {
            // TODO Auto-generated catch block
            System.out.println("=========================>  custom checked exception thrown");
        }

        System.out.println("Check the database: No data should be persisted.");
    }
}