package recommendation;

import data.ProductRepository;
import model.Product;
import model.User;

import java.util.List;

/**
 * Simplified collaborative filtering:
 * For this assignment, we just pretend "top rated" items represent
 * items liked by similar users.
 */
public class CollaborativeFiltering implements RecommendationStrategy {

    private static final int DEFAULT_LIMIT = 5;

    @Override
    public List<Product> recommend(User user) {
        // In a real implementation, this would use user similarity matrices, etc.
        return ProductRepository.findTopRated(DEFAULT_LIMIT);
    }
}
