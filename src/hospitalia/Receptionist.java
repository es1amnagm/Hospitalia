package hospitalia;

import static hospitalia.Create.Button;
import static hospitalia.Create.Frame;
import static hospitalia.Create.Label;
import static hospitalia.Create.*;
import static hospitalia.GUI.screenSize;
import java.awt.Color; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.sql.*;

public class Receptionist {

    public Receptionist() {

        JFrame receptionistFrame = Frame("Receptionist", null);

        JPanel receptionistPanel = Panel(null, new Color(17, 92, 115));

        receptionistPanel.setBounds(0, 0, 350, screenSize.height);
        JPanel receptionistPanel2 = Panel(null, Color.white);
        receptionistPanel2.setBounds(350, 0, screenSize.width, screenSize.height);

        receptionistFrame.add(receptionistPanel);
        receptionistFrame.add(receptionistPanel2);
  
//Exit        
         JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds((screenSize.width/2)-30, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         receptionistFrame.dispose();
        });
 receptionistFrame.add(exitButton);
        
        
        
        // buttons in the first panel (receptionistPanel)
        JButton makeInvoice = Button("Make Invoice", 50, 20, 200, 40, 18,Color.black);

        JButton addDonation = Button("Add Donation", 50, 120, 200, 40, 18,Color.black);

        JButton driversOrders = Button("Drivers Orders", 50, 220, 200, 40, 18, Color.black);

        JButton paramedicOrder = Button("Paramedics Order", 50, 320, 200, 40, 18, Color.black);

     JButton showPatientDetails = Button("Show Patient Details", 50, 720, 210, 40, 18, Color.black);
receptionistPanel.add(showPatientDetails);

        receptionistPanel.add(makeInvoice);
        receptionistPanel.add(addDonation);
        receptionistPanel.add(driversOrders);
        receptionistPanel.add(paramedicOrder);

