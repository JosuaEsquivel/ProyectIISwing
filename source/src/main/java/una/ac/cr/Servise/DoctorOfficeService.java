package una.ac.cr.Servise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.Modelo.DoctorOffice;

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
public class DoctorOfficeService {

    // Using logger for project
    final Logger logger = LogManager.getLogger(DoctorOfficeService.class);

    private static final String REST_URI = Constants.WS_ENDPOINT.concat(Constants.DoctorOffice);
    private Client client = null;

    /**
     * Empty Constructor
     */
    public DoctorOfficeService() {
        client = ClientBuilder.newClient();
    }

    /**
     * This method will load the information from JSON depending if the filter text
     *
     * @param searchTerm filter term
     * @return the list of Medical Office
     */
    public List<DoctorOffice> searchMedicalOfficesByTerm(int searchTerm) {

        logger.debug("Obteniendo la lista de Medical Office que coinciden con ["+searchTerm+"]");

        List<DoctorOffice> medicalOfficeList = loadAllMedicalOffice();
        List<DoctorOffice> updatedMedicalOfficetList = new ArrayList<DoctorOffice>();

        if (medicalOfficeList != null && medicalOfficeList.size() > 0) {
            for (DoctorOffice medicalOffice : medicalOfficeList) {
                if (searchTerm >0 && medicalOffice.getId_office()==searchTerm) {
                    updatedMedicalOfficetList.add(medicalOffice);
                }
            }
        }

        return updatedMedicalOfficetList;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of Medical Office
     */
    public List<DoctorOffice> loadAllMedicalOffice() {

        logger.debug("Obteniendo toda la lista de Medical Office");

        // Library Jackson parse JSon
        List<DoctorOffice> medicalOfficeList = null;

        medicalOfficeList = Arrays.asList(client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get(DoctorOffice[].class));

        return medicalOfficeList;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of Students
     */
    public List<DoctorOffice> loadAllDoctorOffice() {

        logger.debug("Obteniendo toda la lista de estudiantes");

        // Library Jackson parse JSon
        List<DoctorOffice> studentList = null;

        studentList = Arrays.asList(client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get(DoctorOffice[].class));

        return studentList;
    }

    public DoctorOffice saveMedicalOffice(DoctorOffice medicalOffice) {
        DoctorOffice medicalOfficeSave;
        System.out.println("Entro al Medical service a guardar");
        medicalOfficeSave = client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(medicalOffice,
                MediaType.APPLICATION_JSON), DoctorOffice.class);

        return medicalOfficeSave;
    }

    /**
     * This metodo will load delete the data from the WS
     *
     * @return the boolean of patient
     */

    public Boolean deleteDoctorOfficesByTerm(int patient) {

        Boolean patientSave=false;

        patientSave = client.target(REST_URI).queryParam("id_office",patient).request(MediaType.APPLICATION_JSON).delete(Boolean.class);
        return patientSave;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the true boolean of patient
     */

    public DoctorOffice upDateDoctorOffice(DoctorOffice patient) {
        DoctorOffice patientSave;

        patientSave = client.target(REST_URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(patient,
                MediaType.APPLICATION_JSON), DoctorOffice.class);

        return patientSave;
    }

}
