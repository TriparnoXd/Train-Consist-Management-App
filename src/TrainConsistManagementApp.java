import java.util.Arrays;

/**
 * UC16: Sort Passenger Bogies by Capacity (Bubble Sort – Algorithm Intro)
 * This class demonstrates manual sorting logic using nested loops and
 * adjacent comparisons to build algorithmic thinking.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Manual Bubble Sort ===\n");

        // 1. Initialize an array of passenger bogie capacities
        // Scenarios include: Unsorted, Duplicates, and Single elements
        int[] bogieCapacities = {72, 56, 24, 70, 56, 60};

        System.out.println("Initial Capacities: " + Arrays.toString(bogieCapacities));

        // 2. Perform Bubble Sort Algorithm
        bubbleSort(bogieCapacities);

        // 3. Display the Sorted Results
        System.out.println("Sorted Capacities:  " + Arrays.toString(bogieCapacities));

        // 4. Edge Case: Single Element Array
        int[] singleBogie = {50};
        bubbleSort(singleBogie);
        System.out.println("Single Bogie Sort:  " + Arrays.toString(singleBogie));

        System.out.println("\nAlgorithm Note: Bubble Sort uses O(n²) time complexity.");
        System.out.println("=====================================================");
    }

    /**
     * Manual implementation of the Bubble Sort algorithm.
     * Iterates through the array and swaps adjacent elements if they are out of order.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop: Controls the number of passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop: Compares adjacent elements
            // After each pass, the largest element is 'bubbled' to the end (n-i-1)
            for (int j = 0; j < n - i - 1; j++) {

                // If the left element is greater than the right, swap them
                if (arr[j] > arr[j + 1]) {
                    // Swapping Logic using a temporary variable
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
}