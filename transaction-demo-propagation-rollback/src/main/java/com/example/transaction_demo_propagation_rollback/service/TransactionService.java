// package com.example.transaction_demo_propagation_rollback.service;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Propagation;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.transaction_demo_propagation_rollback.exception.CustomCheckedException;
// import com.example.transaction_demo_propagation_rollback.repository.RecordRepository;
// import com.example.transaction_demo_propagation_rollback.entity.Record;
// @Service
// public class TransactionService {
//     private final RecordRepository recordRepository;

//     public TransactionService(RecordRepository recordRepository) {
//         this.recordRepository = recordRepository;
//     }

//     @Transactional(rollbackFor = CustomCheckedException.class)
//     public void performTransactionalOperation() throws CustomCheckedException {
//         method1(); // Step 1: Successful operation
//         method2(); // Step 2: This will throw an exception and cause rollback
//     }

//     public void method1() {
//         Record record = new Record();
//         record.setData("Method1 Data");
//         recordRepository.save(record);
//         System.out.println("Method1 completed successfully!");
//     }

    
//     public void method2() throws CustomCheckedException {
//         Record record = new Record();
//         record.setData("Method2 Data");
//         recordRepository.save(record);
//         System.out.println("Method2 completed successfully!");
//         // Simulate failure
//         throw new CustomCheckedException("Simulated failure in method2!");
//     }
// }