# Assignment_3
# E-Retail Recommendation System – Complex Module (Recommendation Engine)

This repository contains the Java implementation of the **Recommendation Engine** complex module
for the e-retail assignment, along with minimal supporting domain and data classes.

The engine is implemented using the **Strategy** and **Singleton** design patterns and demonstrates
three recommendation algorithms:

- `CollaborativeFiltering`
- `ContentBasedFiltering`
- `HybridFiltering`

---

## 1. Prerequisites

- **Operating System:** Any (Windows, macOS, Linux)
- **Java Version:** Java 11 or later (tested with Java 17)
- Java compiler (`javac`) and runtime (`java`) available in your PATH

---

## 2. Project Structure

```text
src/
  model/
    User.java
    Product.java
  data/
    ProductRepository.java
  recommendation/
    RecommendationStrategy.java
    CollaborativeFiltering.java
    ContentBasedFiltering.java
    HybridFiltering.java
    RecommendationEngine.java
  app/
    DemoMain.java
```
How to Compile

From the root of the repository (where src/ is located):

```javac -d out $(find src -name "*.java")```

On Windows (PowerShell):

```Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName } | javac -d out @-```
This compiles all Java files into the out/ directory.

How to Run the Demo

From the root folder, after compiling:

```cd out
java app.DemoMain
```

You should see console output showing:

Recommendations using CollaborativeFiltering

Recommendations using ContentBasedFiltering

Combined Hybrid recommendations

This demonstrates how the RecommendationEngine switches strategies at runtime.


Sample Data

Sample products are defined in data/ProductRepository.java:

Electronics (headphones, mouse)

Books (fantasy novel, cookbook)

Sports (running shoes, yoga mat)

Accessories (phone case)

The sample User in DemoMain has preferences for:

```Arrays.asList("electronics", "books")```

Mapping to the Design Report

User → model.User

Product → model.Product

RecommendationStrategy interface → recommendation.RecommendationStrategy

CollaborativeFiltering → recommendation.CollaborativeFiltering

ContentBasedFiltering → recommendation.ContentBasedFiltering

HybridFiltering → recommendation.HybridFiltering

RecommendationEngine (Singleton) → recommendation.RecommendationEngine

ProductRepository (data access) → data.ProductRepository

Demo / Application entry point → app.DemoMain

This module maps directly to the conceptual class diagram described in the design report.






