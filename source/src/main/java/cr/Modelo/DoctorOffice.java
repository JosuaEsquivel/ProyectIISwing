package cr.Modelo;

/**
 * MedicalOffice Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity MedicalOffice
 */
public class DoctorOffice {
    // Using logger for project
    final Logger logger = LogManager.getLogger(DoctorOffice.class);

    private int id_office;
    private String name;
    private String address;
    private String schedule;
    private int telephone;

    /**
     *
     */
    public DoctorOffice() { logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * @param id_office
     * @param name
     * @param schedule
     * @param address
     * @param telephone
     */
    public DoctorOffice(int id_office, String name, String schedule, String address, int telephone) {
        this.id_office = id_office;
        this.name = name;
        this.schedule=schedule;
        this.address = address;
        this.telephone = telephone;
    }

    public int getId_office() {
        return id_office;
    }

    public void setId_office(int id_office) {
        this.id_office = id_office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "MedicalOffice{" +
                "id_office=" + id_office +
                ", name='" + name +
                ",schedule='"+schedule+
                ", address='" + address +
                ", telephone=" + telephone +
                '}';
    }
}
