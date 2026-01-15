export const patternData = {
  singleton: {
    title: 'Singleton Pattern',
    content: `
# Singleton Pattern

## What is it?
Ensures a class has only ONE instance and provides global access to it.

## When to Use
- Configuration managers
- Logger classes
- Database connection pools
- Cache managers

## Implementation (Thread-Safe)
\`\`\`java
public class ConfigurationManager {
    private static volatile ConfigurationManager instance;
    
    private ConfigurationManager() {}
    
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }
}
\`\`\`

## Key Points
- Private constructor prevents external instantiation
- Double-checked locking for thread safety
- Volatile keyword ensures proper memory visibility
- Lazy initialization for better performance

## REST API Example
\`\`\`bash
curl http://localhost:8080/api/singleton/instance-id
# Returns same ID across all requests
\`\`\`
    `
  },
  factory: {
    title: 'Factory Pattern',
    content: `
# Factory Pattern

## What is it?
Creates objects without specifying exact classes. Promotes loose coupling.

## Types
1. **Factory Method**: Single product type
2. **Abstract Factory**: Families of related products

## When to Use
- Object creation is complex
- Need flexibility in object types
- Want to hide instantiation logic

## Factory Method Example
\`\`\`java
public interface Notification {
    String send(String message);
}

public class NotificationFactory {
    public Notification createNotification(String type) {
        return switch (type) {
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SmsNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
\`\`\`

## Benefits
- Open/Closed Principle (open for extension, closed for modification)
- Single Responsibility (creation logic in one place)
- Easy to add new types without changing client code

## REST API Example
\`\`\`bash
curl -X POST "http://localhost:8080/api/factory/notification/send?type=EMAIL&message=Hello"
\`\`\`
    `
  },
  builder: {
    title: 'Builder Pattern',
    content: `
# Builder Pattern

## What is it?
Constructs complex objects step by step using fluent API.

## When to Use
- Objects with many optional parameters
- Telescoping constructor anti-pattern
- Want immutable objects

## Implementation
\`\`\`java
public class Email {
    private final String to;
    private final String subject;
    private final String body;
    // Many optional fields...
    
    private Email(EmailBuilder builder) {
        this.to = builder.to;
        this.subject = builder.subject;
        this.body = builder.body;
    }
    
    public static class EmailBuilder {
        private String to;
        private String subject;
        private String body;
        
        public EmailBuilder to(String to) {
            this.to = to;
            return this;
        }
        
        public Email build() {
            // Validation
            return new Email(this);
        }
    }
}

// Usage
Email email = Email.builder()
    .to("user@example.com")
    .subject("Hello")
    .body("Message")
    .build();
\`\`\`

## Benefits
- Readable code (method chaining)
- Flexible (set only needed parameters)
- Immutable objects
- Validation before construction

## REST API Example
\`\`\`bash
curl -X POST "http://localhost:8080/api/builder/email/simple?to=test@example.com&subject=Test&body=Hello"
\`\`\`
    `
  },
  prototype: {
    title: 'Prototype Pattern',
    content: `
# Prototype Pattern

## What is it?
Creates new objects by cloning existing ones.

## When to Use
- Object creation is expensive (DB queries, network calls)
- Want to avoid subclassing
- Need independent copies with different states

## Implementation
\`\`\`java
public class Document implements Cloneable {
    private String title;
    private String content;
    private DocumentMetadata metadata;
    
    @Override
    public Document clone() {
        try {
            Document cloned = (Document) super.clone();
            // Deep copy for mutable objects
            cloned.metadata = new DocumentMetadata(this.metadata);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
\`\`\`

## Shallow vs Deep Copy
- **Shallow**: Copies object references (shared nested objects)
- **Deep**: Creates new copies of nested objects (independent)

## Benefits
- Faster than creating from scratch
- Hides complexity of creating new instances
- Reduces need for subclassing

## REST API Example
\`\`\`bash
curl -X POST "http://localhost:8080/api/prototype/document/create?template=business-letter&title=MyLetter&author=John"
\`\`\`
    `
  },
  strategy: {
    title: 'Strategy Pattern',
    content: `
# Strategy Pattern

## What is it?
Defines family of algorithms, encapsulates each one, makes them interchangeable.

## When to Use
- Multiple ways to perform operation
- Want runtime algorithm selection
- Avoid conditional statements
- Open/Closed Principle

## Implementation
\`\`\`java
public interface PaymentStrategy {
    String processPayment(double amount);
}

public class CreditCardStrategy implements PaymentStrategy {
    public String processPayment(double amount) {
        return "Paid with Credit Card: $" + amount;
    }
}

public class PaymentContext {
    private PaymentStrategy strategy;
    
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    
    public String executePayment(double amount) {
        return strategy.processPayment(amount);
    }
}

// Usage
PaymentContext context = new PaymentContext();
context.setStrategy(new CreditCardStrategy());
context.executePayment(100.00);
\`\`\`

## Benefits
- No if-else chains
- Easy to add new strategies
- Runtime algorithm switching
- Promotes composition over inheritance

## REST API Example
\`\`\`bash
curl -X POST "http://localhost:8080/api/strategy/payment/process?method=CREDIT_CARD&amount=100"
curl -X POST "http://localhost:8080/api/strategy/payment/process?method=PAYPAL&amount=100"
\`\`\`
    `
  },
  observer: {
    title: 'Observer Pattern',
    content: `
# Observer Pattern

## What is it?
Defines one-to-many dependency. When one object changes, all dependents are notified.

## When to Use
- Event handling systems
- Newsletter subscriptions
- Stock price updates
- UI updates based on model changes

## Implementation
\`\`\`java
public interface Observer {
    void update(String event);
}

public class NewsletterPublisher {
    private List<Observer> observers = new ArrayList<>();
    
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
    
    public void publishArticle(String article) {
        notifyObservers("New article: " + article);
    }
}

public class EmailSubscriber implements Observer {
    public void update(String event) {
        System.out.println("Email notification: " + event);
    }
}
\`\`\`

## Benefits
- Loose coupling between subject and observers
- Dynamic subscription/unsubscription
- Broadcast communication
- Supports event-driven architecture

## REST API Example
\`\`\`bash
curl -X POST "http://localhost:8080/api/observer/subscribe?name=John&contact=john@example.com&type=EMAIL"
curl -X POST "http://localhost:8080/api/observer/publish?article=New%20Article"
\`\`\`
    `
  },
  decorator: {
    title: 'Decorator Pattern',
    content: `
# Decorator Pattern

## What is it?
Adds responsibilities to objects dynamically. Alternative to subclassing.

## When to Use
- Add functionality without modifying code
- Avoid class explosion (too many subclasses)
- Runtime feature addition
- Single Responsibility Principle

## Implementation
\`\`\`java
public interface Coffee {
    String getDescription();
    double getCost();
}

public class Espresso implements Coffee {
    public String getDescription() { return "Espresso"; }
    public double getCost() { return 2.00; }
}

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee wrappedCoffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.wrappedCoffee = coffee;
    }
}

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Milk";
    }
    
    public double getCost() {
        return wrappedCoffee.getCost() + 0.50;
    }
}

// Usage - decorators can be stacked
Coffee coffee = new MilkDecorator(
                    new MochaDecorator(
                        new Espresso()));
// Result: "Espresso, Mocha, Milk" for $3.20
\`\`\`

## Key Points
- Decorator IS-A Component (same interface)
- Decorator HAS-A Component (wraps it)
- Can stack multiple decorators
- Java I/O uses this (BufferedReader wraps FileReader)

## Benefits
- Flexible alternative to subclassing
- Add/remove features at runtime
- Combine decorators in any order
- Follows Open/Closed Principle

## REST API Example
\`\`\`bash
curl -X POST "http://localhost:8080/api/decorator/coffee/order?base=ESPRESSO&additions=MILK&additions=MOCHA"
\`\`\`
    `
  },
};
