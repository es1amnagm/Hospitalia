/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalia;

import static hospitalia.Create.*;
import static hospitalia.GUI.screenSize;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Doctor_manager {

    public Doctor_manager() throws SQLException, IOException {
        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> holidays = new ArrayList<>();

        JFrame doctorFrame = Frame("Doctor", null);
        JPanel doctorPanel = Panel(null, new Color(17, 92, 115));

        doctorPanel.setBounds(0, 0, 350, screenSize.height);

        JPanel doctorPanel2 = Panel(null, Color.white);

        doctorPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

        doctorFrame.add(doctorPanel);
        doctorFrame.add(doctorPanel2);
        
          JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 730, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         doctorFrame.dispose();
        });

        // Add button to the panel and the panel to the frame
        doctorPanel.add(exitButton);
        doctorFrame.add(doctorPanel);

        JButton addDoctor = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));

        JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));

        JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));


        doctorPanel.add(addDoctor);
        doctorPanel.add(selectAll);
        doctorPanel.add(selectOne);

        //add
        addDoctor.addActionListener((e) -> {
                  doctorPanel2.removeAll();
    doctorPanel2.repaint();
            JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
            add.setBackground(Color.white);
            doctorPanel2.add(add);
            doctorPanel2.setVisible(true);

            JButton addPhones = Button("Add-Phones", 870, 630, 300, 40, 50, new Color(110, 181, 178));
            addPhones.setBackground(Color.white);
            doctorPanel2.add(addPhones);

            JButton addHolidays = Button("Add-Holidays", 30, 630, 350, 40, 50, new Color(110, 181, 178));
            addHolidays.setBackground(Color.white);
            doctorPanel2.add(addHolidays);

            JLabel id = Label("ID", 150, 20, 100, 30, 35);
            JTextField idField = TextField(320, 25, 300, 30);

            JLabel firstName = Label("First Name", 120, 100, 200, 30, 35);
            JTextField firstNameField = TextField(320, 105, 300, 30);

            JLabel lastName = Label("Last Name", 120, 180, 200, 30, 35);
            JTextField lastNameField = TextField(320, 185, 300, 30);

            JLabel address = Label("Address", 120, 260, 200, 30, 35);
            JTextField addressField = TextField(320, 265, 300, 30);

            JLabel extraHours = Label("Extra Hours", 120, 340, 200, 30, 35);
            JTextField extraHoursField = TextField(320, 345, 300, 30);

            JLabel startDate = Label("Start Date", 120, 420, 210, 30, 35);
            JTextField startDateField = TextField(320, 425, 300, 30);

            JLabel yearsOfExperience = Label("Years of Experience", 20, 500, 300, 30, 35);
            JTextField yearsOfExperienceField = TextField(320, 505, 300, 30);

            JLabel shift = Label("Shift", 970, 20, 200, 30, 35);
            JTextField shiftField = TextField(650, 25, 300, 30);

            JLabel salary = Label("Salary", 970, 100, 200, 30, 35);
            JTextField salaryField = TextField(650, 105, 300, 30);

            JLabel gender = Label("Gender", 970, 180, 200, 30, 35);
            JTextField genderField = TextField(650, 185, 300, 30);

            JLabel specialtyName = Label("Specialty Name", 960, 260, 230, 30, 35);
            JTextField specialtyNameField = TextField(650, 265, 300, 30);

            JLabel nurseId = Label("Nurse ID", 970, 340, 200, 30, 35);
            JTextField nurseIdField = TextField(650, 345, 300, 30);

            JLabel managerId = Label("Manager ID", 970, 420, 200, 30, 35);
            JTextField managerIdField = TextField(650, 425, 300, 30);

            JLabel phone = Label("Phone", 970, 500, 200, 30, 35);
            JTextField phoneField = TextField(650, 505, 300, 30);

            JLabel holiday = Label("Holiday", 300, 580, 200, 30, 35);
            JTextField holidayField = TextField(500, 585, 300, 30);

            // Add all components to frame
            doctorPanel2.add(id);
            doctorPanel2.add(idField);
            doctorPanel2.add(firstName);
            doctorPanel2.add(firstNameField);
            doctorPanel2.add(lastName);
            doctorPanel2.add(lastNameField);
            doctorPanel2.add(address);
            doctorPanel2.add(addressField);
            doctorPanel2.add(salary);
            doctorPanel2.add(salaryField);
            doctorPanel2.add(startDate);
            doctorPanel2.add(startDateField);
            doctorPanel2.add(yearsOfExperience);
            doctorPanel2.add(yearsOfExperienceField);
            doctorPanel2.add(shift);
            doctorPanel2.add(shiftField);
            doctorPanel2.add(extraHours);
            doctorPanel2.add(extraHoursField);
            doctorPanel2.add(gender);
            doctorPanel2.add(genderField);
            doctorPanel2.add(specialtyName);
            doctorPanel2.add(specialtyNameField);
            doctorPanel2.add(nurseId);
            doctorPanel2.add(nurseIdField);
            doctorPanel2.add(managerId);
            doctorPanel2.add(managerIdField);
            doctorPanel2.add(phone);
            doctorPanel2.add(phoneField);

            doctorPanel2.add(holiday);
            doctorPanel2.add(holidayField);

            //////////////////////
            //add phones
            addPhones.addActionListener((b) -> {

                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the id first");

                } else {
                    doctorPanel2.setVisible(false);
                    JPanel addPhonesPanel = Panel(null, Color.white);

                    doctorFrame.add(addPhonesPanel);
                    addPhonesPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);

                    JButton ok = Button("OK", 550, 450, 180, 80, 70, new Color(110, 181, 178));
                    add.setBackground(Color.white);
                    addPhonesPanel.add(ok);

                    JLabel phone1 = Label("Phone1", 120, 20, 200, 30, 35);
                    JTextField phone1Field = TextField(320, 25, 300, 30);

                    JLabel phone2 = Label("Phone2", 120, 100, 200, 30, 35);
                    JTextField phone2Field = TextField(320, 105, 300, 30);

                    JLabel phone3 = Label("Phone3", 120, 180, 200, 30, 35);
                    JTextField phone3Field = TextField(320, 185, 300, 30);

                    addPhonesPanel.add(phone1);
                    addPhonesPanel.add(phone1Field);

                    addPhonesPanel.add(phone2);
                    addPhonesPanel.add(phone2Field);

                    addPhonesPanel.add(phone3);
                    addPhonesPanel.add(phone3Field);

                    ok.addActionListener((c) -> {

                        if (!(phone1Field.getText().isEmpty())) {
                            phones.add(phone1Field.getText());
                        }
                        if (!(phone2Field.getText().isEmpty())) {
                            phones.add(phone2Field.getText());
                        }
                        if (!(phone3Field.getText().isEmpty())) {
                            phones.add(phone3Field.getText());
                        }
                    });

// else bracket
                }

            });

            ////////////////////
            ///add holidays
            addHolidays.addActionListener((b) -> {
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the id first");
                } else {
                    doctorPanel2.setVisible(false);
                    JPanel addHolidaysPanel = Panel(null, Color.white);

                    doctorFrame.add(addHolidaysPanel);
                    addHolidaysPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);

                    JButton ok = Button("OK", 550, 450, 180, 80, 70, new Color(110, 181, 178));
                    add.setBackground(Color.white);
                    addHolidaysPanel.add(ok);

                    JLabel holiday1 = Label("Holiday1", 120, 20, 200, 30, 35);
                    JTextField holiday1Field = TextField(320, 25, 300, 30);

                    JLabel holiday2 = Label("Holiday2", 120, 100, 200, 30, 35);
                    JTextField holiday2Field = TextField(320, 105, 300, 30);

                    JLabel holiday3 = Label("Holiday3", 120, 180, 200, 30, 35);
                    JTextField holiday3Field = TextField(320, 185, 300, 30);

                    addHolidaysPanel.add(holiday1);
                    addHolidaysPanel.add(holiday1Field);

                    addHolidaysPanel.add(holiday2);
                    addHolidaysPanel.add(holiday2Field);

                    addHolidaysPanel.add(holiday3);
                    addHolidaysPanel.add(holiday3Field);

                    ok.addActionListener((c) -> {
                        if (!(holiday1Field.getText().isEmpty())) {
                            holidays.add(holiday1Field.getText());
                        }
                        if (!(holiday2Field.getText().isEmpty())) {
                            holidays.add(holiday2Field.getText());
                        }
                        if (!(holiday3Field.getText().isEmpty())) {
                            holidays.add(holiday3Field.getText());
                        }

                        addHolidaysPanel.setVisible(false);
                        doctorPanel2.setVisible(true);
                    });

                    // esle bracket     
                }
            });

            add.addActionListener((a) -> {
                String getId = idField.getText();
                String getFirstName = firstNameField.getText();
                String getLastName = lastNameField.getText();
                String getAddress = addressField.getText();
                String getSalary = salaryField.getText();
                String getStartDate = startDateField.getText();
                String getYearsOfExperience = yearsOfExperienceField.getText();
                String getShift = shiftField.getText();
                String getExtraHours = extraHoursField.getText();
                String getGender = genderField.getText();
                String getSpecialtyName = specialtyNameField.getText();
                String getNurseId = nurseIdField.getText();
                String getManagerId = managerIdField.getText();
                String getPhone = phoneField.getText(); // Single phone
                String getHoliday = holidayField.getText(); // Single holiday

                java.sql.Connection connect = DatabaseConnection.connect();

                if (!getPhone.matches("\\d*")) {
                    JOptionPane.showMessageDialog(null, "Please enter a numeric value for the phone number!");
                    return;
                }

                // Validate all phone numbers in the list (if needed)
                for (String phonee : phones) {
                    if (!phonee.matches("\\d*")) {
                        JOptionPane.showMessageDialog(null, "All phone numbers must be numeric!");
                        return;
                    }
                }

                try (connect) {
                    // Insert into Doctor table
                    String insertDoctorQuery = "INSERT INTO Doctor (doctor_id, first_name, last_name, address, salary, start_date, "
                            + "years_of_experience, shift, extra_hours, genderd, speciality_name, nurse_id, manager_id) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement doctorStatement = connect.prepareStatement(insertDoctorQuery);

                    doctorStatement.setInt(1, Integer.parseInt(getId));
                    doctorStatement.setString(2, getFirstName);
                    doctorStatement.setString(3, getLastName);
                    doctorStatement.setString(4, getAddress);
                    doctorStatement.setDouble(5, Double.parseDouble(getSalary));
                    doctorStatement.setDate(6, java.sql.Date.valueOf(getStartDate)); // Ensure date is in 'YYYY-MM-DD' format
                    doctorStatement.setInt(7, Integer.parseInt(getYearsOfExperience));
                    doctorStatement.setString(8, getShift);
                    doctorStatement.setFloat(9, Float.parseFloat(getExtraHours));
                    doctorStatement.setString(10, getGender);
                    doctorStatement.setString(11, getSpecialtyName);
                    doctorStatement.setInt(12, Integer.parseInt(getNurseId));
                    doctorStatement.setInt(13, Integer.parseInt(getManagerId));

                    int doctorRows = doctorStatement.executeUpdate();
                    if (doctorRows > 0) {
                        JOptionPane.showMessageDialog(null, "Doctor added successfully!");
                        doctorPanel2.setVisible(false);
                    }

                    // Insert single phone into doctor_phone table
                    if (!getPhone.isEmpty()) {
                        String insertPhoneQuery = "INSERT INTO doctor_phone (doctor_id, phone) VALUES (?, ?)";
                        PreparedStatement phoneStatement = connect.prepareStatement(insertPhoneQuery);

                        phoneStatement.setInt(1, Integer.parseInt(getId));
                        phoneStatement.setString(2, getPhone);

                        int phoneRows = phoneStatement.executeUpdate();

                    }

                    // Insert single holiday into doctor_holiday table
                    if (!getHoliday.isEmpty()) {
                        String insertHolidayQuery = "INSERT INTO doctor_holiday (doctor_id, holiday) VALUES (?, ?)";
                        PreparedStatement holidayStatement = connect.prepareStatement(insertHolidayQuery);

                        holidayStatement.setInt(1, Integer.parseInt(getId));
                        holidayStatement.setDate(2, java.sql.Date.valueOf(getHoliday)); // Ensure date is in 'YYYY-MM-DD' format

                        int holidayRows = holidayStatement.executeUpdate();

                    }

                    // Insert multiple phones into doctor_phone table
                    if (!phones.isEmpty()) {
                        String insertPhoneQuery2 = "INSERT INTO doctor_phone (doctor_id, phone) VALUES (?, ?)";
                        PreparedStatement phoneStatement2 = connect.prepareStatement(insertPhoneQuery2);

                        for (String phonee : phones) {
                            phoneStatement2.setInt(1, Integer.parseInt(getId));
                            phoneStatement2.setString(2, phonee);
                            phoneStatement2.addBatch(); // Add to batch
                        }
                        phoneStatement2.executeBatch();
                        JOptionPane.showMessageDialog(null, "Multiple phone numbers added successfully!");
                    }

                    // Insert multiple holidays into doctor_holiday table
                    if (!holidays.isEmpty()) {
                        String insertHolidayQuery2 = "INSERT INTO doctor_holiday (doctor_id, holiday) VALUES (?, ?)";
                        PreparedStatement holidayStatement2 = connect.prepareStatement(insertHolidayQuery2);

                        for (String holidayy : holidays) {
                            holidayStatement2.setInt(1, Integer.parseInt(getId));
                            holidayStatement2.setDate(2, java.sql.Date.valueOf(holidayy)); // Ensure date is in 'YYYY-MM-DD' format
                            holidayStatement2.addBatch(); // Add to batch
                        }
                        holidayStatement2.executeBatch();
                        JOptionPane.showMessageDialog(null, "Multiple holidays added successfully!");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error inserting data into the database: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for numeric fields");
                }
            });
        });

        //select one
        selectOne.addActionListener((e) -> {
                  doctorPanel2.removeAll();
    doctorPanel2.repaint();
            JFrame idFrame = Frame("Enter Doctor ID", new GridLayout(1, 1), 500, 400);
            JPanel idPanel = Create.Panel(null, Color.white);

            // ID Input
            JLabel idLabel = Label("ID", 90, 30, 70, 30, 30);
            JTextField idField = TextField(150, 30, 300, 30);

            // OK Button
            JButton ok = Button("OK", 190, 290, 100, 30);

            idFrame.add(idPanel);
            idPanel.add(idLabel);
            idPanel.add(idField);
            idPanel.add(ok);

            // OK Button Listener
            ok.addActionListener((a) -> {
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Doctor ID.");
                } else {
                    idFrame.setVisible(false);
                    int doctorId = Integer.parseInt(idField.getText()); // Get user input

                    // New panel for displaying doctor data
                    // Set the bounds for doctorPanel2 (optional)
                    doctorPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);
                    doctorFrame.add(doctorPanel2);

                    // Fetch data from the database
                    java.sql.Connection connect = null;

                    try {
                        connect = DatabaseConnection.connect();
                        if (connect == null) {
                            JOptionPane.showMessageDialog(null, "Database connection failed.");
                            return;
                        }

                        // Query to get all required data
                        String query = """
                    SELECT d.doctor_id, d.first_name, d.last_name, d.address, d.salary, d.start_date, d.years_of_experience, d.shift, d.extra_hours, d.genderd, d.speciality_name, 
                           c.clinic_id, c.floor AS clinic_floor,
                           r.room_id, r.floor AS room_floor, r.beds, r.capacity,
                           dp.phone,
                           dh.holiday
                    FROM Doctor d
                    LEFT JOIN Clinic c ON d.doctor_id = c.doctor_id
                    LEFT JOIN doctor_work_at_room dw ON d.doctor_id = dw.doctor_id
                    LEFT JOIN Room r ON dw.room_id = r.room_id
                    LEFT JOIN doctor_phone dp ON d.doctor_id = dp.doctor_id
                    LEFT JOIN doctor_holiday dh ON d.doctor_id = dh.doctor_id
                    WHERE d.doctor_id = ?;
                """;

                        try (PreparedStatement stmt = connect.prepareStatement(query)) {
                            stmt.setInt(1, doctorId);
                            ResultSet resultSet = stmt.executeQuery();

                            if (resultSet.next()) {
                                // Create labels for each field
                                JLabel firstNameLabel = Label("First Name: " + resultSet.getString("first_name"), 50, 20, 400, 60, 30);
                                doctorPanel2.add(firstNameLabel);

                                JLabel lastNameLabel = Label("Last Name: " + resultSet.getString("last_name"), 50, 80, 400, 60, 30);
                                doctorPanel2.add(lastNameLabel);

                                JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 140, 400, 60, 30);
                                doctorPanel2.add(addressLabel);

                                JLabel salaryLabel = Label("Salary: " + resultSet.getDouble("salary"), 50, 200, 400, 60, 30);
                                doctorPanel2.add(salaryLabel);

                                JLabel startDateLabel = Label("Start Date: " + resultSet.getDate("start_date"), 50, 260, 400, 60, 30);
                                doctorPanel2.add(startDateLabel);

                                JLabel yearsOfExperienceLabel = Label("Years of Experience: " + resultSet.getInt("years_of_experience"), 50, 320, 400, 60, 30);
                                doctorPanel2.add(yearsOfExperienceLabel);

                                JLabel shiftLabel = Label("Shift: " + resultSet.getString("shift"), 50, 380, 400, 60, 30);
                                doctorPanel2.add(shiftLabel);

                                JLabel extraHoursLabel = Label("Extra Hours: " + resultSet.getDouble("extra_hours"), 50, 440, 400, 60, 30);
                                doctorPanel2.add(extraHoursLabel);

                                JLabel genderLabel = Label("Gender: " + resultSet.getString("genderd"), 50, 500, 400, 60, 30);
                                doctorPanel2.add(genderLabel);

                                JLabel specialtyLabel = Label("Specialty: " + resultSet.getString("speciality_name"), 50, 560, 400, 60, 30);
                                doctorPanel2.add(specialtyLabel);

                                // Show Clinic or Room information depending on the doctor's assignment
                                boolean isWorkingInClinic = resultSet.getInt("clinic_id") != 0;
                                boolean isWorkingInRoom = resultSet.getInt("room_id") != 0;

                                if (isWorkingInClinic) {
                                    JLabel clinicIdLabel = Label("Clinic ID: " + resultSet.getInt("clinic_id"), 50, 620, 400, 60, 30);
                                    doctorPanel2.add(clinicIdLabel);

                                    JLabel clinicFloorLabel = Label("Clinic Floor: " + resultSet.getInt("clinic_floor"), 50, 680, 400, 60, 30);
                                    doctorPanel2.add(clinicFloorLabel);
                                } else if (isWorkingInRoom) {
                                    JLabel roomIdLabel = Label("Room ID: " + resultSet.getInt("room_id"), 50, 620, 400, 60, 30);
                                    doctorPanel2.add(roomIdLabel);

                                    JLabel roomFloorLabel = Label("Room Floor: " + resultSet.getInt("room_floor"), 50, 680, 400, 60, 30);
                                    doctorPanel2.add(roomFloorLabel);

                                    JLabel bedsLabel = Label("Beds: " + resultSet.getInt("beds"), 50, 740, 400, 60, 30);
                                    doctorPanel2.add(bedsLabel);

                                    JLabel capacityLabel = Label("Capacity: " + resultSet.getInt("capacity"), 50, 800, 400, 60, 30);
                                    doctorPanel2.add(capacityLabel);
                                }

                                // Phone information (can be multiple phones)
                                JLabel phoneLabel = Label("Phone(s): ", 800, 20, 400, 60, 30);
                                doctorPanel2.add(phoneLabel);
                                int yOffset = 80;

                                // Iterate through the phones and add them
                                String phoneQuery = "SELECT phone FROM doctor_phone WHERE doctor_id = ?";
                                try (PreparedStatement phoneStmt = connect.prepareStatement(phoneQuery)) {
                                    phoneStmt.setInt(1, doctorId);
                                    ResultSet phoneResult = phoneStmt.executeQuery();
                                    while (phoneResult.next()) {
                                        JLabel phone = Label(phoneResult.getString("phone"), 800, yOffset, 400, 60, 30);
                                        doctorPanel2.add(phone);
                                        yOffset += 80;  // Increase Y position for next phone number
                                    }
                                }

                                // Holiday information (can be multiple holidays)
                                JLabel holidayLabel = Label("Holiday(s): ", 800, yOffset, 400, 60, 30);
                                doctorPanel2.add(holidayLabel);

                                // Iterate through holidays and add them
                                String holidayQuery = "SELECT holiday FROM doctor_holiday WHERE doctor_id = ?";
                                try (PreparedStatement holidayStmt = connect.prepareStatement(holidayQuery)) {
                                    holidayStmt.setInt(1, doctorId);
                                    ResultSet holidayResult = holidayStmt.executeQuery();
                                    yOffset += 80;
                                    while (holidayResult.next()) {
                                        JLabel holiday = Label(holidayResult.getDate("holiday").toString(), 800, yOffset, 400, 60, 30);
                                        doctorPanel2.add(holiday);
                                        yOffset += 80;  // Increase Y position for next holiday
                                    }
                                }
                            }

                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error while fetching doctor data.");
                    } finally {
                        if (connect != null) {
                            try {
                                connect.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                    // Show the doctorFrame with the data labels
                    doctorFrame.setVisible(true);
                }
            });
        });

// select all
        selectAll.addActionListener((e) -> {
      doctorPanel2.removeAll();
    doctorPanel2.repaint();
            // Create the frame
            // Create the panel
            JPanel selectAllPanel = new JPanel();
            selectAllPanel.setLayout(new BorderLayout());
            selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
            JTable doctorTable = new JTable();

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }
                JScrollPane scrollPane = new JScrollPane(doctorTable);
                selectAllPanel.add(scrollPane, BorderLayout.CENTER);

                // Add the panel to the frame
                doctorFrame.add(selectAllPanel, BorderLayout.CENTER);

                // Query to select all rows from the Doctor table
                String query = "SELECT doctor_id, first_name, last_name, address, salary, start_date, "
                        + "years_of_experience, shift, extra_hours, genderd, speciality_name, nurse_id, manager_id FROM Doctor";

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
                    doctorTable.setModel(tableModel);
                }

                // Close the connection
                connect.close();

                // Display the frame
                doctorFrame.setVisible(true);

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
