package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Paramedic_manager {
    
    
    public Paramedic_manager()
    {
        
        
ArrayList<String> phones = new ArrayList<>();
ArrayList<String> holidays = new ArrayList<>();

JFrame paramedicFrame = Frame("Paramedic", null);
JPanel paramedicPanel = Panel(null, new Color(17, 92, 115));

paramedicPanel.setBounds(0, 0, 350, screenSize.height);

JPanel paramedicPanel2 = Panel(null, Color.white);

paramedicPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

paramedicFrame.add(paramedicPanel);
paramedicFrame.add(paramedicPanel2);


                // Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         paramedicFrame.dispose();
        });
 paramedicFrame.add(exitButton);




JButton addParamedic = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));
JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));

paramedicPanel.add(addParamedic);
paramedicPanel.add(selectAll);
paramedicPanel.add(selectOne);

addParamedic.addActionListener((e) -> {
           paramedicPanel2.removeAll();
    paramedicPanel2.repaint();
    JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
    add.setBackground(Color.white);
    paramedicPanel2.add(add);
    paramedicPanel2.setVisible(true);

    JButton addPhones = Button("Add-Phones", 870, 630, 300, 40, 50, new Color(110, 181, 178));
    addPhones.setBackground(Color.white);
    paramedicPanel2.add(addPhones);

    JButton addHolidays = Button("Add-Holidays", 30, 630, 350, 40, 50, new Color(110, 181, 178));
    addHolidays.setBackground(Color.white);
    paramedicPanel2.add(addHolidays);

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

    JLabel ambulanceId = Label("Ambulance ID", 960, 260, 230, 30, 35);
    JTextField ambulanceIdField = TextField(650, 265, 300, 30);

    JLabel driverId = Label("Driver ID", 970, 340, 200, 30, 35);
    JTextField driverIdField = TextField(650, 345, 300, 30);

    JLabel receptionistId = Label("Receptionist ID", 960, 420, 230, 30, 35);
    JTextField receptionistIdField = TextField(650, 425, 300, 30);

    JLabel managerId = Label("Manager ID", 970, 500, 200, 30, 35);
    JTextField managerIdField = TextField(650, 505, 300, 30);

    JLabel phone = Label("Phone", 970, 580, 200, 30, 35);
    JTextField phoneField = TextField(650, 585, 300, 30);

    JLabel holiday = Label("Holiday", 970, 660, 200, 30, 35);
    JTextField holidayField = TextField(650, 665, 300, 30);

    paramedicPanel2.add(id);
    paramedicPanel2.add(idField);
    paramedicPanel2.add(firstName);
    paramedicPanel2.add(firstNameField);
    paramedicPanel2.add(lastName);
    paramedicPanel2.add(lastNameField);
    paramedicPanel2.add(address);
    paramedicPanel2.add(addressField);
    paramedicPanel2.add(salary);
    paramedicPanel2.add(salaryField);
    paramedicPanel2.add(startDate);
    paramedicPanel2.add(startDateField);
    paramedicPanel2.add(yearsOfExperience);
    paramedicPanel2.add(yearsOfExperienceField);
    paramedicPanel2.add(shift);
    paramedicPanel2.add(shiftField);
    paramedicPanel2.add(extraHours);
    paramedicPanel2.add(extraHoursField);
    paramedicPanel2.add(gender);
    paramedicPanel2.add(genderField);
    paramedicPanel2.add(ambulanceId);
    paramedicPanel2.add(ambulanceIdField);
    paramedicPanel2.add(driverId);
    paramedicPanel2.add(driverIdField);
    paramedicPanel2.add(receptionistId);
    paramedicPanel2.add(receptionistIdField);
    paramedicPanel2.add(managerId);
    paramedicPanel2.add(managerIdField);
    paramedicPanel2.add(phone);
    paramedicPanel2.add(phoneField);
    paramedicPanel2.add(holiday);
    paramedicPanel2.add(holidayField);

    addPhones.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            paramedicPanel2.setVisible(false);
            JPanel addPhonesPanel = Panel(null, Color.white);

            paramedicFrame.add(addPhonesPanel);
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
                paramedicPanel2.setVisible(true);
            });
        }
    });

    addHolidays.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            paramedicPanel2.setVisible(false);
            JPanel addHolidaysPanel = Panel(null, Color.white);

            paramedicFrame.add(addHolidaysPanel);
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
                paramedicPanel2.setVisible(true);
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
        String getAmbulanceId = ambulanceIdField.getText();
        String getDriverId = driverIdField.getText();
        String getReceptionistId = receptionistIdField.getText();
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
            String insertParamedicQuery = "INSERT INTO Paramedic (paramedic_id, first_name, last_name, address, salary, start_date, "
                    + "years_of_experience, shift, extra_hours, genderpar, ambulance_id, driver_id, receptionist_id, manager_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement paramedicStatement = connect.prepareStatement(insertParamedicQuery);

            paramedicStatement.setInt(1, Integer.parseInt(getId));
            paramedicStatement.setString(2, getFirstName);
            paramedicStatement.setString(3, getLastName);
            paramedicStatement.setString(4, getAddress);
            paramedicStatement.setDouble(5, Double.parseDouble(getSalary));
            paramedicStatement.setDate(6, java.sql.Date.valueOf(getStartDate));
            paramedicStatement.setInt(7, Integer.parseInt(getYearsOfExperience));
            paramedicStatement.setString(8, getShift);
            paramedicStatement.setFloat(9, Float.parseFloat(getExtraHours));
            paramedicStatement.setString(10, getGender);
            paramedicStatement.setInt(11, Integer.parseInt(getAmbulanceId));
            paramedicStatement.setInt(12, Integer.parseInt(getDriverId));
            paramedicStatement.setInt(13, Integer.parseInt(getReceptionistId));
            paramedicStatement.setInt(14, Integer.parseInt(getManagerId));

            int paramedicRows = paramedicStatement.executeUpdate();
            if (paramedicRows > 0) {
                JOptionPane.showMessageDialog(null, "Paramedic added successfully!");
                paramedicPanel2.setVisible(false);
            }

            if (!getPhone.isEmpty()) {
                String insertPhoneQuery = "INSERT INTO paramedic_phone (paramedic_id, phone) VALUES (?, ?)";
                PreparedStatement phoneStatement = connect.prepareStatement(insertPhoneQuery);

                phoneStatement.setInt(1, Integer.parseInt(getId));
                phoneStatement.setString(2, getPhone);

                int phoneRows = phoneStatement.executeUpdate();
            }

            if (!getHoliday.isEmpty()) {
                String insertHolidayQuery = "INSERT INTO paramedic_holiday (paramedic_id, holiday) VALUES (?, ?)";
                PreparedStatement holidayStatement = connect.prepareStatement(insertHolidayQuery);

                holidayStatement.setInt(1, Integer.parseInt(getId));
                holidayStatement.setDate(2, java.sql.Date.valueOf(getHoliday));

                int holidayRows = holidayStatement.executeUpdate();
            }

            for (String phonee : phones) {
                String insertPhoneQuery2 = "INSERT INTO paramedic_phone (paramedic_id, phone) VALUES (?, ?)";
                PreparedStatement phoneStatement2 = connect.prepareStatement(insertPhoneQuery2);

                phoneStatement2.setInt(1, Integer.parseInt(getId));
                phoneStatement2.setString(2, phonee);

                phoneStatement2.executeUpdate();
            }

            for (String holidayy : holidays) {
                String insertHolidayQuery2 = "INSERT INTO paramedic_holiday (paramedic_id, holiday) VALUES (?, ?)";
                PreparedStatement holidayStatement2 = connect.prepareStatement(insertHolidayQuery2);

                holidayStatement2.setInt(1, Integer.parseInt(getId));
                holidayStatement2.setDate(2, java.sql.Date.valueOf(holidayy));

                holidayStatement2.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding paramedic: " + ex.getMessage());
        }
    });
});

        // select one 
        
        selectOne.addActionListener((c) -> {
                   paramedicPanel2.removeAll();
    paramedicPanel2.repaint();
    JFrame idFrame = Frame("Enter Paramedic ID", new GridLayout(1, 1), 500, 400);
    JPanel idPanel = Create.Panel(null, Color.white);

    JLabel idLabel = Label("Paramedic ID", 20, 30, 150, 30, 20);
    JTextField idField = TextField(180, 30, 200, 30);

    JButton ok = Button("OK", 190, 290, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Paramedic ID.");
        } else {
            idFrame.setVisible(false);
            int paramedicId = Integer.parseInt(idField.getText());

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                String query = "SELECT * FROM Paramedic WHERE paramedic_id = ?";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, paramedicId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        JLabel firstNameLabel = Label("First Name: " + resultSet.getString("first_name"), 50, 20, 400, 30, 20);
                        paramedicPanel2.add(firstNameLabel);

                        JLabel lastNameLabel = Label("Last Name: " + resultSet.getString("last_name"), 50, 60, 400, 30, 20);
                        paramedicPanel2.add(lastNameLabel);

                        JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 100, 400, 30, 20);
                        paramedicPanel2.add(addressLabel);

                        JLabel startDateLabel = Label("Start Date: " + resultSet.getDate("start_date"), 50, 140, 400, 30, 20);
                        paramedicPanel2.add(startDateLabel);

                        JLabel salaryLabel = Label("Salary: " + resultSet.getFloat("salary"), 50, 180, 400, 30, 20);
                        paramedicPanel2.add(salaryLabel);

                        JLabel yearsExperienceLabel = Label("Years of Experience: " + resultSet.getInt("years_of_experience"), 50, 220, 400, 30, 20);
                        paramedicPanel2.add(yearsExperienceLabel);

                        JLabel shiftLabel = Label("Shift: " + resultSet.getString("shift"), 50, 260, 400, 30, 20);
                        paramedicPanel2.add(shiftLabel);

                        JLabel extraHoursLabel = Label("Extra Hours: " + resultSet.getFloat("extra_hours"), 50, 300, 400, 30, 20);
                        paramedicPanel2.add(extraHoursLabel);

                        JLabel genderLabel = Label("Gender: " + resultSet.getString("genderpar"), 50, 340, 400, 30, 20);
                        paramedicPanel2.add(genderLabel);

                        JLabel ambulanceIdLabel = Label("Ambulance ID: " + resultSet.getInt("ambulance_id"), 50, 380, 400, 30, 20);
                        paramedicPanel2.add(ambulanceIdLabel);

                        JLabel driverIdLabel = Label("Driver ID: " + resultSet.getInt("driver_id"), 50, 420, 400, 30, 20);
                        paramedicPanel2.add(driverIdLabel);

                        JLabel receptionistIdLabel = Label("Receptionist ID: " + resultSet.getInt("receptionist_id"), 50, 460, 400, 30, 20);
                        paramedicPanel2.add(receptionistIdLabel);

                        JLabel managerIdLabel = Label("Manager ID: " + resultSet.getInt("manager_id"), 50, 500, 400, 30, 20);
                        paramedicPanel2.add(managerIdLabel);
                    } else {
                        JOptionPane.showMessageDialog(null, "No paramedic found with the given ID.");
                        return;
                    }
                }

                // Phone Numbers
                JLabel phoneHeader = Label("Phone(s):", 50, 540, 400, 30, 20);
                paramedicPanel2.add(phoneHeader);
                int yOffset = 580;

                String phoneQuery = "SELECT phone FROM paramedic_phone WHERE paramedic_id = ?";
                try (PreparedStatement phoneStmt = connect.prepareStatement(phoneQuery)) {
                    phoneStmt.setInt(1, paramedicId);
                    ResultSet phoneResult = phoneStmt.executeQuery();

                    while (phoneResult.next()) {
                        JLabel phoneLabel = Label(phoneResult.getString("phone"), 50, yOffset, 400, 30, 20);
                        paramedicPanel2.add(phoneLabel);
                        yOffset += 40;
                    }
                }

                // Holidays
                JLabel holidayHeader = Label("Holiday(s):", 50, yOffset, 400, 30, 20);
                paramedicPanel2.add(holidayHeader);
                yOffset += 40;

                String holidayQuery = "SELECT holiday FROM paramedic_holiday WHERE paramedic_id = ?";
                try (PreparedStatement holidayStmt = connect.prepareStatement(holidayQuery)) {
                    holidayStmt.setInt(1, paramedicId);
                    ResultSet holidayResult = holidayStmt.executeQuery();

                    while (holidayResult.next()) {
                        JLabel holidayLabel = Label(holidayResult.getDate("holiday").toString(), 50, yOffset, 400, 30, 20);
                        paramedicPanel2.add(holidayLabel);
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

            paramedicFrame.add(paramedicPanel2);
            paramedicFrame.setVisible(true);
        }
    });
});

        
        
                
                //select all
                
        selectAll.addActionListener((e) -> {
       paramedicPanel2.removeAll();
    paramedicPanel2.repaint();
    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable paramedicTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(paramedicTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        paramedicFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Paramedic table
        String query = "SELECT paramedic_id, first_name, last_name, address, salary, start_date, " +
                       "years_of_experience, shift, extra_hours, genderpar, ambulance_id, driver_id, " +
                       "receptionist_id, manager_id FROM Paramedic";

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
            paramedicTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        paramedicFrame.setVisible(true);

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
