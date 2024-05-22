package pl.put.poznan.info.logic.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class CompositeFloorMockTest {

    @Test
    void calculateTotalAreaMockTest() {
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
    void calculateTotalVolumeMockTest() {
        Room mockRoom1 = mock(Room.class);
        Room mockRoom2 = mock(Room.class);
        Room mockRoom3 = mock(Room.class);

        when(mockRoom1.calculateTotalVolume()).thenReturn(3900.0);
        when(mockRoom2.calculateTotalVolume()).thenReturn(9600.0);
        when(mockRoom3.calculateTotalVolume()).thenReturn(17280.0);

        CompositeFloor floor = new CompositeFloor();
        floor.addLocation(mockRoom1);
        floor.addLocation(mockRoom2);
        floor.addLocation(mockRoom3);

        assertEquals(3900.0 + 9600.0 + 17280.0, floor.calculateTotalVolume());
        verify(mockRoom1).calculateTotalVolume();
        verify(mockRoom2).calculateTotalVolume();
        verify(mockRoom3).calculateTotalVolume();
    }

    @Test
    void calculateTotalHeatingEnergyMockTest() {
        Room mockRoom1 = mock(Room.class);
        Room mockRoom2 = mock(Room.class);
        Room mockRoom3 = mock(Room.class);

        when(mockRoom1.calculateTotalHeatingEnergy()).thenReturn(1040.0);
        when(mockRoom2.calculateTotalHeatingEnergy()).thenReturn(3200.0);
        when(mockRoom3.calculateTotalHeatingEnergy()).thenReturn(6912.0);
        when(mockRoom1.calculateTotalVolume()).thenReturn(13.0);
        when(mockRoom2.calculateTotalVolume()).thenReturn(50.0);
        when(mockRoom3.calculateTotalVolume()).thenReturn(124.0);

        CompositeFloor floor = new CompositeFloor();
        floor.addLocation(mockRoom1);
        floor.addLocation(mockRoom2);
        floor.addLocation(mockRoom3);

        assertEquals((1040.0 + 3200.0 + 6912.0)/(13.0+50.0+124.0), floor.calculateTotalHeatingEnergy());
        verify(mockRoom1).calculateTotalHeatingEnergy();
        verify(mockRoom2).calculateTotalHeatingEnergy();
        verify(mockRoom3).calculateTotalHeatingEnergy();
    }

    @Test
    void calculateTotalLightingPowerMockTest() {
        Room mockRoom1 = mock(Room.class);
        Room mockRoom2 = mock(Room.class);
        Room mockRoom3 = mock(Room.class);

        when(mockRoom1.calculateTotalLightingPower()).thenReturn(100.0);
        when(mockRoom2.calculateTotalLightingPower()).thenReturn(200.0);
        when(mockRoom3.calculateTotalLightingPower()).thenReturn(666.0);
        when(mockRoom1.calculateTotalArea()).thenReturn(30.0);
        when(mockRoom2.calculateTotalArea()).thenReturn(50.0);
        when(mockRoom3.calculateTotalArea()).thenReturn(66.0);

        CompositeFloor floor = new CompositeFloor();
        floor.addLocation(mockRoom1);
        floor.addLocation(mockRoom2);
        floor.addLocation(mockRoom3);

        assertEquals((100.0 + 200.0 + 666.0)/(30.0+50.0+66.0), floor.calculateTotalLightingPower());
        verify(mockRoom1).calculateTotalLightingPower();
        verify(mockRoom2).calculateTotalLightingPower();
        verify(mockRoom3).calculateTotalLightingPower();
    }

    @Test
    void calculateTotalWaterConsumptionMockTest() {
        Room mockRoom1 = mock(Room.class);
        Room mockRoom2 = mock(Room.class);
        Room mockRoom3 = mock(Room.class);

        when(mockRoom1.calculateTotalWaterConsumption()).thenReturn(10.0);
        when(mockRoom2.calculateTotalWaterConsumption()).thenReturn(15.0);
        when(mockRoom3.calculateTotalWaterConsumption()).thenReturn(20.0);

        CompositeFloor floor = new CompositeFloor();
        floor.addLocation(mockRoom1);
        floor.addLocation(mockRoom2);
        floor.addLocation(mockRoom3);


        assertEquals(10.0 + 15.0 + 20.0, floor.calculateTotalWaterConsumption());
        verify(mockRoom1).calculateTotalWaterConsumption();
        verify(mockRoom2).calculateTotalWaterConsumption();
        verify(mockRoom3).calculateTotalWaterConsumption();
    }

    @Test
    void calculateTotalMaintenanceMockTest() {

    }
}