package Classes.DataStructure;

import java.util.*;

public class AppData {
    public static AppData instance = null;
    private LinkedList<Manufacturer> manufacturersList = new LinkedList<>();
    private LinkedList<Model> modelsList = new LinkedList<>();
    private LinkedList<Vehicle> vehiclesList = new LinkedList<>();

    public AppData() {
        manufacturersList.add(new Manufacturer<Car>("Opel", Car.class));
        manufacturersList.add(new Manufacturer<Bike>("BMW", Bike.class));
        manufacturersList.add(new Manufacturer<Car>("BMW", Car.class));
        manufacturersList.add(new Manufacturer<Car>("Volkswagen", Car.class));
        manufacturersList.add(new Manufacturer<Car>("Skoda", Car.class));
        manufacturersList.add(new Manufacturer<Car>("Renault", Car.class));
        manufacturersList.add(new Manufacturer<Bike>("Yamaha", Bike.class));

        modelsList.add(new Model(manufacturersList.get(0),"Corsa"));
        modelsList.add(new Model(manufacturersList.get(6),"MT-07"));
        modelsList.add(new Model(manufacturersList.get(1),"S1000RR"));
        modelsList.add(new Model(manufacturersList.get(2),"320d"));

        vehiclesList.add(new Car(modelsList.get(0),"45-DP-20"));
        vehiclesList.add(new Bike(modelsList.get(1),"AB-01-CD"));
    }

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
            loadData();
        }
        return instance;
    }

    private static void loadData() {}

    public LinkedList<Manufacturer> getManufacturersList() {
        return manufacturersList;
    }

    public LinkedList<Model> getModelsList() {
        return modelsList;
    }

    public LinkedList<Vehicle> getVehiclesList() {
        return vehiclesList;
    }
}
