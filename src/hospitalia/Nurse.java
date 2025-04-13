package hospitalia;

import static hospitalia.Create.*;
import static hospitalia.GUI.screenSize;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
 
import java.sql.*;

public class Nurse {

    private JFrame loginFrame;
    private JTextField nurseIdField;
    private JButton loginButton;

    public Nurse() {
        // Create Login Frame

        // Create Login Frame
        loginFrame = Frame("Nurse Login", null, 300, 200);

        // Label
        JLabel nurseIdLabel = Label("Enter Nurse ID:", 50, 30, 150, 30);
        loginFrame.add(nurseIdLabel);

        // Text Field for Nurse ID
        nurseIdField = TextField(50, 60, 180, 30);
        loginFrame.add(nurseIdField);

        // Login Button
        loginButton = Button("Login", 50, 100, 180, 30);
        loginFrame.add(loginButton);

            
    

 
        
        
        
        
        // Action Listener for Button
        loginButton.addActionListener(e -> {
            try {
                int nurseId = Integer.parseInt(nurseIdField.getText());
                loginFrame.dispose(); // Close login frame
                new NurseDashboard(nurseId); // Open Dashboard
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(loginFrame, "Please enter a valid Nurse ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}

// -------------------------------- Nurse Dashboard --------------------------------
class NurseDashboard {

    private JFrame nurseFrame;
    private JPanel nursePanel, nursePanel2;
    private JTable dataTable;
    private JScrollPane scrollPane;
    private int currentNurseId;

    public NurseDashboard(int nurseId) {
        this.currentNurseId = nurseId;
        nurseFrame = Frame("Nurse Dashboard - ID: " + nurseId, null);

        // Left Panel
        nursePanel = Panel(null, new Color(17, 92, 115));
        nursePanel.setBounds(0, 0, 350, screenSize.height);

        // Right Panel
        nursePanel2 = Panel(new BorderLayout(), Color.WHITE);
        nursePanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

        
        
        // Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 600, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         nurseFrame.dispose();
        });
 nurseFrame.add(exitButton);
        
        
        
        // Show Patients Button
        JButton showPatientsButton = Button("Show Patients", 20, 50, 150, 30);
        showPatientsButton.addActionListener(e -> loadPatients());
        nursePanel.add(showPatientsButton);

        // Show Operations Button
        JButton showOperationsButton = Button("Show Operations", 20, 100, 150, 30);
        showOperationsButton.addActionListener(e -> loadOperations());
        nursePanel.add(showOperationsButton);

        // Add panels to frame
        nurseFrame.add(nursePanel);
        nurseFrame.add(nursePanel2);
    }

    private void loadPatients() {
        String[] columnNames = {"ID", "First Name", "Last Name", "Gender", "Visit Date", "Out Date", "Diagnosis"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        try (Connection connect = DatabaseConnection.connect()) {
            String query = "SELECT patient_id, first_name, last_name, genderp, visit_date, out_date, diagnosis FROM Patient WHERE nurse_id = ?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, currentNurseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("patient_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("genderp"),
                    rs.getDate("visit_date"),
                    rs.getDate("out_date"),
                    rs.getString("diagnosis")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        updateTable(model);
    }

    private void loadOperations() {
        String[] columnNames = {"Operation ID", "Type", "Done", "Date", "Room ID", "Patient ID"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        try (Connection connect = DatabaseConnection.connect()) {
            String query = "SELECT o.operation_id, o.type, o.done, o.date, o.room_id, o.patient_id FROM Operation o "
                    + "JOIN nurse_do_operation ndo ON o.operation_id = ndo.operation_id WHERE ndo.nurse_id = ?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, currentNurseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("operation_id"),
                    rs.getString("type"),
                    rs.getBoolean("done"),
                    rs.getDate("date"),
                    rs.getInt("room_id"),
                    rs.getInt("patient_id")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        updateTable(model);
    }

    private void updateTable(DefaultTableModel model) {
        dataTable = new JTable(model);
        scrollPane = new JScrollPane(dataTable);
        nursePanel2.removeAll();
        nursePanel2.add(scrollPane, BorderLayout.CENTER);
        nursePanel2.revalidate();
        nursePanel2.repaint();
    }
}
