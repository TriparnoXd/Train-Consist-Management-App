import java.util.*;

/**
 * UC4: Maintain Ordered Bogie IDs (LinkedList)
 * This class demonstrates how a LinkedList models the physical chaining of a train.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: LinkedList Chaining ===");

        // 1. Initialize LinkedList
        // LinkedList is ideal for frequent insertions at the head or tail
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Building the Train (Chaining Bogies)
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");

        // Using specific LinkedList methods for Head and Tail
        trainConsist.addFirst("Engine"); // Locomotive must be at the front
        trainConsist.addLast("Guard Coach"); // Guard coach is always at the end

        System.out.println("Initial Train Formation:");
        System.out.println(trainConsist);

        // 3. Middle Insertion
        // Adding a Pantry Car at index 2 (position 3)
        System.out.println("\nInserting 'Pantry Car' at position 2...");
        trainConsist.add(2, "Pantry Car");

        System.out.println("Updated Consist: " + trainConsist);

        // 4. Detaching Bogies (Head and Tail operations)
        System.out.println("\nDetaching first and last bogies for maintenance...");
        trainConsist.removeFirst(); // Removes Engine
        trainConsist.removeLast();  // Removes Guard Coach

        // 5. Final Display
        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(trainConsist);

        System.out.println("\nTotal Bogies Remaining: " + trainConsist.size());
        System.out.println("=====================================================");
    }
}