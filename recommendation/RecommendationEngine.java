package recommendation;

import model.Product;
import model.User;

import java.util.List;

/**
 * Singleton RecommendationEngine that delegates to a pluggable strategy.
 */
public class RecommendationEngine {

    private static RecommendationEngine instance;

    private RecommendationStrategy currentStrategy;

    private RecommendationEngine() {
        // Default strategy if none set
        this.currentStrategy = new CollaborativeFiltering();
    }

    public static synchronized RecommendationEngine getInstance() {
        if (instance == null) {
            instance = new RecommendationEngine();
        }
        return instance;
    }

    public void setStrategy(RecommendationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.currentStrategy = strategy;
    }

    public List<Product> generate(User user) {
        if (currentStrategy == null) {
            throw new IllegalStateException("No recommendation strategy set");
        }
        return currentStrategy.recommend(user);
    }
}
