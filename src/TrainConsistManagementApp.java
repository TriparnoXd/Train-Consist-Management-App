import java.util.*;

/**
 * Custom Exception: InvalidCapacityException
 * A domain-specific checked exception to handle railway business rule violations.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * Bogie Class: Represents a custom object with built-in validation.
 */
class Bogie {
    private String name;
    private int capacity;

    /**
     * Constructor with Fail-Fast Validation.
     * @throws InvalidCapacityException if capacity is less than or equal to zero.
     */
    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid Capacity: [" + capacity +
                    "]. Capacity must be greater than zero for " + name + ".");
        }
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("Bogie: %-12s | Capacity: %d seats", name, capacity);
    }
}

/**
 * UC14: Handle Invalid Bogie Capacity (Custom Exception)
 * This class demonstrates enforcing business constraints during object creation.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Custom Exception Handling ===\n");

        List<Bogie> trainConsist = new ArrayList<>();

        // Test Case 1: Valid Capacity Creation
        try {
            System.out.println("Attempting to add valid bogies...");
            trainConsist.add(new Bogie("Sleeper", 72));
            trainConsist.add(new Bogie("AC Chair", 56));
            System.out.println("Successfully added valid bogies.");
        } catch (InvalidCapacityException e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }

        // Test Case 2: Zero Capacity Detection
        try {
            System.out.println("\nAttempting to add a bogie with ZERO capacity...");
            trainConsist.add(new Bogie("Pantry Car", 0));
        } catch (InvalidCapacityException e) {
            System.err.println("CATCHED ERROR: " + e.getMessage());
        }

        // Test Case 3: Negative Capacity Detection
        try {
            System.out.println("\nAttempting to add a bogie with NEGATIVE capacity...");
            trainConsist.add(new Bogie("First Class", -10));
        } catch (InvalidCapacityException e) {
            System.err.println("CATCHED ERROR: " + e.getMessage());
        }

        // Final Result Display
        System.out.println("\n--- Final Valid Train Consist ---");
        if (trainConsist.isEmpty()) {
            System.out.println("No bogies were successfully added.");
        } else {
            trainConsist.forEach(System.out::println);
        }

        System.out.println("\nTotal Valid Bogies: " + trainConsist.size());
        System.out.println("==========================================================");
    }
}