        makeInvoice.addActionListener((e) -> {
              receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
            JButton add = Button("Add", 550, 650, 180, 80, 40, Color.black);
             receptionistPanel2.add(add);
            receptionistPanel2.setVisible(true);

            JLabel invoiceId = Label("Invoice ID", 150, 20, 200, 30, 30);
            JTextField invoiceIdField = TextField(320, 25, 300, 30);

            JLabel price = Label("Price", 150, 100, 200, 30, 30);
            JTextField priceField = TextField(320, 105, 300, 30);

            JLabel paid = Label("Paid", 150, 180, 200, 30, 30);
            JTextField paidField = TextField(320, 185, 300, 30);

            JLabel date = Label("Date", 150, 260, 200, 30, 30);
            JTextField dateField = TextField(320, 265, 300, 30);

            JLabel patientId = Label("Patient ID", 150, 340, 200, 30, 30);
            JTextField patientIdField = TextField(320, 345, 300, 30);

            JLabel receptionistId = Label("Receptionist ID", 70, 420, 250, 30, 30);
            JTextField receptionistIdField = TextField(320, 425, 300, 30);

            receptionistPanel2.add(invoiceId);
            receptionistPanel2.add(invoiceIdField);
            receptionistPanel2.add(price);
            receptionistPanel2.add(priceField);
            receptionistPanel2.add(paid);
            receptionistPanel2.add(paidField);
            receptionistPanel2.add(date);
            receptionistPanel2.add(dateField);
            receptionistPanel2.add(patientId);
            receptionistPanel2.add(patientIdField);
            receptionistPanel2.add(receptionistId);
            receptionistPanel2.add(receptionistIdField);

            add.addActionListener((a) -> {
                String getInvoiceId = invoiceIdField.getText();
                String getPrice = priceField.getText();
                String getPaid = paidField.getText();
                String getDate = dateField.getText();
                String getPatientId = patientIdField.getText();
                String getReceptionistId = receptionistIdField.getText();

                java.sql.Connection connect = DatabaseConnection.connect();

                try (connect) {
                    String insertInvoiceQuery = "INSERT INTO Invoice (invoice_id, price, paid, date, patient_id, receptionist_id) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement invoiceStatement = connect.prepareStatement(insertInvoiceQuery);

                    invoiceStatement.setInt(1, Integer.parseInt(getInvoiceId));
                    invoiceStatement.setFloat(2, Float.parseFloat(getPrice));
                    invoiceStatement.setFloat(3, Float.parseFloat(getPaid));
                    invoiceStatement.setDate(4, java.sql.Date.valueOf(getDate));
                    invoiceStatement.setInt(5, Integer.parseInt(getPatientId));
                    invoiceStatement.setInt(6, Integer.parseInt(getReceptionistId));

                    int invoiceRows = invoiceStatement.executeUpdate();
                    if (invoiceRows > 0) {
                        JOptionPane.showMessageDialog(null, "Invoice added successfully!");
                        receptionistPanel2.setVisible(false);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error adding invoice: " + ex.getMessage());
                }
            });
        });

        // add donation
        addDonation.addActionListener((e) -> {
              receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
            JButton add = Button("Add", 550, 650, 180, 80, 40, Color.black);
             receptionistPanel2.add(add);
            receptionistPanel2.setVisible(true);

            JLabel donationId = Label("Donation ID", 120, 20, 200, 30, 30);
            JTextField donationIdField = TextField(320, 25, 300, 30);

            JLabel nameOfDonar = Label("Name of Donor", 70, 100, 300, 30, 30);
            JTextField nameOfDonarField = TextField(320, 105, 300, 30);

            JLabel addressOfDonar = Label("Address of Donor", 60, 180, 300, 30, 30);
            JTextField addressOfDonarField = TextField(320, 185, 300, 30);

            JLabel amount = Label("Amount", 180, 260, 200, 30, 30);
            JTextField amountField = TextField(320, 265, 300, 30);

            JLabel date = Label("Date", 180, 340, 200, 30, 30);
            JTextField dateField = TextField(320, 345, 300, 30);

            JLabel receptionistId = Label("Receptionist ID", 70, 420, 230, 30, 30);
            JTextField receptionistIdField = TextField(320, 425, 300, 30);

            JLabel managerId = Label("Manager ID", 120, 500, 200, 30, 30);
            JTextField managerIdField = TextField(320, 505, 300, 30);

            receptionistPanel2.add(donationId);
            receptionistPanel2.add(donationIdField);
            receptionistPanel2.add(nameOfDonar);
            receptionistPanel2.add(nameOfDonarField);
            receptionistPanel2.add(addressOfDonar);
            receptionistPanel2.add(addressOfDonarField);
            receptionistPanel2.add(amount);
            receptionistPanel2.add(amountField);
            receptionistPanel2.add(date);
            receptionistPanel2.add(dateField);
            receptionistPanel2.add(receptionistId);
            receptionistPanel2.add(receptionistIdField);
            receptionistPanel2.add(managerId);
            receptionistPanel2.add(managerIdField);

            add.addActionListener((a) -> {
                String getDonationId = donationIdField.getText();
                String getNameOfDonar = nameOfDonarField.getText();
                String getAddressOfDonar = addressOfDonarField.getText();
                String getAmount = amountField.getText();
                String getDate = dateField.getText();
                String getReceptionistId = receptionistIdField.getText();
                String getManagerId = managerIdField.getText();

                java.sql.Connection connect = DatabaseConnection.connect();

                try (connect) {
                    String insertDonationQuery = "INSERT INTO Donations (donation_id, name_of_donar, address_of_donar, amount, date, receptionist_id, manager_id) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement donationStatement = connect.prepareStatement(insertDonationQuery);

                    donationStatement.setInt(1, Integer.parseInt(getDonationId));
                    donationStatement.setString(2, getNameOfDonar);
                    donationStatement.setString(3, getAddressOfDonar);
                    donationStatement.setFloat(4, Float.parseFloat(getAmount));
                    donationStatement.setDate(5, java.sql.Date.valueOf(getDate));
                    donationStatement.setInt(6, Integer.parseInt(getReceptionistId));
                    donationStatement.setInt(7, Integer.parseInt(getManagerId));

                    int donationRows = donationStatement.executeUpdate();
                    if (donationRows > 0) {
                        JOptionPane.showMessageDialog(null, "Donation added successfully!");
                        receptionistPanel2.setVisible(false);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error adding donation: " + ex.getMessage());
                }
            });
        });

        // order for driver 
        driversOrders.addActionListener((e) -> {
              receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
            JButton add = Button("Add", 550, 650, 180, 80, 30, Color.black);
             receptionistPanel2.add(add);
            receptionistPanel2.setVisible(true);

            JLabel receptionistId = Label("Receptionist ID", 60, 20, 220, 30, 30);
            JTextField receptionistIdField = TextField(320, 25, 300, 30);

            JLabel driverId = Label("Driver ID", 120, 100, 200, 30, 30);
            JTextField driverIdField = TextField(320, 105, 300, 30);

            JLabel date = Label("Date", 120, 180, 200, 30, 30);
            JTextField dateField = TextField(320, 185, 300, 30);

            JLabel address = Label("Address", 120, 260, 200, 30, 30);
            JTextField addressField = TextField(320, 265, 300, 30);

            receptionistPanel2.add(receptionistId);
            receptionistPanel2.add(receptionistIdField);
            receptionistPanel2.add(driverId);
            receptionistPanel2.add(driverIdField);
            receptionistPanel2.add(date);
            receptionistPanel2.add(dateField);
            receptionistPanel2.add(address);
            receptionistPanel2.add(addressField);

            add.addActionListener((a) -> {
                String getReceptionistId = receptionistIdField.getText();
                String getDriverId = driverIdField.getText();
                String getDate = dateField.getText();
                String getAddress = addressField.getText();

                java.sql.Connection connect = DatabaseConnection.connect();

                try (connect) {
                    String insertOrderDriverQuery = "INSERT INTO receptionist_order_driver (receptionist_id, driver_id, date, address) "
                            + "VALUES (?, ?, ?, ?)";
                    PreparedStatement orderDriverStatement = connect.prepareStatement(insertOrderDriverQuery);

                    orderDriverStatement.setInt(1, Integer.parseInt(getReceptionistId));
                    orderDriverStatement.setInt(2, Integer.parseInt(getDriverId));
                    orderDriverStatement.setDate(3, java.sql.Date.valueOf(getDate));
                    orderDriverStatement.setString(4, getAddress);

                    int orderDriverRows = orderDriverStatement.executeUpdate();
                    if (orderDriverRows > 0) {
                        JOptionPane.showMessageDialog(null, "Order added successfully!");
                        receptionistPanel2.setVisible(false);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error adding order: " + ex.getMessage());
                }
            });
        });

        // order for paramedic
        paramedicOrder.addActionListener((e) -> {
              receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
            JButton add = Button("Add", 550, 650, 180, 80, 40, Color.black);
             receptionistPanel2.add(add);
            receptionistPanel2.setVisible(true);

            JLabel receptionistId = Label("Receptionist ID", 60, 20, 220, 30, 30);
            JTextField receptionistIdField = TextField(320, 25, 300, 30);

            JLabel paramedicId = Label("Paramedic ID", 120, 100, 200, 30, 30);
            JTextField paramedicIdField = TextField(320, 105, 300, 30);

            JLabel date = Label("Date", 120, 180, 200, 30, 30);
            JTextField dateField = TextField(320, 185, 300, 30);

            JLabel address = Label("Address", 120, 260, 200, 30, 30);
            JTextField addressField = TextField(320, 265, 300, 30);

            receptionistPanel2.add(receptionistId);
            receptionistPanel2.add(receptionistIdField);
            receptionistPanel2.add(paramedicId);
            receptionistPanel2.add(paramedicIdField);
            receptionistPanel2.add(date);
            receptionistPanel2.add(dateField);
            receptionistPanel2.add(address);
            receptionistPanel2.add(addressField);

            add.addActionListener((a) -> {
                String getReceptionistId = receptionistIdField.getText();
                String getParamedicId = paramedicIdField.getText();
                String getDate = dateField.getText();
                String getAddress = addressField.getText();

                java.sql.Connection connect = DatabaseConnection.connect();

                try (connect) {
                    String insertOrderParamedicQuery = "INSERT INTO receptionist_order_paramedic (receptionist_id, paramedic_id, date, address) "
                            + "VALUES (?, ?, ?, ?)";
                    PreparedStatement orderParamedicStatement = connect.prepareStatement(insertOrderParamedicQuery);

                    orderParamedicStatement.setInt(1, Integer.parseInt(getReceptionistId));
                    orderParamedicStatement.setInt(2, Integer.parseInt(getParamedicId));
                    orderParamedicStatement.setDate(3, java.sql.Date.valueOf(getDate));
                    orderParamedicStatement.setString(4, getAddress);

                    int orderParamedicRows = orderParamedicStatement.executeUpdate();
                    if (orderParamedicRows > 0) {
                        JOptionPane.showMessageDialog(null, "Order added successfully!");
                        receptionistPanel2.setVisible(false);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error adding order: " + ex.getMessage());
                }
            });
        });
        
        
        

// add patient 



        JButton addPatient = Button("Add Patient", 50, 420, 200, 40, 18, Color.black); // New button

        receptionistPanel.add(addPatient); // Add the new button to the panel

  
  
 
 
 

 
addPatient.addActionListener((e) -> {
      receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
    // Create button to add patient
    JButton addPatientBtn = Button("Add", 750, 450, 180, 80, 40, Color.black);
     receptionistPanel2.add(addPatientBtn);
    receptionistPanel2.setVisible(true);

    // Create labels and fields for patient data
    JLabel patientId = Label("Patient ID", 120, 20, 200, 30, 30);
    JTextField patientIdField = TextField(320, 25, 300, 30);

    JLabel firstName = Label("First Name", 120, 100, 300, 30, 30);
    JTextField firstNameField = TextField(320, 105, 300, 30);

    JLabel lastName = Label("Last Name", 120, 180, 300, 30, 030);
    JTextField lastNameField = TextField(320, 185, 300, 30);

    JLabel gender = Label("Gender", 120, 260, 200, 30, 30);
    JCheckBox maleCheckBox = new JCheckBox("Male");
    maleCheckBox.setBounds(320, 265, 100, 30);
    JCheckBox femaleCheckBox = new JCheckBox("Female");
    femaleCheckBox.setBounds(420, 265, 100, 30);

    JLabel visitDate = Label("Visit Date", 120, 340, 200, 30, 30);
    JTextField visitDateField = TextField(320, 345, 300, 30);

    JLabel outDate = Label("Out Date", 120, 420, 200, 30, 30);
    JTextField outDateField = TextField(320, 425, 300, 30);

    JLabel diagnosis = Label("Diagnosis", 120, 500, 200, 30, 030);
      JTextField diagnosisArea = TextField(320, 505, 300, 30);


    JLabel address = Label("Address", 120, 590, 200, 30, 30);
    JTextField addressField = TextField(320, 595, 300, 30);

    JLabel doctorId = Label("Doctor ID", 120, 670, 200, 30, 30);
    JTextField doctorIdField = TextField(320, 675, 300, 30);

    JLabel nurseId = Label("Nurse ID", 120, 750, 200, 30, 030);
    JTextField nurseIdField = TextField(320, 755, 300, 30);

    // Add labels, fields, and checkboxes to the panel
    receptionistPanel2.add(patientId);
    receptionistPanel2.add(patientIdField);
    receptionistPanel2.add(firstName);
    receptionistPanel2.add(firstNameField);
    receptionistPanel2.add(lastName);
    receptionistPanel2.add(lastNameField);
    receptionistPanel2.add(gender);
    receptionistPanel2.add(maleCheckBox);
    receptionistPanel2.add(femaleCheckBox);
    receptionistPanel2.add(visitDate);
    receptionistPanel2.add(visitDateField);
    receptionistPanel2.add(outDate);
    receptionistPanel2.add(outDateField);
    receptionistPanel2.add(diagnosis);
    receptionistPanel2.add(diagnosisArea);
    receptionistPanel2.add(address);
    receptionistPanel2.add(addressField);
    receptionistPanel2.add(doctorId);
    receptionistPanel2.add(doctorIdField);
    receptionistPanel2.add(nurseId);
    receptionistPanel2.add(nurseIdField);

    // Action listener for the add patient button
    addPatientBtn.addActionListener((a) -> {
        String getPatientId = patientIdField.getText();
        String getFirstName = firstNameField.getText();
        String getLastName = lastNameField.getText();
        String genderValue = maleCheckBox.isSelected() ? "male" : femaleCheckBox.isSelected() ? "female" : "";
        String getVisitDate = visitDateField.getText();
        String getOutDate = outDateField.getText();
        String getDiagnosis = diagnosisArea.getText();
        String getAddress = addressField.getText();
        String getDoctorId = doctorIdField.getText();
        String getNurseId = nurseIdField.getText();

        java.sql.Connection connect = DatabaseConnection.connect();

        try (connect) {
            String insertPatientQuery = "INSERT INTO Patient (patient_id, first_name, last_name, genderp, visit_date, out_date, diagnosis, address, doctor_id, nurse_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement patientStatement = connect.prepareStatement(insertPatientQuery);

            patientStatement.setInt(1, Integer.parseInt(getPatientId));
            patientStatement.setString(2, getFirstName);
            patientStatement.setString(3, getLastName);
            patientStatement.setString(4, genderValue);
            patientStatement.setDate(5, java.sql.Date.valueOf(getVisitDate));
            patientStatement.setDate(6, java.sql.Date.valueOf(getOutDate));
            patientStatement.setString(7, getDiagnosis);
            patientStatement.setString(8, getAddress);
            patientStatement.setInt(9, Integer.parseInt(getDoctorId));
            patientStatement.setInt(10, Integer.parseInt(getNurseId));

            int patientRows = patientStatement.executeUpdate();
            if (patientRows > 0) {
                JOptionPane.showMessageDialog(null, "Patient added successfully!");
                receptionistPanel2.setVisible(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding patient: " + ex.getMessage());
        }
    });
});


 //add the patient to room
 JButton addPatientToRoom = Button("Add Patient to Room", 50, 520, 200, 40, 17, Color.black); // New button

        receptionistPanel.add(addPatientToRoom); 
addPatientToRoom.addActionListener((e) -> {
      receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
    // Create button to add patient to room
    JButton addPatientToRoomBtn = Button("Add", 550, 650, 180, 80, 40, Color.black);
     receptionistPanel2.add(addPatientToRoomBtn);
    receptionistPanel2.setVisible(true);

    // Create labels and fields for patient to room data
    JLabel patientIdLabel = Label("Patient ID", 120, 20, 200, 30, 30);
    JTextField patientIdField = TextField(320, 25, 300, 30);

    JLabel roomIdLabel = Label("Room ID", 120, 100, 200, 30, 30);
    JTextField roomIdField = TextField(320, 105, 300, 30);

    // Add labels and fields to the panel
    receptionistPanel2.add(patientIdLabel);
    receptionistPanel2.add(patientIdField);
    receptionistPanel2.add(roomIdLabel);
    receptionistPanel2.add(roomIdField);

    // Action listener for the add patient to room button
    addPatientToRoomBtn.addActionListener((a) -> {
        String getPatientId = patientIdField.getText();
        String getRoomId = roomIdField.getText();

        java.sql.Connection connect = DatabaseConnection.connect();

        try (connect) {
            // Check if the patient ID exists in the Patient table
            String checkPatientQuery = "SELECT COUNT(*) FROM Patient WHERE patient_id = ?";
            PreparedStatement checkPatientStatement = connect.prepareStatement(checkPatientQuery);
            checkPatientStatement.setInt(1, Integer.parseInt(getPatientId));
            ResultSet resultSet = checkPatientStatement.executeQuery();
            
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                // Patient exists, proceed with inserting into patient_stay_in_room table
                String insertPatientRoomQuery = "INSERT INTO patient_stay_in_room (patient_id, room_id) "
                        + "VALUES (?, ?)";
                PreparedStatement patientRoomStatement = connect.prepareStatement(insertPatientRoomQuery);

                patientRoomStatement.setInt(1, Integer.parseInt(getPatientId));
                patientRoomStatement.setInt(2, Integer.parseInt(getRoomId));

                int patientRoomRows = patientRoomStatement.executeUpdate();
                if (patientRoomRows > 0) {
                    JOptionPane.showMessageDialog(null, "Patient added to room successfully!");
                    receptionistPanel2.setVisible(false);
                }
            } else {
                // Patient ID does not exist, show error message
                JOptionPane.showMessageDialog(null, "Patient ID does not exist. Please enter a valid Patient ID.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding patient to room: " + ex.getMessage());
        }
    });
});


JButton addPatientToClinic = Button("Add Patient to Clinic", 50, 620, 210, 40, 17,Color.black); // New button

        receptionistPanel.add(addPatientToClinic); 


addPatientToClinic.addActionListener((e) -> {
      receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
    // Create button to add patient to clinic
    JButton addPatientToClinicBtn = Button("Add", 550, 650, 180, 80, 40, Color.black);
     receptionistPanel2.add(addPatientToClinicBtn);
    receptionistPanel2.setVisible(true);

    // Create labels and fields for patient to clinic data
    JLabel patientIdLabel = Label("Patient ID", 120, 20, 200, 30, 30);
    JTextField patientIdField = TextField(320, 25, 300, 30);

    JLabel clinicIdLabel = Label("Clinic ID", 120, 100, 200, 30, 30);
    JTextField clinicIdField = TextField(320, 105, 300, 30);

    JLabel floorLabel = Label("Floor", 120, 180, 200, 30, 30);
    JTextField floorField = TextField(320, 185, 300, 30);

    JLabel nurseIdLabel = Label("Nurse ID", 120, 260, 200, 30, 30);
    JTextField nurseIdField = TextField(320, 265, 300, 30);

    JLabel doctorIdLabel = Label("Doctor ID", 120, 340, 200, 30, 30);
    JTextField doctorIdField = TextField(320, 345, 300, 30);

    // Add labels and fields to the panel
    receptionistPanel2.add(patientIdLabel);
    receptionistPanel2.add(patientIdField);
    receptionistPanel2.add(clinicIdLabel);
    receptionistPanel2.add(clinicIdField);
    receptionistPanel2.add(floorLabel);
    receptionistPanel2.add(floorField);
    receptionistPanel2.add(nurseIdLabel);
    receptionistPanel2.add(nurseIdField);
    receptionistPanel2.add(doctorIdLabel);
    receptionistPanel2.add(doctorIdField);

    // Action listener for the add patient to clinic button
    addPatientToClinicBtn.addActionListener((a) -> {
        String getPatientId = patientIdField.getText();
        String getClinicId = clinicIdField.getText();
        String getFloor = floorField.getText();
        String getNurseId = nurseIdField.getText();
        String getDoctorId = doctorIdField.getText();

        java.sql.Connection connect = DatabaseConnection.connect();

        try (connect) {
            // Check if the patient ID exists in the Patient table
            String checkPatientQuery = "SELECT COUNT(*) FROM Patient WHERE patient_id = ?";
            PreparedStatement checkPatientStatement = connect.prepareStatement(checkPatientQuery);
            checkPatientStatement.setInt(1, Integer.parseInt(getPatientId));
            ResultSet resultSet = checkPatientStatement.executeQuery();

            if (resultSet.next() && resultSet.getInt(1) > 0) {
                // Patient exists, proceed with inserting into clinic table
                String insertPatientClinicQuery = "INSERT INTO Clinic (clinic_id, floor, nurse_id, doctor_id, patient_id) "
                        + "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement patientClinicStatement = connect.prepareStatement(insertPatientClinicQuery);

                patientClinicStatement.setInt(1, Integer.parseInt(getClinicId));
                patientClinicStatement.setInt(2, Integer.parseInt(getFloor));
                patientClinicStatement.setInt(3, Integer.parseInt(getNurseId));
                patientClinicStatement.setInt(4, Integer.parseInt(getDoctorId));
                patientClinicStatement.setInt(5, Integer.parseInt(getPatientId));

                int patientClinicRows = patientClinicStatement.executeUpdate();
                if (patientClinicRows > 0) {
                    JOptionPane.showMessageDialog(null, "Patient added to clinic successfully!");
                    receptionistPanel2.setVisible(false);
                }
            } else {
                // Patient ID does not exist, show error message
                JOptionPane.showMessageDialog(null, "Patient ID does not exist. Please enter a valid Patient ID.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding patient to clinic: " + ex.getMessage());
        }
    });
});
 

showPatientDetails.addActionListener((e) -> {
      receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
    String patientIdStr = JOptionPane.showInputDialog("Enter Patient ID:");
    if (patientIdStr != null && !patientIdStr.isEmpty()) {
        int patientId = Integer.parseInt(patientIdStr);
        fetchAndDisplayPatientDetails(patientId, receptionistPanel2);
    }
});


receptionistPanel2.revalidate();
receptionistPanel2.repaint();





    }
private void fetchAndDisplayPatientDetails(int patientId, JPanel receptionistPanel2) {
    receptionistPanel2.removeAll(); // Clear the panel before adding new components

    java.sql.Connection connect = DatabaseConnection.connect();

    try (connect) {
        // Fetch patient details
        String patientQuery = "SELECT * FROM Patient WHERE patient_id = ?";
        PreparedStatement patientStatement = connect.prepareStatement(patientQuery);
        patientStatement.setInt(1, patientId);
        ResultSet patientResult = patientStatement.executeQuery();

        if (patientResult.next()) {
            // Display patient details
            JLabel patientIdLabel = Label("Patient ID: " + patientResult.getInt("patient_id"), 50, 20, 300, 30, 20);
            JLabel firstNameLabel = Label("First Name: " + patientResult.getString("first_name"), 50, 60, 300, 30, 20);
            JLabel lastNameLabel = Label("Last Name: " + patientResult.getString("last_name"), 50, 100, 300, 30, 20);
            JLabel genderLabel = Label("Gender: " + patientResult.getString("genderp"), 50, 140, 300, 30, 20);
            JLabel visitDateLabel = Label("Visit Date: " + patientResult.getDate("visit_date"), 50, 180, 300, 30, 20);
            JLabel outDateLabel = Label("Out Date: " + patientResult.getDate("out_date"), 50, 220, 300, 30, 20);
            JLabel diagnosisLabel = Label("Diagnosis: " + patientResult.getString("diagnosis"), 50, 260, 300, 30, 20);
            JLabel addressLabel = Label("Address: " + patientResult.getString("address"), 50, 300, 300, 30, 20);
            JLabel doctorIdLabel = Label("Doctor ID: " + patientResult.getInt("doctor_id"), 50, 340, 300, 30, 20);
            JLabel nurseIdLabel = Label("Nurse ID: " + patientResult.getInt("nurse_id"), 50, 380, 300, 30, 20);

            receptionistPanel2.add(patientIdLabel);
            receptionistPanel2.add(firstNameLabel);
            receptionistPanel2.add(lastNameLabel);
            receptionistPanel2.add(genderLabel);
            receptionistPanel2.add(visitDateLabel);
            receptionistPanel2.add(outDateLabel);
            receptionistPanel2.add(diagnosisLabel);
            receptionistPanel2.add(addressLabel);
            receptionistPanel2.add(doctorIdLabel);
            receptionistPanel2.add(nurseIdLabel);

            // Fetch room details if available
            String roomQuery = "SELECT room_id FROM patient_stay_in_room WHERE patient_id = ?";
            PreparedStatement roomStatement = connect.prepareStatement(roomQuery);
            roomStatement.setInt(1, patientId);
            ResultSet roomResult = roomStatement.executeQuery();

            if (roomResult.next()) {
                JLabel roomIdLabel = Label("Room ID: " + roomResult.getInt("room_id"), 50, 420, 300, 30, 20);
                receptionistPanel2.add(roomIdLabel);
            } else {
                JLabel noRoomLabel = Label("Patient is not assigned to a room.", 50, 420, 300, 30, 20);
                receptionistPanel2.add(noRoomLabel);
            }

            // Fetch invoice details if available
            String invoiceQuery = "SELECT invoice_id, price, paid, date FROM Invoice WHERE patient_id = ?";
            PreparedStatement invoiceStatement = connect.prepareStatement(invoiceQuery);
            invoiceStatement.setInt(1, patientId);
            ResultSet invoiceResult = invoiceStatement.executeQuery();

            if (invoiceResult.next()) {
                JLabel invoiceIdLabel = Label("Invoice ID: " + invoiceResult.getInt("invoice_id"), 50, 460, 300, 30, 20);
                JLabel priceLabel = Label("Price: " + invoiceResult.getFloat("price"), 50, 500, 300, 30, 20);
                JLabel paidLabel = Label("Paid: " + invoiceResult.getFloat("paid"), 50, 540, 300, 30, 20);
                JLabel dateLabel = Label("Date: " + invoiceResult.getDate("date"), 50, 580, 300, 30, 20);

                receptionistPanel2.add(invoiceIdLabel);
                receptionistPanel2.add(priceLabel);
                receptionistPanel2.add(paidLabel);
                receptionistPanel2.add(dateLabel);
            } else {
                JLabel noInvoiceLabel = Label("No invoice found for this patient.", 50, 460, 300, 30, 20);
                receptionistPanel2.add(noInvoiceLabel);
            }

            // Fetch phone numbers from patient_phone table
            String phoneQuery = "SELECT phone FROM patient_phone WHERE patient_id = ?";
            PreparedStatement phoneStatement = connect.prepareStatement(phoneQuery);
            phoneStatement.setInt(1, patientId);
            ResultSet phoneResult = phoneStatement.executeQuery();

            int yOffset = 620; // Starting Y position for phone numbers
            boolean hasPhones = false;

            while (phoneResult.next()) {
                hasPhones = true;
                JLabel phoneLabel = Label("Phone: " + phoneResult.getString("phone"), 50, yOffset, 300, 30, 20);
                receptionistPanel2.add(phoneLabel);
                yOffset += 40; // Move down for the next phone number
            }

            if (!hasPhones) {
                JLabel noPhoneLabel = Label("No phone numbers found for this patient.", 50, yOffset, 300, 30, 20);
                receptionistPanel2.add(noPhoneLabel);
            }

            receptionistPanel2.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Patient ID not found.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error fetching patient details: " + ex.getMessage());
    }

    // Refresh the panel to display new components
    receptionistPanel2.revalidate();
    receptionistPanel2.repaint();
}

}
