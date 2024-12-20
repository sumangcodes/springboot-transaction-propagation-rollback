// package com.example.transaction_demo_propagation_rollback;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.example.transaction_demo_propagation_rollback.exception.CustomCheckedException;
// import com.example.transaction_demo_propagation_rollback.service.TransactionService;

// @Component
// public class DemoRunner implements CommandLineRunner {
//     private final TransactionService transactionService;

//     public DemoRunner(TransactionService transactionService) {
//         this.transactionService = transactionService;
//     }

//     @Override
//     public void run(String... args) {
//         try {
//             transactionService.performTransactionalOperation();
//         } catch (CustomCheckedException e) {
//             System.err.println("Transaction failed: " + e.getMessage());
//         }

//         System.out.println("Check the database: No data should be persisted.");
//     }
// }