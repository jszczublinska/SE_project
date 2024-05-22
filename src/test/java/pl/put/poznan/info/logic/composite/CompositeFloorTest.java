package pl.put.poznan.info.logic.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeFloorTest {

    private ArrayList<ComponentLocation> listOfRooms;
    private CompositeFloor floor;

    @BeforeEach
    public void setUp() {
        listOfRooms = new ArrayList<ComponentLocation>(Arrays.asList(
                new Room("112", 13, 200, 5, 9),
                new Room("111", 20, 400, 15, 30),
                new Room("110", 80, 600, 21, 60)
        ));

        floor = new CompositeFloor();
        floor.addLocation(listOfRooms.get(0));
        floor.addLocation(listOfRooms.get(1));
        floor.addLocation(listOfRooms.get(2));
    }

    @Test //9
    void calculateTotalAreaTest() {
        double expectedArea = 13 + 20 + 80;
        assertEquals(expectedArea, floor.calculateTotalArea());
    }

    @Test //10
    void calculateTotalVolumeTest() {
        double expectedVolume = 200 + 400 + 600;
        assertEquals(expectedVolume, floor.calculateTotalVolume());
    }

    @Test //11
    void calculateTotalHeatingEnergyTest(){
        double expectedHeatingEnergy = (double) (9 + 30 + 60) /(200 + 400 + 600);
        assertEquals(expectedHeatingEnergy, floor.calculateTotalHeatingEnergy());
    }

    @Test //12
    void calculateTotalLightingPower(){
        double expectedLightingPower = (double) (5 + 15 + 21)/ (13 + 20 + 80);
        assertEquals(expectedLightingPower, floor.calculateTotalLightingPower());
    }

    @Test //13
    void calculateTotalWaterConsumption(){
        double expectedWaterConsumption = (double) 2*(13 + 20 + 80);
        assertEquals(expectedWaterConsumption, floor.calculateTotalWaterConsumption());
    }

    @Test //14
    void calculateTotalMaintenance(){
        double expectedTotalCost = 2*13 + 0.8*5 + 1.2*13 + 6.9*9;
        expectedTotalCost += 2*20 + 0.8*15 + 1.2*20 + 6.9*30;
        expectedTotalCost += 2*80 + 0.8*21 + 1.2*80 + 6.9*60;
        assertEquals(expectedTotalCost, floor.calculateTotalMaintenance());
    }

}
