package Classes.Windows;

import Classes.DataStructure.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VehicleManagerWindow<TVehicle extends Vehicle> extends JFrame{
    private JTable vehiclesTable;
    private JButton addVehicleButton;
    private JButton removeVehicleButton;
    private JButton editVehicleButton;
    private JButton vehicleDetailsButton;
    private JScrollPane scrollPane;
    private JPanel mainPanel;
    private JButton backButton;
    private JLabel pageTitle;
    private String[] columns;
    private DefaultTableModel tableModel;

    private final Class<TVehicle> vehicleClass;

    public VehicleManagerWindow(Class<TVehicle> vehicleClass) throws HeadlessException {
        super(vehicleClass.getSimpleName() + " List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        String className = vehicleClass.getSimpleName();

        pageTitle.setText(className + " List");
        addVehicleButton.setText("Add " + className);
        editVehicleButton.setText("Edit " + className);
        removeVehicleButton.setText("Remove " + className);
        vehicleDetailsButton.setText(className + " details");

        this.vehicleClass = vehicleClass;

        String[] columns = {"License Plate", "Model", "Make"};
        this.columns = columns;

        vehiclesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateTable();

        this.addVehicleButton.addActionListener(this::addButtonPerformed);
        this.backButton.addActionListener(this::backButtonPerformed);
    }

    private void addButtonPerformed(ActionEvent e){
        new VehicleAddWindow<TVehicle>(vehicleClass,this).setVisible(true);
        setVisible(false);
    }

    private void backButtonPerformed(ActionEvent e){
        new MainWindow().setVisible(true);
        dispose();
    }

    public void updateTable(){
        tableModel = new DefaultTableModel(columns,0);

        for (Vehicle vehicle : AppData.getInstance().getVehiclesList()) {
            if (vehicleClass.isInstance(vehicle)) {
                TVehicle v = vehicleClass.cast(vehicle);
                Object[] row = {
                        v.getLicensePlate(),
                        v.getModel().getName(),
                        v.getModel().getManufacturer().getName()
                };
                tableModel.addRow(row);
            }
        }

        vehiclesTable.setModel(tableModel);
    }
}
