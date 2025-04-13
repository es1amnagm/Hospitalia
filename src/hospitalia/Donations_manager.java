package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Donations_manager {
    
    public Donations_manager(){
    JFrame donationsManagerFrame = Frame("Donations Manager", null);
JPanel donationsManagerPanel = Panel(null, new Color(17, 92, 115));

 donationsManagerPanel.setBounds(0, 0, 350, screenSize.height);

JPanel donationsManagerPanel2 = Panel(null, Color.white);

 donationsManagerPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

donationsManagerFrame.add(donationsManagerPanel);
donationsManagerFrame.add(donationsManagerPanel2);



// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 400, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         donationsManagerFrame.dispose();
        });
 donationsManagerFrame.add(exitButton);

JButton selectOneDonation = Button("Select one ", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectAllDonations = Button("Select All", 50, 240, 240, 40, 35, new Color(110, 181, 178));
  
 
donationsManagerPanel.add(selectAllDonations);
donationsManagerPanel.add(selectOneDonation);

 // select one 
 
 selectOneDonation.addActionListener((c) -> {
           donationsManagerPanel2.removeAll();
    donationsManagerPanel2.repaint();
    JFrame idFrame = Frame("Enter Donation ID", new GridLayout(1, 1), 500, 300);
    JPanel idPanel = Create.Panel(null, Color.white);

    JLabel idLabel = Label("Donation ID", 90, 30, 120, 30, 20);
    JTextField idField = TextField(220, 30, 200, 30);

    JButton ok = Button("OK", 190, 200, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Donation ID.");
        } else {
            idFrame.setVisible(false);
            int donationId = Integer.parseInt(idField.getText());

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                String query = "SELECT * FROM Donations WHERE donation_id = ?";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, donationId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        JFrame donationFrame = Frame("Donation Details", new GridLayout(1, 1), 500, 500);
                        JPanel donationPanel = Create.Panel(null, Color.white);

                        JLabel nameLabel = Label("Donor Name: " + resultSet.getString("name_of_donar"), 50, 20, 400, 30, 20);
                        donationPanel.add(nameLabel);

                        JLabel addressLabel = Label("Donor Address: " + resultSet.getString("address_of_donar"), 50, 60, 400, 30, 20);
                        donationPanel.add(addressLabel);

                        JLabel amountLabel = Label("Amount: " + resultSet.getFloat("amount"), 50, 100, 400, 30, 20);
                        donationPanel.add(amountLabel);

                        JLabel dateLabel = Label("Date: " + resultSet.getDate("date"), 50, 140, 400, 30, 20);
                        donationPanel.add(dateLabel);

                        JLabel receptionistLabel = Label("Receptionist ID: " + resultSet.getInt("receptionist_id"), 50, 180, 400, 30, 20);
                        donationPanel.add(receptionistLabel);

                        JLabel managerLabel = Label("Manager ID: " + resultSet.getInt("manager_id"), 50, 220, 400, 30, 20);
                        donationPanel.add(managerLabel);

                        donationFrame.add(donationPanel);
                        donationFrame.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "No donation found with the given ID.");
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
        }
    });
});



 
 
   // select All
   
   selectAllDonations.addActionListener((e) -> {
           donationsManagerPanel2.removeAll();
    donationsManagerPanel2.repaint();
    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable donationsTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(donationsTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        donationsManagerFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Donations table
        String query = "SELECT donation_id, name_of_donar, address_of_donar, amount, date, receptionist_id, manager_id FROM Donations";

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
            donationsTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        donationsManagerFrame.setVisible(true);

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