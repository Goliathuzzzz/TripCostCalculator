import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TripCostCalculator {
    private double distance;
    private double fuelPrice;
    private final ResourceBundle resourceBundle;

    public TripCostCalculator(double distance, double fuelPrice, ResourceBundle resourceBundle) {
        this.distance = distance;
        this.fuelPrice = fuelPrice;
        this.resourceBundle = resourceBundle;
    }

    public double calculateTotalFuel() {
        //liters per 100km
        double consumption = 5;
        return distance * consumption / 100;
    }

    public double calculateTotalCost() {
        return calculateTotalFuel() * fuelPrice;
    }

    public void gatherTripInfo() {
        System.out.println(resourceBundle.getString("fuel") + ": " + calculateTotalFuel());
        System.out.println(resourceBundle.getString("trip") + ": " + calculateTotalCost());
    }

    public double getDistance() {
        return distance;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }
}
