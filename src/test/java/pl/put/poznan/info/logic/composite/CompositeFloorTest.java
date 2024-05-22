package pl.put.poznan.info.logic.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CompositeFloorTest {

    //    @BeforeEach
//    public void setUp(){
//        List<ComponentLocation> listOfRooms = Arrays.asList(
//                new Room(),
//                new Room(),
//                new Room()
//        );
//    }
    @Test
    void calculateTotalAreaTest() {
        ArrayList<ComponentLocation> listOfRooms = new ArrayList<ComponentLocation>(Arrays.asList(
                new Room("112", 13, 200, 5, 9),
                new Room("111", 20, 400, 15, 30),
                new Room("110", 80, 600, 21, 60)
        ));

        CompositeFloor mockFloor = mock(CompositeFloor.class);
        when(mockFloor.getList()).thenReturn(listOfRooms);

        assertEquals(113.0, mockFloor.calculateTotalArea());
    }

    @Test
    void calculateTotalVolumeTest() {
    }

    @Test
    void calculateTotalHeatingEnergyTest() {
    }

    @Test
    void calculateTotalLightingPowerTest() {
    }

    @Test
    void calculateTotalWaterConsumptionTest() {
    }
}