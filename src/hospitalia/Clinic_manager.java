package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Clinic_manager {
    
    public Clinic_manager()
    {
      
        
        JFrame clinicFrame = Frame("Clinic", null);
JPanel clinicPanel = Panel(null, new Color(17, 92, 115));

clinicPanel.setBounds(0, 0, 350, screenSize.height);

JPanel clinicPanel2 = Panel(null, Color.white);

clinicPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

clinicFrame.add(clinicPanel);
clinicFrame.add(clinicPanel2);


// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         clinicFrame.dispose();
        });
 clinicFrame.add(exitButton);
 

JButton addClinic = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));
JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));

clinicPanel.add(addClinic);
clinicPanel.add(selectAll);
clinicPanel.add(selectOne);

addClinic.addActionListener((e) -> {
          clinicPanel2.removeAll();
    clinicPanel2.repaint();
    JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
    add.setBackground(Color.white);
    clinicPanel2.add(add);
    clinicPanel2.setVisible(true);

    JLabel clinicId = Label("Clinic ID", 150, 20, 200, 30, 35);
    JTextField clinicIdField = TextField(320, 25, 300, 30);

    JLabel floor = Label("Floor", 120, 100, 200, 30, 35);
    JTextField floorField = TextField(320, 105, 300, 30);

    JLabel nurseId = Label("Nurse ID", 120, 180, 200, 30, 35);
    JTextField nurseIdField = TextField(320, 185, 300, 30);

    JLabel doctorId = Label("Doctor ID", 120, 260, 200, 30, 35);
    JTextField doctorIdField = TextField(320, 265, 300, 30);

    JLabel patientId = Label("Patient ID", 970, 20, 200, 30, 35);
    JTextField patientIdField = TextField(650, 25, 300, 30);

    clinicPanel2.add(clinicId);
    clinicPanel2.add(clinicIdField);
    clinicPanel2.add(floor);
    clinicPanel2.add(floorField);
    clinicPanel2.add(nurseId);
    clinicPanel2.add(nurseIdField);
    clinicPanel2.add(doctorId);
    clinicPanel2.add(doctorIdField);
    clinicPanel2.add(patientId);
    clinicPanel2.add(patientIdField);

    add.addActionListener((a) -> {
        String getClinicId = clinicIdField.getText();
        String getFloor = floorField.getText();
        String getNurseId = nurseIdField.getText();
        String getDoctorId = doctorIdField.getText();
        String getPatientId = patientIdField.getText();

        java.sql.Connection connect = DatabaseConnection.connect();

        try (connect) {
            String insertClinicQuery = "INSERT INTO Clinic (clinic_id, floor, nurse_id, doctor_id, patient_id) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement clinicStatement = connect.prepareStatement(insertClinicQuery);

            clinicStatement.setInt(1, Integer.parseInt(getClinicId));
            clinicStatement.setInt(2, Integer.parseInt(getFloor));
            clinicStatement.setInt(3, Integer.parseInt(getNurseId));
            clinicStatement.setInt(4, Integer.parseInt(getDoctorId));
            clinicStatement.setInt(5, Integer.parseInt(getPatientId));

            int clinicRows = clinicStatement.executeUpdate();
            if (clinicRows > 0) {
                JOptionPane.showMessageDialog(null, "Clinic added successfully!");
                clinicPanel2.setVisible(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding clinic: " + ex.getMessage());
        }
    });
});






    // select one 
    
    selectOne.addActionListener((c) -> {
              clinicPanel2.removeAll();
    clinicPanel2.repaint();
    JFrame idFrame = Frame("Enter Clinic ID", new GridLayout(1, 1), 500, 300);
    JPanel idPanel = Create.Panel(null, Color.white);

    JLabel idLabel = Label("Clinic ID", 90, 30, 120, 30, 20);
    JTextField idField = TextField(220, 30, 200, 30);

    JButton ok = Button("OK", 190, 200, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Clinic ID.");
        } else {
            idFrame.setVisible(false);
            int clinicId = Integer.parseInt(idField.getText());

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                String query = "SELECT * FROM Clinic WHERE clinic_id = ?";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, clinicId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        

                        JLabel floorLabel = Label("Floor: " + resultSet.getInt("floor"), 50, 20, 400, 30, 20);
                        clinicPanel2.add(floorLabel);

                        JLabel nurseLabel = Label("Nurse ID: " + resultSet.getInt("nurse_id"), 50, 60, 400, 30, 20);
                        clinicPanel2.add(nurseLabel);

                        JLabel doctorLabel = Label("Doctor ID: " + resultSet.getInt("doctor_id"), 50, 100, 400, 30, 20);
                        clinicPanel2.add(doctorLabel);

                        JLabel patientLabel = Label("Patient ID: " + resultSet.getInt("patient_id"), 50, 140, 400, 30, 20);
                        clinicPanel2.add(patientLabel);

                        clinicFrame.add(clinicPanel2);
                        clinicFrame.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "No clinic found with the given ID.");
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (connect != null) {
                    try {
                        connect.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    });
});

        
        
        
        //select all
        
        selectAll.addActionListener((e) -> {
      clinicPanel2.removeAll();
    clinicPanel2.repaint();
    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable clinicTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(clinicTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        clinicFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Clinic table
        String query = "SELECT clinic_id, floor, nurse_id, doctor_id, patient_id FROM Clinic";

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
            clinicTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        clinicFrame.setVisible(true);

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
