# Spring Transaction Management: A Comprehensive Example

This repository demonstrates the implementation of Spring Transaction Management, including transaction propagation, rollback scenarios, and how proxies are used internally. The goal is to help developers understand and effectively use Spring's `@Transactional` annotation for managing transactions in real-world applications.

---

## **Features**

- Demonstrates various transaction propagation types (`REQUIRED`, `REQUIRES_NEW`, etc.).
- Configures rollback scenarios for both checked and unchecked exceptions.
- Illustrates Spring proxy behavior in declarative transaction management.
- Includes practical examples such as order processing and independent logging.

---

## **Getting Started**

### **Prerequisites**
- Java 17 or higher
- Spring Boot 3.x
- Maven 3.6+
- H2 Database (in-memory for demonstration)

### **Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/spring-transaction-management.git
   cd spring-transaction-management
   ```

2. Build and run the project:
   ```bash
   mvn spring-boot:run
   ```

3. Access the H2 Console:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`, Password: (leave blank)

---

## **Project Structure**

- **`service/TransactionService`**:
  Contains methods demonstrating transaction propagation and rollback handling.
- **`entity/Record`**:
  Represents a sample database entity.
- **`repository/RecordRepository`**:
  A Spring Data JPA repository for CRUD operations.
- **`exception/CustomCheckedException`**:
  A custom checked exception to test rollback configurations.

---

## **Examples**

### **Transaction Propagation**

#### **Code Example**
```java
 @Transactional
    public void performTransactionalOperation() throws CustomCheckedException {
        method1(); // Step 1: Successful operation
        
            selfProxy.method2(); // Step 2: Independent transaction
         
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void method1() {
        Record record = new Record();
        record.setData("Method1 Data");
        recordRepository.save(record);
        System.out.println("Method1 completed successfully!");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = CustomCheckedException.class)
    public void method2() throws CustomCheckedException {
        Record record = new Record();
        record.setData("Method2 Data");
        recordRepository.save(record);
        System.out.println("Method2 completed successfully!");
        // Simulate failure
       // throw new CustomCheckedException("Simulated failure in method2!");
    }```

#### **Behavior**
- **`method1()`**: Joins the existing transaction.
- **`method2()`**: Starts a new transaction and rolls back independently on failure.

---

### **Rollback Configuration**

By default, Spring rolls back transactions for unchecked exceptions. To handle checked exceptions, use the `rollbackFor` attribute:
```java
@Transactional(rollbackFor = CustomCheckedException.class)
public void method2() throws CustomCheckedException {
    // Save record
    throw new CustomCheckedException("Simulated failure");
}
```

---

## **Best Practices**

1. **Design Transaction Boundaries**:
   - Use `REQUIRED` for tightly coupled operations.
   - Use `REQUIRES_NEW` for independent operations like logging.

2. **Avoid Proxy Pitfalls**:
   - Ensure method calls go through the proxy by splitting transactional methods into separate beans or using self-injected proxies.

3. **Test Transaction Behavior**:
   - Simulate failures to verify rollback behavior.
   - Use logs and database inspections to ensure data consistency.

4. **Monitor Performance**:
   - Minimize nested transactions for better performance.
   - Use transaction logs to debug issues.

---

## **Run the Example**

- Start the application using `mvn spring-boot:run`.
- Observe the output in the console for transaction status and rollback behavior.
- Check the database state using the H2 Console.

---

## **Contributing**

We welcome contributions! Please fork the repository, create a feature branch, and submit a pull request.

---
