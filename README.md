# Design Patterns Learning Project

A comprehensive learning platform for design patterns with practical implementations in Spring Boot and interactive documentation.

## 📚 Project Overview

This repository contains two main components:

1. **Spring Boot Application** (`design-patterns-spring/`) - Production-ready implementations of 7 core design patterns with REST APIs
2. **React Documentation Site** (`docs/`) - Interactive learning platform with pattern explanations, system design FAQs, and interview preparation

## 🎯 Design Patterns Implemented

### Creational Patterns
- **Singleton** - Thread-safe configuration manager
- **Factory Method** - Notification system (Email, SMS, Push)
- **Abstract Factory** - UI component factory (Windows, Mac)
- **Builder** - Email builder with fluent API
- **Prototype** - Document cloning with template registry

### Behavioral Patterns
- **Strategy** - Payment processing (Credit Card, PayPal, Crypto)
- **Observer** - Newsletter subscription system

### Structural Patterns
- **Decorator** - Coffee ordering with dynamic add-ons

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+
- Node.js 18+
- npm 8+

### Spring Boot Application

```bash
cd design-patterns-spring

# Build
mvn clean install

# Run
mvn spring-boot:run

# Run tests
mvn test
```

Access the application:
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html

### React Documentation Site

```bash
cd docs

# Install dependencies
npm install

# Development server
npm run dev

# Build for production
npm run build

# Deploy to GitHub Pages
npm run deploy
```

Access the docs: http://localhost:5173

## 📖 API Examples

### Singleton Pattern
```bash
# Get singleton instance ID (same across all requests)
curl http://localhost:8080/api/singleton/instance-id

# Get configuration
curl http://localhost:8080/api/singleton/config/app.name
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
# Send email with Builder
curl -X POST "http://localhost:8080/api/builder/email/simple?to=user@example.com&subject=Test&body=Hello"
```

### Strategy Pattern
```bash
# Process payment with different strategies
curl -X POST "http://localhost:8080/api/strategy/payment/process?method=CREDIT_CARD&amount=100"
curl -X POST "http://localhost:8080/api/strategy/payment/process?method=PAYPAL&amount=100"
```

### Observer Pattern
```bash
# Subscribe to newsletter
curl -X POST "http://localhost:8080/api/observer/subscribe?name=John&contact=john@example.com&type=EMAIL"

# Publish article (notifies all subscribers)
curl -X POST "http://localhost:8080/api/observer/publish?article=New%20Article"
```

### Decorator Pattern
```bash
# Order coffee with additions
curl -X POST "http://localhost:8080/api/decorator/coffee/order?base=ESPRESSO&additions=MILK&additions=MOCHA"
```

## 📁 Project Structure

```
Learn/
├── design-patterns-spring/          # Spring Boot application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/learn/designpatterns/
│   │   │   │   ├── singleton/      # Singleton pattern
│   │   │   │   ├── factory/        # Factory patterns
│   │   │   │   ├── builder/        # Builder pattern
│   │   │   │   ├── prototype/      # Prototype pattern
│   │   │   │   ├── strategy/       # Strategy pattern
│   │   │   │   ├── observer/       # Observer pattern
│   │   │   │   └── decorator/      # Decorator pattern
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                   # Comprehensive unit tests
│   ├── pom.xml
│   └── README.md
│
├── docs/                            # React documentation site
│   ├── src/
│   │   ├── components/             # Layout and reusable components
│   │   ├── pages/                  # Route pages
│   │   ├── data/                   # Pattern content
│   │   └── App.jsx
│   ├── package.json
│   └── README.md
│
├── .gitignore
└── README.md                        # This file
```

## 🎓 Learning Resources

Each pattern implementation includes:

✅ **Detailed Comments** - Explains WHAT, WHY, and WHEN to use  
✅ **Real-World Examples** - Practical scenarios from production systems  
✅ **Unit Tests** - Demonstrates correct usage and edge cases  
✅ **REST APIs** - Interactive way to understand pattern behavior  
✅ **Best Practices** - Thread-safety, immutability, SOLID principles

