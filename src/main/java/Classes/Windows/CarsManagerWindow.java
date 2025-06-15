package Classes.Windows;

import Classes.DataStructure.AppData;
import Classes.DataStructure.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CarsManagerWindow extends JFrame {
    private JTable carsTable;
    private JButton addCarButton;
    private JButton removeCarButton;
    private JButton editCarButton;
    private JButton carDetailsButton;
    private JScrollPane scrollPane;
    private JPanel mainPanel;
    private String[] columns;
    private DefaultTableModel tableModel;

    public CarsManagerWindow() throws HeadlessException {
        super("Cars List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        String[] columns = {"License Plate", "Model", "Make"};
        this.columns = columns;

        carsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateTable();
    }

    public void updateTable(){
        tableModel = new DefaultTableModel(columns,0);
        for(Car car: AppData.getInstance().getCarsList()){
            Object[] row = {
                    car.getLicensePlate(),
                    car.getModel().getName(),
                    car.getModel().getManufacturer().getName()
            };
            tableModel.addRow(row);
        }
        carsTable.setModel(tableModel);
    }
}
