package model;

public class Product {
    private final int productId;
    private final String name;
    private final String category;
    private final double price;
    private final double rating;
    private int stock;

    public Product(int productId, String name, String category, double price, double rating, int stock) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int amount) {
        this.stock += amount;
    }

    @Override
    public String toString() {
        return name + " (" + category + ", $" + price + ", rating " + rating + ")";
    }
}
