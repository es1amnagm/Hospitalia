
package hospitalia;



 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlserver://Es1am-Najm:1433;databaseName=Hospitalia;encrypt=false;integratedSecurity=true";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

    























//     JFrame frame = Frame("Manager Table Entry", null, 400, 400);
//
//        // Panel
//        JPanel panel = Panel(null, Color.LIGHT_GRAY);
//
//        // Labels and TextFields
//        JLabel idLabel = Label("Manager ID:", 50, 30, 100, 30);
//        JTextField idField = TextField(150, 30, 200, 30);
//
//        JLabel nameLabel = Label("Name:", 50, 70, 100, 30);
//        JTextField nameField = TextField(150, 70, 200, 30);
//
//        JLabel salaryLabel = Label("Salary:", 50, 110, 100, 30);
//        JTextField salaryField = TextField(150, 110, 200, 30);
//
//        JLabel experienceLabel = Label("Experience:", 50, 150, 100, 30);
//        JTextField experienceField = TextField(150, 150, 200, 30);
//
//        JLabel addressLabel = Label("Address:", 50, 190, 100, 30);
//        JTextField addressField = TextField(150, 190, 200, 30);
//
//        JLabel startDateLabel = Label("Start Date:", 50, 230, 100, 30);
//        JTextField startDateField = TextField(150, 230, 200, 30);
//
//        JLabel genderLabel = Label("Gender:", 50, 270, 100, 30);
//        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"male", "female"});
//        genderCombo.setBounds(150, 270, 200, 30);
//
//        // Buttons
//        JButton submitButton = Button("Submit", 50, 320, 100, 30);
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Collect data
//                String id = idField.getText();
//                String name = nameField.getText();
//                String salary = salaryField.getText();
//                String experience = experienceField.getText();
//                String address = addressField.getText();
//                String startDate = startDateField.getText();
//                String gender = (String) genderCombo.getSelectedItem();
//
//                // Placeholder for database insertion logic
//                System.out.println("Manager Data:");
//                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Experience: " + experience + ", Address: " + address + ", Start Date: " + startDate + ", Gender: " + gender);
//            }
//        });
//
//        JButton resetButton = Button("Reset", 250, 320, 100, 30);
//        resetButton.addActionListener(e -> {
//            idField.setText("");
//            nameField.setText("");
//            salaryField.setText("");
//            experienceField.setText("");
//            addressField.setText("");
//            startDateField.setText("");
//            genderCombo.setSelectedIndex(0);
//        });
//
//        // Add components to panel
//        panel.add(idLabel);
//        panel.add(idField);
//        panel.add(nameLabel);
//        panel.add(nameField);
//        panel.add(salaryLabel);
//        panel.add(salaryField);
//        panel.add(experienceLabel);
//        panel.add(experienceField);
//        panel.add(addressLabel);
//        panel.add(addressField);
//        panel.add(startDateLabel);
//        panel.add(startDateField);
//        panel.add(genderLabel);
//        panel.add(genderCombo);
//        panel.add(submitButton);
//        panel.add(resetButton);
//
//        // Add panel to frame
//        frame.add(panel);
//    }
//
//    // Frame for Doctor Table
//    public static void doctorFrame() {
//        JFrame frame = Frame("Doctor Table Entry", null, 500, 500);
//
//        // Panel
//        JPanel panel = Panel(null, Color.LIGHT_GRAY);
//
//        // Labels and TextFields
//        JLabel idLabel = Label("Doctor ID:", 50, 30, 100, 30);
//        JTextField idField = TextField(150, 30, 200, 30);
//
//        JLabel firstNameLabel = Label("First Name:", 50, 70, 100, 30);
//        JTextField firstNameField = TextField(150, 70, 200, 30);
//
//        JLabel lastNameLabel = Label("Last Name:", 50, 110, 100, 30);
//        JTextField lastNameField = TextField(150, 110, 200, 30);
//
//        JLabel addressLabel = Label("Address:", 50, 150, 100, 30);
//        JTextField addressField = TextField(150, 150, 200, 30);
//
//        JLabel salaryLabel = Label("Salary:", 50, 190, 100, 30);
//        JTextField salaryField = TextField(150, 190, 200, 30);
//
//        JLabel startDateLabel = Label("Start Date:", 50, 230, 100, 30);
//        JTextField startDateField = TextField(150, 230, 200, 30);
//
//        JLabel experienceLabel = Label("Experience:", 50, 270, 100, 30);
//        JTextField experienceField = TextField(150, 270, 200, 30);
//
//        JLabel specialtyLabel = Label("Specialty:", 50, 310, 100, 30);
//        JTextField specialtyField = TextField(150, 310, 200, 30);
//
//        JLabel genderLabel = Label("Gender:", 50, 350, 100, 30);
//        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"male", "female"});
//        genderCombo.setBounds(150, 350, 200, 30);
//
//        // Buttons
//        JButton submitButton = Button("Submit", 50, 400, 100, 30);
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Collect data
//                String id = idField.getText();
//                String firstName = firstNameField.getText();
//                String lastName = lastNameField.getText();
//                String address = addressField.getText();
//                String salary = salaryField.getText();
//                String startDate = startDateField.getText();
//                String experience = experienceField.getText();
//                String specialty = specialtyField.getText();
//                String gender = (String) genderCombo.getSelectedItem();
//
//                // Placeholder for database insertion logic
//                System.out.println("Doctor Data:");
//                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Address: " + address + ", Salary: " + salary + ", Start Date: " + startDate + ", Experience: " + experience + ", Specialty: " + specialty + ", Gender: " + gender);
//            }
//        });
//
//        JButton resetButton = Button("Reset", 250, 400, 100, 30);
//        resetButton.addActionListener(e -> {
//            idField.setText("");
//            firstNameField.setText("");
//            lastNameField.setText("");
//            addressField.setText("");
//            salaryField.setText("");
//            startDateField.setText("");
//            experienceField.setText("");
//            specialtyField.setText("");
//            genderCombo.setSelectedIndex(0);
//        });
//
//        // Add components to panel
//        panel.add(idLabel);
//        panel.add(idField);
//        panel.add(firstNameLabel);
//        panel.add(firstNameField);
//        panel.add(lastNameLabel);
//        panel.add(lastNameField);
//        panel.add(addressLabel);
//        panel.add(addressField);
//        panel.add(salaryLabel);
//        panel.add(salaryField);
//        panel.add(startDateLabel);
//        panel.add(startDateField);
//        panel.add(experienceLabel);
//        panel.add(experienceField);
//        panel.add(specialtyLabel);
//        panel.add(specialtyField);
//        panel.add(genderLabel);
//        panel.add(genderCombo);
//        panel.add(submitButton);
//        panel.add(resetButton);
//
//        // Add panel to frame
//        frame.add(panel);
//    }
//
//
//
//
//
//  JFrame frame = Frame("Nurse Table Entry", null, 500, 500);
//
//        // Panel
//        JPanel panel = Panel(null, Color.LIGHT_GRAY);
//
//        // Labels and TextFields
//        JLabel idLabel = Label("Nurse ID:", 50, 30, 100, 30);
//        JTextField idField = TextField(150, 30, 200, 30);
//
//        JLabel firstNameLabel = Label("First Name:", 50, 70, 100, 30);
//        JTextField firstNameField = TextField(150, 70, 200, 30);
//
//        JLabel lastNameLabel = Label("Last Name:", 50, 110, 100, 30);
//        JTextField lastNameField = TextField(150, 110, 200, 30);
//
//        JLabel addressLabel = Label("Address:", 50, 150, 100, 30);
//        JTextField addressField = TextField(150, 150, 200, 30);
//
//        JLabel salaryLabel = Label("Salary:", 50, 190, 100, 30);
//        JTextField salaryField = TextField(150, 190, 200, 30);
//
//        JLabel startDateLabel = Label("Start Date:", 50, 230, 100, 30);
//        JTextField startDateField = TextField(150, 230, 200, 30);
//
//        JLabel experienceLabel = Label("Experience:", 50, 270, 100, 30);
//        JTextField experienceField = TextField(150, 270, 200, 30);
//
//        JLabel specialtyLabel = Label("Specialty:", 50, 310, 100, 30);
//        JTextField specialtyField = TextField(150, 310, 200, 30);
//
//        JLabel genderLabel = Label("Gender:", 50, 350, 100, 30);
//        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"male", "female"});
//        genderCombo.setBounds(150, 350, 200, 30);
//
//        // Buttons
//        JButton submitButton = Button("Submit", 50, 400, 100, 30);
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Collect data
//                String id = idField.getText();
//                String firstName = firstNameField.getText();
//                String lastName = lastNameField.getText();
//                String address = addressField.getText();
//                String salary = salaryField.getText();
//                String startDate = startDateField.getText();
//                String experience = experienceField.getText();
//                String specialty = specialtyField.getText();
//                String gender = (String) genderCombo.getSelectedItem();
//
//                // Placeholder for database insertion logic
//                System.out.println("Nurse Data:");
//                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Address: " + address + ", Salary: " + salary + ", Start Date: " + startDate + ", Experience: " + experience + ", Specialty: " + specialty + ", Gender: " + gender);
//            }
//        });
//
//        JButton resetButton = Button("Reset", 250, 400, 100, 30);
//        resetButton.addActionListener(e -> {
//            idField.setText("");
//            firstNameField.setText("");
//            lastNameField.setText("");
//            addressField.setText("");
//            salaryField.setText("");
//            startDateField.setText("");
//            experienceField.setText("");
//            specialtyField.setText("");
//            genderCombo.setSelectedIndex(0);
//        });
//
//        // Add components to panel
//        panel.add(idLabel);
//        panel.add(idField);
//        panel.add(firstNameLabel);
//        panel.add(firstNameField);
//        panel.add(lastNameLabel);
//        panel.add(lastNameField);
//        panel.add(addressLabel);
//        panel.add(addressField);
//        panel.add(salaryLabel);
//        panel.add(salaryField);
//        panel.add(startDateLabel);
//        panel.add(startDateField);
//        panel.add(experienceLabel);
//        panel.add(experienceField);
//        panel.add(specialtyLabel);
//        panel.add(specialtyField);
//        panel.add(genderLabel);
//        panel.add(genderCombo);
//        panel.add(submitButton);
//        panel.add(resetButton);
//
//        // Add panel to frame
//        frame.add(panel);
//    }
//
//    // Frame for Pharmaceutical Table
//    public static void pharmaceuticalFrame() {
//        JFrame frame = Frame("Pharmaceutical Table Entry", null, 500, 500);
//
//        // Panel
//        JPanel panel = Panel(null, Color.LIGHT_GRAY);
//
//        // Labels and TextFields
//        JLabel idLabel = Label("Pharmaceutical ID:", 50, 30, 150, 30);
//        JTextField idField = TextField(210, 30, 200, 30);
//
//        JLabel firstNameLabel = Label("First Name:", 50, 70, 150, 30);
//        JTextField firstNameField = TextField(210, 70, 200, 30);
//
//        JLabel lastNameLabel = Label("Last Name:", 50, 110, 150, 30);
//        JTextField lastNameField = TextField(210, 110, 200, 30);
//
//        JLabel addressLabel = Label("Address:", 50, 150, 150, 30);
//        JTextField addressField = TextField(210, 150, 200, 30);
//
//        JLabel salaryLabel = Label("Salary:", 50, 190, 150, 30);
//        JTextField salaryField = TextField(210, 190, 200, 30);
//
//        JLabel startDateLabel = Label("Start Date:", 50, 230, 150, 30);
//        JTextField startDateField = TextField(210, 230, 200, 30);
//
//        JLabel experienceLabel = Label("Experience:", 50, 270, 150, 30);
//        JTextField experienceField = TextField(210, 270, 200, 30);
//
//        JLabel genderLabel = Label("Gender:", 50, 310, 150, 30);
//        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"male", "female"});
//        genderCombo.setBounds(210, 310, 200, 30);
//
//        // Buttons
//        JButton submitButton = Button("Submit", 50, 360, 100, 30);
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Collect data
//                String id = idField.getText();
//                String firstName = firstNameField.getText();
//                String lastName = lastNameField.getText();
//                String address = addressField.getText();
//                String salary = salaryField.getText();
//                String startDate = startDateField.getText();
//                String experience = experienceField.getText();
//                String gender = (String) genderCombo.getSelectedItem();
//
//                // Placeholder for database insertion logic
//                System.out.println("Pharmaceutical Data:");
//                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Address: " + address + ", Salary: " + salary + ", Start Date: " + startDate + ", Experience: " + experience + ", Gender: " + gender);
//            }
//        });
//
//        JButton resetButton = Button("Reset", 250, 360, 100, 30);
//        resetButton.addActionListener(e -> {
//            idField.setText("");
//            firstNameField.setText("");
//            lastNameField.setText("");
//            addressField.setText("");
//            salaryField.setText("");
//            startDateField.setText("");
//            experienceField.setText("");
//            genderCombo.setSelectedIndex(0);
//        });
//
//        // Add components to panel
//        panel.add(idLabel);
//        panel.add(idField);
//        panel.add(firstNameLabel);
//        panel.add(firstNameField);
//        panel.add(lastNameLabel);
//        panel.add(lastNameField);
//        panel.add(addressLabel);
//        panel.add(addressField);
//        panel.add(salaryLabel);
//        panel.add(salaryField);
//        panel.add(startDateLabel);
//        panel.add(startDateField);
//        panel.add(experienceLabel);
//        panel.add(experienceField);
//        panel.add(genderLabel);
//        panel.add(genderCombo);
//        panel.add(submitButton);
//        panel.add(resetButton);
//
//        // Add panel to frame
//        frame.add(panel);
//    }
//
//





