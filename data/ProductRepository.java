package data;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {

    // In a real system this would talk to a database.
    // Here we use a static in-memory list as sample data.
    private static final List<Product> PRODUCTS = new ArrayList<>();

    static {
        PRODUCTS.add(new Product(1, "Noise-Cancelling Headphones", "electronics", 199.99, 4.7, 15));
        PRODUCTS.add(new Product(2, "Wireless Mouse", "electronics", 29.99, 4.4, 120));
        PRODUCTS.add(new Product(3, "Fantasy Novel", "books", 14.99, 4.9, 60));
        PRODUCTS.add(new Product(4, "Cookbook", "books", 24.99, 4.3, 45));
        PRODUCTS.add(new Product(5, "Running Shoes", "sports", 89.99, 4.5, 30));
        PRODUCTS.add(new Product(6, "Yoga Mat", "sports", 39.99, 4.6, 80));
        PRODUCTS.add(new Product(7, "Phone Case", "accessories", 19.99, 4.1, 200));
    }

    public static List<Product> findAll() {
        return Collections.unmodifiableList(PRODUCTS);
    }

    public static List<Product> findByCategory(String category) {
        return PRODUCTS.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public static List<Product> findTopRated(int limit) {
        return PRODUCTS.stream()
                .sorted((a, b) -> Double.compare(b.getRating(), a.getRating()))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
