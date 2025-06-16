package Classes.DataStructure;

public class Manufacturer<TVehicle extends Vehicle> {
    private String name;
    private Class<TVehicle> vehicleType;

    public Manufacturer(String name, Class<TVehicle> vehicleType) {
        this.name = name;
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<TVehicle> getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return name;
    }
}
