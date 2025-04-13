package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Driver_manager {
    
    
    
    public Driver_manager()
    {
        
        
        ArrayList<String> driverPhones = new ArrayList<>();
ArrayList<String> driverHolidays = new ArrayList<>();

JFrame driverFrame = Frame("Driver", null);
JPanel driverPanel = Panel(null, new Color(17, 92, 115));

driverPanel.setBounds(0, 0, 350, screenSize.height);

JPanel driverPanel2 = Panel(null, Color.white);

driverPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

driverFrame.add(driverPanel);
driverFrame.add(driverPanel2);

// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         driverFrame.dispose();
        });
 driverFrame.add(exitButton);
 

JButton addDriver = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));
JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));

driverPanel.add(addDriver);
driverPanel.add(selectAll);
driverPanel.add(selectOne);

addDriver.addActionListener((e) -> {
           driverPanel2.removeAll();
    driverPanel2.repaint();
    JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
    add.setBackground(Color.white);
    driverPanel2.add(add);
    driverPanel2.setVisible(true);

    JButton addPhones = Button("Add-Phones", 870, 630, 300, 40, 50, new Color(110, 181, 178));
    addPhones.setBackground(Color.white);
    driverPanel2.add(addPhones);

    JButton addHolidays = Button("Add-Holidays", 30, 630, 350, 40, 50, new Color(110, 181, 178));
    addHolidays.setBackground(Color.white);
    driverPanel2.add(addHolidays);

    JLabel id = Label("ID", 150, 20, 100, 30, 35);
    JTextField idField = TextField(320, 25, 300, 30);

    JLabel firstName = Label("First Name", 120, 100, 200, 30, 35);
    JTextField firstNameField = TextField(320, 105, 300, 30);

    JLabel lastName = Label("Last Name", 120, 180, 200, 30, 35);
    JTextField lastNameField = TextField(320, 185, 300, 30);

    JLabel address = Label("Address", 120, 260, 200, 30, 35);
    JTextField addressField = TextField(320, 265, 300, 30);

    JLabel experience = Label("Years of Experience", 120, 340, 200, 30, 35);
    JTextField experienceField = TextField(320, 345, 300, 30);

    JLabel salary = Label("Salary", 120, 420, 200, 30, 35);
    JTextField salaryField = TextField(320, 425, 300, 30);
    
        JLabel extraHours = Label("Extra Hours", 120, 380, 200, 30, 35);
    JTextField extraHoursField = TextField(320, 385, 300, 30);

    JLabel startDate = Label("Start Date", 120, 500, 210, 30, 35);
    JTextField startDateField = TextField(320, 505, 300, 30);

    JLabel gender = Label("Gender", 970, 20, 200, 30, 35);
    JTextField genderField = TextField(650, 25, 300, 30);

    JLabel shift = Label("Shift", 970, 100, 200, 30, 35);
    JTextField shiftField = TextField(650, 105, 300, 30);

    JLabel receptionistId = Label("Receptionist ID", 970, 180, 200, 30, 35);
    JTextField receptionistIdField = TextField(650, 185, 300, 30);

    JLabel managerId = Label("Manager ID", 970, 260, 200, 30, 35);
    JTextField managerIdField = TextField(650, 265, 300, 30);

    JLabel phone = Label("Phone", 970, 340, 200, 30, 35);
    JTextField phoneField = TextField(650, 345, 300, 30);

    JLabel holiday = Label("Holiday", 970, 420, 200, 30, 35);
    JTextField holidayField = TextField(650, 425, 300, 30);

    driverPanel2.add(id);
    driverPanel2.add(idField);
    driverPanel2.add(firstName);
    driverPanel2.add(firstNameField);
    driverPanel2.add(lastName);
    driverPanel2.add(lastNameField);
    driverPanel2.add(address);
    driverPanel2.add(addressField);
    driverPanel2.add(experience);
    driverPanel2.add(experienceField);
    driverPanel2.add(salary);
    driverPanel2.add(salaryField);
    driverPanel2.add(startDate);
    driverPanel2.add(startDateField);
    driverPanel2.add(gender);
    driverPanel2.add(genderField);
    driverPanel2.add(shift);
    driverPanel2.add(shiftField);
    driverPanel2.add(receptionistId);
    driverPanel2.add(receptionistIdField);
    driverPanel2.add(managerId);
    driverPanel2.add(managerIdField);
    driverPanel2.add(phone);
    driverPanel2.add(phoneField);
    driverPanel2.add(holiday);
    driverPanel2.add(holidayField);

    addPhones.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            driverPanel2.setVisible(false);
            JPanel addPhonesPanel = Panel(null, Color.white);

            driverFrame.add(addPhonesPanel);
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
                    driverPhones.add(phone1Field.getText());
                }
                if (!phone2Field.getText().isEmpty()) {
                    driverPhones.add(phone2Field.getText());
                }
                if (!phone3Field.getText().isEmpty()) {
                    driverPhones.add(phone3Field.getText());
                }
                addPhonesPanel.setVisible(false);
                driverPanel2.setVisible(true);
            });
        }
    });

    addHolidays.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            driverPanel2.setVisible(false);
            JPanel addHolidaysPanel = Panel(null, Color.white);

            driverFrame.add(addHolidaysPanel);
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
                    driverHolidays.add(holiday1Field.getText());
                }
                if (!holiday2Field.getText().isEmpty()) {
                    driverHolidays.add(holiday2Field.getText());
                }
                if (!holiday3Field.getText().isEmpty()) {
                    driverHolidays.add(holiday3Field.getText());
                }
                addHolidaysPanel.setVisible(false);
                driverPanel2.setVisible(true);
            });
        }
    });

    add.addActionListener((a) -> {
        String getId = idField.getText();
        String getFirstName = firstNameField.getText();
        String getLastName = lastNameField.getText();
        String getAddress = addressField.getText();
        String getExperience = experienceField.getText();
        String getSalary = salaryField.getText();
        String getStartDate = startDateField.getText();
        String getGender = genderField.getText();
                String getExtraHours = extraHoursField.getText();

        String getShift = shiftField.getText();
        String getReceptionistId = receptionistIdField.getText();
        String getManagerId = managerIdField.getText();
        String getPhone = phoneField.getText();
        String getHoliday = holidayField.getText();

        java.sql.Connection connect = DatabaseConnection.connect();

        if (!getPhone.matches("\\d*")) {
            JOptionPane.showMessageDialog(null, "Please enter a numeric value for the phone number!");
            return;
        }

        for (String phonee : driverPhones) {
            if (!phonee.matches("\\d*")) {
                JOptionPane.showMessageDialog(null, "All phone numbers must be numeric!");
                return;
            }
        }

        try (connect) {
            String insertDriverQuery = "INSERT INTO Driver (driver_id, first_name, last_name, address, years_of_experience, salary, shift, start_date, extra_hours, genderdr, receptionist_id, manager_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement driverStatement = connect.prepareStatement(insertDriverQuery);

            driverStatement.setInt(1, Integer.parseInt(getId));
            driverStatement.setString(2, getFirstName);
            driverStatement.setString(3, getLastName);
            driverStatement.setString(4, getAddress);
            driverStatement.setByte(5, Byte.parseByte(getExperience));
            driverStatement.setFloat(6, Float.parseFloat(getSalary));
            driverStatement.setString(7, getShift);
            driverStatement.setDate(8, java.sql.Date.valueOf(getStartDate));
            driverStatement.setFloat(9, Float.parseFloat(getExtraHours));
            driverStatement.setString(10, getGender);
            driverStatement.setInt(11, Integer.parseInt(getReceptionistId));
            driverStatement.setInt(12, Integer.parseInt(getManagerId));

            int driverRows = driverStatement.executeUpdate();
            if (driverRows > 0) {
                JOptionPane.showMessageDialog(null, "Driver added successfully!");
                driverPanel2.setVisible(false);
            }

            if (!getPhone.isEmpty()) {
                String insertPhoneQuery = "INSERT INTO driver_phone (driver_id, phone) VALUES (?, ?)";
                PreparedStatement phoneStatement = connect.prepareStatement(insertPhoneQuery);

                phoneStatement.setInt(1, Integer.parseInt(getId));
                phoneStatement.setString(2, getPhone);

                phoneStatement.executeUpdate();
            }

            if (!getHoliday.isEmpty()) {
                String insertHolidayQuery = "INSERT INTO driver_holiday (driver_id, holiday) VALUES (?, ?)";
                PreparedStatement holidayStatement = connect.prepareStatement(insertHolidayQuery);

                holidayStatement.setInt(1, Integer.parseInt(getId));
                holidayStatement.setDate(2, java.sql.Date.valueOf(getHoliday));

                holidayStatement.executeUpdate();
            }

            for (String phonee : driverPhones) {
                String insertPhoneQuery2 = "INSERT INTO driver_phone (driver_id, phone) VALUES (?, ?)";
                PreparedStatement phoneStatement2 = connect.prepareStatement(insertPhoneQuery2);

                phoneStatement2.setInt(1, Integer.parseInt(getId));
                phoneStatement2.setString(2, phonee);

                phoneStatement2.executeUpdate();
            }

            for (String holidayy : driverHolidays) {
                String insertHolidayQuery2 = "INSERT INTO driver_holiday (driver_id, holiday) VALUES (?, ?)";
                PreparedStatement holidayStatement2 = connect.prepareStatement(insertHolidayQuery2);

                holidayStatement2.setInt(1, Integer.parseInt(getId));
                holidayStatement2.setDate(2, java.sql.Date.valueOf(holidayy));

                holidayStatement2.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding driver: " + ex.getMessage());
        }
    });
});

        
        
        
        // select one 
        
        selectOne.addActionListener((c) -> {
                   driverPanel2.removeAll();
    driverPanel2.repaint();
    JFrame idFrame = Frame("Enter Driver ID", new GridLayout(1, 1), 500, 400);
    JPanel idPanel = Create.Panel(null, Color.white);

    JLabel idLabel = Label("Driver ID", 90, 30, 100, 30, 20);
    JTextField idField = TextField(200, 30, 200, 30);

    JButton ok = Button("OK", 190, 290, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Driver ID.");
        } else {
            idFrame.setVisible(false);
            int driverId = Integer.parseInt(idField.getText());

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                String query = "SELECT * FROM Driver WHERE driver_id = ?";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, driverId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        JLabel firstNameLabel = Label("First Name: " + resultSet.getString("first_name"), 50, 20, 400, 30, 20);
                        driverPanel2.add(firstNameLabel);

                        JLabel lastNameLabel = Label("Last Name: " + resultSet.getString("last_name"), 50, 60, 400, 30, 20);
                        driverPanel2.add(lastNameLabel);

                        JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 100, 400, 30, 20);
                        driverPanel2.add(addressLabel);

                        JLabel startDateLabel = Label("Start Date: " + resultSet.getDate("start_date"), 50, 140, 400, 30, 20);
                        driverPanel2.add(startDateLabel);

                        JLabel salaryLabel = Label("Salary: " + resultSet.getFloat("salary"), 50, 180, 400, 30, 20);
                        driverPanel2.add(salaryLabel);

                        JLabel yearsExperienceLabel = Label("Years of Experience: " + resultSet.getInt("years_of_experience"), 50, 220, 400, 30, 20);
                        driverPanel2.add(yearsExperienceLabel);

                        JLabel shiftLabel = Label("Shift: " + resultSet.getString("shift"), 50, 260, 400, 30, 20);
                        driverPanel2.add(shiftLabel);

                        JLabel extraHoursLabel = Label("Extra Hours: " + resultSet.getFloat("extra_hours"), 50, 300, 400, 30, 20);
                        driverPanel2.add(extraHoursLabel);

                        JLabel genderLabel = Label("Gender: " + resultSet.getString("genderdr"), 50, 340, 400, 30, 20);
                        driverPanel2.add(genderLabel);

                        JLabel receptionistIdLabel = Label("Receptionist ID: " + resultSet.getInt("receptionist_id"), 50, 380, 400, 30, 20);
                        driverPanel2.add(receptionistIdLabel);

                        JLabel managerIdLabel = Label("Manager ID: " + resultSet.getInt("manager_id"), 50, 420, 400, 30, 20);
                        driverPanel2.add(managerIdLabel);
                    } else {
                        JOptionPane.showMessageDialog(null, "No driver found with the given ID.");
                        return;
                    }
                }

                // Phones
                JLabel phoneHeader = Label("Phone(s):", 50, 460, 400, 30, 20);
                driverPanel2.add(phoneHeader);
                int yOffset = 500;

                String phoneQuery = "SELECT phone FROM driver_phone WHERE driver_id = ?";
                try (PreparedStatement phoneStmt = connect.prepareStatement(phoneQuery)) {
                    phoneStmt.setInt(1, driverId);
                    ResultSet phoneResult = phoneStmt.executeQuery();
                    while (phoneResult.next()) {
                        JLabel phoneLabel = Label(phoneResult.getString("phone"), 50, yOffset, 400, 30, 20);
                        driverPanel2.add(phoneLabel);
                        yOffset += 40;
                    }
                }

                // Holidays
                JLabel holidayHeader = Label("Holiday(s):", 50, yOffset, 400, 30, 20);
                driverPanel2.add(holidayHeader);
                yOffset += 40;

                String holidayQuery = "SELECT holiday FROM driver_holiday WHERE driver_id = ?";
                try (PreparedStatement holidayStmt = connect.prepareStatement(holidayQuery)) {
                    holidayStmt.setInt(1, driverId);
                    ResultSet holidayResult = holidayStmt.executeQuery();
                    while (holidayResult.next()) {
                        JLabel holidayLabel = Label(holidayResult.getDate("holiday").toString(), 50, yOffset, 400, 30, 20);
                        driverPanel2.add(holidayLabel);
                        yOffset += 40;
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

            driverFrame.add(driverPanel2);
            driverFrame.setVisible(true);
        }
    });
});

        
        
        
        
        
        
        
        //select All
        
        
        selectAll.addActionListener((e) -> {
       driverPanel2.removeAll();
    driverPanel2.repaint();
    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable driverTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(driverTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        driverFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Driver table
        String query = "SELECT driver_id, first_name, last_name, address, years_of_experience, salary, " +
                       "shift, start_date, extra_hours, genderdr, receptionist_id, manager_id FROM Driver";

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
            driverTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        driverFrame.setVisible(true);

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
