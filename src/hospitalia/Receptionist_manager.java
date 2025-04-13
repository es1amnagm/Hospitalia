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
public class Receptionist_manager {


public Receptionist_manager()
{
    
    ArrayList<String> phones = new ArrayList<>();
ArrayList<String> holidays = new ArrayList<>();

JFrame receptionistFrame = Frame("Receptionist", null);
 JPanel receptionistPanel = Panel(null, new Color(17, 92, 115));

receptionistPanel.setBounds(0, 0, 350, screenSize.height);

JPanel receptionistPanel2 = Panel(null, Color.white);

receptionistPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

receptionistFrame.add(receptionistPanel);
receptionistFrame.add(receptionistPanel2);

// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         receptionistFrame.dispose();
        });
 receptionistFrame.add(exitButton);



JButton addReceptionist = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));
JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));

receptionistPanel.add(addReceptionist);
receptionistPanel.add(selectAll);
receptionistPanel.add(selectOne);

addReceptionist.addActionListener((e) -> {
      receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
    JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
    add.setBackground(Color.white);
    receptionistPanel2.add(add);
    receptionistPanel2.setVisible(true);

    JButton addPhones = Button("Add-Phones", 870, 630, 300, 40, 50, new Color(110, 181, 178));
    addPhones.setBackground(Color.white);
    receptionistPanel2.add(addPhones);

    JButton addHolidays = Button("Add-Holidays", 30, 630, 350, 40, 50, new Color(110, 181, 178));
    addHolidays.setBackground(Color.white);
    receptionistPanel2.add(addHolidays);

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

    JLabel managerId = Label("Manager ID", 970, 340, 200, 30, 35);
    JTextField managerIdField = TextField(650, 345, 300, 30);

    JLabel phone = Label("Phone", 970, 420, 200, 30, 35);
    JTextField phoneField = TextField(650, 425, 300, 30);

    JLabel holiday = Label("Holiday", 970, 500, 200, 30, 35);
    JTextField holidayField = TextField(650, 505, 300, 30);

    receptionistPanel2.add(id);
    receptionistPanel2.add(idField);
    receptionistPanel2.add(firstName);
    receptionistPanel2.add(firstNameField);
    receptionistPanel2.add(lastName);
    receptionistPanel2.add(lastNameField);
    receptionistPanel2.add(address);
    receptionistPanel2.add(addressField);
    receptionistPanel2.add(salary);
    receptionistPanel2.add(salaryField);
    receptionistPanel2.add(startDate);
    receptionistPanel2.add(startDateField);
    receptionistPanel2.add(yearsOfExperience);
    receptionistPanel2.add(yearsOfExperienceField);
    receptionistPanel2.add(shift);
    receptionistPanel2.add(shiftField);
    receptionistPanel2.add(extraHours);
    receptionistPanel2.add(extraHoursField);
    receptionistPanel2.add(gender);
    receptionistPanel2.add(genderField);
    receptionistPanel2.add(managerId);
    receptionistPanel2.add(managerIdField);
    receptionistPanel2.add(phone);
    receptionistPanel2.add(phoneField);
    receptionistPanel2.add(holiday);
    receptionistPanel2.add(holidayField);

    addPhones.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            receptionistPanel2.setVisible(false);
            JPanel addPhonesPanel = Panel(null, Color.white);

            receptionistFrame.add(addPhonesPanel);
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
                receptionistPanel2.setVisible(true);
            });
        }
    });

    addHolidays.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            receptionistPanel2.setVisible(false);
            JPanel addHolidaysPanel = Panel(null, Color.white);

            receptionistFrame.add(addHolidaysPanel);
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
                receptionistPanel2.setVisible(true);
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
        String insertreceptionistQuery = "INSERT INTO Receptionist (receptionist_id, first_name, last_name, address, salary, start_date, "
                + "years_of_experience, shift, extra_hours, genderr,  manager_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement receptionistStatement = connect.prepareStatement(insertreceptionistQuery);

        receptionistStatement.setInt(1, Integer.parseInt(getId));
        receptionistStatement.setString(2, getFirstName);
        receptionistStatement.setString(3, getLastName);
        receptionistStatement.setString(4, getAddress);
        receptionistStatement.setDouble(5, Double.parseDouble(getSalary));
        receptionistStatement.setDate(6, java.sql.Date.valueOf(getStartDate));
        receptionistStatement.setInt(7, Integer.parseInt(getYearsOfExperience));
        receptionistStatement.setString(8, getShift);
        receptionistStatement.setFloat(9, Float.parseFloat(getExtraHours));
        receptionistStatement.setString(10, getGender);
        receptionistStatement.setInt(11, Integer.parseInt(getManagerId));

        int pharmacyuticalRows = receptionistStatement.executeUpdate();
        if (pharmacyuticalRows > 0) {
            JOptionPane.showMessageDialog(null, "Pharmaceutical added successfully!");
            receptionistPanel2.setVisible(false);
        }

        if (!getPhone.isEmpty()) {
            String insertPhoneQuery = "INSERT INTO receptionist_phone (receptionist_id, phone) VALUES (?, ?)";
            PreparedStatement phoneStatement = connect.prepareStatement(insertPhoneQuery);

            phoneStatement.setInt(1, Integer.parseInt(getId));
            phoneStatement.setString(2, getPhone);

            int phoneRows = phoneStatement.executeUpdate();
        }

        if (!getHoliday.isEmpty()) {
            String insertHolidayQuery = "INSERT INTO receptionist_holiday (receptionist_id, holiday) VALUES (?, ?)";
            PreparedStatement holidayStatement = connect.prepareStatement(insertHolidayQuery);

            holidayStatement.setInt(1, Integer.parseInt(getId));
            holidayStatement.setDate(2, java.sql.Date.valueOf(getHoliday));

            int holidayRows = holidayStatement.executeUpdate();
        }

        if (!phones.isEmpty()) {
            String insertPhoneQuery2 = "INSERT INTO receptionist_phone (receptionist_id, phone) VALUES (?, ?)";
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
            String insertHolidayQuery2 = "INSERT INTO receptionist_holiday (receptionist_id, holiday) VALUES (?, ?)";
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
    
    
    selectOne.addActionListener((c) -> {
          receptionistPanel2.removeAll();
    receptionistPanel2.repaint();
    JFrame idFrame = Frame("Enter Receptionist ID", new GridLayout(1, 1), 500, 400);
    JPanel idPanel = Create.Panel(null, Color.white);

    // ID Input
    JLabel idLabel = Label("Receptionist ID", 90, 30, 100, 30, 20);
    JTextField idField = TextField(200, 30, 200, 30);

    // OK Button
    JButton ok = Button("OK", 190, 290, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    // OK Button Listener
    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Receptionist ID.");
        } else {
            idFrame.setVisible(false);

  

            int receptionistId = Integer.parseInt(idField.getText()); // Get user input

            // Database connection
            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                // Query to fetch receptionist data
                String query = "SELECT * FROM Receptionist WHERE receptionist_id = ?";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, receptionistId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        JLabel firstNameLabel = Label("First Name: " + resultSet.getString("first_name"), 50, 20, 400, 30, 20);
                        receptionistPanel2.add(firstNameLabel);

                        JLabel lastNameLabel = Label("Last Name: " + resultSet.getString("last_name"), 50, 60, 400, 30, 20);
                        receptionistPanel2.add(lastNameLabel);

                        JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 100, 400, 30, 20);
                        receptionistPanel2.add(addressLabel);

                        JLabel startDateLabel = Label("Start Date: " + resultSet.getDate("start_date"), 50, 140, 400, 30, 20);
                        receptionistPanel2.add(startDateLabel);

                        JLabel salaryLabel = Label("Salary: " + resultSet.getFloat("salary"), 50, 180, 400, 30, 20);
                        receptionistPanel2.add(salaryLabel);

                        JLabel yearsExperienceLabel = Label("Years of Experience: " + resultSet.getInt("years_of_experience"), 50, 220, 400, 30, 20);
                        receptionistPanel2.add(yearsExperienceLabel);

                        JLabel shiftLabel = Label("Shift: " + resultSet.getString("shift"), 50, 260, 400, 30, 20);
                        receptionistPanel2.add(shiftLabel);

                        JLabel extraHoursLabel = Label("Extra Hours: " + resultSet.getFloat("extra_hours"), 50, 300, 400, 30, 20);
                        receptionistPanel2.add(extraHoursLabel);

                        JLabel genderLabel = Label("Gender: " + resultSet.getString("genderr"), 50, 340, 400, 30, 20);
                        receptionistPanel2.add(genderLabel);
                
                            JLabel managerIdLabel = Label("Manager ID: " + resultSet.getInt("manager_id"), 50, 380, 400, 60, 20);
                        receptionistPanel2.add(managerIdLabel);
                    } else {
                        JOptionPane.showMessageDialog(null, "No receptionist_id found with the given ID.");
                        return;
                    
                
                    }
               
                
                }
                 // Display phone numbers
                JLabel phoneHeader = Label("Phone(s):", 50, 420, 400, 60, 30);
                receptionistPanel2.add(phoneHeader);
                int yOffset = 80;

                String phoneQuery = "SELECT phone FROM receptionist_phone WHERE receptionist_id = ?;";
                try (PreparedStatement phoneStmt = connect.prepareStatement(phoneQuery)) {
                    phoneStmt.setInt(1, receptionistId);
                    ResultSet phoneResult = phoneStmt.executeQuery();

                    while (phoneResult.next()) {
                        JLabel phoneLabel = Label(phoneResult.getString("phone"), 50, yOffset, 400, 60, 30);
                        receptionistPanel2.add(phoneLabel);
                        yOffset += 60;
                    }
                }

                // Display holidays

                JLabel holidayHeader = Label("Holiday(s):", 50, 580, 400, 60, 30);
                receptionistPanel2.add(holidayHeader);
                yOffset += 60;

                String holidayQuery = "SELECT holiday FROM receptionist_holiday WHERE receptionist_id = ?;";
                try (PreparedStatement holidayStmt = connect.prepareStatement(holidayQuery)) {
                    holidayStmt.setInt(1, receptionistId);
                    ResultSet holidayResult = holidayStmt.executeQuery();

                    while (holidayResult.next()) {
                        JLabel holidayLabel = Label(holidayResult.getDate("holiday").toString(), 50, yOffset, 400, 60, 30);
                        receptionistPanel2.add(holidayLabel);
                        yOffset += 60;
                    }
                }

                // Fetch related patient call data
                String patientCallQuery = "SELECT patient_id FROM patien_call_receptionsit WHERE receptionist_id = ?";
                try (PreparedStatement patientStmt = connect.prepareStatement(patientCallQuery)) {
                    patientStmt.setInt(1, receptionistId);
                    ResultSet patientResult = patientStmt.executeQuery();

                    JLabel callsFromPatientsLabel = Label("Calls from Patients:", 800, 20, 400, 30, 20);
                    receptionistPanel2.add(callsFromPatientsLabel);

                     yOffset = 60;
                    while (patientResult.next()) {
                        JLabel patientLabel = Label("Patient ID: " + patientResult.getInt("patient_id"), 800, yOffset, 400, 30, 20);
                        receptionistPanel2.add(patientLabel);
                        yOffset += 40;
                    }
                }

                // Fetch related invoice data
                String invoiceQuery = "SELECT invoice_id FROM Invoice WHERE receptionist_id = ?";
                try (PreparedStatement invoiceStmt = connect.prepareStatement(invoiceQuery)) {
                    invoiceStmt.setInt(1, receptionistId);
                    ResultSet invoiceResult = invoiceStmt.executeQuery();

                    JLabel invoicesLabel = Label("Invoices Handled:", 800, 300, 400, 30, 20);
                    receptionistPanel2.add(invoicesLabel);

                     yOffset = 340;
                    while (invoiceResult.next()) {
                        JLabel invoiceLabel = Label("Invoice ID: " + invoiceResult.getInt("invoice_id"), 800, yOffset, 400, 30, 20);
                        receptionistPanel2.add(invoiceLabel);
                        yOffset += 40;
                    }
                }

                // Fetch related driver data
                String driverQuery = "SELECT driver_id FROM Driver WHERE receptionist_id = ?";
                try (PreparedStatement driverStmt = connect.prepareStatement(driverQuery)) {
                    driverStmt.setInt(1, receptionistId);
                    ResultSet driverResult = driverStmt.executeQuery();

                    JLabel driversLabel = Label("Drivers Took Orders:", 800, 500, 400, 30, 20);
                    receptionistPanel2.add(driversLabel);

                     yOffset = 540;
                    while (driverResult.next()) {
                        JLabel driverLabel = Label("Driver ID: " + driverResult.getInt("driver_id"), 800, yOffset, 400, 30, 20);
                        receptionistPanel2.add(driverLabel);
                        yOffset += 40;
                    }
                }

                // Fetch related paramedic data
                String paramedicQuery = "SELECT paramedic_id FROM Paramedic WHERE receptionist_id = ?";
                try (PreparedStatement paramedicStmt = connect.prepareStatement(paramedicQuery)) {
                    paramedicStmt.setInt(1, receptionistId);
                    ResultSet paramedicResult = paramedicStmt.executeQuery();

                    JLabel paramedicsLabel = Label("Paramedics Took Orders:", 800, 700, 400, 30, 20);
                    receptionistPanel2.add(paramedicsLabel);

                     yOffset = 740;
                    while (paramedicResult.next()) {
                        JLabel paramedicLabel = Label("Paramedic ID: " + paramedicResult.getInt("paramedic_id"), 800, yOffset, 400, 30, 20);
                        receptionistPanel2.add(paramedicLabel);
                        yOffset += 40;
                    }
                }

                // Fetch related donation data
                String donationQuery = "SELECT donation_id FROM Donations WHERE receptionist_id = ?";
                try (PreparedStatement donationStmt = connect.prepareStatement(donationQuery)) {
                    donationStmt.setInt(1, receptionistId);
                    ResultSet donationResult = donationStmt.executeQuery();

                    JLabel donationsLabel = Label("Donations Handled:", 800, 900, 400, 30, 20);
                    receptionistPanel2.add(donationsLabel);

                     yOffset = 940;
                    while (donationResult.next()) {
                        JLabel donationLabel = Label("Donation ID: " + donationResult.getInt("donation_id"), 800, yOffset, 400, 30, 20);
                        receptionistPanel2.add(donationLabel);
                        yOffset += 40;
                    }
                }

            } catch (SQLException ex) {
             } finally {
                if (connect != null) {
                    try {
                        connect.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            // Show the receptionist frame with the data
            receptionistFrame.add(receptionistPanel2);
            receptionistFrame.setVisible(true);
        }
    });
});

    // select all
    
    
    selectAll.addActionListener((e) -> {
          receptionistPanel2.removeAll();
    receptionistPanel2.repaint();

    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable receptionistTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(receptionistTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        receptionistFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Receptionist table
        String query = "SELECT receptionist_id, first_name, last_name, address, start_date, salary, " +
                       "years_of_experience, shift, extra_hours, genderr, manager_id FROM Receptionist";

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
            receptionistTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        receptionistFrame.setVisible(true);

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
