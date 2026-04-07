import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UC11: Validate Train ID & Cargo Codes (Regex)
 * This class demonstrates format enforcement using Regular Expressions
 * to ensure data integrity before the train is processed.
 */
public class TrainConsistManagementApp {

    // Define Regex Patterns as constants for reusability
    // TRN- followed by exactly 4 digits (\\d{4})
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";

    // PET- followed by exactly 2 uppercase letters ([A-Z]{2})
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management: Regex Validation ===");

        // 1. Compile the Patterns
        Pattern trainIdPattern = Pattern.compile(TRAIN_ID_REGEX);
        Pattern cargoCodePattern = Pattern.compile(CARGO_CODE_REGEX);

        // 2. Test Data (Valid and Invalid)
        String[] testTrainIds = {"TRN-1234", "TRAIN12", "TRN-123", "TRN-12345", "TRN-9999"};
        String[] testCargoCodes = {"PET-AB", "PET-bc", "PET123", "PET-XY", "AB-PET"};

        // 3. Validate Train IDs
        System.out.println("\n--- Validating Train IDs ---");
        for (String id : testTrainIds) {
            Matcher matcher = trainIdPattern.matcher(id);
            if (matcher.matches()) {
                System.out.println("[VALID]   : " + id);
            } else {
                System.out.println("[INVALID] : " + id + " (Required format: TRN-xxxx)");
            }
        }

        // 4. Validate Cargo Codes
        System.out.println("\n--- Validating Cargo Codes ---");
        for (String code : testCargoCodes) {
            Matcher matcher = cargoCodePattern.matcher(code);
            if (matcher.matches()) {
                System.out.println("[VALID]   : " + code);
            } else {
                System.out.println("[INVALID] : " + code + " (Required format: PET-XX)");
            }
        }

        // 5. Example of Functional Usage
        System.out.println("\n--- Final System Check ---");
        String finalId = "TRN-2026";
        if (validate(finalId, TRAIN_ID_REGEX)) {
            System.out.println("System initialized successfully for Train: " + finalId);
        }

        System.out.println("===================================================");
    }

    /**
     * Helper method to demonstrate clean validation logic
     */
    public static boolean validate(String input, String regex) {
        return Pattern.compile(regex).matcher(input).matches();
    }
}