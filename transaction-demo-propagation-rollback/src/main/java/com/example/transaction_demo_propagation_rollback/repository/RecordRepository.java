package com.example.transaction_demo_propagation_rollback.repository;
import com.example.transaction_demo_propagation_rollback.entity.Record;




import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
