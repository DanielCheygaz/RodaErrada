package Classes.DataStructure;

public class Bike implements Vehicle{
    private Model model;
    private String licensePlate;

    public Bike(Model model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
}
