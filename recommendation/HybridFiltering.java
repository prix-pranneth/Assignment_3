package recommendation;

import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Hybrid strategy that merges collaborative and content-based results.
 */
public class HybridFiltering implements RecommendationStrategy {

    private final RecommendationStrategy collaborative;
    private final RecommendationStrategy contentBased;

    public HybridFiltering(RecommendationStrategy collaborative,
                           RecommendationStrategy contentBased) {
        this.collaborative = collaborative;
        this.contentBased = contentBased;
    }

    @Override
    public List<Product> recommend(User user) {
        List<Product> collabList = collaborative.recommend(user);
        List<Product> contentList = contentBased.recommend(user);

        // Merge while preserving order and removing duplicates.
        Set<Product> merged = new LinkedHashSet<>();
        merged.addAll(collabList);
        merged.addAll(contentList);

        return new ArrayList<>(merged);
    }
}
