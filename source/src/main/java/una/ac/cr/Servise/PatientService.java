package una.ac.cr.Servise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.Modelo.Patient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service to get the data from the service
 *
 * @author Javier Garro, Joshua Esquivel
 */
public class PatientService {

    // Using logger for project
    final Logger logger = LogManager.getLogger(PatientService.class);

    private static final String REST_URI = Constants.WS_ENDPOINT.concat(Constants.Patient);
    private Client client = null;

    /**
     * Empty Constructor
     */
    public PatientService() {
        client = ClientBuilder.newClient();
    }

    /**
     * This method will load the information from JSON depending if the filter text
     *
     * @param searchTerm filter term
     * @return the list of patient
     */
    public List<Patient> searchPatientsByTerm(int searchTerm) {

        logger.debug("Obteniendo la lista de pacientes que coinciden con [" + searchTerm + "]");

        List<Patient> patientsList = loadAllPatient();
        List<Patient> updatedPatienttList = new ArrayList<Patient>();

        if (patientsList != null && patientsList.size() > 0) {
            for (Patient patient : patientsList) {
                if (searchTerm > 0 && patient.getId_patient() == searchTerm) {
                    updatedPatienttList.add(patient);
                }
            }
        }

        return updatedPatienttList;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of patient
     */
    public List<Patient> loadAllPatient() {

        logger.debug("Obteniendo toda la lista de pacientes");

        // Library Jackson parse JSon
        List<Patient> patientList = null;

        patientList = Arrays.asList(client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get(Patient[].class));

        return patientList;
    }
    /**
     * This method will load all the data from the WS
     *
     * @return the save of patient
     */

    public Patient savePatient(Patient patient) {
        Patient patientSave;

        patientSave = client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(patient,
                MediaType.APPLICATION_JSON), Patient.class);

        return patientSave;
    }

    /**
     * This metodo will load delete the data from the WS
     *
     * @return the boolean of patient
     */

    public Boolean deletePatientsByTerm(int patient) {

        Boolean patientSave=false;

       patientSave = client.target(REST_URI).queryParam("id_patient",patient).
               request(MediaType.APPLICATION_JSON).delete(Boolean.class);
        return patientSave;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the true boolean of patient
     */

    public Patient upDatePatient(Patient patient) {
        Patient patientSave;

        patientSave = client.target(REST_URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(patient,
                MediaType.APPLICATION_JSON), Patient.class);

        return patientSave;
    }
}
