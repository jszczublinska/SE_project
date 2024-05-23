package pl.put.poznan.info.logic.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class CompositeBuildingMockTest {

    @Test //7
    void calculateTotalArea() {
        CompositeFloor floor1 = mock(CompositeFloor.class);
        CompositeFloor floor2 = mock(CompositeFloor.class);
        CompositeFloor floor3 = mock(CompositeFloor.class);

        when(floor1.calculateTotalArea()).thenReturn(200.0);
        when(floor2.calculateTotalArea()).thenReturn(400.0);
        when(floor3.calculateTotalArea()).thenReturn(1600.0);

        CompositeBuilding mainBuilding = new CompositeBuilding();
        mainBuilding.addLocation(floor1);
        mainBuilding.addLocation(floor2);
        mainBuilding.addLocation(floor3);

        assertEquals(200.0 + 400.0 + 1600.0, mainBuilding.calculateTotalArea());
        verify(floor1).calculateTotalArea();
        verify(floor2).calculateTotalArea();
        verify(floor3).calculateTotalArea();

    }

    @Test //8
    void calculateTotalVolume() {
        CompositeFloor mockFloor1 = mock(CompositeFloor.class);
        CompositeFloor mockFloor2 = mock(CompositeFloor.class);
        CompositeFloor mockFloor3 = mock(CompositeFloor.class);

        when(mockFloor1.calculateTotalVolume()).thenReturn(50.0);
        when(mockFloor2.calculateTotalVolume()).thenReturn(59.0);
        when(mockFloor3.calculateTotalVolume()).thenReturn(21.5);

        CompositeBuilding mainBuilding = new CompositeBuilding();
        mainBuilding.addLocation(mockFloor1);
        mainBuilding.addLocation(mockFloor2);
        mainBuilding.addLocation(mockFloor3);

        assertEquals(50.0 + 59.0 + 21.5, mainBuilding.calculateTotalVolume());
        verify(mockFloor1).calculateTotalVolume();
        verify(mockFloor2).calculateTotalVolume();
        verify(mockFloor3).calculateTotalVolume();
    }

    @Test //9
    void calculateTotalHeatingEnergy() {
        CompositeFloor mockFloor1 = mock(CompositeFloor.class);
        CompositeFloor mockFloor2 = mock(CompositeFloor.class);
        CompositeFloor mockFloor3 = mock(CompositeFloor.class);

        when(mockFloor1.calculateTotalHeatingEnergy()).thenReturn(2.0);
        when(mockFloor2.calculateTotalHeatingEnergy()).thenReturn(4.75);
        when(mockFloor3.calculateTotalHeatingEnergy()).thenReturn(9.5);

        CompositeBuilding mainBuilding = new CompositeBuilding();
        mainBuilding.addLocation(mockFloor1);
        mainBuilding.addLocation(mockFloor2);
        mainBuilding.addLocation(mockFloor3);

        assertEquals((2.0 + 4.75 + 9.5)/3, mainBuilding.calculateTotalHeatingEnergy());
        verify(mockFloor1).calculateTotalHeatingEnergy();
        verify(mockFloor2).calculateTotalHeatingEnergy();
        verify(mockFloor3).calculateTotalHeatingEnergy();
    }

    @Test //10
    void calculateTotalLightingPower() {
        CompositeFloor mockFloor1 = mock(CompositeFloor.class);
        CompositeFloor mockFloor2 = mock(CompositeFloor.class);
        CompositeFloor mockFloor3 = mock(CompositeFloor.class);

        when(mockFloor1.calculateTotalLightingPower()).thenReturn(450.8);
        when(mockFloor2.calculateTotalLightingPower()).thenReturn(237.9);
        when(mockFloor3.calculateTotalLightingPower()).thenReturn(1234.9);

        CompositeBuilding mainBuilding = new CompositeBuilding();
        mainBuilding.addLocation(mockFloor1);
        mainBuilding.addLocation(mockFloor2);
        mainBuilding.addLocation(mockFloor3);

        assertEquals((450.8 + 237.9 + 1234.9)/3, mainBuilding.calculateTotalLightingPower());
        verify(mockFloor1).calculateTotalLightingPower();
        verify(mockFloor2).calculateTotalLightingPower();
        verify(mockFloor3).calculateTotalLightingPower();

    }

    @Test //11
    void calculateTotalWaterConsumption() {
        CompositeFloor mockFloor1 = mock(CompositeFloor.class);
        CompositeFloor mockFloor2 = mock(CompositeFloor.class);
        CompositeFloor mockFloor3 = mock(CompositeFloor.class);

        when(mockFloor1.calculateTotalWaterConsumption()).thenReturn(49.3);
        when(mockFloor2.calculateTotalWaterConsumption()).thenReturn(78.9);
        when(mockFloor3.calculateTotalWaterConsumption()).thenReturn(30.10);

        CompositeBuilding mainBuilding = new CompositeBuilding();
        mainBuilding.addLocation(mockFloor1);
        mainBuilding.addLocation(mockFloor2);
        mainBuilding.addLocation(mockFloor3);

        assertEquals(49.3 + 78.9 + 30.10, mainBuilding.calculateTotalWaterConsumption());
        verify(mockFloor1).calculateTotalWaterConsumption();
        verify(mockFloor2).calculateTotalWaterConsumption();
        verify(mockFloor3).calculateTotalWaterConsumption();

    }

}