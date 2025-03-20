import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose language (en, fi, ja): ");
        Locale locale;
        ResourceBundle resourceBundle;
        String lang = sc.next();
        locale = switch (lang) {
            case "fi" -> new Locale("fi", "FI");
            case "ja" -> new Locale("ja", "JP");
            default -> new Locale("en", "US");
        };
        resourceBundle = ResourceBundle.getBundle("messages", locale);
        System.out.println(resourceBundle.getString("distance") + ": ");
        double distance = Double.parseDouble(sc.next());
        System.out.println(resourceBundle.getString("price") + ": ");
        double price = Double.parseDouble(sc.next());
        TripCostCalculator tripCostCalculator = new TripCostCalculator(distance, price, resourceBundle);
        tripCostCalculator.gatherTripInfo();
    }
}
