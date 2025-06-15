package Classes.DataStructure;

import java.util.*;

public class AppData {
    public static AppData instance = null;
    private LinkedList<Manufacturer> manufacturersList = new LinkedList<>();
    private LinkedList<Model> modelsList = new LinkedList<>();
    private LinkedList<Bike> bikesList = new LinkedList<>();
    private LinkedList<Car> carsList = new LinkedList<>();

    public AppData() {
        manufacturersList.add(new Manufacturer("Opel"));
        manufacturersList.add(new Manufacturer("BMW"));
        manufacturersList.add(new Manufacturer("Volkswagen"));
        manufacturersList.add(new Manufacturer("Skoda"));
        manufacturersList.add(new Manufacturer("Renault"));
        manufacturersList.add(new Manufacturer("Yamaha"));

        modelsList.add(new Model(manufacturersList.get(0),"Corsa"));
        modelsList.add(new Model(manufacturersList.get(5),"MT-07"));

        carsList.add(new Car(modelsList.get(0),"45-DP-20"));
        bikesList.add(new Bike(modelsList.get(1),"AB-01-CD"));
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

    public LinkedList<Bike> getBikesList() {
        return bikesList;
    }

    public LinkedList<Car> getCarsList() {
        return carsList;
    }
}
