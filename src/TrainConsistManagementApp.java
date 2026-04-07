import java.util.*;
import java.util.stream.Collectors;

/**
 * Bogie Class: Represents a custom object with attributes.
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
}

/**
 * UC13: Performance Comparison (Loops vs Streams)
 * This class benchmarks the execution time of traditional loops
 * versus modern Stream API using nanosecond precision.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Performance Benchmarking ===\n");

        // 1. Prepare a larger dataset for meaningful measurement
        List<Bogie> largeTrainConsist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeTrainConsist.add(new Bogie("Sleeper", 72));
            largeTrainConsist.add(new Bogie("AC Chair", 56));
            largeTrainConsist.add(new Bogie("First Class", 24));
        }

        System.out.println("Processing " + largeTrainConsist.size() + " bogies...");
        int capacityThreshold = 60;

        // 2. Benchmark: Traditional For-Loop
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopResults = new ArrayList<>();
        for (Bogie b : largeTrainConsist) {
            if (b.getCapacity() > capacityThreshold) {
                loopResults.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // 3. Benchmark: Java Streams
        long startTimeStream = System.nanoTime();
        List<Bogie> streamResults = largeTrainConsist.stream()
                .filter(b -> b.getCapacity() > capacityThreshold)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // 4. Display Results and Comparison
        System.out.println("\n--- Performance Results ---");
        System.out.println("Loop-Based Time   : " + durationLoop + " ns");
        System.out.println("Stream-Based Time : " + durationStream + " ns");

        // 5. Verification of Consistency
        System.out.println("\n--- Consistency Check ---");
        System.out.println("Loop Result Size  : " + loopResults.