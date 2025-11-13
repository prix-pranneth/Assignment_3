
---

## 4. `DeveloperGuide.md` (Short Dev Guide Mapping Diagram → Code)

# Developer Guide – Recommendation Engine Module

This document gives a short technical overview for developers and markers about
where the main classes from the **conceptual class diagram** are implemented in the codebase.

---

## 1. Packages Overview

- `model` – Core domain model classes (`User`, `Product`)
- `data` – Simple in-memory data access (`ProductRepository`)
- `recommendation` – Complex module (Recommendation Engine + strategies)
- `app` – Demo entry point for running and testing the complex module

---

## 2. Class Mapping from UML Diagram

### Domain Layer

- **User (UML)** → `model.User`
  - Fields: `userId`, `name`, `email`, `passwordHash`, `preferences`
  - Methods: `updateProfile()`, `authenticate()`, `getPreferences()`

- **Product (UML)** → `model.Product`
  - Fields: `productId`, `name`, `category`, `price`, `rating`, `stock`
  - Methods: `updateStock()`, `toString()`

### Data Layer

- **ProductRepository (UML/Data Access)** → `data.ProductRepository`
  - Provides in-memory sample data.
  - Methods: `findAll()`, `findByCategory()`, `findTopRated()`.

### Recommendation Engine (Complex Module)

- **RecommendationStrategy (interface)** → `recommendation.RecommendationStrategy`
  - Method: `recommend(User user) : List<Product>`

- **CollaborativeFiltering** → `recommendation.CollaborativeFiltering`
  - Implements: `RecommendationStrategy`
  - Uses `ProductRepository.findTopRated()` as a stand–in for collaborative logic.

- **ContentBasedFiltering** → `recommendation.ContentBasedFiltering`
  - Implements: `RecommendationStrategy`
  - Uses `User.preferences` + `Product.category` for matching.

- **HybridFiltering** → `recommendation.HybridFiltering`
  - Implements: `RecommendationStrategy`
  - Internally holds references to both a `CollaborativeFiltering` and a
    `ContentBasedFiltering` instance.
  - Merges result lists while removing duplicates.

- **RecommendationEngine (Singleton)** → `recommendation.RecommendationEngine`
  - Field: `private static RecommendationEngine instance`
  - Field: `private RecommendationStrategy currentStrategy`
  - Methods:
    - `getInstance()` – returns the singleton instance.
    - `setStrategy(RecommendationStrategy strategy)` – swap algorithm at runtime.
    - `generate(User user)` – delegates to `currentStrategy.recommend(user)`.

### Application / Presentation

- **Demo / Application Entry Point** → `app.DemoMain`
  - Creates a `User` with preferences.
  - Obtains the `RecommendationEngine` singleton.
  - Demonstrates:
    - Collaborative filtering recommendations
    - Content-based recommendations
    - Hybrid recommendations

---

## 3. How to Extend the Recommendation Engine

To add a new algorithm:

1. Create a new class implementing `RecommendationStrategy`.
2. Implement the `recommend(User user)` method.
3. Use `RecommendationEngine.getInstance().setStrategy(new YourNewStrategy());`
   in application code or configuration.

No changes are required to existing strategy classes or to the engine itself,
which demonstrates the **Strategy Pattern** and clean extensibility.

---
