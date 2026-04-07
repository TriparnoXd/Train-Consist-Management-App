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
        return String.format("[Type: %s, Capacity: %d]", name, capacity);
    }
}

/**
 * UC10: Count Total Seats in Train (reduce)
 * This class demonstrates functional aggregation to calculate total
 * seating capacity across the entire train consist.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Capacity Aggregation ===");

        // 1. Initialize the list of bogies
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("General", 90));

        System.out.println("Current Train Consist:");
        trainConsist.forEach(System.out::println);

        // 2. Stream Pipeline: Map and Reduce
        // Step 1: stream() - Start the pipeline
        // Step 2: map() - Extract only the capacity (Integer) from each Bogie
        // Step 3: reduce() - Sum all capacities starting from an identity of 0
        int totalSeatingCapacity = trainConsist.stream()
                .map(Bogie::getCapacity)            // Extracting numeric values
                .reduce(0, Integer::sum);           // Aggregating into a single total

        // 3. Display the Aggregated Result
        System.out.println("\n--- Operational Analytics Report ---");
        System.out.println("Total Number of Bogies: " + trainConsist.size());
        System.out.println("Total Seating Capacity: " + totalSeatingCapacity + " seats");
        System.out.println("------------------------------------");

        // 4. Verification with Empty List (Edge Case Handling)
        List<Bogie> emptyConsist = new ArrayList<>();
        int emptyTotal = emptyConsist.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        System.out.println("Empty Train Capacity Check: " + emptyTotal + " seats");

        // 5. Verification of Original Collection Integrity
        System.out.println("\nVerification: Original list remains unchanged with "
                + trainConsist.size() + " bogies.");
        System.out.println("