package Classes.Windows;

import Classes.DataStructure.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VehicleAddWindow<TVehicle extends Vehicle> extends JFrame{
    private JPanel mainPanel;
    private JTable manufacturersTable;
    private JTable modelsTable;
    private JTextField textField1;
    private JButton addMakeButton;
    private JTextField textField2;
    private JButton addModelButton;
    private JTextField textField3;
    private JTextField textField4;
    private JButton cancelButton;
    private VehicleManagerWindow previousWindow;
    private DefaultTableModel manufacturersTableModel;
    private DefaultTableModel modelsTableModel;
    private String[] columns;
    Class<TVehicle> vehicleClass;

    public VehicleAddWindow(Class<TVehicle> vehicleClass, VehicleManagerWindow previousWindow) throws HeadlessException {
        super(vehicleClass.getSimpleName() + " List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        this.vehicleClass = vehicleClass;

        modelsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        manufacturersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        String[] columns = {"Name"};
        this.columns = columns;
        modelsTableModel = new DefaultTableModel(columns,0);
        modelsTable.setModel(modelsTableModel);

        updateManufacturersTable();

        this.previousWindow = previousWindow;

        manufacturersTable.getSelectionModel().addListSelectionListener(this::manufacturersTableClicked);
        this.cancelButton.addActionListener(this::cancelButtonPerformed);
    }

    private void updateManufacturersTable(){
        manufacturersTableModel = new DefaultTableModel(columns,0);

        for (Manufacturer manufacturer: AppData.getInstance().getManufacturersList()) {
            if(manufacturer.getVehicleType()==vehicleClass){
                Object[] row = {
                    manufacturer
                };
                manufacturersTableModel.addRow(row);
            }
        }
        manufacturersTable.setModel(manufacturersTableModel);

    }

    private void manufacturersTableClicked(ListSelectionEvent e){
        if (!e.getValueIsAdjusting()) {
            int selectedRow = manufacturersTable.getSelectedRow();
            if (selectedRow != -1) {
                Manufacturer manufacturer = (Manufacturer) manufacturersTable.getValueAt(selectedRow,0);

                modelsTableModel = new DefaultTableModel(columns,0);

                for (Model model: AppData.getInstance().getModelsList()) {
                    if(model.getManufacturer().equals(manufacturer)){
                        Object[] row = {
                                model
                        };
                        modelsTableModel.addRow(row);
                    }
                }
                modelsTable.setModel(modelsTableModel);
            }
        }
    }

    private void cancelButtonPerformed(ActionEvent e){
        previousWindow.setVisible(true);
        dispose();
    }
}
