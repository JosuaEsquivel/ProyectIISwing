package cr.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.Modelo.Patient;
import una.ac.cr.Servise.PatientService;
import una.ac.cr.View.PatientView;

import java.util.List;
import java.util.Vector;

import static javax.swing.JOptionPane.showMessageDialog;

public class PatientController {
    // Using logger for project
    final Logger logger = LogManager.getLogger(PatientController.class);

    // Patient Model
    private List<Patient> listPatientModel;
    // Patient Service
    private PatientService patientService;
    // Vector for the Data Table
    private Vector<Vector<String>> dataVector;
    //Patien View
    PatientView patientView;
    MenusController menusController;

    public PatientController() {
        patientView = new PatientView("Patient");
        patientService = new PatientService();
        actualizar();
        initController();
    }

    private void initController() {
        logger.debug("Controller Init");
        // Different ways to implement the action performed

        patientView.getButtonAdd().addActionListener(e -> savePatient());
        patientView.getButtonFilter().addActionListener(e -> searchText());
        patientView.getButtonDelete().addActionListener(e -> delete());
        patientView.getButtonUpDate().addActionListener(e -> update());
        patientView.getButtonCancel().addActionListener(e -> atras());
    }

    /**
     * Method to Atras
     */
    private void atras() {
        patientView.dispose();
        menusController = new MenusController();
    }

    /**
     * Method to Actualizar
     */
    private void actualizar() {
        dataVector = loadDataFromService(0);
        patientView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER);
    }

    /**
     * Method to parseInt
     */

    private int parseInt(String phone) {

        int phone1 = 0;
        if (!phone.equals("")) {
            phone1 = Integer.parseInt(phone);
        }
        return phone1;

    }

    /**
     * Method to save the data using the service
     */
    private void savePatient() {

        Patient patient = new Patient();
        Patient patientSaved = null;


        int phone = parseInt(patientView.getTextFieldTelephonPersonalPatient().getText());

        patient.setName(patientView.getTextFieldNamePatient().getText());
        patient.setDateBorn(patientView.getTextFieldDateBornPatient().getText());
        patient.setTelephone(phone);
        patient.setAddress(patientView.getTextFieldAddressPatient().getText());
        patient.setAssociatedDiseases(patientView.getTextAreaAssosiateDiseasesPatient().getText());
        patient.setObservations(patientView.getTextAreaObservationPatient().getText());

        patientSaved = patientService.savePatient(patient);

        if (patientSaved != null) {
            showMessageDialog(null, "Se almacenó correctamente los datos del Paciente con " +
                    "el id [" + patientSaved.getId_patient() + "]");
            patientView.getTextFieldNamePatient().setText("");
            patientView.getTextFieldDateBornPatient().setText("");
            patientView.getTextFieldTelephonPersonalPatient().setText("");
            patientView.getTextFieldAddressPatient().setText("");
            patientView.getTextAreaAssosiateDiseasesPatient().setText("");
            patientView.getTextAreaObservationPatient().setText("");


        } else {
            showMessageDialog(null, "Hubo un error al almacenar los datos del Paciente");
        }
        actualizar();
    }

    /**
     * Method to Delete the data from the service depending of the search value
     * As soon the user click the button search
     */

    private void delete() {

        int searchTerm = parseInt(patientView.getTextFieldSearch().getText());
        patientView.getTextFieldSearch().setText("");
        Boolean bolean = patientService.deletePatientsByTerm(searchTerm);
        if (bolean) {
            showMessageDialog(null, "Se Elimino correctamente los datos del Paciente con "
            );
            patientView.getTextFieldSearch().setText("");
            patientView.getTextFieldNamePatient().setText("");
            patientView.getTextFieldDateBornPatient().setText("");
            patientView.getTextFieldTelephonPersonalPatient().setText("");
            patientView.getTextFieldAddressPatient().setText("");
            patientView.getTextAreaAssosiateDiseasesPatient().setText("");
            patientView.getTextAreaObservationPatient().setText("");
        } else {
            showMessageDialog(null, "Hubo un error al Eliminar los datos del Paciente");

        }
        actualizar();

    }

    /**
     * Method to Update the data from the service depending of the search value
     * As soon the user click the button search
     */

    private void update() {

        if (!patientView.getTextFieldSearch().equals("")) {

            Patient patient = new Patient();
            Patient patientUpdate = null;
            int id = parseInt(patientView.getTextFieldSearch().getText());
            int phone = parseInt(patientView.getTextFieldTelephonPersonalPatient().getText());

            patient.setId_patient(id);
            patient.setName(patientView.getTextFieldNamePatient().getText());
            patient.setDateBorn(patientView.getTextFieldDateBornPatient().getText());

            patient.setAddress(patientView.getTextFieldAddressPatient().getText());
            patient.setTelephone(phone);
            patient.setAssociatedDiseases(patientView.getTextAreaAssosiateDiseasesPatient().getText());
            patient.setObservations(patientView.getTextAreaObservationPatient().getText());

            patientUpdate = patientService.upDatePatient(patient);

            if (patientUpdate != null) {
                showMessageDialog(null, "Se actualizo correctamente los datos del Paciente con " +
                        "el id [" + patientUpdate.getId_patient() + "]");
                patientView.getTextFieldSearch().setText("");
                patientView.getTextFieldNamePatient().setText("");
                patientView.getTextFieldDateBornPatient().setText("");
                patientView.getTextFieldTelephonPersonalPatient().setText("");
                patientView.getTextFieldAddressPatient().setText("");
                patientView.getTextAreaAssosiateDiseasesPatient().setText("");
                patientView.getTextAreaObservationPatient().setText("");
            } else {
                showMessageDialog(null, "Hubo un error al actualizar los datos del Paciente");
            }
        }

        actualizar();


    }

    /**
     * Method to filter the data from the service depending of the search value
     * As soon the user click the button search
     */
    private void searchText() {
        int searchTerm = 0;
        logger.debug("Searching the information of: " + searchTerm);


        if (patientView.getTextFieldSearch().getText().length() != 0) {
            searchTerm = Integer.parseInt(patientView.getTextFieldSearch().getText());
            dataVector = loadDataFromService(searchTerm);
            Vector<String> studentVector = dataVector.elementAt(0);
            patientView.getTextFieldNamePatient().setText(studentVector.get(2));
            patientView.getTextFieldDateBornPatient().setText(studentVector.get(1));
            patientView.getTextFieldAddressPatient().setText(studentVector.get(3));
            patientView.getTextFieldTelephonPersonalPatient().setText(studentVector.get(4));
            patientView.getTextAreaAssosiateDiseasesPatient().setText(studentVector.get(5));
            patientView.getTextAreaObservationPatient().setText(studentVector.get(6));
            logger.debug("Data found: " + dataVector.size());

            patientView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER);
        } else {
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
            listPatientModel = patientService.searchPatientsByTerm(searchTerm);

        } else {
            listPatientModel = patientService.loadAllPatient();
        }

        if (listPatientModel != null && listPatientModel.size() > 0) {
            int index = 0;
            Vector<String> studentVector = null;
            for (Patient student : listPatientModel) {
                studentVector = new Vector();
                studentVector.add(checkIfNull(student.getId_patient()));
                studentVector.add(checkIfNull(student.getDateBorn()));
                studentVector.add(checkIfNull(student.getName()));
                studentVector.add(checkIfNull(student.getAddress()));
                studentVector.add(checkIfNull(student.getTelephone()));
                studentVector.add(checkIfNull(student.getAssociatedDiseases()));
                studentVector.add(checkIfNull(student.getObservations()));

                dataVector.add(studentVector);
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
