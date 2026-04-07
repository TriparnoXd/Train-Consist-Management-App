import java.util.*;

/**
 * Custom Runtime Exception: CargoSafetyException
 * This represents a safety violation discovered during train operations.
 */
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

/**
 * GoodsBogie Class: Represents a freight car with dynamic cargo assignment.
 */
class GoodsBogie {
    private String shape;
    private String currentCargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
        this.currentCargo = "Empty";
    }

    /**
     * Business Logic: Assigns cargo with strict safety checks.
     * Rule: Petroleum can ONLY be assigned to Cylindrical bogies.
     */
    public void assignCargo(String cargo) {
        System.out.println("Operation: Attempting to load " + cargo + " into " + shape + " bogie.");

        try {
            if (cargo.equalsIgnoreCase("Petroleum") && !shape.equalsIgnoreCase("Cylindrical")) {
                throw new CargoSafetyException("SAFETY ALERT: Cannot load Petroleum into a " + shape + " bogie!");
            }
            this.currentCargo = cargo;
            System.out.println("Success: Cargo '" + cargo + "' assigned successfully.");
        }
        catch (CargoSafetyException e) {
            // Handle the specific safety violation
            System.err.println("TERMINATED: " + e.getMessage());
        }
        finally {
            // This block runs REGARDLESS of success or failure
            System.out.println("Log: Safety validation check completed for this unit.");
            System.out.println("--------------------------------------------------");
        }
    }

    @Override
    public String toString() {
        return "Bogie Shape: " + shape + " | Current Cargo: " + currentCargo;
    }
}

/**
 * UC15: Safe Cargo Assignment Using try-catch-finally
 * This class demonstrates structured exception handling for runtime operations.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Structured Error Handling ===\n");

        // 1. Initialize different bogie shapes
        GoodsBogie tanker = new GoodsBogie("Cylindrical");
        GoodsBogie freightCar = new GoodsBogie("Rectangular");

        // 2. Scenario A: Safe Assignment
        // Loading petroleum into a cylindrical bogie is safe.
        tanker.assignCargo("Petroleum");

        // 3. Scenario B: Unsafe Assignment (Handled)
        // Loading petroleum into a rectangular bogie is a fire hazard.
        // The system will catch the exception and keep running.
        freightCar.assignCargo("Petroleum");

        // 4. Scenario C: Another Safe Assignment
        // Loading Coal into a rectangular bogie is safe.
        freightCar.assignCargo("Coal");

        // 5. Final System Status
        System.out.println("\n--- Final Yard Status ---");
        System.out.println(tanker);
        System.out.println(freightCar);

        System.out.println("\nSystem Check: Application remains stable after handling safety alerts.");
        System.out.println("==========================================================");
    }
}