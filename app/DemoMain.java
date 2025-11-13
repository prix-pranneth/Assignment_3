package app;

import model.User;
import recommendation.CollaborativeFiltering;
import recommendation.ContentBasedFiltering;
import recommendation.HybridFiltering;
import recommendation.RecommendationEngine;

import java.util.Arrays;

public class DemoMain {

    public static void main(String[] args) {
        // Create a sample user with preferences
        User user = new User(
                1,
                "Alice",
                "alice@example.com",
                "hashedPassword123",
                Arrays.asList("electronics", "books")
        );

        RecommendationEngine engine = RecommendationEngine.getInstance();

        System.out.println("=== Collaborative Filtering ===");
        engine.setStrategy(new CollaborativeFiltering());
        engine.generate(user).forEach(p -> System.out.println(" - " + p));

        System.out.println("\n=== Content-Based Filtering ===");
        engine.setStrategy(new ContentBasedFiltering());
        engine.generate(user).forEach(p -> System.out.println(" - " + p));

        System.out.println("\n=== Hybrid Recommendations ===");
        engine.setStrategy(new HybridFiltering(
                new CollaborativeFiltering(),
                new ContentBasedFiltering()
        ));
        engine.generate(user).forEach(p -> System.out.println(" - " + p));
    }
}
