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
        return String.format("[Type: %s, Cap: %d]", name, capacity);
    }
}

/**
 * UC9: Group Bogies by Type (Collectors.groupingBy)
 * This class demonstrates how to transform flat data into a
 * structured Map for better reporting and operational visibility.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Categorized Grouping ===");

        // 1. Initialize the list with multiple bogies of the same type
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("General", 90));

        System.out.println("Total bogies registered: " + trainConsist.size());

        // 2. Stream Pipeline: Grouping by Bogie Name
        // groupingBy takes a classifier function (Bogie::getName)
        Map<String, List<Bogie>> groupedBogies = trainConsist.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 3. Display the Grouped Results
        System.out.println("\n--- Structured Consist Report (Grouped by Type) ---");

        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type + " | Total Units: " + list.size());
            for (Bogie b : list) {
                System.out.println("  -> " + b);
            }
        });

        // 4. Specific Category Analysis
        System.out.println("\n--- Quick Category Check ---");
        if (groupedBogies.containsKey("Sleeper")) {
            int sleeperCount = groupedBogies.get("Sleeper").size();
            System.out.println("Ready to depart: " + sleeperCount + " Sleeper bogies found.");
        }

        // 5. Verification of Original Collection Integrity
        System.out.println("\nVerification: Original list remains a flat sequence of "
                + trainConsist.size() + " bogies.");
        System.out.println("======================================================");
    }
}