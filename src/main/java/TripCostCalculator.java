import java.util.Scanner;

public class TripCostCalculator {
    private double distance;
    private double fuelPrice;

    public TripCostCalculator(double distance, double fuelPrice) {
        this.distance = distance;
        this.fuelPrice = fuelPrice;
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
        System.out.println("Total fuel needed: " + calculateTotalFuel());
        System.out.println("Total cost of trip: " + calculateTotalCost());
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
