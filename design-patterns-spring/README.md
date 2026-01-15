# Design Patterns Spring Boot Application

A comprehensive implementation of design patterns in Java using Spring Boot 3.x. This project demonstrates seven fundamental design patterns with real-world examples, detailed explanations, and REST APIs for hands-on learning.

## 📚 Implemented Design Patterns

### Creational Patterns
1. **Singleton** - Thread-safe configuration manager
2. **Factory Method** - Notification system with multiple delivery channels
3. **Abstract Factory** - UI component factory for different operating systems
4. **Builder** - Email builder with fluent API
5. **Prototype** - Document cloning with template registry

### Behavioral Patterns
6. **Strategy** - Payment processing with interchangeable algorithms
7. **Observer** - Newsletter subscription system with multiple notification types

### Structural Patterns
8. **Decorator** - Coffee ordering system with dynamic add-ons

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Build the Project
```bash
mvn clean install
```

### Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Run Tests
```bash
mvn test
```

## 📖 API Documentation

Once the application is running, access the interactive API documentation:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/api-docs

## 🎯 Pattern Examples

### Singleton Pattern
```bash
# Get singleton instance ID (same across all requests)
curl http://localhost:8080/api/singleton/instance-id

# Get configuration
curl http://localhost:8080/api/singleton/config/app.name

# Set configuration (persists across requests)
curl -X POST "http://localhost:8080/api/singleton/config?key=test&value=example"
```

### Factory Pattern
```bash
# Send notification using Factory Method
curl -X POST "http://localhost:8080/api/factory/notification/send?type=EMAIL&message=Hello"

# Render UI using Abstract Factory
curl "http://localhost:8080/api/factory/ui/render?os=WINDOWS"
```

### Builder Pattern
```bash
# Send simple email
curl -X POST "http://localhost:8080/api/builder/email/simple?to=user@example.com&subject=Test&body=Hello"

# Send complex email with all options
curl -X POST "http://localhost:8080/api/builder/email/complex?to=user@example.com&subject=Test&body=Hello&priority=1&readReceipt=true"

# Demo builder pattern
curl http://localhost:8080/api/builder/email/demo
```

### Prototype Pattern
```bash
# Get available templates
curl http://localhost:8080/api/prototype/templates

# Create document from template
curl -X POST "http://localhost:8080/api/prototype/document/create?template=business-letter&title=My%20Letter&author=John"

# Demo cloning behavior
curl http://localhost:8080/api/prototype/demo/clone
```

### Strategy Pattern
```bash
# Process payment with different strategies
curl -X POST "http://localhost:8080/api/strategy/payment/process?method=CREDIT_CARD&amount=100"
curl -X POST "http://localhost:8080/api/strategy/payment/process?method=PAYPAL&amount=100"
curl -X POST "http://localhost:8080/api/strategy/payment/process?method=CRYPTO&amount=100"

# Demo strategy switching
curl http://localhost:8080/api/strategy/demo
```

### Observer Pattern
```bash
# Subscribe to newsletter
curl -X POST "http://localhost:8080/api/observer/subscribe?name=John&contact=john@example.com&type=EMAIL"

# Publish article (notifies all subscribers)
curl -X POST "http://localhost:8080/api/observer/publish?article=New%20Article%20Title"

# Unsubscribe
curl -X POST "http://localhost:8080/api/observer/unsubscribe?name=John"

# Demo observer pattern
curl http://localhost:8080/api/observer/demo
```

### Decorator Pattern
```bash
# Order coffee with additions
curl -X POST "http://localhost:8080/api/decorator/coffee/order?base=ESPRESSO&additions=MILK&additions=MOCHA"

# Get available options
curl http://localhost:8080/api/decorator/coffee/options

# Demo decorator pattern
curl http://localhost:8080/api/decorator/demo
```

## 📦 Project Structure

