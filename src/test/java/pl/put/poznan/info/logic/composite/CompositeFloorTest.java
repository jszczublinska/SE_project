package pl.put.poznan.info.logic.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CompositeFloorTest {
    private static final Logger logger = LoggerFactory.getLogger(CompositeFloor.class);


//    @Test
//    void calculateTotalAreaTest() {
//
//        ArrayList<ComponentLocation> listOfRooms = new ArrayList<ComponentLocation>(Arrays.asList(
//                new Room("112", 13, 200, 5, 9),
//                new Room("111", 20, 400, 15, 30),
//                new Room("110", 80, 600, 21, 60)
//        ));
////        Room mockRoom1 = mock(Room.class);
//        CompositeFloor mockFloor = mock(CompositeFloor.class);
////        mockFloor.addLocation(mockRoom1);
////        when(mockRoom1.calculateTotalArea()).thenReturn(13.0);
//        when(mockFloor.getList()).thenReturn(listOfRooms);
//        assertEquals(13.0, mockFloor.calculateTotalArea());
//    }
    @Test
    void calculateTotalAreaTest() {
        Room mockRoom1 = mock(Room.class);
        Room mockRoom2 = mock(Room.class);
        Room mockRoom3 = mock(Room.class);

        when(mockRoom1.calculateTotalArea()).thenReturn(260.0);
        when(mockRoom2.calculateTotalArea()).thenReturn(800.0);
        when(mockRoom3.calculateTotalArea()).thenReturn(1440.0);

        CompositeFloor floor = new CompositeFloor();
        floor.addLocation(mockRoom1);
        floor.addLocation(mockRoom2);
        floor.addLocation(mockRoom3);

        assertEquals(260.0 + 800.0 + 1440.0, floor.calculateTotalArea());
        verify(mockRoom1).calculateTotalArea();
        verify(mockRoom2).calculateTotalArea();
        verify(mockRoom3).calculateTotalArea();
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