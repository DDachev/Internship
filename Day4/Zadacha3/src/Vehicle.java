import java.time.LocalDate;

public class Vehicle {
    private final String type;
    private final String model;
    private final double power;
    private final double fuelConsumption;
    private final int yearProduced;
    private final int distance;
    private final String licenseNo;
    private double weight;
    private String color = "N/A";


    public Vehicle(String type, String model, double power, double fuelConsumption, int yearProduced, int distance, String licenseNo) {
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;
        this.distance = distance;
        this.licenseNo = licenseNo;
    }

    public Vehicle(String type, String model, double power, double fuelConsumption, int yearProduced, int distance, String licenseNo, String color) {
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;
        this.distance = distance;
        this.licenseNo = licenseNo;
        this.color = color;
    }

    public Vehicle(String type, String model, double power, double fuelConsumption, int yearProduced, int distance, String licenseNo, double weight) {
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;
        this.distance = distance;
        this.licenseNo = licenseNo;
        this.weight = weight;
    }

    public Vehicle(String type, String model, double power, double fuelConsumption, int yearProduced, int distance, String licenseNo, double weight, String color) {
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;
        this.licenseNo = licenseNo;
        this.distance = distance;
        this.weight = weight;
        this.color = color;
    }

    public double calculateTripPrice(double fuelPrice, double distance) {
        return fuelPrice * distance;
    }

    public int getCarAge() {
        return LocalDate.now().getYear() - yearProduced;
    }

    public double getInsurancePrice() {
        double typeCoefficient = 0;
        switch (type) {
            case "car":
                typeCoefficient = 1.00;
                break;
            case "suv":
                typeCoefficient = 1.12;
                break;
            case "truck":
                typeCoefficient = 1.20;
                break;
            case "motorcycle":
                typeCoefficient = 1.50;
            default:
                // code block
        }
        return (0.16 * power) * (1.25 * getCarAge()) * (0.05 * fuelConsumption) * typeCoefficient;
    }

    @Override
    public String toString() {
        return licenseNo + " - " + model + ", " + yearProduced + ", " + color + " Insurance cost: " + String.format("%.02f", getInsurancePrice()) + " - Travel cost: " + String.format("%.02f", calculateTripPrice(1.5, distance));
    }
}