```
src/
├── main/
│   ├── java/com/learn/designpatterns/
│   │   ├── App.java                    # Main Spring Boot application
│   │   ├── singleton/                  # Singleton pattern implementation
│   │   │   ├── ConfigurationManager.java
│   │   │   └── SingletonController.java
│   │   ├── factory/                    # Factory patterns implementation
│   │   │   ├── Notification.java
│   │   │   ├── NotificationFactory.java
│   │   │   ├── UIFactory.java
│   │   │   ├── AbstractFactoryProvider.java
│   │   │   └── FactoryController.java
│   │   ├── builder/                    # Builder pattern implementation
│   │   │   ├── Email.java
│   │   │   ├── EmailService.java
│   │   │   └── BuilderController.java
│   │   ├── prototype/                  # Prototype pattern implementation
│   │   │   ├── Document.java
│   │   │   ├── DocumentRegistry.java
│   │   │   └── PrototypeController.java
│   │   ├── strategy/                   # Strategy pattern implementation
│   │   │   ├── PaymentStrategy.java
│   │   │   ├── PaymentContext.java
│   │   │   └── StrategyController.java
│   │   ├── observer/                   # Observer pattern implementation
│   │   │   ├── Observer.java
│   │   │   ├── NewsletterPublisher.java
│   │   │   └── ObserverController.java
│   │   └── decorator/                  # Decorator pattern implementation
│   │       ├── Coffee.java
│   │       ├── CoffeeDecorator.java
│   │       ├── CoffeeService.java
│   │       └── DecoratorController.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/learn/designpatterns/   # Comprehensive unit tests
```

## 🎓 Learning Guide

### Why This Project?

Each pattern is implemented with:
- **Detailed Comments**: Explains WHAT, WHY, and WHEN to use each pattern
- **Real-World Examples**: Practical scenarios you'll encounter in production
- **REST APIs**: Interactive way to understand pattern behavior
- **Unit Tests**: Demonstrates correct usage and edge cases
- **Best Practices**: Thread-safety, immutability, SOLID principles

### Pattern Categories

**Creational Patterns**: Control object creation
- Use when you need flexibility in how objects are created
- Examples: Singleton, Factory, Builder, Prototype

**Behavioral Patterns**: Define communication between objects
- Use when you need flexible algorithms and responsibilities
- Examples: Strategy, Observer, Command, State

**Structural Patterns**: Compose objects for larger structures
- Use when you need flexible object composition
- Examples: Decorator, Adapter, Proxy, Facade

## 🔧 Configuration

### Application Properties

The application can be configured via `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080

# Logging
logging.level.com.learn.designpatterns=DEBUG

# Swagger UI
springdoc.swagger-ui.path=/swagger-ui.html
```

## 🧪 Testing

Run all tests:
```bash
mvn test
```

Run specific pattern tests:
```bash
mvn test -Dtest=SingletonTest
mvn test -Dtest=FactoryTest
mvn test -Dtest=BuilderTest
```

## 📚 Additional Resources

### Books
- "Design Patterns: Elements of Reusable Object-Oriented Software" (Gang of Four)
- "Head First Design Patterns" by Eric Freeman
- "Effective Java" by Joshua Bloch

### Online Resources
- [Refactoring.Guru](https://refactoring.guru/design-patterns)
- [SourceMaking](https://sourcemaking.com/design_patterns)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Implement your pattern with detailed comments
4. Add comprehensive tests
5. Submit a pull request

## 📝 License

This project is for educational purposes.

## 👨‍💻 Author

Learn Project - Design Patterns Study Material

## 🐛 Troubleshooting

### Port Already in Use
```bash
# Change port in application.properties or use:
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

### Build Failures
```bash
# Clean and rebuild
mvn clean install -U
```

### Test Failures
```bash
# Run tests with debug output
mvn test -X
```

## 🎯 Next Steps

1. Explore each pattern through Swagger UI
2. Review source code and detailed comments
3. Run unit tests to understand behavior
4. Try modifying examples to deepen understanding
5. Implement patterns in your own projects

Happy Learning! 🚀
