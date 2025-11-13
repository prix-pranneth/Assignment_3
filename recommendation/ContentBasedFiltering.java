package recommendation;

import data.ProductRepository;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple content-based recommendations based on user's preferred categories.
 */
public class ContentBasedFiltering implements RecommendationStrategy {

    @Override
    public List<Product> recommend(User user) {
        List<String> preferences = user.getPreferences();
        if (preferences == null || preferences.isEmpty()) {
            // No preferences -> fallback to top rated
            return ProductRepository.findTopRated(5);
        }

        Set<Product> resultSet = new HashSet<>();
        for (String category : preferences) {
            resultSet.addAll(ProductRepository.findByCategory(category));
        }

        return new ArrayList<>(resultSet);
    }
}
