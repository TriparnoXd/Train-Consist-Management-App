import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // 1. Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // 2. Initialize an empty List to store bogies
        // We use the List interface for abstraction and ArrayList for dynamic resizing
        List<String> trainConsist = new ArrayList<>();

        // 3. Display the initial state
        // Initially, the train has no bogies attached to the engine
        System.out.println("Train initialized with empty consist.");
        System.out.println("Initial bogie count: " + trainConsist.size());
    }
}