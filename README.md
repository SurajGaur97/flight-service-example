# Project: flight-service-example
This project is created for handling ***Transactions*** using `@Transactional` in Spring-Boot App

# Try-Catch Block:
***try-catch*** block prevent transction to roll back it. So avoid using try-catch block to that method where `@Transactional` annotation applied. By default **checked exception** is egnored by `@Transactional`, but it can be configured later to work with checked exception.

# There's Important Point about @Transaction is Spring-Boot that Must be Known:
In a Spring Boot application, the `@Transactional` annotation is typically used to manage transactions and automatically roll back those transactions when an unchecked exception is thrown. By default, checked exceptions do not trigger a rollback. However, you can configure the `@Transactional` annotation to roll back on checked exceptions by using the `rollbackFor` or `noRollbackFor` attributes.

Here's how you can do it:

1. **Using `rollbackFor` Attribute**:

   You can specify the checked exception types for which you want to trigger a transaction rollback by providing them as values to the `rollbackFor` attribute of the `@Transactional` annotation.

   For example, if you want to roll back the transaction for a specific checked exception, you can do it like this:

   ```java
   import org.springframework.transaction.annotation.Transactional;

   @Service
   public class MyService {
       @Transactional(rollbackFor = MyCheckedException.class)
       public void myTransactionalMethod() throws MyCheckedException {
           // Business logic that may throw MyCheckedException
       }
   }
   ```

   In the above example, if `MyCheckedException` is thrown, the transaction will be rolled back.

2. **Using `noRollbackFor` Attribute**:

   Conversely, you can use the `noRollbackFor` attribute to specify exceptions for which you want to prevent a rollback, even if they are checked exceptions.

   ```java
   @Transactional(noRollbackFor = MyCheckedException.class)
   public void myTransactionalMethod() throws MyCheckedException {
       // Business logic that may throw MyCheckedException
   }
   ```

   In this case, if `MyCheckedException` is thrown, the transaction will not be rolled back.

Keep in mind that when you use `rollbackFor` or `noRollbackFor`, it's important to consider the impact on the application's behavior and ensure that you handle exceptions appropriately. Rolling back on checked exceptions may be useful in specific situations where you need more fine-grained control over transaction behavior, but it should be used with caution, as it can affect the consistency of your data.

# Rolling back Transaction for Multiple Checked Exception:
To roll back a transaction for multiple checked exceptions in a Spring Boot application, you can use the `rollbackFor` attribute of the `@Transactional` annotation to specify an array of exception types for which you want the transaction to roll back. Here's how to do it:

```java
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {
    @Transactional(rollbackFor = {ExceptionType1.class, ExceptionType2.class, ExceptionType3.class})
    public void myTransactionalMethod() throws ExceptionType1, ExceptionType2, ExceptionType3 {
        // Business logic that may throw one of the specified exceptions
    }
}
```

In the example above, we've specified an array of exception types `{ExceptionType1.class, ExceptionType2.class, ExceptionType3.class}` using the `rollbackFor` attribute. If any of these exceptions (`ExceptionType1`, `ExceptionType2`, or `ExceptionType3`) are thrown within the `myTransactionalMethod`, the transaction will be rolled back.

This approach allows you to specify multiple checked exceptions for which you want to trigger a transaction rollback. You can add as many exception types to the array as needed, and the transaction will roll back if any of the specified exceptions is thrown.

Just be aware that rolling back transactions on multiple checked exceptions should be used carefully and with a clear understanding of the implications for data consistency and application behavior. It's essential to handle these exceptions appropriately in your business logic to ensure the application behaves as expected.
