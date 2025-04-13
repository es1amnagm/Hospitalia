/*
 * Click nbfs://,nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalia;

//
// JOptionPane.showMessageDialog(panel, "Please select your position before log in", 
//                                              "Selection Required", JOptionPane.WARNING_MESSAGE);


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

import javax.swing.JOptionPane;

/**
 *
 * @author eslam
 */
public class GUI {

    String choise=null;
     static   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public GUI() {
//        // Log in
        JFrame loginFrame = Frame("Welcome", new GridLayout(1, 1), 500, 400);
        JPanel loginPanel = Create.Panel(null, Color.white);
//id
        JLabel id = Label("ID", 90, 30, 70, 30);
        JTextField idField = TextField(150, 30, 300, 30);
//password
        JLabel password = Label("Password", 60, 80, 100, 30);
        JPasswordField passwordField = Password(150, 80, 300, 30);

        // Position selection
        JLabel positionLabel = Label("Position", 60, 130, 100, 30);
        String[] positions = {"Manager", "Doctor", "Driver", "Nurse", "Paramedic", "Pharmacist", "Receptionist"};
        JComboBox<String> positionCombo = new JComboBox<>(positions);
        positionCombo.setBounds(150, 130, 300, 30);

        JButton login = Button("Log in", 190, 290, 100, 30);

        loginFrame.add(loginPanel);

        loginPanel.add(id);
        loginPanel.add(idField);
        loginPanel.add(password);
        loginPanel.add(passwordField);
        loginPanel.add(positionLabel);
        loginPanel.add(positionCombo);
        loginPanel.add(login);

               // choise = CreateList(loginPanel, 180, 130, 150, 30, login);

                  
                  

                               
                                      
                                        



                   

// check if the employee enter the correct data or no
        login.addActionListener((e) -> {
            // Validate that all fields are filled
            if (idField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(loginPanel, "Please enter your ID", 
                    "ID Required", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(loginPanel, "Please enter your password", 
                    "Password Required", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (positionCombo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(loginPanel, "Please select your position", 
                    "Position Required", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Get the selected position and ID
            String selectedPosition = (String) positionCombo.getSelectedItem();
            String enteredId = idField.getText().trim();
                        java.sql.Connection connect = null;

              try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                // Prepare the query based on position
                String tableName = selectedPosition.toLowerCase();
                String idColumn = tableName + "_id";
                
                // First check if ID exists
                String idQuery = "SELECT * FROM " + tableName + " WHERE " + idColumn + " = ?";
                PreparedStatement idStmt = connect.prepareStatement(idQuery);
                idStmt.setString(1, enteredId);
                ResultSet idRs = idStmt.executeQuery();
                
                if (!idRs.next()) {
                    // ID not found
                    JOptionPane.showMessageDialog(loginPanel, 
                        "No " + selectedPosition + " found with ID: " + enteredId,
                        "Invalid ID", JOptionPane.WARNING_MESSAGE);
                    idRs.close();
                    idStmt.close();
                    connect.close();
                    return;
                }
                
                // ID exists, now check password
                String passwordQuery = "SELECT * FROM " + tableName + " WHERE " + idColumn + " = ? AND password = ?";
                PreparedStatement pwdStmt = connect.prepareStatement(passwordQuery);
                pwdStmt.setString(1, enteredId);
                pwdStmt.setString(2, new String(passwordField.getPassword()));
                ResultSet pwdRs = pwdStmt.executeQuery();
                
                if (pwdRs.next()) {
                    // ID and password match in the database
                    loginFrame.setVisible(false);
                    switch(selectedPosition) {
                        case "Manager":
                            Manager manager = new Manager();
                            break;
                        case "Doctor":
                            Doctor  doctor = new Doctor ();
                            break;
                        case "Nurse":
                            Nurse  nurse = new Nurse ();
                            break;
                        case "Driver":
                            Driver  driver = new Driver ();
                            break;
                        case "Paramedic":
                            Paramedic  paramedic = new Paramedic ();
                            break;
                        case "Pharmacist":
                            Pharmacitucal  pharmacist = new Pharmacitucal ();
                            break;
                        case "Receptionist":
                            Receptionist  receptionist = new Receptionist ();
                            break;
                        default:
                            JOptionPane.showMessageDialog(loginPanel, 
                                "Unknown position: " + selectedPosition,
                                "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                } else {
                    // ID exists but password is incorrect
                    JOptionPane.showMessageDialog(loginPanel, 
                        "Incorrect password for " + selectedPosition + " with ID: " + enteredId,
                        "Invalid Password", JOptionPane.WARNING_MESSAGE);
                }
                
                // Close database resources
                idRs.close();
                idStmt.close();
                pwdRs.close();
                pwdStmt.close();
                connect.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(loginPanel, 
                    "Database error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

                //for constructor
            }
            // fro class
}
