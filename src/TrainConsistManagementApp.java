import java.util.*;
import java.util.stream.Collectors;

/**
 * Bogie Class: Represents a custom object with attributes.
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("%-15s | Capacity: %d seats", name, capacity);
    }
}

/**
 * UC8: Filter Passenger Bogies Using Streams
 * This class demonstrates functional-style collection processing to
 * select bogies based on business rules (Capacity > 60).
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Stream Filtering ===");

        // 1. Initialize the list of bogies (as in UC7)
        List<Bogie> allBogies = new ArrayList<>();
        allBogies.add(new Bogie("Sleeper", 72));
        allBogies.add(new Bogie("AC Chair", 56));
        allBogies.add(new Bogie("First Class", 24));
        allBogies.add(new Bogie("General", 90));
        allBogies.add(new Bogie("Executive", 40));

        System.out.println("Total bogies in system: " + allBogies.size());

        // 2. Stream Pipeline: Filter and Collect
        // We want to find "High-Capacity" bogies (Capacity > 60)
        int threshold = 60;
        System.out.println("\nFiltering bogies with capacity greater than " + threshold + "...");

        List<Bogie> highCapacityBogies = allBogies.stream()
                .filter(b -> b.getCapacity() > threshold) // Lambda expression for the condition
                .collect(Collectors.toList());            // Gather results into a new list

        // 3. Display Filtered Results
        System.out.println("--- High-Capacity Bogie Report ---");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        // 4. Verification of Original Collection Integrity
        // The Stream API does not modify 'allBogies'
        System.out.println("\nVerification: Original list still contains " + allBogies.size() + " bogies.");

        // 5. Another Example: Finding small bogies (Capacity <= 40)
        System.out.println("\n--- Special-Purpose Bogie Report (Capacity <= 40) ---");
        allBogies.stream()
                .filter(b -> b.getCapacity() <= 40)
                .forEach(System.out::println);

        System.out.println("=================================================");
    }
}