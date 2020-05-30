package cr.View;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class Menus extends JFrame {
    private JButton medicalOffice;
    private JButton patient;
    private JButton doctor;

    public Menus(String titleView){

        super(titleView);

        // Using logger for project
        final Logger logger = LogManager.getLogger(Menus.class);

        logger.debug("Design Pattern MVC: [VIEW]");
        this.getContentPane().setBackground(Color.lightGray);
        this.setSize(300, 300);
        this.setLayout(null);
        this.setLocationRelativeTo(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        medicalOffice=new JButton("Doctor Office");
        medicalOffice.setBounds(50,50,180,30);
        patient=new JButton("Patient");
        patient.setBounds(50,100,180,30);
        doctor=new JButton("Doctor");
        doctor.setBounds(50,150,180,30);


        add(medicalOffice);
        add(patient);
        add(doctor);

    }

    public JButton getMedicalOffice() {
        return medicalOffice;
    }

    public void setMedicalOffice(JButton medicalOffice) {
        this.medicalOffice = medicalOffice;
    }

    public JButton getPatient() {
        return patient;
    }

    public void setPatient(JButton patient) {
        this.patient = patient;
    }

    public JButton getDoctor() {
        return doctor;
    }

    public void setDoctor(JButton doctor) {
        this.doctor = doctor;
    }
}
