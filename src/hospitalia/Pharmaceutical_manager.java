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

public class Pharmaceutical_manager {

    public Pharmaceutical_manager() {

        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> holidays = new ArrayList<>();

        JFrame pharmaceuticalFrame = Frame("Pharmaceutical", null);
        JPanel pharmaceuticalPanel = Panel(null, new Color(17, 92, 115));

        pharmaceuticalPanel.setBounds(0, 0, 350, screenSize.height);

        JPanel pharmaceuticalPanel2 = Panel(null, Color.white);

        pharmaceuticalPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

        pharmaceuticalFrame.add(pharmaceuticalPanel);
        pharmaceuticalFrame.add(pharmaceuticalPanel2);

        // Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
            pharmaceuticalFrame.dispose();
        });
        pharmaceuticalFrame.add(exitButton);

        JButton addPharmaceutical = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
        JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));
        JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));

        pharmaceuticalPanel.add(addPharmaceutical);
        pharmaceuticalPanel.add(selectAll);
        pharmaceuticalPanel.add(selectOne);

        addPharmaceutical.addActionListener((e) -> {
            pharmaceuticalPanel2.removeAll();
            pharmaceuticalPanel2.repaint();
            JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
            add.setBackground(Color.white);
            pharmaceuticalPanel2.add(add);
            pharmaceuticalPanel2.setVisible(true);

            JButton addPhones = Button("Add-Phones", 870, 630, 300, 40, 50, new Color(110, 181, 178));
            addPhones.setBackground(Color.white);
            pharmaceuticalPanel2.add(addPhones);

            JButton addHolidays = Button("Add-Holidays", 30, 630, 350, 40, 50, new Color(110, 181, 178));
            addHolidays.setBackground(Color.white);
            pharmaceuticalPanel2.add(addHolidays);

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

            JLabel pharmacyId = Label("Pharmacy ID", 960, 260, 230, 30, 35);
            JTextField pharmacyIdField = TextField(650, 265, 300, 30);

            JLabel managerId = Label("Manager ID", 970, 340, 200, 30, 35);
            JTextField managerIdField = TextField(650, 345, 300, 30);

            JLabel phone = Label("Phone", 970, 420, 200, 30, 35);
            JTextField phoneField = TextField(650, 425, 300, 30);

            JLabel holiday = Label("Holiday", 970, 500, 200, 30, 35);
            JTextField holidayField = TextField(650, 505, 300, 30);

            pharmaceuticalPanel2.add(id);
            pharmaceuticalPanel2.add(idField);
            pharmaceuticalPanel2.add(firstName);
            pharmaceuticalPanel2.add(firstNameField);
            pharmaceuticalPanel2.add(lastName);
            pharmaceuticalPanel2.add(lastNameField);
            pharmaceuticalPanel2.add(address);
            pharmaceuticalPanel2.add(addressField);
            pharmaceuticalPanel2.add(salary);
            pharmaceuticalPanel2.add(salaryField);
            pharmaceuticalPanel2.add(startDate);
            pharmaceuticalPanel2.add(startDateField);
            pharmaceuticalPanel2.add(yearsOfExperience);
            pharmaceuticalPanel2.add(yearsOfExperienceField);
            pharmaceuticalPanel2.add(shift);
            pharmaceuticalPanel2.add(shiftField);
            pharmaceuticalPanel2.add(extraHours);
            pharmaceuticalPanel2.add(extraHoursField);
            pharmaceuticalPanel2.add(gender);
            pharmaceuticalPanel2.add(genderField);
            pharmaceuticalPanel2.add(pharmacyId);
            pharmaceuticalPanel2.add(pharmacyIdField);
            pharmaceuticalPanel2.add(managerId);
            pharmaceuticalPanel2.add(managerIdField);
            pharmaceuticalPanel2.add(phone);
            pharmaceuticalPanel2.add(phoneField);
            pharmaceuticalPanel2.add(holiday);
            pharmaceuticalPanel2.add(holidayField);

            addPhones.addActionListener((b) -> {
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the ID first");
                } else {
                    pharmaceuticalPanel2.setVisible(false);
                    JPanel addPhonesPanel = Panel(null, Color.white);

                    pharmaceuticalFrame.add(addPhonesPanel);
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
                        if (!phone1Field.getText().isEmpty()) {
                            phones.add(phone1Field.getText());
                        }
                        if (!phone2Field.getText().isEmpty()) {
                            phones.add(phone2Field.getText());
                        }
                        if (!phone3Field.getText().isEmpty()) {
                            phones.add(phone3Field.getText());
                        }
                        addPhonesPanel.setVisible(false);
                        pharmaceuticalPanel2.setVisible(true);
                    });
                }
            });

            addHolidays.addActionListener((b) -> {
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the ID first");
                } else {
                    pharmaceuticalPanel2.setVisible(false);
                    JPanel addHolidaysPanel = Panel(null, Color.white);

                    pharmaceuticalFrame.add(addHolidaysPanel);
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
                        if (!holiday1Field.getText().isEmpty()) {
                            holidays.add(holiday1Field.getText());
                        }
                        if (!holiday2Field.getText().isEmpty()) {
                            holidays.add(holiday2Field.getText());
                        }
                        if (!holiday3Field.getText().isEmpty()) {
                            holidays.add(holiday3Field.getText());
                        }
                        addHolidaysPanel.setVisible(false);
                        pharmaceuticalPanel2.setVisible(true);
                    });
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
                String getPharmacyId = pharmacyIdField.getText();
                String getManagerId = managerIdField.getText();
                String getPhone = phoneField.getText();
                String getHoliday = holidayField.getText();

                java.sql.Connection connect = DatabaseConnection.connect();

                if (!getPhone.matches("\\d*")) {
                    JOptionPane.showMessageDialog(null, "Please enter a numeric value for the phone number!");
                    return;
                }

                for (String phonee : phones) {
                    if (!phonee.matches("\\d*")) {
                        JOptionPane.showMessageDialog(null, "All phone numbers must be numeric!");
                        return;
                    }
                }

                try (connect) {
                    String insertPharmacyuticalQuery = "INSERT INTO Pharmacyutical (pharmacyutical_id, first_name, last_name, address, salary, start_date, "
                            + "years_of_experience, shift, extra_hours, genderph, pharmacy_id, manager_id) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pharmacyuticalStatement = connect.prepareStatement(insertPharmacyuticalQuery);

                    pharmacyuticalStatement.setInt(1, Integer.parseInt(getId));
                    pharmacyuticalStatement.setString(2, getFirstName);
                    pharmacyuticalStatement.setString(3, getLastName);
                    pharmacyuticalStatement.setString(4, getAddress);
                    pharmacyuticalStatement.setDouble(5, Double.parseDouble(getSalary));
                    pharmacyuticalStatement.setDate(6, java.sql.Date.valueOf(getStartDate));
                    pharmacyuticalStatement.setInt(7, Integer.parseInt(getYearsOfExperience));
                    pharmacyuticalStatement.setString(8, getShift);
                    pharmacyuticalStatement.setFloat(9, Float.parseFloat(getExtraHours));
                    pharmacyuticalStatement.setString(10, getGender);
                    pharmacyuticalStatement.setInt(11, Integer.parseInt(getPharmacyId));
                    pharmacyuticalStatement.setInt(12, Integer.parseInt(getManagerId));

                    int pharmacyuticalRows = pharmacyuticalStatement.executeUpdate();
                    if (pharmacyuticalRows > 0) {
                        JOptionPane.showMessageDialog(null, "Pharmaceutical added successfully!");
                        pharmaceuticalPanel2.setVisible(false);
                    }

                    if (!getPhone.isEmpty()) {
                        String insertPhoneQuery = "INSERT INTO pharmacyutical_phone (pharmacyutical_id, phone) VALUES (?, ?)";
                        PreparedStatement phoneStatement = connect.prepareStatement(insertPhoneQuery);

                        phoneStatement.setInt(1, Integer.parseInt(getId));
                        phoneStatement.setString(2, getPhone);

                        int phoneRows = phoneStatement.executeUpdate();
                    }

                    if (!getHoliday.isEmpty()) {
                        String insertHolidayQuery = "INSERT INTO pharmacyutical_holiday (pharmacyutical_id, holiday) VALUES (?, ?)";
                        PreparedStatement holidayStatement = connect.prepareStatement(insertHolidayQuery);

                        holidayStatement.setInt(1, Integer.parseInt(getId));
                        holidayStatement.setDate(2, java.sql.Date.valueOf(getHoliday));

                        int holidayRows = holidayStatement.executeUpdate();
                    }

                    if (!phones.isEmpty()) {
                        String insertPhoneQuery2 = "INSERT INTO pharmacyutical_phone (pharmacyutical_id, phone) VALUES (?, ?)";
                        PreparedStatement phoneStatement2 = connect.prepareStatement(insertPhoneQuery2);

                        for (String phonee : phones) {
                            phoneStatement2.setInt(1, Integer.parseInt(getId));
                            phoneStatement2.setString(2, phonee);
                            phoneStatement2.addBatch();
                        }
                        phoneStatement2.executeBatch();
                        JOptionPane.showMessageDialog(null, "Multiple phone numbers added successfully!");
                    }

                    if (!holidays.isEmpty()) {
                        String insertHolidayQuery2 = "INSERT INTO pharmacyutical_holiday (pharmacyutical_id, holiday) VALUES (?, ?)";
                        PreparedStatement holidayStatement2 = connect.prepareStatement(insertHolidayQuery2);

                        for (String holidayy : holidays) {
                            holidayStatement2.setInt(1, Integer.parseInt(getId));
                            holidayStatement2.setDate(2, java.sql.Date.valueOf(holidayy));
                            holidayStatement2.addBatch();
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

// select one 
        selectOne.addActionListener((e) -> {
            pharmaceuticalPanel2.removeAll();
            pharmaceuticalPanel2.repaint();
            JFrame idFrame = Frame("Enter Pharmacyutical ID", new GridLayout(1, 1), 500, 400);
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
                    JOptionPane.showMessageDialog(null, "Please enter a valid Pharmacyutical ID.");
                } else {
                    idFrame.setVisible(false);

                    int pharmacyuticalId = Integer.parseInt(idField.getText()); // Get user input

                    // Fetch data from the database
                    java.sql.Connection connect = null;

                    try {
                        connect = DatabaseConnection.connect();
                        if (connect == null) {
                            JOptionPane.showMessageDialog(null, "Database connection failed.");
                            return;
                        }

                        // Query to get all required data for the pharmacyutical
                        String query = "SELECT p.pharmacyutical_id, p.first_name, p.last_name, p.address, p.salary, p.start_date, p.years_of_experience, p.shift, p.extra_hours, p.genderph, "
                                + "p.pharmacy_id, p.manager_id "
                                + "FROM Pharmacyutical p WHERE p.pharmacyutical_id = ?;";

                        try (PreparedStatement stmt = connect.prepareStatement(query)) {
                            stmt.setInt(1, pharmacyuticalId);
                            ResultSet resultSet = stmt.executeQuery();

                            if (resultSet.next()) {
                                // Display pharmacyutical details
                                JLabel firstNameLabel = Label("First Name: " + resultSet.getString("first_name"), 50, 20, 400, 60, 30);
                                pharmaceuticalPanel2.add(firstNameLabel);

                                JLabel lastNameLabel = Label("Last Name: " + resultSet.getString("last_name"), 50, 80, 400, 60, 30);
                                pharmaceuticalPanel2.add(lastNameLabel);

                                JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 140, 400, 60, 30);
                                pharmaceuticalPanel2.add(addressLabel);

                                JLabel salaryLabel = Label("Salary: " + resultSet.getDouble("salary"), 50, 200, 400, 60, 30);
                                pharmaceuticalPanel2.add(salaryLabel);

                                JLabel startDateLabel = Label("Start Date: " + resultSet.getDate("start_date"), 50, 260, 400, 60, 30);
                                pharmaceuticalPanel2.add(startDateLabel);

                                JLabel yearsOfExperienceLabel = Label("Years of Experience: " + resultSet.getInt("years_of_experience"), 50, 320, 400, 60, 30);
                                pharmaceuticalPanel2.add(yearsOfExperienceLabel);

                                JLabel shiftLabel = Label("Shift: " + resultSet.getString("shift"), 50, 380, 400, 60, 30);
                                pharmaceuticalPanel2.add(shiftLabel);

                                JLabel extraHoursLabel = Label("Extra Hours: " + resultSet.getDouble("extra_hours"), 50, 440, 400, 60, 30);
                                pharmaceuticalPanel2.add(extraHoursLabel);

                                JLabel genderLabel = Label("Gender: " + resultSet.getString("genderph"), 50, 500, 400, 60, 30);
                                pharmaceuticalPanel2.add(genderLabel);

                                JLabel pharmacyIdLabel = Label("Pharmacy ID: " + resultSet.getInt("pharmacy_id"), 50, 560, 400, 60, 30);
                                pharmaceuticalPanel2.add(pharmacyIdLabel);

                                JLabel managerIdLabel = Label("Manager ID: " + resultSet.getInt("manager_id"), 50, 620, 400, 60, 30);
                                pharmaceuticalPanel2.add(managerIdLabel);
                            } else {
                                JOptionPane.showMessageDialog(null, "No Pharmacyutical found with the given ID.");
                                return;
                            }
                        }

                        // Display phone numbers
                        JLabel phoneHeader = Label("Phone(s):", 800, 20, 400, 60, 30);
                        pharmaceuticalPanel2.add(phoneHeader);
                        int yOffset = 80;

                        String phoneQuery = "SELECT phone FROM pharmacyutical_phone WHERE pharmacyutical_id = ?;";
                        try (PreparedStatement phoneStmt = connect.prepareStatement(phoneQuery)) {
                            phoneStmt.setInt(1, pharmacyuticalId);
                            ResultSet phoneResult = phoneStmt.executeQuery();

                            while (phoneResult.next()) {
                                JLabel phoneLabel = Label(phoneResult.getString("phone"), 800, yOffset, 400, 60, 30);
                                pharmaceuticalPanel2.add(phoneLabel);
                                yOffset += 60;
                            }
                        }

                        // Display holidays
                        JLabel holidayHeader = Label("Holiday(s):", 800, yOffset, 400, 60, 30);
                        pharmaceuticalPanel2.add(holidayHeader);
                        yOffset += 60;

                        String holidayQuery = "SELECT holiday FROM pharmacyutical_holiday WHERE pharmacyutical_id = ?;";
                        try (PreparedStatement holidayStmt = connect.prepareStatement(holidayQuery)) {
                            holidayStmt.setInt(1, pharmacyuticalId);
                            ResultSet holidayResult = holidayStmt.executeQuery();

                            while (holidayResult.next()) {
                                JLabel holidayLabel = Label(holidayResult.getDate("holiday").toString(), 800, yOffset, 400, 60, 30);
                                pharmaceuticalPanel2.add(holidayLabel);
                                yOffset += 60;
                            }
                        }

                        // Display orders
                        JLabel orderHeader = Label("Order(s):", 800, yOffset, 400, 60, 30);
                        pharmaceuticalPanel2.add(orderHeader);
                        yOffset += 60;

                        String orderQuery = "SELECT worker_store_id, ordder, date FROM pharmacyutical_call_worker_store_to_get_medicine WHERE pharmacyutical_id = ?;";
                        try (PreparedStatement orderStmt = connect.prepareStatement(orderQuery)) {
                            orderStmt.setInt(1, pharmacyuticalId);
                            ResultSet orderResult = orderStmt.executeQuery();

                            while (orderResult.next()) {
                                JLabel workerStoreLabel = Label("Worker Store ID: " + orderResult.getInt("worker_store_id"), 800, yOffset, 400, 60, 30);
                                pharmaceuticalPanel2.add(workerStoreLabel);

                                JLabel orderLabel = Label("Order: " + orderResult.getString("ordder"), 800, yOffset + 60, 400, 60, 30);
                                pharmaceuticalPanel2.add(orderLabel);

                                JLabel dateLabel = Label("Date: " + orderResult.getDate("date"), 800, yOffset + 120, 400, 60, 30);
                                pharmaceuticalPanel2.add(dateLabel);

                                yOffset += 180;
                            }
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error while fetching pharmacyutical data.");
                    } finally {
                        if (connect != null) {
                            try {
                                connect.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                    // Show the pharmacyFrame with the data labels
                    pharmaceuticalFrame.add(pharmaceuticalPanel2);
                    pharmaceuticalFrame.setVisible(true);
                }
            });
        });

// select all
        selectAll.addActionListener((e) -> {
            pharmaceuticalPanel2.removeAll();
            pharmaceuticalPanel2.repaint();
            // Create the frame
            // Create the panel
            JPanel selectAllPanel = new JPanel();
            selectAllPanel.setLayout(new BorderLayout());
            selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
            JTable pharmacyuticalTable = new JTable();

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }
                JScrollPane scrollPane = new JScrollPane(pharmacyuticalTable);
                selectAllPanel.add(scrollPane, BorderLayout.CENTER);

                // Add the panel to the frame
                pharmaceuticalFrame.add(selectAllPanel, BorderLayout.CENTER);

                // Query to select all rows from the Pharmacyutical table
                String query = "SELECT pharmacyutical_id, first_name, last_name, address, salary, start_date, "
                        + "years_of_experience, shift, extra_hours, genderph, pharmacy_id, manager_id FROM Pharmacyutical";

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
                    pharmacyuticalTable.setModel(tableModel);
                }

                // Close the connection
                connect.close();

                // Display the frame
                pharmaceuticalFrame.setVisible(true);

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
