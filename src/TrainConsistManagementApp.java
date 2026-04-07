import java.util.*;

/**
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * This class demonstrates dynamic list management for a railway consist.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Passenger Bogies ===");

        // 1. Initialize the dynamic ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. ADD (Create): Adding bogies to the train
        // ArrayList maintains insertion order, so 'Sleeper' is behind the engine
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Bogies added to the consist.");
        System.out.println("Current Consist: " + passengerBogies);
        System.out.println("Total Bogie Count: " + passengerBogies.size());

        // 3. REMOVE (Delete): Simulating detaching a bogie
        String toRemove = "AC Chair";
        System.out.println("\nDetaching bogie: " + toRemove);
        passengerBogies.remove(toRemove);

        // 4. CONTAINS (Read/Check): Verify if a specific bogie is still attached
        System.out.println("\n--- Safety & Status Check ---");
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Is 'Sleeper' bogie present? " + (hasSleeper ? "Yes" : "No"));

        boolean hasACChair = passengerBogies.contains("AC Chair");
        System.out.println("Is 'AC Chair' bogie present? " + (hasACChair ? "Yes" : "No"));

        // 5. Final State Display
        System.out.println("\nUpdated Consist Summary: " + passengerBogies);
        System.out.println("Final Bogie Count: " + passengerBogies.size());
        System.out.println("=================================================");
    }
}