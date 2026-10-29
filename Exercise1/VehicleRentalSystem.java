
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Rentable {
    double calculateRent(int days);
    boolean isAvailable();
}

abstract class Vehicle implements Rentable {
    protected String id;
    protected String model;
    protected double dailyRate;
    protected boolean available = true;

    public Vehicle(String id, String model, double dailyRate) {
        this.id = id;
        this.model = model;
        this.dailyRate = dailyRate;
    }

    public String getId() {
        return id;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + model
                + " (" + id + ")";
    }
}

class Car extends Vehicle {
    public Car(String id, String model, double rate) {
        super(id, model, rate);
    }

    @Override
    public double calculateRent(int days) {
        return dailyRate * days;
    }
}

class Bike extends Vehicle {
    public Bike(String id, String model, double rate) {
        super(id, model, rate);
    }

    @Override
    public double calculateRent(int days) {
        double rent = dailyRate * days;

        if (days >= 7) {
            rent = rent * 0.90;
        }

        return rent;
    }
}

class Truck extends Vehicle {
    public Truck(String id, String model, double rate) {
        super(id, model, rate);
    }

    @Override
    public double calculateRent(int days) {
        return (dailyRate * days) + 500;
    }
}

class Customer {
    private String name;
    private List<Rental> history = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        history.add(rental);
    }

    public List<Rental> getHistory() {
        return history;
    }
}

class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int days;

    public Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    public double getTotalRent() {
        return vehicle.calculateRent(days);
    }
}

class RentalShop {
    private List<Vehicle> fleet = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public Vehicle findVehicle(String id) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                return vehicle;
            }
        }
        return null;
    }

    public void showAvailable() {
        System.out.println("\nAvailable vehicles:");

        boolean found = false;

        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailable()) {
                System.out.printf(
                    "  %s - Rs. %.2f/day%n",
                    vehicle,
                    vehicle.getDailyRate()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("  No vehicles available.");
        }
    }

    public void rent(Vehicle vehicle, Customer customer, int days) {
        if (vehicle == null || !fleet.contains(vehicle)) {
            throw new IllegalArgumentException(
                "Vehicle not found in the shop."
            );
        }

        if (!vehicle.isAvailable()) {
            throw new IllegalStateException(
                vehicle + " is already rented"
            );
        }

        if (days <= 0) {
            throw new IllegalArgumentException(
                "Rental days must be greater than zero."
            );
        }

        Rental rental = new Rental(vehicle, customer, days);

        vehicle.setAvailable(false);
        customer.addRental(rental);

        System.out.printf(
            "%s rented %s for %d days = %.2f%n",
            customer.getName(),
            vehicle,
            days,
            rental.getTotalRent()
        );
    }

    public void giveBack(String vehicleId) {
        Vehicle vehicle = findVehicle(vehicleId);

        if (vehicle == null) {
            throw new IllegalArgumentException(
                "Vehicle ID not found."
            );
        }

        if (vehicle.isAvailable()) {
            throw new IllegalStateException(
                vehicle + " is not currently rented."
            );
        }

        vehicle.setAvailable(true);
        System.out.println(vehicle + " returned successfully.");
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RentalShop shop = new RentalShop();

        shop.addVehicle(new Car("C1", "Swift", 2000));
        shop.addVehicle(new Bike("B1", "Activa", 400));
        shop.addVehicle(new Truck("T1", "Tata Ace", 2500));

        List<Customer> customers = new ArrayList<>();

        while (true) {
            System.out.println("\n===== VEHICLE RENTAL SYSTEM =====");
            System.out.println("1. Rent a vehicle");
            System.out.println("2. Return a vehicle");
            System.out.println("3. Show available vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    shop.showAvailable();

                    System.out.print("\nEnter vehicle ID: ");
                    String id = sc.nextLine().trim();

                    Vehicle vehicle = shop.findVehicle(id);

                    if (vehicle == null) {
                        System.out.println("Error: Vehicle not found.");
                        break;
                    }

                    if (!vehicle.isAvailable()) {
                        System.out.println(
                            "Error: " + vehicle + " is already rented"
                        );
                        break;
                    }

                    System.out.print("Enter your name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter number of days: ");

                    int days;

                    try {
                        days = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println(
                            "Please enter a valid number of days."
                        );
                        break;
                    }

                    Customer customer = null;

                    for (Customer c : customers) {
                        if (c.getName().equalsIgnoreCase(name)) {
                            customer = c;
                            break;
                        }
                    }

                    if (customer == null) {
                        customer = new Customer(name);
                        customers.add(customer);
                    }

                    try {
                        shop.rent(vehicle, customer, days);
                    } catch (IllegalArgumentException |
                             IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter vehicle ID to return: ");
                    String returnId = sc.nextLine().trim();

                    try {
                        shop.giveBack(returnId);
                    } catch (IllegalArgumentException |
                             IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    shop.showAvailable();
                    break;

                case 4:
                    System.out.println(
                        "Thank you for using Vehicle Rental System!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println(
                        "Invalid choice. Please select 1 to 4."
                    );
            }
        }
    }
}
