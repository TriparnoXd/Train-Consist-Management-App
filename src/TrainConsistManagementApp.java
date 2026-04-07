import java.util.*;

/**
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 * This class demonstrates how to enforce data integrity using a HashSet.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Bogie ID Tracking ===");

        // 1. Initialize HashSet to ensure only unique Bogie IDs are stored
        Set<String> bogieIds = new HashSet<>();

        // 2. Add Bogie IDs (including duplicates to test uniqueness)
        System.out.println("Registering bogies to the train...");

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        // Intentionally adding duplicates
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        // 3. Displaying the Set
        // The HashSet automatically handles deduplication
        System.out.println("\nFinal Consist ID List (Automatically Deduplicated):");
        System.out.println(bogieIds);

        System.out.println("\nTotal Unique Bogies: " + bogieIds.size());
        System.out.println("==================================================");
    }
}