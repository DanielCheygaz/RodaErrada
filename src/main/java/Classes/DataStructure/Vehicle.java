package Classes.DataStructure;

public class Vehicle {
    private Model model;
    private String licensePlate;

    public Vehicle(Model model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public Model getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
