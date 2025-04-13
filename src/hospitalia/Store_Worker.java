/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalia;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import static hospitalia.Create.*;

public class Store_Worker {
    
    public Store_Worker(){
JFrame workerFrame = Frame("Worker Orders", null);
JPanel workerPanel = Panel(null, new Color(17, 92, 115));

workerPanel.setBounds(0, 0, 350, screenSize.height);

JPanel workerPanel2 = Panel(null, Color.white);
workerPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

workerFrame.add(workerPanel);
workerFrame.add(workerPanel2);

        // Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         workerFrame.dispose();
        });
 workerFrame.add(exitButton);



JButton showOrders = Button("Show Orders", 50, 40, 200, 40, 18,Color.black);
workerPanel.add(showOrders);

showOrders.addActionListener((e) -> {
    JFrame idFrame = Frame("Enter Worker Store ID", new GridLayout(1, 1), 500, 400);
    JPanel idPanel = Panel(null, Color.white);

    // ID Input
    JLabel idLabel = Label("Worker Store ID", 20, 30, 200, 30, 25);
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
            JOptionPane.showMessageDialog(null, "Please enter a valid Worker Store ID.");
        } else {
            idFrame.setVisible(false);
            int workerStoreId = Integer.parseInt(idField.getText()); // Get user input

            workerPanel2.removeAll(); // Clear previous data
            workerPanel2.repaint();

            // Fetch data from the database
            java.sql.Connection connect = null;
            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                // Query to get all orders for the worker
                String query = """
                    SELECT pharmacyutical_id, ordder 
                    FROM pharmacyutical_call_worker_store_to_get_medicine
                    WHERE worker_store_id = ?;
                """;

                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, workerStoreId);
                    ResultSet resultSet = stmt.executeQuery();

                    int yPosition = 20; // Initial Y position for labels
                    if (resultSet.next()) {
                        do {
                            JLabel pharmacyIdLabel = Label("Pharmaceutical ID: " + resultSet.getInt("pharmacyutical_id"), 50, yPosition, 400, 30, 20);
                            workerPanel2.add(pharmacyIdLabel);
                            yPosition += 40;

                            JLabel orderLabel = Label("Order: " + resultSet.getString("ordder"), 50, yPosition, 400, 30, 20);
                            workerPanel2.add(orderLabel);
                            yPosition += 50;
                        } while (resultSet.next());
                    } else {
                        JOptionPane.showMessageDialog(null, "No orders found for the given Worker Store ID.");
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
            workerFrame.setVisible(true);
            workerPanel2.revalidate();
            workerPanel2.repaint();
        }
    });
});

JButton addMedicineBtn = new JButton("Add Medicine");
addMedicineBtn.setBounds(50, 100, 200, 40);
addMedicineBtn.setFont(new Font("Arial", Font.BOLD, 18));
addMedicineBtn.setBackground(new Color(110, 181, 178));
workerPanel.add(addMedicineBtn);

addMedicineBtn.addActionListener(e -> {
    workerPanel2.removeAll();
    workerPanel2.repaint();

    JLabel medicineNameLabel = new JLabel("Medicine Name:");
    medicineNameLabel.setBounds(50, 50, 200, 30);
    medicineNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
    workerPanel2.add(medicineNameLabel);

    JTextField medicineNameField = new JTextField();
    medicineNameField.setBounds(250, 50, 300, 30);
    workerPanel2.add(medicineNameField);

    JLabel quantityLabel = new JLabel("Number of Boxes:");
    quantityLabel.setBounds(50, 100, 200, 30);
    quantityLabel.setFont(new Font("Arial", Font.BOLD, 18));
    workerPanel2.add(quantityLabel);

    JTextField quantityField = new JTextField();
    quantityField.setBounds(250, 100, 300, 30);
    workerPanel2.add(quantityField);

    JLabel storeIdLabel = new JLabel("Store ID:");
    storeIdLabel.setBounds(50, 150, 200, 30);
    storeIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
    workerPanel2.add(storeIdLabel);

    JTextField storeIdField = new JTextField();
    storeIdField.setBounds(250, 150, 300, 30);
    workerPanel2.add(storeIdField);

    JButton submitBtn = new JButton("Submit");
    submitBtn.setBounds(250, 200, 120, 40);
    submitBtn.setFont(new Font("Arial", Font.BOLD, 18));
    submitBtn.setBackground(new Color(110, 181, 178));
    workerPanel2.add(submitBtn);

    submitBtn.addActionListener(submitEvent -> {
        String medicineName = medicineNameField.getText();
        String quantityText = quantityField.getText();
        String storeIdText = storeIdField.getText();

        if (medicineName.isEmpty() || quantityText.isEmpty() || storeIdText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled.");
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityText);
            int storeId = Integer.parseInt(storeIdText);

            java.sql.Connection connect = DatabaseConnection.connect();
            String insertQuery = "INSERT INTO store_and_medicine (medicine_name, number_number_of_medicine_box, store_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connect.prepareStatement(insertQuery);
            statement.setString(1, medicineName);
            statement.setInt(2, quantity);
            statement.setInt(3, storeId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Medicine added successfully!");
                medicineNameField.setText("");
                quantityField.setText("");
                storeIdField.setText("");
            }

            connect.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter valid numeric values for Quantity and Store ID.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inserting data into the database: " + ex.getMessage());
        }
    });

    workerPanel2.revalidate();
    workerPanel2.repaint();
});
    
    }
    
}