//        signup.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                JFrame passwordFrame = Frame("Password for Sign Up", new GridLayout(1, 1), 400, 200);
//                JPanel passwordPanel = Panel(null, Color.WHITE);
//
//                JLabel password = Label("Password", 20, 30, 100, 30);
//                JPasswordField passwordField = Password(115, 36, 250, 20);
//
//                JButton enter = Button("Enter", 155, 110, 100, 30);
//
//                passwordFrame.add(passwordPanel);
//
//                passwordPanel.add(password);
//                passwordPanel.add(passwordField);
//                passwordPanel.add(enter);
//
//                enter.addActionListener(new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        int hospitalPassword = 1;
//
//                        if (!passwordField.getText().equals(hospitalPassword + "")) {
//                            JFrame wrongPasswordFrame = Frame("Error", new GridLayout(1, 1), 400, 200);
//                            JPanel worngPasswordPanel = Panel(null, Color.WHITE);
//                            JLabel wrongPassword1 = Label("Wrong Password !", 130, 20, 150, 30);
//                            JLabel wrongPassword2 = Label("Please enter the correct password", 50, 40, 300, 30);
//
//                            JButton ok = Button("OK", 155, 110, 70, 30);
//
//                            wrongPasswordFrame.add(worngPasswordPanel);
//
//                            worngPasswordPanel.add(wrongPassword1);
//                            worngPasswordPanel.add(wrongPassword2);
//
//                            worngPasswordPanel.add(ok);
//
//                            passwordFrame.setVisible(false);
//                            ok.addActionListener(new ActionListener() {
//                                @Override
//                                public void actionPerformed(ActionEvent e) {
//                                    wrongPasswordFrame.setVisible(false);
//                                    passwordFrame.setVisible(true);
//                                }
//                            });
//
//                        } else {
//                            JFrame signupFrame = Frame("Sign Up", new GridLayout(1, 1), 370, 350);
//                            JPanel signupPanel = Panel(null, Color.white);
//                            JLabel selectMassage = Label("Select the position for employee", 60, 30, 300, 30);
//                            CreateList(signupPanel, 140, 90, 100, 30);
//                            JButton enter = Button("Enter", 140, 250, 100, 30);
//
//                            signupFrame.add(signupPanel);
//                            signupPanel.add(selectMassage);
//                            signupPanel.add(enter);
//
//                        }
//                    }
//
//                    //      loginFrame.setVisible(false); // Hide login frame
//                });
//
//            }
//        });