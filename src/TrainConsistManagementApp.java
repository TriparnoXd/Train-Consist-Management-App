import java.util.*;

/**
 * UC18: Linear Search for Bogie ID (Array-Based Searching)
 * This class demonstrates the fundamental sequential search technique
 * to locate a specific bogie ID in an unsorted array.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Linear Search System ===\n");

        // 1. Initialize an array of Bogie IDs (Unsorted)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Define search targets (Test Cases)
        String searchKey1 = "BG309"; // Existing ID
        String searchKey2 = "BG999"; // Non-existing ID

        System.out.println("Consist IDs: " + Arrays.toString(bogieIds));

        // 3. Perform Linear Search
        System.out.println("\nSearching for Bogie: " + searchKey1);
        performLinearSearch(bogieIds, searchKey1);

        System.out.println("\nSearching for Bogie: " + searchKey2);
        performLinearSearch(bogieIds, searchKey2);

        System.out.println("\n=====================================================");
    }

    /**
     * Sequential Search Logic
     * Traverses the array from index 0 to n-1.
     */
    public static void performLinearSearch(String[] arr, String key) {
        boolean found = false;
        int position = -1;

        for (int i = 0; i < arr.length; i++) {
            // String comparison using .equals() for safety
            if (arr[i].equals(key)) {
                found = true;
                position = i;
                break; // Early Termination: stop searching once found
            }
        }

        if (found) {
            System.out.println(">>> SUCCESS: Bogie " + key + " located at position " + (position + 1) + ".");
        } else {
            System.out.println(">>> NOT FOUND: Bogie " + key + " is not present in the current consist.");
        }
    }
}