package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Worker_Store_manager {
    
    
    
    
    public Worker_Store_manager()
    {
        
        
        ArrayList<String> phones = new ArrayList<>();
ArrayList<String> holidays = new ArrayList<>();

JFrame workerStoreFrame = Frame("Worker Store", null);
JPanel workerStorePanel = Panel(null, new Color(17, 92, 115));

workerStorePanel.setBounds(0, 0, 350, screenSize.height);

JPanel workerStorePanel2 = Panel(null, Color.white);

workerStorePanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

workerStoreFrame.add(workerStorePanel);
workerStoreFrame.add(workerStorePanel2);

// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         workerStoreFrame.dispose();
        });
 workerStoreFrame.add(exitButton);
  workerStorePanel2.removeAll();
    workerStorePanel2.repaint();
JButton addWorkerStore = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));
JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));

workerStorePanel.add(addWorkerStore);
workerStorePanel.add(selectAll);
workerStorePanel.add(selectOne);

addWorkerStore.addActionListener((e) -> {
      workerStorePanel2.removeAll();
    workerStorePanel2.repaint();
    JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
    add.setBackground(Color.white);
    workerStorePanel2.add(add);
    workerStorePanel2.setVisible(true);

    JButton addPhones = Button("Add-Phones", 870, 630, 300, 40, 50, new Color(110, 181, 178));
    addPhones.setBackground(Color.white);
    workerStorePanel2.add(addPhones);

    JButton addHolidays = Button("Add-Holidays", 30, 630, 350, 40, 50, new Color(110, 181, 178));
    addHolidays.setBackground(Color.white);
    workerStorePanel2.add(addHolidays);

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

    JLabel salary = Label("Salary", 120, 500, 200, 30, 35);
    JTextField salaryField = TextField(320, 505, 300, 30);

    JLabel shift = Label("Shift", 970, 20, 200, 30, 35);
    JTextField shiftField = TextField(650, 25, 300, 30);

    JLabel gender = Label("Gender", 970, 100, 200, 30, 35);
    JTextField genderField = TextField(650, 105, 300, 30);

    JLabel storeId = Label("Store ID", 960, 180, 230, 30, 35);
    JTextField storeIdField = TextField(650, 185, 300, 30);

    JLabel managerId = Label("Manager ID", 970, 260, 200, 30, 35);
    JTextField managerIdField = TextField(650, 265, 300, 30);

    JLabel phone = Label("Phone", 970, 340, 200, 30, 35);
    JTextField phoneField = TextField(650, 345, 300, 30);

    JLabel holiday = Label("Holiday", 970, 420, 200, 30, 35);
    JTextField holidayField = TextField(650, 425, 300, 30);

    workerStorePanel2.add(id);
    workerStorePanel2.add(idField);
    workerStorePanel2.add(firstName);
    workerStorePanel2.add(firstNameField);
    workerStorePanel2.add(lastName);
    workerStorePanel2.add(lastNameField);
    workerStorePanel2.add(address);
    workerStorePanel2.add(addressField);
    workerStorePanel2.add(salary);
    workerStorePanel2.add(salaryField);
    workerStorePanel2.add(startDate);
    workerStorePanel2.add(startDateField);
    workerStorePanel2.add(shift);
    workerStorePanel2.add(shiftField);
    workerStorePanel2.add(extraHours);
    workerStorePanel2.add(extraHoursField);
    workerStorePanel2.add(gender);
    workerStorePanel2.add(genderField);
    workerStorePanel2.add(storeId);
    workerStorePanel2.add(storeIdField);
    workerStorePanel2.add(managerId);
    workerStorePanel2.add(managerIdField);
    workerStorePanel2.add(phone);
    workerStorePanel2.add(phoneField);
    workerStorePanel2.add(holiday);
    workerStorePanel2.add(holidayField);

    addPhones.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            workerStorePanel2.setVisible(false);
            JPanel addPhonesPanel = Panel(null, Color.white);

            workerStoreFrame.add(addPhonesPanel);
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
                workerStorePanel2.setVisible(true);
            });
        }
    });

    addHolidays.addActionListener((b) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the ID first");
        } else {
            workerStorePanel2.setVisible(false);
            JPanel addHolidaysPanel = Panel(null, Color.white);

            workerStoreFrame.add(addHolidaysPanel);
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
                workerStorePanel2.setVisible(true);
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
        String getShift = shiftField.getText();
        String getExtraHours = extraHoursField.getText();
        String getGender = genderField.getText();
        String getStoreId = storeIdField.getText();
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
            String insertWorkerStoreQuery = "INSERT INTO worker_store (worker_store_id, first_name, last_name, address, salary, start_date, "
                    + "shift, extra_hours, genderws, store_id, manager_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement workerStoreStatement = connect.prepareStatement(insertWorkerStoreQuery);


        workerStoreStatement.setInt(1, Integer.parseInt(getId));
        workerStoreStatement.setString(2, getFirstName);
        workerStoreStatement.setString(3, getLastName);
        workerStoreStatement.setString(4, getAddress);
        workerStoreStatement.setDouble(5, Double.parseDouble(getSalary));
        workerStoreStatement.setDate(6, java.sql.Date.valueOf(getStartDate));
         workerStoreStatement.setString(7, getShift);
        workerStoreStatement.setFloat(8, Float.parseFloat(getExtraHours));
        workerStoreStatement.setString(9, getGender);
                workerStoreStatement.setString(10, getStoreId);

         workerStoreStatement.setInt(11, Integer.parseInt(getManagerId));

        int pharmacyuticalRows = workerStoreStatement.executeUpdate();
        if (pharmacyuticalRows > 0) {
            JOptionPane.showMessageDialog(null, "worker_store added successfully!");
            workerStorePanel2.setVisible(false);
        }

        if (!getPhone.isEmpty()) {
            String insertPhoneQuery = "INSERT INTO worker_store_phone (worker_store_id, phone) VALUES (?, ?)";
            PreparedStatement phoneStatement = connect.prepareStatement(insertPhoneQuery);

            phoneStatement.setInt(1, Integer.parseInt(getId));
            phoneStatement.setString(2, getPhone);

            int phoneRows = phoneStatement.executeUpdate();
        }

        if (!getHoliday.isEmpty()) {
            String insertHolidayQuery = "INSERT INTO worker_store_holiday (worker_store_id, holiday) VALUES (?, ?)";
            PreparedStatement holidayStatement = connect.prepareStatement(insertHolidayQuery);

            holidayStatement.setInt(1, Integer.parseInt(getId));
            holidayStatement.setDate(2, java.sql.Date.valueOf(getHoliday));

            int holidayRows = holidayStatement.executeUpdate();
        }

        if (!phones.isEmpty()) {
            String insertPhoneQuery2 = "INSERT INTO worker_store_phone (worker_store_id, phone) VALUES (?, ?)";
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
            String insertHolidayQuery2 = "INSERT INTO worker_store_holiday (worker_store_id, holiday) VALUES (?, ?)";
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
        
        
        
        
        
        
        //  select one
        
     selectOne.addActionListener((e) -> {
           workerStorePanel2.removeAll();
    workerStorePanel2.repaint();
    JFrame idFrame = Frame("Enter Worker Store ID", new GridLayout(1, 1), 500, 400);
    JPanel idPanel = Create.Panel(null, Color.white);

    // ID Input
    JLabel idLabel = Label("Worker Store ID", 20, 30, 200, 30, 25);
    JTextField idField = TextField(230, 30, 250, 30);

    // OK Button
    JButton ok = Button("OK", 190, 290, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    // OK Button Listener
    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Worker Store ID.");
        } else {
            idFrame.setVisible(false);

            int workerStoreId = Integer.parseInt(idField.getText()); // Get user input

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                

                // Query to get all required data from the worker_store table
                String query = "SELECT * FROM worker_store WHERE worker_store_id = ?;";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, workerStoreId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        // Display worker store details
                        JLabel firstNameLabel = Label("First Name: " + resultSet.getString("first_name"), 50, 20, 400, 60, 30);
                        workerStorePanel2.add(firstNameLabel);

                        JLabel lastNameLabel = Label("Last Name: " + resultSet.getString("last_name"), 50, 80, 400, 60, 30);
                        workerStorePanel2.add(lastNameLabel);

                        JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 140, 400, 60, 30);
                        workerStorePanel2.add(addressLabel);

                        JLabel startDateLabel = Label("Start Date: " + resultSet.getDate("start_date"), 50, 200, 400, 60, 30);
                        workerStorePanel2.add(startDateLabel);

                        JLabel salaryLabel = Label("Salary: " + resultSet.getDouble("salary"), 50, 260, 400, 60, 30);
                        workerStorePanel2.add(salaryLabel);

                        JLabel shiftLabel = Label("Shift: " + resultSet.getString("shift"), 50, 320, 400, 60, 30);
                        workerStorePanel2.add(shiftLabel);

                        JLabel extraHoursLabel = Label("Extra Hours: " + resultSet.getDouble("extra_hours"), 50, 380, 400, 60, 30);
                        workerStorePanel2.add(extraHoursLabel);

                        JLabel genderLabel = Label("Gender: " + resultSet.getString("genderws"), 50, 440, 400, 60, 30);
                        workerStorePanel2.add(genderLabel);

                        JLabel storeIdLabel = Label("Store ID: " + resultSet.getInt("store_id"), 50, 500, 400, 60, 30);
                        workerStorePanel2.add(storeIdLabel);

                        JLabel managerIdLabel = Label("Manager ID: " + resultSet.getInt("manager_id"), 50, 560, 400, 60, 30);
                        workerStorePanel2.add(managerIdLabel);
                    } else {
                        JOptionPane.showMessageDialog(null, "No Worker Store found with the given ID.");
                        return;
                    }
                }

                // Query to fetch orders for the worker store
                String ordersQuery = """
                    SELECT pcm.pharmacyutical_id, pcm.ordder, pcm.date
                    FROM pharmacyutical_call_worker_store_to_get_medicine pcm
                    WHERE pcm.worker_store_id = ?;
                """;

                try (PreparedStatement ordersStmt = connect.prepareStatement(ordersQuery)) {
                    ordersStmt.setInt(1, workerStoreId);
                    ResultSet ordersResult = ordersStmt.executeQuery();

                    int yOffset = 20; // Start below the worker store details
                    JLabel orderHeader = Label("Orders:", 800, yOffset, 400, 60, 30);
                    workerStorePanel2.add(orderHeader);
                    yOffset += 60;

                    while (ordersResult.next()) {
                        JLabel pharmacyuticalIdLabel = Label("Pharmacyutical ID: " + ordersResult.getInt("pharmacyutical_id"), 800, yOffset, 400, 30, 30);
                        workerStorePanel2.add(pharmacyuticalIdLabel);

                        JLabel orderLabel = Label("Order: " + ordersResult.getString("ordder"), 800, yOffset + 30, 400, 30, 30);
                        workerStorePanel2.add(orderLabel);

                        JLabel dateLabel = Label("Date: " + ordersResult.getDate("date"), 800, yOffset + 60, 400, 30, 30);
                        workerStorePanel2.add(dateLabel);

                        JLabel separatorLabel = Label("------------------------------------", 800, yOffset + 90, 400, 10, 30);
                        workerStorePanel2.add(separatorLabel);

                        yOffset += 110;
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while fetching data.");
            } finally {
                if (connect != null) {
                    try {
                        connect.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            workerStoreFrame.add(workerStorePanel2);
            workerStoreFrame.setVisible(true);
        }
    });
});

        selectAll.addActionListener((e) -> {
  workerStorePanel2.removeAll();
    workerStorePanel2.repaint();
    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable workerStoreTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(workerStoreTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        workerStoreFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Worker_Store table
        String query = "SELECT worker_store_id, first_name, last_name, address, start_date, salary, " +
                       "shift, extra_hours, genderws, store_id, manager_id FROM Worker_Store";

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
            workerStoreTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        workerStoreFrame.setVisible(true);

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
