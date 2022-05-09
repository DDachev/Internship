import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double balance;
    private List<Product> products = new ArrayList<>();

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
    }

    public void buyProduct(Product product) {
        if (product.getPrice() > this.balance) {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
        } else {
            this.products.add(product);
            this.balance -= product.getPrice();
            System.out.printf("%s bought %s%n", this.name, product.getName());
        }
    }

    private void setMoney(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Balance can't be negative.");
        }
        this.balance = amount;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.length() < 1 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        } else {
            result.append(String.format("%s - ", this.name));
            for (Product product : this.products) {
                result.append(String.format("%s", product.getName()));
                result.append(", ");
            }
        }
        return result.substring(0, result.lastIndexOf(", "));
    }
}