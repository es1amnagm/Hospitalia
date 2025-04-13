package hospitalia;

import static hospitalia.Create.Font;
import static hospitalia.Create.screenSize;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Pharmacitucal {
    private JFrame frame;
    private JPanel leftPanel, rightPanel;
    private JTextField patientIdField;
    private JButton searchButton, showMedicineButton, checkPharmacyButton, checkStoreButton, makeOrderButton;
    private JTextArea treatmentDetails;
    private Connection connection;

    public Pharmacitucal() {
        
        
        
    
        
        frame = new JFrame("Patient Treatment Search");
        frame.setSize(screenSize.width + 10, screenSize.height - 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Left Panel (Dark Blue-Green)
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(17, 92, 115));
        leftPanel.setBounds(0, 0, 350, screenSize.height);

        // Right Panel (White)
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(350, 0, screenSize.width, screenSize.height);

        // Components in Left Panel
        JLabel label = new JLabel("Enter Patient ID:");
        label.setBounds(50, 50, 200, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        
      //   Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         frame.dispose();
        });
 frame.add(exitButton);
        
        
        patientIdField = new JTextField();
        patientIdField.setBounds(50, 90, 200, 30);

        searchButton = createStyledButton("Search Treatment", 50, 140, 200, 40);
        searchButton.addActionListener(e -> searchPatientTreatment());

        checkPharmacyButton = createStyledButton("Check Pharmacy Medicines", 50, 200, 200, 40);
        checkPharmacyButton.addActionListener(e -> checkMedicineAvailability("Pharmacy_and_Medicine"));

        checkStoreButton = createStyledButton("Check Store Medicines", 50, 260, 200, 40);
        checkStoreButton.addActionListener(e -> checkMedicineAvailability("Store_and_Medicine"));

        makeOrderButton = createStyledButton("Make Order", 50, 320, 200, 40);
        makeOrderButton.setEnabled(false);
        makeOrderButton.addActionListener(e -> makeOrder());

        leftPanel.add(label);
        leftPanel.add(patientIdField);
        leftPanel.add(searchButton);
        leftPanel.add(checkPharmacyButton);
        leftPanel.add(checkStoreButton);
        leftPanel.add(makeOrderButton);

        // Components in Right Panel
        treatmentDetails = new JTextArea();
        treatmentDetails.setBounds(20, 20, 450, 300);
        treatmentDetails.setEditable(false);
        treatmentDetails.setFont(new Font("Arial", Font.PLAIN, 14));

        showMedicineButton = createStyledButton("Show Medicines", 550, 650, 200, 40);
        showMedicineButton.setEnabled(false);
        showMedicineButton.addActionListener(e -> showMedicines());

        rightPanel.add(treatmentDetails);
        rightPanel.add(showMedicineButton);

        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.setVisible(true);

        JButton addMedicineButton = createStyledButton("Add Medicine to Pharmacy", 50, 380, 200, 40);
addMedicineButton.addActionListener(e -> addMedicineToPharmacy());
leftPanel.add(addMedicineButton);

        // Database connection
        connection = connect();
    }

    public static Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlserver://Es1am-Najm:1433;databaseName=Hospitalia;encrypt=false;integratedSecurity=true";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Connection Failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }

    private void searchPatientTreatment() {
        String patientId = patientIdField.getText().trim();
        if (patientId.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a Patient ID!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String query = "SELECT treatment_id, date, state FROM Treatment WHERE patient_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(patientId));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                JOptionPane.showMessageDialog(frame, "Please enter a correct ID!", "Error", JOptionPane.ERROR_MESSAGE);
                treatmentDetails.setText("");
                showMedicineButton.setEnabled(false);
            } else {
                int treatmentId = resultSet.getInt("treatment_id");
                String date = resultSet.getString("date");
                String state = resultSet.getString("state");

                treatmentDetails.setText("Patient ID: " + patientId +
                        "\nTreatment ID: " + treatmentId +
                        "\nDate: " + date +
                        "\nState: " + state);

                showMedicineButton.setEnabled(true);
                showMedicineButton.putClientProperty("treatment_id", treatmentId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database Error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showMedicines() {
        int treatmentId = (int) showMedicineButton.getClientProperty("treatment_id");

        try {
            String query = "SELECT medicine_name FROM treatment_and_medicine WHERE treatment_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, treatmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder medicines = new StringBuilder("Medicines for Treatment ID: " + treatmentId + "\n");
            while (resultSet.next()) {
                medicines.append("- ").append(resultSet.getString("medicine_name")).append("\n");
            }

            JOptionPane.showMessageDialog(null, medicines.toString(), "Medicines", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching medicines!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

private void checkMedicineAvailability(String tableName) {
    String patientId = patientIdField.getText().trim();
    if (patientId.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Please enter a Patient ID!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // Query for medicines that the patient is prescribed but not available in the pharmacy
        String query = "SELECT tm.medicine_name " +
                       "FROM treatment_and_medicine tm " +
                       "LEFT JOIN pharmacy_and_medicine pm ON tm.medicine_name = pm.medicine_name " +
                       "WHERE tm.treatment_id =? " +
                       "AND tm.medicine_name NOT IN (SELECT medicine_name FROM pharmacy_and_medicine WHERE pharmacy_id IN (SELECT pharmacy_id FROM Pharmacy))"; // Check medicines not in the pharmacy

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, Integer.parseInt(patientId));  // Use the provided patient ID here
        ResultSet rs = stmt.executeQuery();

        StringBuilder missingMedicines = new StringBuilder();
        boolean missing = false;

        while (rs.next()) {
            missingMedicines.append(rs.getString("medicine_name")).append(", ");
            missing = true;  // Flag when a missing medicine is found
        }

        if (!missing) {
            JOptionPane.showMessageDialog(frame, "All prescribed medicines are available in the pharmacy.", "Medicine Availability", JOptionPane.INFORMATION_MESSAGE);
            makeOrderButton.setEnabled(false);
        } else {
            // Check if the missing medicines exist in the store
          String storeCheckQuery = "SELECT sm.medicine_name " +
                         "FROM store_and_medicine sm " +
                         "WHERE sm.medicine_name IN (" + 
                         missingMedicines.toString().replaceAll("([^,]+)", "'$1'") + ")";

// Execute the query
ResultSet storeCheckResult = connection.prepareStatement(storeCheckQuery).executeQuery();
            StringBuilder storeMedicines = new StringBuilder();
            boolean storeAvailable = false;

            while (storeCheckResult.next()) {
                storeMedicines.append(storeCheckResult.getString("medicine_name")).append(", ");
                storeAvailable = true; // Medicine found in store
            }

            if (storeAvailable) {
                // Remove the trailing comma and space for a cleaner display
                storeMedicines.setLength(storeMedicines.length() - 2); // Remove the trailing comma and space
                JOptionPane.showMessageDialog(frame, "The following medicines are missing in the pharmacy but available in the store: " + storeMedicines,
                        "Medicine Availability", JOptionPane.WARNING_MESSAGE);
                makeOrderButton.setEnabled(true); // Enable makeOrder button
            } else {
                // No medicines found in store
                missingMedicines.setLength(missingMedicines.length() - 2); // Remove the trailing comma and space
                JOptionPane.showMessageDialog(frame, "The following prescribed medicines for Patient ID " + patientId +
                        " are not available in the pharmacy or the store: " + missingMedicines,
                        "Medicine Availability", JOptionPane.WARNING_MESSAGE);
                makeOrderButton.setEnabled(false); // Keep makeOrder button disabled
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error while checking medicine availability!", "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}



    private void makeOrder() {
        String workerStoreId = JOptionPane.showInputDialog(frame, "Enter Worker Store ID:");
        String orderDescription = JOptionPane.showInputDialog(frame, "Enter Order Description:");

        if (workerStoreId == null || workerStoreId.trim().isEmpty() || orderDescription == null || orderDescription.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String query = "INSERT INTO pharmacyutical_call_worker_store_to_get_medicine (worker_store_id, pharmacyutical_id, ordder) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(workerStoreId));
            preparedStatement.setInt(2, Integer.parseInt(patientIdField.getText().trim()));
            preparedStatement.setString(3, orderDescription);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Order placed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error placing order!", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JButton createStyledButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(110, 181, 178));
        button.setForeground(Color.WHITE);
        return button;
    }
 private void addMedicineToPharmacy() {
    // Get input from the user
    String pharmacyId = JOptionPane.showInputDialog(frame, "Enter Pharmacy ID:");
    String medicineName = JOptionPane.showInputDialog(frame, "Enter Medicine Name:");
    String numberOfBoxes = JOptionPane.showInputDialog(frame, "Enter Number of Medicine Boxes:");

    // Validate input
    if (pharmacyId == null || pharmacyId.trim().isEmpty() ||
        medicineName == null || medicineName.trim().isEmpty() ||
        numberOfBoxes == null || numberOfBoxes.trim().isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        String query = "INSERT INTO pharmacy_and_medicine (pharmacy_id, medicine_name, number_of_medicine_box) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, Integer.parseInt(pharmacyId));
        preparedStatement.setString(2, medicineName);
        preparedStatement.setInt(3, Integer.parseInt(numberOfBoxes));

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(frame, "Medicine added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Failed to add medicine!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error while adding medicine!", "Database Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Invalid input! Please enter numeric values for IDs and number of boxes.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}

}