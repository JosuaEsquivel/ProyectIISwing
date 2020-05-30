package una.ac.cr.Modelo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Client Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


/**
 * Entity Client
 */
public class Patient {
    // Using logger for project
    final Logger logger = LogManager.getLogger(Patient.class);



    private int id_patient;
    private String dateBorn;
    private String name;
    private String address;
    private int telephone;
    private String associatedDiseases;
    private String observations;

    /**
     *
     */
    public Patient() {logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     *
     * @param id_patient
     * @param dateBorn
     * @param name
     * @param address
     * @param telephone
     * @param associatedDiseases
     * @param observations
     */
    public Patient(int id_patient, String dateBorn, String name, String address, int telephone,  String associatedDiseases, String observations) {
        this.id_patient = id_patient;
        this.dateBorn = dateBorn;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.associatedDiseases = associatedDiseases;
        this.observations = observations;
    }

    /**
     * @return
     */
    public int getId_patient() {
        return id_patient;
    }

    /**
     * @param id_patient
     */
    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    /**
     * @return
     */
    public String getDateBorn() {
        return dateBorn;
    }

    /**
     * @param dateBorn
     */
    public void setDateBorn(String  dateBorn) {
        this.dateBorn = dateBorn;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    /**
     * @return
     */
    public String getAssociatedDiseases() {
        return associatedDiseases;
    }

    /**
     * @param associatedDiseases
     */
    public void setAssociatedDiseases(String associatedDiseases) {
        this.associatedDiseases = associatedDiseases;
    }

    /**
     * @return
     */
    public String getObservations() {
        return observations;
    }

    /**
     * @param observations
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Patient{" +
                ", id_patient=" + id_patient +
                ", dateBorn='" + dateBorn + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone=" + telephone +
                ", associatedDiseases='" + associatedDiseases + '\'' +
                ", observations='" + observations + '\'' +
                '}';
    }
}
