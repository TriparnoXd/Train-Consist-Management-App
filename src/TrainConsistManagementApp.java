import java.util.Arrays;

/**
 * UC17: Sort Bogie Names Using Arrays.sort()
 * This class demonstrates the use of Java's built-in utility methods
 * for efficient, alphabetical sorting of bogie types.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Built-in Array Sorting ===\n");

        // 1. Initialize an array of bogie type names
        // Note: The data is unsorted and contains duplicates to test robustness.
        String[] bogieTypes = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury",
                "Sleeper"
        };

        System.out.println("Initial Bogie Names:  " + Arrays.toString(bogieTypes));

        // 2. Perform Alphabetical Sorting
        // Arrays.sort() uses 'Natural Ordering' for Strings (A-Z)
        Arrays.sort(bogieTypes);

        // 3. Display the Sorted Results
        System.out.println("Sorted Bogie Names:   " + Arrays.toString(bogieTypes));

        // 4. Edge Case: Single Element Array
        String[] singleBogie = {"Engine"};
        Arrays.sort(singleBogie);
        System.out.println("Single Element Sort:  " + Arrays.toString(singleBogie));

        // 5. Performance Context
        System.out.println("\nLibrary Note: Arrays.sort() is O(n log n), making it ideal for large datasets.");
        System.out.println("Standard libraries are preferred in production for speed and readability.");
        System.out.println("========================================================");
    }
}