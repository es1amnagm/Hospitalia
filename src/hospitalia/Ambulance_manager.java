package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Ambulance_manager {
    
    
        public Ambulance_manager()
        {
            
        JFrame ambulanceFrame = Frame("Ambulance", null);
JPanel ambulancePanel = Panel(null, new Color(17, 92, 115));

ambulancePanel.setBounds(0, 0, 350, screenSize.height);

JPanel ambulancePanel2 = Panel(null, Color.white);

ambulancePanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

ambulanceFrame.add(ambulancePanel);
ambulanceFrame.add(ambulancePanel2);

// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         ambulanceFrame.dispose();
        });
 ambulanceFrame.add(exitButton);
 

JButton addAmbulance = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));
JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));

ambulancePanel.add(addAmbulance);
ambulancePanel.add(selectAll);
ambulancePanel.add(selectOne);

addAmbulance.addActionListener((e) -> {
        ambulancePanel2.removeAll();
    ambulancePanel2.repaint();
    JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
    add.setBackground(Color.white);
    ambulancePanel2.add(add);
    ambulancePanel2.setVisible(true);

    JLabel ambulanceId = Label("Ambulance ID", 150, 20, 200, 30, 35);
    JTextField ambulanceIdField = TextField(320, 25, 300, 30);

    JLabel isFree = Label("Is Free (1/0)", 120, 100, 200, 30, 35);
    JTextField isFreeField = TextField(320, 105, 300, 30);

    JLabel outDate = Label("Out Date", 120, 180, 200, 30, 35);
    JTextField outDateField = TextField(320, 185, 300, 30);

    JLabel inDate = Label("In Date", 120, 260, 200, 30, 35);
    JTextField inDateField = TextField(320, 265, 300, 30);

    JLabel driverId = Label("Driver ID", 970, 20, 200, 30, 35);
    JTextField driverIdField = TextField(650, 25, 300, 30);

    JLabel needPreparing = Label("Need Preparing (1/0)", 970, 100, 200, 30, 35);
    JTextField needPreparingField = TextField(650, 105, 300, 30);

    ambulancePanel2.add(ambulanceId);
    ambulancePanel2.add(ambulanceIdField);
    ambulancePanel2.add(isFree);
    ambulancePanel2.add(isFreeField);
    ambulancePanel2.add(outDate);
    ambulancePanel2.add(outDateField);
    ambulancePanel2.add(inDate);
    ambulancePanel2.add(inDateField);
    ambulancePanel2.add(driverId);
    ambulancePanel2.add(driverIdField);
    ambulancePanel2.add(needPreparing);
    ambulancePanel2.add(needPreparingField);

    add.addActionListener((a) -> {
        String getAmbulanceId = ambulanceIdField.getText();
        String getIsFree = isFreeField.getText();
        String getOutDate = outDateField.getText();
        String getInDate = inDateField.getText();
        String getDriverId = driverIdField.getText();
        String getNeedPreparing = needPreparingField.getText();

        java.sql.Connection connect = DatabaseConnection.connect();

        try (connect) {
            String insertAmbulanceQuery = "INSERT INTO Ambulance (ambulance_id, is_free, out_date, in_date, driver_id, need_preparing) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ambulanceStatement = connect.prepareStatement(insertAmbulanceQuery);

            ambulanceStatement.setInt(1, Integer.parseInt(getAmbulanceId));
            ambulanceStatement.setBoolean(2, getIsFree.equals("1"));
            ambulanceStatement.setDate(3, java.sql.Date.valueOf(getOutDate));
            ambulanceStatement.setDate(4, java.sql.Date.valueOf(getInDate));
            ambulanceStatement.setInt(5, Integer.parseInt(getDriverId));
            ambulanceStatement.setBoolean(6, getNeedPreparing.equals("1"));

            int ambulanceRows = ambulanceStatement.executeUpdate();
            if (ambulanceRows > 0) {
                JOptionPane.showMessageDialog(null, "Ambulance added successfully!");
                ambulancePanel2.setVisible(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding ambulance: " + ex.getMessage());
        }
    });
});

            
            
            // select one 
            
            // select one ambulance

selectOne.addActionListener((e) -> {
        ambulancePanel2.removeAll();
    ambulancePanel2.repaint();
    JFrame idFrame = Frame("Enter Ambulance ID", new GridLayout(1, 1), 500, 400);
    JPanel idPanel = Create.Panel(null, Color.white);

    // ID Input
    JLabel idLabel = Label("Ambulance ID", 20, 30, 170, 30, 20);
    JTextField idField = TextField(200, 30, 250, 30);

    // OK Button
    JButton ok = Button("OK", 190, 290, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    // OK Button Listener
    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Ambulance ID.");
        } else {
            idFrame.setVisible(false);

            int ambulanceId = Integer.parseInt(idField.getText());

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                // Query to get ambulance info
                String query = "SELECT * FROM Ambulance WHERE ambulance_id = ?;";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, ambulanceId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        JLabel isFreeLabel = Label("Is Free: " + (resultSet.getObject("is_free") == null ? "Break Down" : (resultSet.getBoolean("is_free") ? "Yes" : "No")), 50, 20, 400, 60, 30);
                        ambulancePanel2.add(isFreeLabel);

                        JLabel outDateLabel = Label("Out Date: " + resultSet.getDate("out_date"), 50, 80, 400, 60, 30);
                        ambulancePanel2.add(outDateLabel);

                        JLabel inDateLabel = Label("In Date: " + resultSet.getDate("in_date"), 50, 140, 400, 60, 30);
                        ambulancePanel2.add(inDateLabel);

                        JLabel driverIdLabel = Label("Driver ID: " + resultSet.getInt("driver_id"), 50, 200, 400, 60, 30);
                        ambulancePanel2.add(driverIdLabel);

                        JLabel prepareLabel = Label("Needs Preparing: " + (resultSet.getBoolean("need_preparing") ? "Yes" : "No"), 50, 260, 400, 60, 30);
                        ambulancePanel2.add(prepareLabel);
                    } else {
                        JOptionPane.showMessageDialog(null, "No Ambulance found with the given ID.");
                        return;
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while fetching ambulance data.");
            } finally {
                if (connect != null) {
                    try {
                        connect.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            ambulanceFrame.add(ambulancePanel);
            ambulanceFrame.setVisible(true);
        }
    });
});

            
            
            
            
            
            
            
            
            
            
            
            //select All
            
            selectAll.addActionListener((e) -> {
    ambulancePanel2.removeAll();
    ambulancePanel2.repaint();
    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable ambulanceTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(ambulanceTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        ambulanceFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Ambulance table
        String query = "SELECT ambulance_id, is_free, out_date, in_date, driver_id, need_preparing FROM Ambulance";

        // Use try-with-resources for the PreparedStatement and ResultSet
  

        try (PreparedStatement stmt = connect.prepareStatement(query) ) {
                    ResultSet resultSet = stmt.executeQuery();
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
            ambulanceTable.setModel(tableModel);
        }

  
        // Display the frame
        ambulanceFrame.setVisible(true);

    } catch (SQLException es) {
        es.printStackTrace();
    } finally {
        // Ensure the connection is closed
        if (connect != null) {
            System.out.println("Connection closed.");
        }
    }

});

            
            
            
            
            
            
            
    }
}
