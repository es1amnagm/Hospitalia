package hospitalia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Create {

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // Set the frame size to the full screen dimensions
//  Frame with specific location
    public static JFrame Frame(String title, LayoutManager layout, int width, int length, int location1, int location2) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setVisible(true);
        frame.setSize(width, length);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(location1, location2);
        frame.setLayout(layout);

        return frame;
    }

    // frame with full size
    public static JFrame Frame(String title, LayoutManager layout) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize.width + 10, screenSize.height - 30);
        frame.setLayout(layout);

        return frame;
    }

    // frame with center location
    public static JFrame Frame(String title, LayoutManager layout, int width, int length) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setVisible(true);
        frame.setSize(width, length);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(layout);

        return frame;
    }

    // panel
    public static JPanel Panel(LayoutManager layout, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBackground(color);
        return panel;
    }

    // Butoon
    public static JButton Button(String name, int x, int y, int width, int length) {
        JButton button = new JButton(name);
        button.setBounds(x, y, width, length);
        button.setFont(Font());
        //button.setBackground(new Color(110, 181, 178));
        return button;
    }

    public static JButton Button(String name, int x, int y, int width, int length, int sizeOfFont, Color color) {
        JButton button = new JButton(name);
        button.setBounds(x, y, width, length);
        button.setFont(Font(sizeOfFont));
        button.setForeground(color);
       // button.setBackground(new Color(110, 181, 178));

        return button;
    }
    // Label
    //label with default font size
    public static JLabel Label(String name, int x, int y, int width, int length) {
        JLabel label = new JLabel(name);
        label.setBounds(x, y, width, length);

        label.setFont(Font());
        return label;

    }

    //label with changeable font size
    public static JLabel Label(String name, int x, int y, int width, int length, int fontSize) {
        JLabel label = new JLabel(name);
        label.setBounds(x, y, width, length);

        label.setFont(Font(fontSize));
        return label;

    }

// TextField
    public static JTextField TextField(int x, int y, int width, int length) {
        JTextField textfield = new JTextField();
        textfield.setBounds(x, y, width, length);
        textfield.setFont(Font());

        return textfield;
    }

// password    
    public static JPasswordField Password(int x, int y, int width, int length) {
        JPasswordField password = new JPasswordField();
        password.setBounds(x, y, width, length);
        return password;
    }

    // RadioButton  --> buttongroup to make one choise only
    public static JRadioButton RadioButton(String name, int x, int y, int width, int length) {
        JRadioButton radiobutton = new JRadioButton(name);
        radiobutton.setBounds(x, y, width, length);
        radiobutton.setFont(Font());

        return radiobutton;
    }

    // checkbox 
    public static JCheckBox CheckBox(String name, int x, int y, int width, int length) {
        JCheckBox checkbox = new JCheckBox(name);
        checkbox.setBounds(x, y, width, length);
        checkbox.setFont(Font());
        return checkbox;
    }

    //font
    // font with default font size =16
    public static Font Font() {
        Font font = new Font("Bell MT", Font.BOLD, 16);
        return font;
    }

    // font with changabel font size
    public static Font Font(int size) {
        Font font = new Font("Bell MT", Font.BOLD, size);

        return font;
    }
}