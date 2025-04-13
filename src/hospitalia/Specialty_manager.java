/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalia;


import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Specialty_manager {

    public Specialty_manager() {

        JFrame specialityFrame = Frame("Specialty", null);
        JPanel leftPanel = Panel(null, new Color(17, 92, 115));

        leftPanel.setBounds(0, 0, 350, screenSize.height);

        JPanel rightPanel = Panel(null, Color.white);

        rightPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
        specialityFrame.add(leftPanel);
        specialityFrame.add(rightPanel);

        // Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         specialityFrame.dispose();
        });
 specialityFrame.add(exitButton);
        
// Buttons on the left panel
        JButton addSpecialityBtn = Button("Add Speciality",30,50,200,40);
        JButton selectAll = Button("Select All",30,200,200,40);

        leftPanel.add(addSpecialityBtn);
        leftPanel.add(selectAll);

// Adding components for speciality on the right panel
        addSpecialityBtn.addActionListener(e -> {
            rightPanel.removeAll();
            rightPanel.repaint();

            JLabel specialityNameLabel = new JLabel("Speciality Name:");
            specialityNameLabel.setBounds(50, 50, 150, 30);
            specialityNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            rightPanel.add(specialityNameLabel);

            JTextField specialityNameField = new JTextField();
            specialityNameField.setBounds(220, 50, 300, 30);
            rightPanel.add(specialityNameField);

            JButton submitBtn = new JButton("Submit");
            submitBtn.setBounds(220, 100, 120, 40);
            submitBtn.setFont(new Font("Arial", Font.BOLD, 18));
            submitBtn.setBackground(new Color(110, 181, 178));
            rightPanel.add(submitBtn);

            submitBtn.addActionListener(submitEvent -> {
                String specialityName = specialityNameField.getText();
                if (specialityName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Speciality name cannot be empty.");
                } else {
                    try {
                        // Database connection and insertion
                        java.sql.Connection connect = DatabaseConnection.connect();
                        String insertQuery = "INSERT INTO Speciality (speciality_name) VALUES (?)";
                        PreparedStatement statement = connect.prepareStatement(insertQuery);
                        statement.setString(1, specialityName);

                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Speciality added successfully!");
                            specialityNameField.setText(""); // Clear the field
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error inserting data into the database: " + ex.getMessage());
                    }
                }
            });
        });

        specialityFrame.setVisible(true);
        
        
        selectAll.addActionListener((e) -> {

    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable specialityTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(specialityTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        specialityFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Speciality table
        String query = "SELECT speciality_name FROM Speciality";

        // Use try-with-resources for the PreparedStatement and ResultSet
        try (PreparedStatement stmt = connect.prepareStatement(query); ResultSet resultSet = stmt.executeQuery()) {

            // Get the column names dynamically from the ResultSet
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a DefaultTableModel to hold the data
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add column names to the table model
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }

            // Set the model to the table
            specialityTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        specialityFrame.setVisible(true);

    } catch (SQLException es) {
        es.printStackTrace();
    } finally {
        // Ensure the connection is closed
        if (connect != null) {
            try {
                connect.close();
                System.out.println("Connection closed.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

});


    }

}
