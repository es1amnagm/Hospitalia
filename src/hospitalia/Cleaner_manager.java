package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Cleaner_manager {
    
    public Cleaner_manager()
    {
        
        
        
        ArrayList<String> phones = new ArrayList<>();
ArrayList<String> holidays = new ArrayList<>();

JFrame cleanerFrame = Frame("Cleaner", null);
JPanel cleanerPanel = Panel(null, new Color(17, 92, 115));

cleanerPanel.setBounds(0, 0, 350, screenSize.height);

JPanel cleanerPanel2 = Panel(null, Color.white);

cleanerPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

cleanerFrame.add(cleanerPanel);
cleanerFrame.add(cleanerPanel2);

// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         cleanerFrame.dispose();
        });
 cleanerFrame.add(exitButton);

JButton addCleaner = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));
JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));

cleanerPanel.add(addCleaner);
cleanerPanel.add(selectAll);
cleanerPanel.add(selectOne);

addCleaner.addActionListener((e) -> {
        cleanerPanel2.removeAll();
    cleanerPanel2.repaint();
    JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
    add.setBackground(Color.white);
    cleanerPanel2.add(add);
    cleanerPanel2.setVisible(true);

    JButton addPhones = Button("Add-Phones", 870, 630, 300, 40, 50, new Color(110, 181, 178));
    addPhones.setBackground(Color.white);
    cleanerPanel2.add(addPhones);

    JButton addHolidays = Button("Add-Holidays", 30, 630, 350, 40, 50, new Color(110, 181, 178));
    addHolidays.setBackground(Color.white);
    cleanerPanel2.add(addHolidays);

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

    JLabel gender = Label("Gender", 970, 20, 200, 30, 35);
    JTextField genderField = TextField(650, 25, 300, 30);

    JLabel shift = Label("Shift", 970, 100, 200, 30, 35);
    JTextField shiftField = TextField(650, 105, 300, 30);

    JLabel managerId = Label("Manager ID", 970, 180, 200, 30, 35);
    JTextField managerIdField = TextField(650, 185, 300, 30);

    JLabel phone = Label("Phone", 970, 260, 200, 30, 35);
    JTextField phoneField = TextField(650, 265, 300, 30);

    JLabel holiday = Label("Holiday", 970, 340, 200, 30, 35);
    JTextField holidayField = TextField(650, 345, 300, 30);

    cleanerPanel2.add(id);
    cleanerPanel2.add(idField);
    cleanerPanel2.add(firstName);
    cleanerPanel2.add(firstNameField);
    cleanerPanel2.add(lastName);
    cleanerPanel2.add(lastNameField);
    cleanerPanel2.add(address);
    cleanerPanel2.add(addressField);
    cleanerPanel2.add(extraHours);
    cleanerPanel2.add(extraHoursField);
    cleanerPanel2.add(startDate);
    cleanerPanel2.add(startDateField);
    cleanerPanel2.add(gender);
    cleanerPanel2.add(genderField);
    cleanerPanel2.add(shift);
    cleanerPanel2.add(shiftField);
    cleanerPanel2.add(managerId);
    cleanerPanel2.add(managerIdField);
    cleanerPanel2.add(phone);
    cleanerPanel2.add(phoneField);
    cleanerPanel2.add(holiday);
    cleanerPanel2.add(holidayField);

    addPhones.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            cleanerPanel2.setVisible(false);
            JPanel addPhonesPanel = Panel(null, Color.white);

            cleanerFrame.add(addPhonesPanel);
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
                cleanerPanel2.setVisible(true);
            });
        }
    });

    addHolidays.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            cleanerPanel2.setVisible(false);
            JPanel addHolidaysPanel = Panel(null, Color.white);

            cleanerFrame.add(addHolidaysPanel);
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
                cleanerPanel2.setVisible(true);
            });
        }
    });

    add.addActionListener((a) -> {
        String getId = idField.getText();
        String getFirstName = firstNameField.getText();
        String getLastName = lastNameField.getText();
        String getAddress = addressField.getText();
        String getShift = shiftField.getText();
        String getExtraHours = extraHoursField.getText();
        String getStartDate = startDateField.getText();
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
            String insertCleanerQuery = "INSERT INTO Cleaner (cleaner_id, first_name, last_name, address, shift, extra_hours, start_date, genderc, manager_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement cleanerStatement = connect.prepareStatement(insertCleanerQuery);

            cleanerStatement.setInt(1, Integer.parseInt(getId));
            cleanerStatement.setString(2, getFirstName);
            cleanerStatement.setString(3, getLastName);
            cleanerStatement.setString(4, getAddress);
            cleanerStatement.setString(5, getShift);
            cleanerStatement.setFloat(6, Float.parseFloat(getExtraHours));
            cleanerStatement.setDate(7, java.sql.Date.valueOf(getStartDate));
            cleanerStatement.setString(8, getGender);
            cleanerStatement.setInt(9, Integer.parseInt(getManagerId));

            int cleanerRows = cleanerStatement.executeUpdate();
            if (cleanerRows > 0) {
                JOptionPane.showMessageDialog(null, "Cleaner added successfully!");
                cleanerPanel2.setVisible(false);
            }

            if (!getPhone.isEmpty()) {
                String insertPhoneQuery = "INSERT INTO cleaner_phone (cleaner_id, phone) VALUES (?, ?)";
                PreparedStatement phoneStatement = connect.prepareStatement(insertPhoneQuery);

                phoneStatement.setInt(1, Integer.parseInt(getId));
                phoneStatement.setString(2, getPhone);

                int phoneRows = phoneStatement.executeUpdate();
            }

            if (!getHoliday.isEmpty()) {
                String insertHolidayQuery = "INSERT INTO cleaner_holiday (cleaner_id, holiday) VALUES (?, ?)";
                PreparedStatement holidayStatement = connect.prepareStatement(insertHolidayQuery);

                holidayStatement.setInt(1, Integer.parseInt(getId));
                holidayStatement.setDate(2, java.sql.Date.valueOf(getHoliday));

                int holidayRows = holidayStatement.executeUpdate();
            }

            for (String phonee : phones) {
                String insertPhoneQuery2 = "INSERT INTO cleaner_phone (cleaner_id, phone) VALUES (?, ?)";
                PreparedStatement phoneStatement2 = connect.prepareStatement(insertPhoneQuery2);

                phoneStatement2.setInt(1, Integer.parseInt(getId));
                phoneStatement2.setString(2, phonee);

                phoneStatement2.executeUpdate();
            }

            for (String holidayy : holidays) {
                String insertHolidayQuery2 = "INSERT INTO cleaner_holiday (cleaner_id, holiday) VALUES (?, ?)";
                PreparedStatement holidayStatement2 = connect.prepareStatement(insertHolidayQuery2);

                holidayStatement2.setInt(1, Integer.parseInt(getId));
                holidayStatement2.setDate(2, java.sql.Date.valueOf(holidayy));

                holidayStatement2.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding cleaner: " + ex.getMessage());
        }
    });
});

        
        // select one 
        
        selectOne.addActionListener((c) -> {
                cleanerPanel2.removeAll();
    cleanerPanel2.repaint();
    JFrame idFrame = Frame("Enter Cleaner ID", new GridLayout(1, 1), 500, 400);
    JPanel idPanel = Create.Panel(null, Color.white);

    JLabel idLabel = Label("Cleaner ID", 90, 30, 100, 30, 20);
    JTextField idField = TextField(200, 30, 200, 30);

    JButton ok = Button("OK", 190, 290, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Cleaner ID.");
        } else {
            idFrame.setVisible(false);
            int cleanerId = Integer.parseInt(idField.getText());

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                String query = "SELECT * FROM Cleaner WHERE cleaner_id = ?";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, cleanerId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        JLabel firstNameLabel = Label("First Name: " + resultSet.getString("first_name"), 50, 20, 400, 30, 20);
                        cleanerPanel2.add(firstNameLabel);

                        JLabel lastNameLabel = Label("Last Name: " + resultSet.getString("last_name"), 50, 60, 400, 30, 20);
                        cleanerPanel2.add(lastNameLabel);

                        JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 100, 400, 30, 20);
                        cleanerPanel2.add(addressLabel);

                        JLabel shiftLabel = Label("Shift: " + resultSet.getString("shift"), 50, 140, 400, 30, 20);
                        cleanerPanel2.add(shiftLabel);

                        JLabel extraHoursLabel = Label("Extra Hours: " + resultSet.getFloat("extra_hours"), 50, 180, 400, 30, 20);
                        cleanerPanel2.add(extraHoursLabel);

                        JLabel startDateLabel = Label("Start Date: " + resultSet.getDate("start_date"), 50, 220, 400, 30, 20);
                        cleanerPanel2.add(startDateLabel);

                        JLabel genderLabel = Label("Gender: " + resultSet.getString("genderc"), 50, 260, 400, 30, 20);
                        cleanerPanel2.add(genderLabel);

                        JLabel managerIdLabel = Label("Manager ID: " + resultSet.getInt("manager_id"), 50, 300, 400, 30, 20);
                        cleanerPanel2.add(managerIdLabel);
                    } else {
                        JOptionPane.showMessageDialog(null, "No cleaner found with the given ID.");
                        return;
                    }
                }

                int yOffset = 340;

                // Phone Numbers
                JLabel phoneHeader = Label("Phone(s):", 50, yOffset, 400, 30, 20);
                cleanerPanel2.add(phoneHeader);
                yOffset += 40;

                String phoneQuery = "SELECT phone FROM cleaner_phone WHERE cleaner_id = ?";
                try (PreparedStatement phoneStmt = connect.prepareStatement(phoneQuery)) {
                    phoneStmt.setInt(1, cleanerId);
                    ResultSet phoneResult = phoneStmt.executeQuery();

                    while (phoneResult.next()) {
                        JLabel phoneLabel = Label(phoneResult.getString("phone"), 50, yOffset, 400, 30, 20);
                        cleanerPanel2.add(phoneLabel);
                        yOffset += 40;
                    }
                }

                // Holidays
                JLabel holidayHeader = Label("Holiday(s):", 50, yOffset, 400, 30, 20);
                cleanerPanel2.add(holidayHeader);
                yOffset += 40;

                String holidayQuery = "SELECT holiday FROM cleaner_holiday WHERE cleaner_id = ?";
                try (PreparedStatement holidayStmt = connect.prepareStatement(holidayQuery)) {
                    holidayStmt.setInt(1, cleanerId);
                    ResultSet holidayResult = holidayStmt.executeQuery();

                    while (holidayResult.next()) {
                        JLabel holidayLabel = Label(holidayResult.getDate("holiday").toString(), 50, yOffset, 400, 30, 20);
                        cleanerPanel2.add(holidayLabel);
                        yOffset += 40;
                    }
                }

                // Rooms cleaned
                JLabel roomHeader = Label("Room(s) Cleaned:", 50, yOffset, 400, 30, 20);
                cleanerPanel2.add(roomHeader);
                yOffset += 40;

                String roomQuery = "SELECT room_id FROM clean_room WHERE cleaner_id = ?";
                try (PreparedStatement roomStmt = connect.prepareStatement(roomQuery)) {
                    roomStmt.setInt(1, cleanerId);
                    ResultSet roomResult = roomStmt.executeQuery();

                    while (roomResult.next()) {
                        JLabel roomLabel = Label("Room ID: " + roomResult.getInt("room_id"), 50, yOffset, 400, 30, 20);
                        cleanerPanel2.add(roomLabel);
                        yOffset += 40;
                    }
                }

                // Clinics cleaned
                JLabel clinicHeader = Label("Clinic(s) Cleaned:", 50, yOffset, 400, 30, 20);
                cleanerPanel2.add(clinicHeader);
                yOffset += 40;

                String clinicQuery = "SELECT clinic_id FROM clean_clinic WHERE cleaner_id = ?";
                try (PreparedStatement clinicStmt = connect.prepareStatement(clinicQuery)) {
                    clinicStmt.setInt(1, cleanerId);
                    ResultSet clinicResult = clinicStmt.executeQuery();

                    while (clinicResult.next()) {
                        JLabel clinicLabel = Label("Clinic ID: " + clinicResult.getInt("clinic_id"), 50, yOffset, 400, 30, 20);
                        cleanerPanel2.add(clinicLabel);
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

            cleanerFrame.add(cleanerPanel2);
            cleanerFrame.setVisible(true);
        }
    });
});

        
        
        
        //select all
        selectAll.addActionListener((e) -> {
    cleanerPanel2.removeAll();
    cleanerPanel2.repaint();
    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable cleanerTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(cleanerTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        cleanerFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Cleaner table
        String query = "SELECT cleaner_id, first_name, last_name, address, shift, extra_hours, start_date, genderc, manager_id FROM Cleaner";

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
            cleanerTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        cleanerFrame.setVisible(true);

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
