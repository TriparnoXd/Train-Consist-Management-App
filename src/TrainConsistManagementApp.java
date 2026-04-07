import java.util.*;

/**
 * UC20: Exception Handling During Search Operations
 * This class demonstrates defensive programming by validating the system state
 * before allowing search operations to proceed.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Search State Validation ===\n");

        // 1. Scenario A: Searching an EMPTY consist (Should throw exception)
        String[] emptyConsist = {};
        System.out.println("Scenario A: Searching in an empty train consist...");
        try {
            validateAndSearch(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.err.println("CRITICAL ERROR: " + e.getMessage());
        }

        // 2. Scenario B: Searching a VALID consist
        String[] activeConsist = {"BG101", "BG205", "BG309"};
        System.out.println("\nScenario B: Searching in an active train consist...");
        try {
            validateAndSearch(activeConsist, "BG205"); // Should succeed
            validateAndSearch(activeConsist, "BG999"); // Should pass validation but not find ID
        } catch (IllegalStateException e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }

        System.out.println("\n=====================================================");
    }

    /**
     * Defensive Search Method
     * Performs state validation before executing search logic.
     * @throws IllegalStateException if the array is null or empty.
     */
    public static void validateAndSearch(String[] bogies, String searchKey) {
        // 1. State Validation (Fail-Fast)
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Search Denied: The train consist is currently empty. " +
                    "Please add bogies before searching.");
        }

        // 2. Search Logic (Only executes if state is valid)
        System.out.println("Searching for Bogie ID: " + searchKey + "...");

        boolean found = false;
        for (String id : bogies) {
            if (id.equals(searchKey)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(">>> SUCCESS: Bogie " + searchKey + " found in the consist.");
        } else {
            System.out.println(">>> NOT FOUND: Bogie " + searchKey + " does not exist in this train.");
        }
    }
}