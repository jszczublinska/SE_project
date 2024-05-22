package pl.put.poznan.info.logic.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room;

    @BeforeEach
    public void steUp(){
        room = new Room("112", 13, 200, 5, 9);
    }

    @Test
    void calculateTotalArea() {
        assertEquals(13.0, room.calculateTotalArea() );
    }

    @Test
    void calculateTotalVolume() {
        assertEquals(200.0, room.calculateTotalVolume());
    }

    @Test
    void calculateTotalHeatingEnergy() {
        assertEquals(9, room.calculateTotalHeatingEnergy());
    }

    @Test
    void calculateTotalLightingPower() {
        assertEquals(5, room.calculateTotalLightingPower());
    }

    @Test
    void calculateTotalWaterConsumption() {
        assertEquals(2*13, room.calculateTotalArea());
    }
}