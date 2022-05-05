import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        double F = Double.parseDouble(sc.nextLine());

        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        String licenseNo;
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(", ");
            String type = input[0];
            String model = input[1];

            DecimalFormat df = new DecimalFormat("0000");
            licenseNo = df.format(i);

            int power = Integer.parseInt(input[2]);
            double fuelConsumption = Double.parseDouble(input[3]);
            int yearProduced = Integer.parseInt(input[4]);
            int distance = Integer.parseInt(input[5]);

            if (input.length == 7 && !input[6].matches("[a-zA-Z]+")) {
                double weight = Double.parseDouble(input[6]);
                Vehicle newVehicle = new Vehicle(type, model, power, fuelConsumption, yearProduced, distance, licenseNo, weight);
                vehicleList.add(newVehicle);
            } else if (input.length == 7 && input[6].matches("[a-zA-Z]+")) {
                String color = input[6];
                Vehicle newVehicle = new Vehicle(type, model, power, fuelConsumption, yearProduced, distance, licenseNo, color);
                vehicleList.add(newVehicle);
            }

            if (input.length == 8) {
                String color = input[7];
                Vehicle newVehicle = new Vehicle(type, model, power, fuelConsumption, yearProduced, distance, licenseNo, color);
                vehicleList.add(newVehicle);
            } else {
                Vehicle newVehicle = new Vehicle(type, model, power, fuelConsumption, yearProduced, distance, licenseNo);
                vehicleList.add(newVehicle);
            }
        }
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }
    }
}