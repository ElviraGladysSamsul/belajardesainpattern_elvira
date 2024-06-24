import java.util.*;

// Interface for basic vehicle operations
interface Vehicle {
    void startEngine();
    void stopEngine();
    String getVehicleType();
}

// Interface for cars, extending basic vehicle operations
interface Car extends Vehicle {
    int getNumberOfDoors();
    boolean hasAirConditioning();
}

// Interface for motorcycles, extending basic vehicle operations
interface Motorcycle extends Vehicle {
    boolean hasSideCar();
    boolean isOffRoad();
}

// Interface for boats, extending basic vehicle operations
interface Boat extends Vehicle {
    boolean hasSail();
    double getMaxSpeedOnWater();
}

// Implementation of Car
class Sedan implements Car {
    @Override
    public void startEngine() {
        System.out.println("Starting engine of the sedan...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping engine of the sedan...");
    }

    @Override
    public String getVehicleType() {
        return "Sedan";
    }

    @Override
    public int getNumberOfDoors() {
        return 4;
    }

    @Override
    public boolean hasAirConditioning() {
        return true;
    }
}

// Implementation of Motorcycle
class SportsBike implements Motorcycle {
    @Override
    public void startEngine() {
        System.out.println("Starting engine of the sports bike...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping engine of the sports bike...");
    }

    @Override
    public String getVehicleType() {
        return "Sports Bike";
    }

    @Override
    public boolean hasSideCar() {
        return false;
    }

    @Override
    public boolean isOffRoad() {
        return false;
    }
}

// Implementation of Boat
class Yacht implements Boat {
    @Override
    public void startEngine() {
        System.out.println("Starting engine of the yacht...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping engine of the yacht...");
    }

    @Override
    public String getVehicleType() {
        return "Yacht";
    }

    @Override
    public boolean hasSail() {
        return true;
    }

    @Override
    public double getMaxSpeedOnWater() {
        return 30.0; // in knots
    }
}

// VehicleProcessor class using the interfaces
class VehicleProcessor {
    public void testCar(Car car) {
        car.startEngine();
        System.out.println("Car type: " + car.getVehicleType());
        System.out.println("Number of doors: " + car.getNumberOfDoors());
        System.out.println("Has air conditioning: " + car.hasAirConditioning());
        car.stopEngine();
        System.out.println();
    }

    public void testMotorcycle(Motorcycle motorcycle) {
        motorcycle.startEngine();
        System.out.println("Motorcycle type: " + motorcycle.getVehicleType());
        System.out.println("Has sidecar: " + motorcycle.hasSideCar());
        System.out.println("Is off-road: " + motorcycle.isOffRoad());
        motorcycle.stopEngine();
        System.out.println();
    }

    public void testBoat(Boat boat) {
        boat.startEngine();
        System.out.println("Boat type: " + boat.getVehicleType());
        System.out.println("Has sail: " + boat.hasSail());
        System.out.println("Max speed on water: " + boat.getMaxSpeedOnWater() + " knots");
        boat.stopEngine();
        System.out.println();
    }
}

// Main class demonstrating usage
class VehicleExample {
    public static void main(String[] args) {
        VehicleProcessor processor = new VehicleProcessor();

        // Example usage with Car
        System.out.println("=== Car Example ===");
        Car sedan = new Sedan();
        processor.testCar(sedan);

        // Example usage with Motorcycle
        System.out.println("=== Motorcycle Example ===");
        Motorcycle sportsBike = new SportsBike();
        processor.testMotorcycle(sportsBike);

        // Example usage with Boat
        System.out.println("=== Boat Example ===");
        Boat yacht = new Yacht();
        processor.testBoat(yacht);
    }
}
