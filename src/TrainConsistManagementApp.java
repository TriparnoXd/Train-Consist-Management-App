import java.util.*;

/**
 * UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
 * This class demonstrates a collection that prevents duplicates 
 * while maintaining the exact physical attachment sequence.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: LinkedHashSet Formation ===");

        // 1. Initialize LinkedHashSet
        // LinkedHashSet = HashSet (Uniqueness) + LinkedList (Insertion Order)
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attaching Bogies to the Engine
        System.out.println("Attaching bogies to the engine in sequence...");
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 3. Attempt to attach a duplicate bogie
        // In a real train, you cannot physically attach the same bogie twice.
        System.out.println("\nAttempting to attach duplicate 'Sleeper' bogie...");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("System Alert: Duplicate bogie detected! Attachment rejected.");
        }

        // 4. Display the Final Formation
        // Notice that the order is exactly as added (Engine first, Guard last)
        // and 'Sleeper' only appears once.
        System.out.println("\nFinal Train Formation (Ordered & Unique):");
        System.out.println(trainFormation);

        // 5. Verification of logic
        System.out.println("\nTotal Unique Bogies in Consist: " + trainFormation.size());
        System.out.println("=========================================================");
    }
}