# Workshop: Dependency Injection with Spring

This project demonstrates the core principles of **Spring Dependency Injection** through a simple **Student Management System**. The project showcases how **Spring IoC (Inversion of Control)** helps in managing object creation, wiring dependencies, and promoting loose coupling within applications.

## Project Overview

The **Student Management System** serves as a practical implementation of **Dependency Injection (DI)**, using **Spring Framework** to manage objects and dependencies. The main components of the project include:

1. **Data Access Layer**:
    - `StudentDao` interface: Defines CRUD operations for managing `Student` objects.
    - `StudentDaoListImpl`: Implements `StudentDao` using an in-memory list to store `Student` entities.
    - The implementation is marked with `@Component`, and Spring manages its lifecycle.

2. **User Input Services**:
    - `UserInputService` interface: Provides an abstraction for capturing user input.
    - `ScannerInputService`: Implements `UserInputService` using a `Scanner` to read input from the console. The `Scanner` is injected as a Spring bean.

3. **Management Service**:
    - `StudentManagementConsoleImpl`: Provides the main business logic for managing `Student` entities, including creating, finding, listing, and deleting students.
    - This class demonstrates **Constructor Injection** for the `UserInputService` and `StudentDao`, which Spring manages.

## Technologies Used

- **Java 22 (OpenJDK 22.0.2)**
- **Spring Framework **
- **Maven** for dependency management and building
- **JUnit 4.13.2** for testing

## Dependency Injection in Action

This Workshop is designed to showcase key aspects of **Spring Dependency Injection**:

- **Inversion of Control (IoC)**: The control of object creation and wiring of dependencies is handled by the Spring container, rather than being manually instantiated within the codebase.
- **Constructor Injection**: Dependencies such as `StudentDao` and `UserInputService` are injected into the classes that need them via constructors.
- **Component Scanning**: Spring is configured to automatically discover and register beans using `@ComponentScan`, simplifying bean management.

### Example of Dependency Injection
The following is an example of **Constructor Injection** within `StudentManagementConsoleImpl`:





```
## Project Overview

src
 └── main
     └── java
         └── se
             └── alex
                 └── lexicon
                     ├── config               // Spring Configuration
                     ├── data_access          // DAO Interfaces and Implementations
                     ├── management           // Business Logic (Student Management)
                     ├── models               // Data Models (e.g., Student)
                     └── services             // Input Services (User Input)





@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    private final UserInputService userInputService;
    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }
// Business logic methods (create, save, find, delete)
}

