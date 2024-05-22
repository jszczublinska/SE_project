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

    @Test
    void calculateTotalAreaTest() {
        double expectedArea = 13 + 20 + 80;
        assertEquals(expectedArea, floor.calculateTotalArea());
    }

    @Test
    void calculateTotalVolumeTest() {
        double expectedVolume = 200 + 400 + 600;
        assertEquals(expectedVolume, floor.calculateTotalVolume());
    }

    @Test
    void calculateTotalHeatingEnergyTest(){
        double expectedHeatingEnergy = (double) (9 + 30 + 60) /(200 + 400 + 600);
        assertEquals(expectedHeatingEnergy, floor.calculateTotalHeatingEnergy());
    }

}
