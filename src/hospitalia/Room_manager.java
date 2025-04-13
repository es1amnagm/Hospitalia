package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Room_manager {
    
    
    public Room_manager()
    {
        
        
        
        
        
        JFrame roomFrame = Frame("Room", null);
JPanel roomPanel = Panel(null, new Color(17, 92, 115));

roomPanel.setBounds(0, 0, 350, screenSize.height);

JPanel roomPanel2 = Panel(null, Color.white);

roomPanel2.setBounds(350, 0, screenSize.width - 350, screenSize.height);

roomFrame.add(roomPanel);
roomFrame.add(roomPanel2);
// Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds(125, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         roomFrame.dispose();
        });
 roomFrame.add(exitButton);
 
JButton addRoom = Button("Add", 50, 40, 240, 40, 35, new Color(110, 181, 178));
JButton selectOne = Button("Select One", 50, 240, 240, 40, 35, new Color(110, 181, 178));
JButton selectAll = Button("Select All", 50, 440, 240, 40, 35, new Color(110, 181, 178));

roomPanel.add(addRoom);
roomPanel.add(selectAll);
roomPanel.add(selectOne);

addRoom.addActionListener((e) -> {
      roomPanel2.removeAll();
    roomPanel2.repaint();
    JButton add = Button("Add", 550, 650, 180, 80, 70, new Color(110, 181, 178));
    add.setBackground(Color.white);
    roomPanel2.add(add);
    roomPanel2.setVisible(true);

    JLabel roomId = Label("Room ID", 150, 20, 200, 30, 35);
    JTextField roomIdField = TextField(320, 25, 300, 30);

    JLabel floor = Label("Floor", 120, 100, 200, 30, 35);
    JTextField floorField = TextField(320, 105, 300, 30);

    JLabel beds = Label("Beds", 120, 180, 200, 30, 35);
    JTextField bedsField = TextField(320, 185, 300, 30);

    JLabel capacity = Label("Capacity", 120, 260, 200, 30, 35);
    JTextField capacityField = TextField(320, 265, 300, 30);

    roomPanel2.add(roomId);
    roomPanel2.add(roomIdField);
    roomPanel2.add(floor);
    roomPanel2.add(floorField);
    roomPanel2.add(beds);
    roomPanel2.add(bedsField);
    roomPanel2.add(capacity);
    roomPanel2.add(capacityField);

    add.addActionListener((a) -> {
        String getRoomId = roomIdField.getText();
        String getFloor = floorField.getText();
        String getBeds = bedsField.getText();
        String getCapacity = capacityField.getText();

        java.sql.Connection connect = DatabaseConnection.connect();

        try (connect) {
            String insertRoomQuery = "INSERT INTO Room (room_id, floor, beds, capacity) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement roomStatement = connect.prepareStatement(insertRoomQuery);

            roomStatement.setInt(1, Integer.parseInt(getRoomId));
            roomStatement.setInt(2, Integer.parseInt(getFloor));
            roomStatement.setInt(3, Integer.parseInt(getBeds));
            roomStatement.setInt(4, Integer.parseInt(getCapacity));

            int roomRows = roomStatement.executeUpdate();
            if (roomRows > 0) {
                JOptionPane.showMessageDialog(null, "Room added successfully!");
                roomPanel2.setVisible(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding room: " + ex.getMessage());
        }
    });
});

        
        
        
        // select one 
        
        
        selectOne.addActionListener((c) -> {
              roomPanel2.removeAll();
    roomPanel2.repaint();
    JFrame idFrame = Frame("Enter Room ID", new GridLayout(1, 1), 500, 300);
    JPanel idPanel = Create.Panel(null, Color.white);

    JLabel idLabel = Label("Room ID", 90, 30, 120, 30, 20);
    JTextField idField = TextField(220, 30, 200, 30);

    JButton ok = Button("OK", 190, 200, 100, 30);

    idFrame.add(idPanel);
    idPanel.add(idLabel);
    idPanel.add(idField);
    idPanel.add(ok);

    ok.addActionListener((a) -> {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Room ID.");
        } else {
            idFrame.setVisible(false);
            int roomId = Integer.parseInt(idField.getText());

            java.sql.Connection connect = null;

            try {
                connect = DatabaseConnection.connect();
                if (connect == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                String query = "SELECT * FROM Room WHERE room_id = ?";
                try (PreparedStatement stmt = connect.prepareStatement(query)) {
                    stmt.setInt(1, roomId);
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
 

                        JLabel floorLabel = Label("Floor: " + resultSet.getInt("floor"), 50, 20, 400, 30, 20);
                        roomPanel2.add(floorLabel);

                        JLabel bedsLabel = Label("Beds: " + resultSet.getInt("beds"), 50, 60, 400, 30, 20);
                        roomPanel2.add(bedsLabel);

                        JLabel capacityLabel = Label("Capacity: " + resultSet.getInt("capacity"), 50, 100, 400, 30, 20);
                        roomPanel2.add(capacityLabel);

                        roomFrame.add(roomPanel2);
                        roomFrame.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "No room found with the given ID.");
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

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //select all
        selectAll.addActionListener((e) -> {
  roomPanel2.removeAll();
    roomPanel2.repaint();
    // Create the frame
    // Create the panel
    JPanel selectAllPanel = new JPanel();
    selectAllPanel.setLayout(new BorderLayout());
    selectAllPanel.setBounds(350, 0, screenSize.width - 350, screenSize.height);
    JTable roomTable = new JTable();

    java.sql.Connection connect = null;

    try {
        connect = DatabaseConnection.connect();
        if (connect == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed.");
            return;
        }
        JScrollPane scrollPane = new JScrollPane(roomTable);
        selectAllPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        roomFrame.add(selectAllPanel, BorderLayout.CENTER);

        // Query to select all rows from the Room table
        String query = "SELECT room_id, floor, beds, capacity FROM Room";

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
            roomTable.setModel(tableModel);
        }

        // Close the connection
        connect.close();

        // Display the frame
        roomFrame.setVisible(true);

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
