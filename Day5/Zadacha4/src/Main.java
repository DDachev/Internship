import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        getPeople(sc, people);
        getProducts(sc, products);
        getCommands(sc, people, products);


        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static void getCommands(Scanner sc, List<Person> people, List<Product> products) {
        String[] userInput = sc.nextLine().split("\\s");
        while (!userInput[0].equalsIgnoreCase("END")) {
            String name = userInput[0];
            String productName = userInput[1];

            if (userInput.length == 3) {
                name = userInput[0] + " " + userInput[1];
                productName = userInput[userInput.length - 1];
            }

            for (Person person : people) {
                if (person.getName().equals(name)) {
                    for (Product product : products) {
                        if (product.getName().equals(productName)) {
                            person.buyProduct(product);
                        }
                    }
                }
            }
            userInput = sc.nextLine().split("\\s");
        }
    }

    public static void getPeople(Scanner sc, List<Person> people) {
        String[] inputPeople = sc.nextLine().split(";");
        for (String s : inputPeople) {
            String[] personInput = s.split("=");
            Person person = new Person(personInput[0], Double.parseDouble(personInput[1]));
            people.add(person);
        }
    }

    public static void getProducts(Scanner sc, List<Product> products) {
        String[] inputProducts = sc.nextLine().split(";");
        for (String s : inputProducts) {
            String[] productInput = s.split("=");
            Product product = new Product(productInput[0], Double.parseDouble(productInput[1]));
            products.add(product);
        }
    }

}