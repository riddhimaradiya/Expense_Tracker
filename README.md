# Expense Tracker Application

A comprehensive Spring Boot-based web application for tracking personal expenses, managing budgets, and generating financial reports.

## 🎯 Overview

The **Expense Tracker Application** is a full-stack Java Spring Boot application designed to help users:
- Track their daily expenses
- Categorize spending by type
- Set and monitor monthly budgets
- Generate detailed financial reports
- Analyze spending patterns

This application uses MySQL as the database and provides RESTful APIs for all operations.

---

## ✨ Features

- **Expense Management**
  - Add, update, and delete expense records
  - Categorize expenses with predefined categories
  - Add detailed notes to expenses
  - Track expenses by date

- **Budget Management**
  - Set monthly budgets for different categories
  - Monitor budget vs actual spending
  - Track budget utilization percentage

- **Financial Reports**
  - Generate spending reports by category
  - View monthly expense summaries
  - Analyze expense trends

- **Category Support**
  - Predefined expense categories (Food, Transportation, Entertainment, Utilities, Healthcare, etc.)
  - Organized spending by category

---

## 🛠️ Tech Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| **Language** | Java | 17 |
| **Framework** | Spring Boot | 3.5.13 |
| **Data Access** | Spring Data JPA | - |
| **Web** | Spring Web | - |
| **Database** | MySQL | 8.0+ |
| **Build Tool** | Maven | 3.6+ |

### Dependencies
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- MySQL Connector/J
- Spring Boot Starter Test

---


## 🚀 Installation & Setup

### Step 1: Clone the Repository
```bash
git clone https://github.com/yourusername/Expense-tracker.git
cd Expense-tracker
```

### Step 2: Create MySQL Database
Open MySQL and create a new database:
```sql
CREATE DATABASE expense_tracker_db;
USE expense_tracker_db;
```

### Step 3: Configure Application Properties
Update the database credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Step 4: Build the Project
Using Maven wrapper (Windows):
```bash
mvnw clean install
```

Using Maven wrapper (Linux/Mac):
```bash
./mvnw clean install
```

Using Maven directly:
```bash
maven clean install
```

---

## ⚙️ Configuration

The application is configured via `src/main/resources/application.properties`:

```properties
# Application Name
spring.application.name=Expense-tracker

# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker_db
spring.datasource.username=your username
spring.datasource.password=your password

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server Configuration
server.port=8081
```

### Configuration Explanation:
- **ddl-auto=update**: Automatically creates/updates database schema on startup
- **show-sql=true**: Logs SQL queries to console (useful for debugging)
- **server.port=8081**: Application runs on port 8081

---

## 📂 Project Structure

```
Expense-tracker/
├── src/
│   ├── main/
│   │   ├── java/com/Expense_tracker/
│   │   │   ├── Category.java                 # Enum for expense categories
│   │   │   ├── ExpenseTrackerApplication.java
│   │   │   ├── Controller/
│   │   │   │   ├── ExpenseController.java    # REST APIs for expenses
│   │   │   │   ├── BudgetController.java     # REST APIs for budgets
│   │   │   │   └── ReportController.java     # REST APIs for reports
│   │   │   ├── Model/
│   │   │   │   ├── Expense.java              # Expense entity
│   │   │   │   └── MonthlyBudget.java        # Budget entity
│   │   │   ├── Repository/
│   │   │   │   ├── ExpenseRepository.java    # Data access for Expenses
│   │   │   │   └── MonthlyBudgetRepository.java
│   │   │   └── Service/
│   │   │       ├── ExpenseService.java       # Business logic for expenses
│   │   │       ├── BudgetService.java        # Business logic for budgets
│   │   │       └── ReportService.java        # Business logic for reports
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/                       # Static resources
│   │       └── templates/                    # HTML templates
│   └── test/
│       └── java/com/Expense_tracker/
│           └── ExpenseTrackerApplicationTests.java
├── pom.xml                                   # Maven configuration
├── README.md                                 # This file
└── HELP.md
```

### Architecture Overview:

```
Controller (REST API)
    ↓
Service (Business Logic)
    ↓
Repository (Data Access)
    ↓
Database (MySQL)
```

---

## 🏃 Running the Application

### Using Maven Wrapper (Recommended)

**Windows:**
```bash
mvnw spring-boot:run
```

**Linux/Mac:**
```bash
./mvnw spring-boot:run
```

### Using Maven directly:
```bash
mvn spring-boot:run
```

### Using IDE:
1. Open the project in your IDE (IntelliJ IDEA, Eclipse, VS Code)
2. Navigate to `ExpenseTrackerApplication.java`
3. Click "Run" or press `Shift+F10` (IntelliJ) / `Ctrl+F11` (Eclipse)

### Verify Application is Running:
Once started successfully, you should see output like:
```
...
Application startup complete
Started ExpenseTrackerApplication in X seconds
```

Access the application at: **http://localhost:8081**

---

## 📡 API Endpoints

### Expense Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/expenses` | Get all expenses |
| GET | `/api/expenses/{id}` | Get expense by ID |
| POST | `/api/expenses` | Create new expense |
| PUT | `/api/expenses/{id}` | Update expense |
| DELETE | `/api/expenses/{id}` | Delete expense |

### Budget Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/budgets` | Get all budgets |
| GET | `/api/budgets/{id}` | Get budget by ID |
| POST | `/api/budgets` | Create new budget |
| PUT | `/api/budgets/{id}` | Update budget |
| DELETE | `/api/budgets/{id}` | Delete budget |

### Report Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/reports/monthly` | Get monthly report |
| GET | `/api/reports/category` | Get category-wise report |
| GET | `/api/reports/summary` | Get spending summary |

