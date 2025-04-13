package hospitalia;

import static hospitalia.Create.*;
import static hospitalia.GUI.screenSize;
import java.awt.*;

import java.sql.*;

import javax.swing.*;

import javax.swing.JTextField;

public class Paramedic {

    public Paramedic() {

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
        
        

        JButton showOrders = Button("Show Orders", 50, 40, 200, 40, 20, Color.black);

        paramedicPanel.add(showOrders);
        showOrders.addActionListener((e) -> {
                   paramedicPanel2.removeAll();
    paramedicPanel2.repaint();
            JFrame idFrame = Frame("Enter Paramedic ID", new GridLayout(1, 1), 500, 400);
            JPanel idPanel = Create.Panel(null, Color.white);
            idFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // ID Input
            JLabel idLabel = Label("Paramedic ID", 30, 30, 200, 30, 25);
            JTextField idField = TextField(210, 30, 250, 30);

            // OK Button
            JButton ok = Button("OK", 190, 290, 100, 30);

            idFrame.add(idPanel);
            idPanel.add(idLabel);
            idPanel.add(idField);
            idPanel.add(ok);

            // OK Button Listener
            ok.addActionListener((a) -> {
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Paramedic ID.");
                } else {
                    idFrame.setVisible(false);
                    int paramedicId = Integer.parseInt(idField.getText()); // Get user input

                    // New panel for displaying paramedic order data
                    paramedicPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);
                    paramedicFrame.add(paramedicPanel2);

                    // Fetch data from the database
                    java.sql.Connection connect = null;

                    try {
                        connect = DatabaseConnection.connect();
                        if (connect == null) {
                            JOptionPane.showMessageDialog(null, "Database connection failed.");
                            return;
                        }

                        // Query to get all required data for the paramedic
                        String query = """
                    SELECT receptionist_id, paramedic_id, date, address
                    FROM receptionist_order_paramedic
                    WHERE paramedic_id = ?;
                """;

                        try (PreparedStatement stmt = connect.prepareStatement(query)) {
                            stmt.setInt(1, paramedicId);
                            ResultSet resultSet = stmt.executeQuery();

                            if (resultSet.next()) {
                                // Create labels for each field
                                JLabel receptionistIdLabel = Label("Receptionist ID: " + resultSet.getInt("receptionist_id"), 50, 20, 400, 60, 30);
                                paramedicPanel2.add(receptionistIdLabel);

                                JLabel paramedicIdLabel = Label("Paramedic ID: " + resultSet.getInt("paramedic_id"), 50, 80, 400, 60, 30);
                                paramedicPanel2.add(paramedicIdLabel);

                                JLabel dateLabel = Label("Date: " + resultSet.getDate("date"), 50, 140, 400, 60, 30);
                                paramedicPanel2.add(dateLabel);

                                JLabel addressLabel = Label("Address: " + resultSet.getString("address"), 50, 200, 400, 60, 30);
                                paramedicPanel2.add(addressLabel);
                            } else {
                                JOptionPane.showMessageDialog(null, "No records found for the given Paramedic ID.");
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

                    // Show the frame with the data labels
                    paramedicFrame.setVisible(true);
                }
            });
        });

    }

}
