import java.util.*;

/**
 * Bogie Class: Represents a custom object with attributes.
 * This allows us to move beyond simple key-value pairs to structured data.
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("%-15s | Capacity: %d seats", name, capacity);
    }
}

/**
 * UC7: Sort Bogies by Capacity (Comparator)
 * This class demonstrates custom object sorting using the Comparator interface.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Capacity Sorting ===");

        // 1. Initialize a List to store Bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();

        // 2. Add custom Bogie objects to the list
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Initial list of bogies added.");

        // 3. Sorting using Comparator
        // We use Comparator.comparingInt to define the sorting criteria (Capacity)
        // This sorts in Natural Order (Ascending: Smallest to Largest)
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // 4. Display the Sorted Results
        System.out.println("\n--- Bogies Sorted by Capacity (Ascending) ---");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // 5. Bonus: Sorting in Descending Order (Highest Capacity First)
        System.out.println("\n--- Bogies Sorted by Capacity (Descending) ---");
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("=================================================");
    }
}