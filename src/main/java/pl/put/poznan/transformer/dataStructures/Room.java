package pl.put.poznan.transformer.dataStructures;

public class Room implements ComponentLocation {

    private String id;
    private String name;

    private double height;
    private double area;
    private double volume;
    private double heating;
    private double lighting;

    /**
     *
     * Default constructor for creation of JSON objects
     */
    public Room(){

    }

    public Room(String id, String name, double width, double length, double height, double heating, double lighting) {
        this.id = id;
        this.name = name;
        this.heating = heating;
        this.lighting = lighting;
        this.height = height;
        this.area = width * length;
        this.volume = this.area * height;

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addLocation(ComponentLocation location) {
        // Rooms are leaf nodes, so this operation doesn't apply
    }

    @Override
    public void removeLocation(ComponentLocation location) {
        // Rooms are leaf nodes, so this operation doesn't apply
    }

    @Override
    public double calculateTotalArea() {
        return this.area;
    }

    @Override
    public double calculateTotalVolume() {
        return this.volume;
    }

    @Override
    public double calculateTotalHeatingEnergy() {
        return this.heating;
    }

    @Override
    public double calculateTotalLightingPower() {
        return this.lighting;
    }
}

