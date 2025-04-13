package hospitalia;

import static hospitalia.Create.Font;
import static hospitalia.Create.screenSize;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Patient_manager extends JFrame {
    private JPanel patientPanel;
    private JTextField idField;
    private JTextArea resultArea;
    private DatabaseConnection dbConnection;
    private JFrame frame;

    public Patient_manager() {
        dbConnection = new DatabaseConnection();
        initializeUI();
    }

    private void initializeUI() {
        // Create frame
        frame = Create.Frame("Patient Manager", null );
 
        // Create panel with null layout
        patientPanel = Create.Panel(null, new Color(240, 240, 240));
patientPanel.setBounds(0, 0, 350, screenSize.height);

  
    
// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         frame.dispose();
        });
 frame.add(exitButton);
 

        // ID input field
        JLabel idLabel = Create.Label("Patient ID:", 50, 40, 100, 30);
        patientPanel.add(idLabel);

        idField = Create.TextField(150, 40, 200, 30);
        patientPanel.add(idField);

        // Select One button
        JButton selectOne = Create.Button("Select One", 50, 100, 240, 40);
        selectOne.addActionListener(e -> selectOnePatient());
        patientPanel.add(selectOne);

        // Select All button
        JButton selectAll = Create.Button("Select All", 50, 160, 240, 40);
        selectAll.addActionListener(e -> selectAllPatients());
        patientPanel.add(selectAll);

        // Result area inside scroll pane
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(Create.Font());
        
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(350, 40, 400, 500);
        patientPanel.add(scrollPane);

        frame.add(patientPanel);
        frame.setVisible(true);
    }

    private void selectOnePatient() {
        String id = idField.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a patient ID");
            return;
        }

        try {
            int clinicId = Integer.parseInt(id);

            Connection connect = DatabaseConnection.connect();
            if (connect == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed.");
                return;
            }

            String query = "SELECT * FROM patient WHERE id = ?";
            try (PreparedStatement stmt = connect.prepareStatement(query)) {
                stmt.setInt(1, clinicId);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    StringBuilder result = new StringBuilder();
                    result.append("Patient Details:\n\n");
                    result.append("ID: ").append(rs.getString("id")).append("\n");
                    result.append("Name: ").append(rs.getString("name")).append("\n");
                    result.append("Age: ").append(rs.getInt("age")).append("\n");
                    result.append("Gender: ").append(rs.getString("gender")).append("\n");
                    result.append("Phone: ").append(rs.getString("phone")).append("\n");
                    result.append("Address: ").append(rs.getString("address")).append("\n");
                    result.append("Blood Type: ").append(rs.getString("blood_type")).append("\n");
                    result.append("Medical History: ").append(rs.getString("medical_history")).append("\n");
                    result.append("Current Condition: ").append(rs.getString("current_condition")).append("\n");
                    result.append("Admission Date: ").append(rs.getDate("admission_date")).append("\n");
                    result.append("Room Number: ").append(rs.getString("room_number")).append("\n");
                    result.append("Doctor ID: ").append(rs.getString("doctor_id")).append("\n");

                    resultArea.setText(result.toString());
                } else {
                    resultArea.setText("No patient found with ID: " + id);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format");
        } catch (SQLException ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    private void selectAllPatients() {
        try {
            Connection connect = DatabaseConnection.connect();
            if (connect == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed.");
                return;
            }

            String query = "SELECT * FROM patient";
            try (PreparedStatement stmt = connect.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                StringBuilder result = new StringBuilder();
                result.append("All Patients:\n\n");

                while (rs.next()) {
                    result.append("Patient ID: ").append(rs.getString("id")).append("\n");
                    result.append("Name: ").append(rs.getString("name")).append("\n");
                    result.append("Age: ").append(rs.getInt("age")).append("\n");
                    result.append("Gender: ").append(rs.getString("gender")).append("\n");
                    result.append("Phone: ").append(rs.getString("phone")).append("\n");
                    result.append("Address: ").append(rs.getString("address")).append("\n");
                    result.append("Blood Type: ").append(rs.getString("blood_type")).append("\n");
                    result.append("Medical History: ").append(rs.getString("medical_history")).append("\n");
                    result.append("Current Condition: ").append(rs.getString("current_condition")).append("\n");
                    result.append("Admission Date: ").append(rs.getDate("admission_date")).append("\n");
                    result.append("Room Number: ").append(rs.getString("room_number")).append("\n");
                    result.append("Doctor ID: ").append(rs.getString("doctor_id")).append("\n");
                    result.append("----------------------------------------\n");
                }

                resultArea.setText(result.toString());
            }
        } catch (SQLException ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }
 
}
