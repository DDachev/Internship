public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.length() < 1 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can't be negative.");
        }
        this.price = price;
    }
}