package pl.put.poznan.info.logic.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.TileObserver;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CompositeBuildingTest {

    private CompositeBuilding mainBuilding = new CompositeBuilding("1", "main building");

    @BeforeEach
    public void setUp() {

        ArrayList<ComponentLocation>listOfRooms_1 = new ArrayList<ComponentLocation>(Arrays.asList(
                new Room("112", 13, 200, 5, 9),
                new Room("111", 20, 400, 15, 30),
                new Room("110", 80, 600, 21, 60)
        ));

        CompositeFloor floor_1 = new CompositeFloor("1", "floor1");
        floor_1.addLocation(listOfRooms_1.get(0));
        floor_1.addLocation(listOfRooms_1.get(1));
        floor_1.addLocation(listOfRooms_1.get(2));


        ArrayList<ComponentLocation>listOfRooms_2 = new ArrayList<ComponentLocation>(Arrays.asList(
                new Room("212", 10, 100, 10, 20),
                new Room("211", 30, 300, 20, 40),
                new Room("210", 60, 600, 30, 6)
        ));

        CompositeFloor floor_2 = new CompositeFloor("2", "floor1");
        floor_2.addLocation(listOfRooms_2.get(0));
        floor_2.addLocation(listOfRooms_2.get(1));
        floor_2.addLocation(listOfRooms_2.get(2));

        mainBuilding.addLocation(floor_1);
        mainBuilding.addLocation(floor_2);
    }


    @Test //15
    void calculateTotalArea() {
        double totalArea = 13 + 20 + 80 + 10 + 30 + 60;
        assertEquals(totalArea, mainBuilding.calculateTotalArea());
    }

    @Test //16
    void calculateTotalVolume() {
        double totalVolume = 200 + 400 + 600 + 100 + 300 + 600;
        assertEquals(totalVolume, mainBuilding.calculateTotalVolume());
    }

    @Test //17
    void calculateTotalHeatingEnergy() {
        double totalHeating = (double) (9 + 30 + 60) / (200 + 400 + 600);
        totalHeating += (double)(20 + 40 + 6)/ (100 + 300 + 600);
        totalHeating /= 2;
        assertEquals(totalHeating, mainBuilding.calculateTotalHeatingEnergy());
    }

    @Test //18
    void calculateTotalLightingPower() {
        double totalLightingPower = (double)(5 + 15 + 21)/ (13 + 20 +80);
        totalLightingPower += (double)(10 + 20 + 30)/(10 + 30 +60);
        totalLightingPower /= 2;
        assertEquals(totalLightingPower, mainBuilding.calculateTotalLightingPower());
    }

    @Test //19
    void calculateTotalWaterConsumption() {
        double totalWaterConsumption = (double) 2*(13 + 20 + 80);
        totalWaterConsumption += 2*(10 + 30 +60);
        assertEquals(totalWaterConsumption, mainBuilding.calculateTotalWaterConsumption());
    }

    @Test //20
    void calculateTotalMaintenance() {
        // floor 1
        double totalMaintenance = (double) 2*13 + 0.8*5 + 1.2*13 + 6.9*9;
        totalMaintenance += 2*20 + 0.8*15 + 1.2*20 + 6.9*30;
        totalMaintenance += 2*80 + 0.8*21 + 1.2*80 + 6.9*60;
        // floor 2
        totalMaintenance += 2*10 + 0.8*10 + 1.2*10 + 6.9*20;
        totalMaintenance += 2*30 + 0.8*20 + 1.2*30 + 6.9*40;
        totalMaintenance += 2*60 + 0.8*30 + 1.2*60 + 6.9*6;

        assertEquals(totalMaintenance, mainBuilding.calculateTotalMaintenance());

    }
}