## 🌐 Deployment

### Spring Boot Application

#### JAR Deployment
```bash
cd design-patterns-spring
mvn clean package
java -jar target/design-patterns-spring-1.0.0.jar
```

#### Docker (Optional)
```bash
# Create Dockerfile in design-patterns-spring/
docker build -t design-patterns-app .
docker run -p 8080:8080 design-patterns-app
```

### React Documentation Site

#### GitHub Pages
```bash
cd docs

# Update package.json homepage
# "homepage": "https://yourusername.github.io/Learn"

# Update vite.config.js base
# base: '/Learn/'

npm run deploy
```

#### Other Hosting
Build and deploy the `dist/` folder to:
- Netlify
- Vercel
- AWS S3
- Azure Static Web Apps

## 🧪 Testing

### Spring Boot Tests
```bash
cd design-patterns-spring

# Run all tests
mvn test

# Run specific pattern tests
mvn test -Dtest=ConfigurationManagerTest
mvn test -Dtest=NotificationFactoryTest
mvn test -Dtest=EmailTest

# Test with coverage
mvn clean test jacoco:report
```

### React App
```bash
cd docs
npm run lint  # Check code quality
npm run build # Verify production build works
```

## 🔧 Configuration

### Spring Boot
Edit `design-patterns-spring/src/main/resources/application.properties`:
```properties
server.port=8080
logging.level.com.learn.designpatterns=DEBUG
```

### React App
Edit `docs/package.json` for deployment:
```json
{
  "homepage": "https://yourusername.github.io/Learn"
}
```

Edit `docs/vite.config.js`:
```javascript
export default defineConfig({
  base: '/Learn/'
})
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewPattern`)
3. Implement your pattern with:
   - Detailed comments
   - Unit tests
   - REST controller (if applicable)
   - Documentation in docs site
4. Ensure tests pass: `mvn test`
5. Ensure build succeeds: `npm run build`
6. Commit changes (`git commit -m 'Add NewPattern'`)
7. Push to branch (`git push origin feature/NewPattern`)
8. Open a Pull Request

### Adding a New Pattern

1. **Spring Boot**:
   - Create package: `com.learn.designpatterns.newpattern`
   - Implement pattern classes with detailed comments
   - Create REST controller
   - Write unit tests
   - Update README

2. **React Docs**:
   - Add pattern data to `docs/src/data/patterns.js`
   - Add to navigation in `docs/src/components/Layout.jsx`
   - Test locally

## 📚 Additional Learning Resources

### Books
- "Design Patterns: Elements of Reusable Object-Oriented Software" (Gang of Four)
- "Head First Design Patterns" by Eric Freeman
- "Effective Java" by Joshua Bloch

### Online
- [Refactoring.Guru](https://refactoring.guru/design-patterns)
- [SourceMaking](https://sourcemaking.com/design_patterns)
- [Spring Documentation](https://spring.io/guides)

## 🐛 Troubleshooting

### Spring Boot

**Port already in use**:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

**Build failures**:
```bash
mvn clean install -U
```

### React App

**Build errors**:
```bash
rm -rf node_modules dist
npm install
npm run build
```

**Routing issues on GitHub Pages**:
Ensure `basename` in Router matches repository name in `App.jsx`.

## 📊 Tech Stack

### Backend
- Java 17
- Spring Boot 3.2.1
- Spring Web
- Lombok
- SpringDoc OpenAPI (Swagger)
- JUnit 5

### Frontend
- React 19
- Vite 7
- React Router 7
- Tailwind CSS 4
- React Markdown

## 📝 License

This project is for educational purposes.

## 👨‍💻 Authors

Design Patterns Learning Project

---

## 🌟 Star This Repository

If you find this project helpful for learning design patterns, please give it a star! ⭐

## 📮 Feedback

Issues and suggestions are welcome! Please open an issue or submit a pull request.

---

Happy Learning! 🚀📚
