package cr.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.Modelo.DoctorOffice;
import una.ac.cr.Servise.DoctorOfficeService;
import una.ac.cr.View.DoctorOfficeView;

import java.util.List;
import java.util.Vector;

import static javax.swing.JOptionPane.showMessageDialog;

public class DoctorOfficeController {
    // Using logger for project
    final Logger logger = LogManager.getLogger(DoctorOfficeController.class);

    // Doctor Office Model
    private List<DoctorOffice> listDoctorOfficeModel;
    // DoctorOffice Service
    private DoctorOfficeService doctorOfficeService;
    // Vector for the Data Table
    private Vector<Vector<String>> dataVector;
    //Patien View
    DoctorOfficeView doctorOfficeView;

    MenusController menusController;

    public DoctorOfficeController( ){
        doctorOfficeView= new DoctorOfficeView("Doctor Office");
        doctorOfficeService= new DoctorOfficeService();
        actualizar();
        initController();
    }
    private void  initController(){
        logger.debug("Controller Init");
        // Different ways to implement the action performed

        doctorOfficeView.getButtonAdd().addActionListener(e -> savePatient());
        doctorOfficeView.getButtonFilter().addActionListener(e->searchText());
        doctorOfficeView.getButtonDelete().addActionListener(e->delete());
        doctorOfficeView.getButtonUpDate().addActionListener(e->update());
        doctorOfficeView.getButtonCancel().addActionListener(e->atras());
    }
    /**
     * Method to Atras
     */
    private void atras(){
        doctorOfficeView.dispose();
        menusController= new MenusController();
    }
    /**
     * Method to Actualizar
     */
    private void actualizar(){
        dataVector = loadDataFromService(0);
        doctorOfficeView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_Medical_Office);
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
     * Method to save the data using the service
     */
    private void savePatient() {

        DoctorOffice doctorOffice = new DoctorOffice();
        DoctorOffice doctorOfficeSaved=null;


        int phone=parseInt(doctorOfficeView.getTextFieldTelephone().getText());

        doctorOffice.setName(doctorOfficeView.getTextFieldNameDocctorOffice().getText());
        doctorOffice.setSchedule(doctorOfficeView.getTextFieldSchecule().getText());
        doctorOffice.setTelephone(phone);
        doctorOffice.setAddress(doctorOfficeView.getTextFieldAddress().getText());

        doctorOfficeSaved = doctorOfficeService.saveMedicalOffice(doctorOffice);

        if (doctorOfficeSaved != null) {
            showMessageDialog(null, "Se almaceno correctamente los datos del Consultorio con " );
            doctorOfficeView.getTextFieldNameDocctorOffice().setText("");
            doctorOfficeView.getTextFieldSchecule().setText("");
            doctorOfficeView.getTextFieldTelephone().setText("");
            doctorOfficeView.getTextFieldAddress().setText("");



        } else {
            showMessageDialog(null, "Hubo un error al almacenar los datos del Paciente");
        }
        actualizar();
    }

    /**
     * Method to Delete the data from the service depending of the search value
     * As soon the user click the button search
     */

    private void delete(){

        int searchTerm=parseInt(doctorOfficeView.getTextFieldSearch().getText());
        doctorOfficeView.getTextFieldSearch().setText("");
        Boolean bolean= doctorOfficeService.deleteDoctorOfficesByTerm(searchTerm);
        if(bolean){
            showMessageDialog(null, "Se Elimino correctamente los datos del Consultorio con "
            );
        }else{
            showMessageDialog(null, "Hubo un error al Eliminar los datos del Consultorio");

        }
        actualizar();

    }

    /**
     * Method to Update the data from the service depending of the search value
     * As soon the user click the button search
     */

    private void update(){

        if(!doctorOfficeView.getTextFieldSearch().equals("")){
            DoctorOffice doctorOffice = new DoctorOffice();
            DoctorOffice doctorOfficeSaved=null;

            int id=parseInt(doctorOfficeView.getTextFieldSearch().getText());
            int phone=parseInt(doctorOfficeView.getTextFieldTelephone().getText());

            doctorOffice.setId_office(id);
            doctorOffice.setName(doctorOfficeView.getTextFieldNameDocctorOffice().getText());
            doctorOffice.setSchedule(doctorOfficeView.getTextFieldSchecule().getText());
            doctorOffice.setTelephone(phone);
            doctorOffice.setAddress(doctorOfficeView.getTextFieldAddress().getText());

            doctorOfficeSaved = doctorOfficeService.upDateDoctorOffice(doctorOffice);

            if (doctorOfficeSaved != null) {
                showMessageDialog(null, "Se actualizo correctamente los datos del Consultorio con " );

                doctorOfficeView.getTextFieldNameDocctorOffice().setText("");
                doctorOfficeView.getTextFieldSchecule().setText("");
                doctorOfficeView.getTextFieldTelephone().setText("");
                doctorOfficeView.getTextFieldAddress().setText("");
                doctorOfficeView.getTextFieldSearch().setText("");

            } else {
                showMessageDialog(null, "Hubo un error al actualizar los datos del Consultorio");
            }
        }

        actualizar();


    }

    /**
     * Method to filter the data from the service depending of the search value
     * As soon the user click the button search
     */
    private void searchText() {
        int searchTerm=0;
        logger.debug("Searching the information of: " + searchTerm);


        if(doctorOfficeView.getTextFieldSearch().getText().length()!=0){
            searchTerm = Integer.parseInt(doctorOfficeView.getTextFieldSearch().getText());
            dataVector = loadDataFromService(searchTerm);
            Vector<String> doctorOfficeVector = dataVector.elementAt(0);
            doctorOfficeView.getTextFieldNameDocctorOffice().setText(doctorOfficeVector.get(1));
            doctorOfficeView.getTextFieldSchecule().setText(doctorOfficeVector.get(2));
            doctorOfficeView.getTextFieldTelephone().setText(doctorOfficeVector.get(3));
            doctorOfficeView.getTextFieldAddress().setText(doctorOfficeVector.get(4));

            logger.debug("Data found: " + dataVector.size());

            doctorOfficeView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_Medical_Office);
        }else{
            showMessageDialog(null, "Debes de ingresar el Id_Patient ");

        }


    }

    /**
     * Method to load data from the service
     *
     * @param searchTerm filter the data with this term
     * @return vector of patient
     */
    private Vector<Vector<String>> loadDataFromService(int searchTerm) {

        dataVector = new Vector();

        if (searchTerm > 0) {
            listDoctorOfficeModel = doctorOfficeService.searchMedicalOfficesByTerm(searchTerm);

        } else {
            listDoctorOfficeModel = doctorOfficeService.loadAllMedicalOffice();
        }

        if (listDoctorOfficeModel != null && listDoctorOfficeModel.size() > 0) {
            int index = 0;
            Vector<String> DoctorOfficeVector = null;
            for (DoctorOffice doctorOffice : listDoctorOfficeModel) {
                DoctorOfficeVector = new Vector();
                DoctorOfficeVector.add(checkIfNull(doctorOffice.getId_office()));
                DoctorOfficeVector.add(checkIfNull(doctorOffice.getName()));
                DoctorOfficeVector.add(checkIfNull(doctorOffice.getSchedule()));
                DoctorOfficeVector.add(checkIfNull(doctorOffice.getTelephone()));
                DoctorOfficeVector.add(checkIfNull(doctorOffice.getAddress()));

                dataVector.add(DoctorOfficeVector);
            }
        }

        return dataVector;
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
