package Classes.Windows;

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
    }

    private void carsButtonPerformed(ActionEvent e){
        new CarsManagerWindow().setVisible(true);
    }

    public static void main(String[] args){
        new MainWindow().setVisible(true);
    }
}
