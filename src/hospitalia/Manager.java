package hospitalia;
import static hospitalia.Create.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static hospitalia.Create.Button;
import static hospitalia.Create.Frame;
import static hospitalia.Create.Panel;
import static hospitalia.GUI.screenSize;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eslam
 */
public class Manager {
    
    public Manager()
    {
                          JFrame managerFrame =Frame("Manager", null);
                  
                  JPanel managerPanel=Panel(null, new Color(17,92,115));

                  managerPanel.setBounds(0,0,350,screenSize.height);
                  
                  JPanel managerPanel2=Panel(null,new Color(17,92,115) );
                  managerPanel2.setBounds(1170,0,350,screenSize.height);

                                    managerFrame.add(managerPanel);

                                    managerFrame.add(managerPanel2);
                                    
                                    
                                    // Exit
 JButton exitButton = new JButton("Exit");
          exitButton.setFont(Font(25));
        exitButton.setBounds((screenSize.width/2)-30, 700, 100, 30); // Positioning the button

        // Add ActionListener to the button
        exitButton.addActionListener((e) -> {
         managerFrame.dispose();
        });
 managerFrame.add(exitButton);

                                    
                  // buttons in the first panel (managerpanel)
                  JButton doctors=Button("Doctors", 50, 10, 240, 40,35 ,new Color(110, 181, 178));
                  
                  JButton nurses=Button("Nurses", 50, 110, 240, 40,35,new Color(110, 181, 178));
                  
                  JButton specialty=Button("Specialty", 50, 210, 240, 40,35,new Color(110, 181, 178));
                  
                  JButton patients=Button("Patients", 50, 310, 240, 40,35,new Color(110, 181, 178));
                  
                  JButton receptionist=Button("Receptionist", 50, 410, 240, 40,35,new Color(110, 181, 178));
                  
                  JButton drivers=Button("Drivers", 50, 510, 240, 40,35,new Color(110, 181, 178));
                  
                  JButton paramedics=Button("Paramedics", 50, 610, 240, 40,35,new Color(110, 181, 178));
                  
                  JButton cleaners=Button("Cleaners", 50, 710, 240, 40,35,new Color(110, 181, 178));
                  
                   managerPanel.add(doctors);
                  managerPanel.add(nurses);
                  managerPanel.add(specialty);
                  managerPanel.add(patients);
                  managerPanel.add(receptionist);
                  managerPanel.add(drivers);
                  managerPanel.add(paramedics);
                  managerPanel.add(cleaners);
                  
                  //buttons in the last panel (managerpanel2)
                      JButton donations=Button("Donations", 50, 10, 255, 40,35,new Color(110, 181, 178));
                  
                  JButton store=Button("Store", 50, 110, 255, 40,35,new Color(110, 181, 178));
                  
                  JButton workerStore=Button("Worker_Store", 50, 210, 255, 40,30,new Color(110, 181, 178));
                  
                  JButton pharmacyutical=Button("Pharmacyutical", 50, 310, 255, 40,30,new Color(110, 181, 178));
                  
                   
                  JButton ambulances=Button("Ambulances", 50, 410, 255, 40,35,new Color(110, 181, 178));
                  
                  JButton Clinics=Button("Clinics", 50, 510, 255, 40,35,new Color(110, 181, 178));
                  
                  JButton Rooms=Button("Rooms", 50, 610, 255, 40,35,new Color(110, 181, 178));
                 
                  
                  managerPanel2.add(donations);
                  managerPanel2.add(store);
                  managerPanel2.add(workerStore);
                  managerPanel2.add(pharmacyutical);
                   managerPanel2.add(ambulances);
                  managerPanel2.add(Clinics);
                  managerPanel2.add(Rooms);
                  
                  
                  
addManagerButtonAction(doctors, "Doctor_manager");
addManagerButtonAction(nurses, "Nurse_manager");
addManagerButtonAction(specialty, "Specialty_manager");
//addManagerButtonAction(patients, "Patient_manager");
addManagerButtonAction(receptionist, "Receptionist_manager");
addManagerButtonAction(drivers, "Driver_manager");
addManagerButtonAction(paramedics, "Paramedic_manager");
addManagerButtonAction(cleaners, "Cleaner_manager");
addManagerButtonAction(patients, "Patient_manager");

 addManagerButtonAction(donations, "Donations_manager");
addManagerButtonAction(store, "Store_Worker");
addManagerButtonAction(workerStore, "Worker_Store_manager");
addManagerButtonAction(pharmacyutical, "Pharmaceutical_manager");
 addManagerButtonAction(ambulances, "Ambulance_manager");
addManagerButtonAction(Clinics, "Clinic_manager");
addManagerButtonAction(Rooms, "Room_manager");

                  
                  
                  
                  
                  
    }
    // method for create actionlistener and the new class 
private void addManagerButtonAction(JButton button, String className) {
    button.addActionListener(e -> {
        try {
            Class<?> clazz = Class.forName("hospitalia." + className);
            clazz.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
}


}
