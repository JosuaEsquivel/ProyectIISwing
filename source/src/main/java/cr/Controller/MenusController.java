package cr.Controller;

import una.ac.cr.View.Menus;

public class MenusController {

  PatientController patientController;
  DoctorOfficeController doctorOfficeController;
  DoctorController doctorController;
    Menus menus;


    public MenusController(){
        menus= new Menus("Menus");
        inicializador();
    }

    public void inicializador(){
        menus.getMedicalOffice().addActionListener(e->dorctorOffice());
        menus.getPatient().addActionListener(e->patient());
        menus.getDoctor().addActionListener(e->doctor());

    }

    private void dorctorOffice(){
        menus.dispose();
        doctorOfficeController = new DoctorOfficeController();

    }
    private void patient(){
        menus.dispose();
        patientController=new PatientController();

    }
    private void doctor(){
        menus.dispose();
        doctorController= new DoctorController();
    }
}
