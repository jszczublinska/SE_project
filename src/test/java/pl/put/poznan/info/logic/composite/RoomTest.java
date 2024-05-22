package pl.put.poznan.info.logic.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room_1;
    private Room room_2;
    private Room room_3;

    @BeforeEach
    public void steUp() {
        room_1 = new Room("112", 13, 200, 5, 9);
        room_2 = new Room("111", 20, 400, 15, 30);
        room_3 = new Room("110", 80, 600, 21, 60);
    }

    @Test
    void calculateTotalArea() {
        assertEquals(13.0, room_1.calculateTotalArea());
        assertEquals(20.0, room_2.calculateTotalArea());
        assertEquals(80.0, room_3.calculateTotalArea());
    }

    @Test
    void calculateTotalVolume() {
        assertEquals(200.0, room_1.calculateTotalVolume());
        assertEquals(400.0, room_2.calculateTotalVolume());
        assertEquals(600.0, room_3.calculateTotalVolume());
    }

    @Test
    void calculateTotalHeatingEnergy() {
        assertEquals(9, room_1.calculateTotalHeatingEnergy());
        assertEquals(30, room_2.calculateTotalHeatingEnergy());
        assertEquals(60, room_3.calculateTotalHeatingEnergy());
    }

    @Test
    void calculateTotalLightingPower() {
        assertEquals(5, room_1.calculateTotalLightingPower());
        assertEquals(15, room_2.calculateTotalLightingPower());
        assertEquals(21, room_3.calculateTotalLightingPower());
    }

    @Test
    void calculateTotalWaterConsumption() {
        assertEquals(2 * 13, room_1.calculateTotalWaterConsumption());
        assertEquals(2 * 20, room_2.calculateTotalWaterConsumption());
        assertEquals(2 * 80, room_3.calculateTotalWaterConsumption());
    }

    @Test
    void testInvalidValues(){
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Room(null, -1, -1, -1, -1));

        assertEquals("Invalid parameters for Room constructor", thrown.getMessage());

    }

    @Test
    void testValidValues(){
        assertDoesNotThrow(()-> new Room("112", 2, 3, 4, 5));
    }
}
