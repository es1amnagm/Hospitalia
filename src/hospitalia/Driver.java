/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalia;

import static hospitalia.Create.*;
import static hospitalia.GUI.screenSize;
 import java.awt.Color;
import java.awt.GridLayout;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
import java.sql.SQLException;
 import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
import javax.swing.JTextField;
 public class Driver {
    
    
    public Driver()
    {
        
            
        
        JFrame driverFrame = Frame("Driver", null);
JPanel driverPanel = Panel(null, new Color(17, 92, 115));

driverPanel.setBounds(0, 0, 350, screenSize.height);

JPanel driverPanel2 = Panel(null, Color.white);

driverPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

driverFrame.add(driverPanel);
driverFrame.add(driverPanel2);


// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         driverFrame.dispose();
        });
 driverFrame.add(exitButton);
 
JButton showOrders = Button("Show Orders", 50, 40, 240, 40, 35, new Color(110, 181, 178));

driverPanel.add(showOrders);

showOrders.addActionListener((e) -> {
           driverPanel2.removeAll();
    driverPanel2.repaint();
    JFrame idFrame = Frame("Enter Driver ID", new GridLayout(1, 1), 500, 400);
    JPanel idPanel = Panel(null, Color.white);

    // ID Input
    JLabel idLabel = Label("Driver ID", 30, 30, 200, 30, 30);
    JTextField idField = TextField(210, 30, 250, 30);

    // OK Button
    JButton ok = Button("OK", 190, 290, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    // OK Button Listener
    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Driver ID.");
        } else {
            idFrame.setVisible(false);
            int driverId = Integer.parseInt(idField.getText()); // Get user input

            // New panel for displaying driver order data
            driverPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);
            driverFrame.add(driverPanel2);

            // Fetch data from the database
            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                // Query to get all required data for the driver
                String query = """
                    SELECT receptionist_id, driver_id, date, address
                    FROM receptionist_order_driver
                    WHERE driver_id = ?;
                """;

                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, driverId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        // Create labels for each field
                        JLabel receptionistIdLabel = Label("Receptionist ID: " + resultSet.getInt("receptionist_id"), 50, 20, 400, 60, 30);
                        driverPanel2.add(receptionistIdLabel);

                        JLabel driverIdLabel = Label("Driver ID: " + resultSet.getInt("driver_id"), 50, 80, 400, 60, 30);
                        driverPanel2.add(driverIdLabel);

                        JLabel dateLabel = Label("Date: " + resultSet.getDate("date"), 50, 140, 400, 60, 30);
                        driverPanel2.add(dateLabel);

                        JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 200, 400, 60, 30);
                        driverPanel2.add(addressLabel);
                    } else {
                        JOptionPane.showMessageDialog(null, "No records found for the given Driver ID.");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while fetching data.");
            } finally {
                if (connect != null) {
                    try {
                        connect.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            // Show the frame with the data labels
            driverFrame.setVisible(true);
        }
    });
});

    }
    
    
}
