package cr.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.Modelo.Doctor;
import una.ac.cr.Servise.DoctorService;
import una.ac.cr.View.DoctorView;

import java.util.List;
import java.util.Vector;

public class DoctorController {

    // Using logger for project
    final Logger logger = LogManager.getLogger(DoctorController.class);

    // Doctor Model
    private List<Doctor> listDoctorModel;
    // Doctor Service
    private DoctorService doctorService;
    // Vector for the Data Table
    private Vector<Vector<String>> dataVector;
    //Doctor View
    DoctorView doctorView;
    MenusController menusController;

    public DoctorController(){
        doctorView=new DoctorView("Doctor");
        doctorService= new DoctorService();
        actualizar();
        initController();
    }

    private void  initController() {
        logger.debug("Controller Init");
        doctorView.getButtonCancel().addActionListener(e->atras());
    }
    /**
     * Method to Atras
     */
    private void atras(){
        doctorView.dispose();
        menusController= new MenusController();
    }
    /**
     * Method to Actualizar
     */
    private void actualizar(){
       // dataVector = loadDataFromService(0);
        doctorView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_Doctor);
    }
    /**
     * Method to parseInt
     */

    private int parseInt(String phone){

        int phone1=0;
        if(!phone.equals("")){
            phone1= Integer.parseInt(phone);
        }
        return phone1;

    }

    /**
     * Check if the value is null
     *
     * @param obj the value
     * @return Empty value if it's null
     */
    private String checkIfNull(Object obj) {
        String text;
        if (obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }
}
