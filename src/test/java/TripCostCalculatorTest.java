import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripCostCalculatorTest {


    private static TripCostCalculator tripCostCalculator;

    @BeforeAll
    static void init() {
        Locale locale = new Locale("en", "US");
        tripCostCalculator = new TripCostCalculator(100, 1.8, ResourceBundle.getBundle("messages", locale));
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        tripCostCalculator.setDistance(0);
        tripCostCalculator.setFuelPrice(0);
    }

    @Test
    void askDistance() {
        tripCostCalculator.setDistance(100);
        assertEquals(100, tripCostCalculator.getDistance());
    }

    @Test
    void askFuelPrice() {
        tripCostCalculator.setFuelPrice(1.8);
        assertEquals(1.8, tripCostCalculator.getFuelPrice());
    }

    @Test
    void calculateTotalFuel() {
        tripCostCalculator.setDistance(150);
        tripCostCalculator.calculateTotalFuel();
        assertEquals(7.5, tripCostCalculator.calculateTotalFuel());
    }

    @Test
    void calculateTotalCost() {
        tripCostCalculator.setDistance(200);
        tripCostCalculator.setFuelPrice(1.8);
        assertEquals(10, tripCostCalculator.calculateTotalFuel());
        assertEquals(18, tripCostCalculator.calculateTotalCost());
    }

    @Test
    void gatherTripInfo() {
        tripCostCalculator.setDistance(150);
        tripCostCalculator.setFuelPrice(160);
        tripCostCalculator.gatherTripInfo();
    }
}