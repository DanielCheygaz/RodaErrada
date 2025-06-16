package Classes.Windows;
import Classes.DataStructure.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame{
    private JPanel mainPanel;
    private JButton carsButton;
    private JButton bikesButton;

    public MainWindow() throws HeadlessException {
        super("Roda Errada");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        this.carsButton.addActionListener(this::carsButtonPerformed);
        this.bikesButton.addActionListener(this::bikesButtonPerformed);
    }

    private void carsButtonPerformed(ActionEvent e){
        VehicleManagerWindow<Car> vehicleManagerWindow = new VehicleManagerWindow<Car>(Car.class);
        vehicleManagerWindow.setVisible(true);
    }

    private void bikesButtonPerformed(ActionEvent e){
        new VehicleManagerWindow<Bike>(Bike.class).setVisible(true);
    }

    public static void main(String[] args){
        new MainWindow().setVisible(true);
    }
}
