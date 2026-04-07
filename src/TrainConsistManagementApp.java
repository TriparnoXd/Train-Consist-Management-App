import java.util.Arrays;

/**
 * UC19: Binary Search for Bogie ID (Optimized Searching)
 * This class demonstrates the divide-and-conquer strategy to find
 * a bogie ID in O(log n) time.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Binary Search System ===\n");

        // 1. Initialize an array of Bogie IDs (Unsorted to test precondition handling)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // 2. Precondition: Binary Search REQUIRES sorted data
        System.out.println("Initial IDs (Unsorted): " + Arrays.toString(bogieIds));
        Arrays.sort(bogieIds);
        System.out.println("Sorted IDs (Required): " + Arrays.toString(bogieIds));

        // 3. Define search targets
        String searchKey1 = "BG309"; // Mid/Random position
        String searchKey2 = "BG101"; // First element
        String searchKey3 = "BG999"; // Non-existent

        // 4. Perform Binary Search
        System.out.println("\n--- Starting Binary Search Operations ---");
        performBinarySearch(bogieIds, searchKey1);
        performBinarySearch(bogieIds, searchKey2);
        performBinarySearch(bogieIds, searchKey3);

        System.out.println("\n=====================================================");
    }

    /**
     * Binary Search Logic
     * Uses low, high, and mid pointers to narrow the search range.
     */
    public static void performBinarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        int position = -1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid potential integer overflow

            // compareTo() returns: 0 if equal, <0 if key is smaller, >0 if key is larger
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                found = true;
                position = mid;
                break; // Found the key!
            } else if (comparison < 0) {
                high = mid - 1; // Key is in the left half
            } else {
                low = mid + 1; // Key is in the right half
            }
        }

        if (found) {
            System.out.println("[FOUND]     : Bogie " + key + " is at sorted index " + position);
        } else {
            System.out.println("[NOT FOUND] : Bogie " + key + " is not in the system.");
        }
    }
}