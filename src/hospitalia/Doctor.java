package hospitalia;

import static hospitalia.Create.*;

import java.awt.*;

import javax.swing.*;
import com.sun.jdi.connect.spi.Connection;
import static hospitalia.Create.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static hospitalia.GUI.screenSize;

import java.awt.event.*;

import java.util.ArrayList;

public class Doctor {

    public Doctor() {

        JFrame doctorFrame = Frame("Doctor", null);  // Using the custom Frame method

// Create Panels
        JPanel doctorPanel = Panel(null, new Color(17, 92, 115));
        doctorPanel.setBounds(0, 0, 350, screenSize.height);

        JPanel doctorPanel2 = Panel(null, Color.white);
        doctorPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

// Button to open the Treatment Frame
        JButton openTreatmentButton = Button("Add Treatment", 100, 50, 150, 30);
        doctorPanel.add(openTreatmentButton);

        
 
// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         doctorFrame.dispose();
        });
 doctorFrame.add(exitButton);
        
        doctorFrame.add(doctorPanel);
        doctorFrame.add(doctorPanel2);
        doctorFrame.setVisible(true);
        // Action Listener to open the Treatment Frame when the button is clicked
        openTreatmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTreatmentFrame();
            }
        });
    }

    // Method to show the Treatment Frame when clicked
    private static void showTreatmentFrame() {
        JFrame treatmentFrame = new JFrame("Add Treatment");
        treatmentFrame.setSize(screenSize.width - 350, screenSize.height);
        treatmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        treatmentFrame.setLocation(350, 20);
        JPanel treatmentPanel = new JPanel(new FlowLayout());
        JPanel treatmentPanel2 = new JPanel();
        treatmentPanel2.setLayout(new BoxLayout(treatmentPanel2, BoxLayout.Y_AXIS));

        JTextField treatmentIdField = new JTextField(15);
        JTextField dateField = new JTextField(15);
        JTextField doctorIdField = new JTextField(15);
        JTextField patientIdField = new JTextField(15);

        JButton addTreatmentButton = new JButton("Add Treatment");
        JButton addMedicinesButton = new JButton("Add Medicines");

        treatmentPanel.add(new JLabel("Treatment ID:"));
        treatmentPanel.add(treatmentIdField);
        treatmentPanel.add(new JLabel("Date:"));
        treatmentPanel.add(dateField);
        treatmentPanel.add(new JLabel("Doctor ID:"));
        treatmentPanel.add(doctorIdField);
        treatmentPanel.add(new JLabel("Patient ID:"));
        treatmentPanel.add(patientIdField);
        treatmentPanel.add(addTreatmentButton);
        treatmentPanel.add(addMedicinesButton);

        treatmentFrame.add(treatmentPanel, BorderLayout.NORTH);
        treatmentFrame.add(new JScrollPane(treatmentPanel2), BorderLayout.CENTER);

        ArrayList<String> medicines = new ArrayList<>();

        addMedicinesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel medicinePanel = new JPanel(new FlowLayout());
                JTextField medicineField = new JTextField(15);
                JButton addMedicineButton = new JButton("Add Medicine");

                medicinePanel.add(new JLabel("Medicine Name:"));
                medicinePanel.add(medicineField);
                medicinePanel.add(addMedicineButton);

                treatmentPanel2.add(medicinePanel);
                treatmentPanel2.revalidate();
                treatmentPanel2.repaint();

                addMedicineButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String medicineName = medicineField.getText().trim();
                        if (!medicineName.isEmpty()) {
                            medicines.add(medicineName);
                            JOptionPane.showMessageDialog(treatmentFrame, "Medicine added: " + medicineName);
                            medicineField.setText("");
                        }
                    }
                });
            }
        });

       addTreatmentButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String treatmentId = treatmentIdField.getText().trim();
        String date = dateField.getText().trim();
        String doctorId = doctorIdField.getText().trim();
        String patientId = patientIdField.getText().trim();

        if (treatmentId.isEmpty() || date.isEmpty() || doctorId.isEmpty() || patientId.isEmpty() || medicines.isEmpty()) {
            JOptionPane.showMessageDialog(treatmentFrame, "Please fill all fields and add at least one medicine.");
            return;
        }

        java.sql.Connection connect = null;

        try {
            connect = DatabaseConnection.connect();
            if (connect == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed.");
                return;
            }

            connect.setAutoCommit(false); // Use transaction to keep things safe

            // 1. Insert into Treatment
            String treatmentQuery = "INSERT INTO Treatment (treatment_id, date, state, doctor_id, patient_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement treatmentStmt = connect.prepareStatement(treatmentQuery);
            treatmentStmt.setInt(1, Integer.parseInt(treatmentId));
            treatmentStmt.setDate(2, java.sql.Date.valueOf(date));
            treatmentStmt.setString(3, "zero"); // Initial state
            treatmentStmt.setInt(4, Integer.parseInt(doctorId));
            treatmentStmt.setInt(5, Integer.parseInt(patientId));
            treatmentStmt.executeUpdate();

            // 2. Insert into Treatment_and_Medicine
            String medicineQuery = "INSERT INTO Treatment_and_Medicine (treatment_id, medicine_name) VALUES (?, ?)";
            PreparedStatement medicineStmt = connect.prepareStatement(medicineQuery);

            // 3. Insert into Patient_Treatment_Medicine
            String patientMedicineQuery = "INSERT INTO Patient_Treatment_Medicine (treatment_id, medicine_name, patient_id, is_taken) VALUES (?, ?, ?, ?)";
            PreparedStatement patientMedicineStmt = connect.prepareStatement(patientMedicineQuery);

            for (String medicine : medicines) {
                medicineStmt.setInt(1, Integer.parseInt(treatmentId));
                medicineStmt.setString(2, medicine);
                medicineStmt.executeUpdate();

                patientMedicineStmt.setInt(1, Integer.parseInt(treatmentId));
                patientMedicineStmt.setString(2, medicine);
                patientMedicineStmt.setInt(3, Integer.parseInt(patientId));
                patientMedicineStmt.setBoolean(4, false); // is_taken = 0
                patientMedicineStmt.executeUpdate();
            }

            connect.commit(); // Commit transaction
            JOptionPane.showMessageDialog(treatmentFrame, "Treatment added successfully with medicines.");
            connect.close();

        } catch (SQLException ex) {
            try {
                if (connect != null) connect.rollback(); // Rollback on failure
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(treatmentFrame, "Rollback error: " + rollbackEx.getMessage());
            }
            JOptionPane.showMessageDialog(treatmentFrame, "Database error: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(treatmentFrame, "Invalid number format in ID fields");
        }
    }
});


        treatmentFrame.setVisible(true);
    }
}
