# flight-service-example
This project is created for handling transaction using @Transaction in Spring-Boot app

# There is a point about @Transaction is Spring-Boot that must be known:
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
