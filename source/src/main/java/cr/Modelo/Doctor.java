package cr.Modelo;



/**
 * Doctor Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity Doctor
 */

public class Doctor {
    // Using logger for project
    final Logger logger = LogManager.getLogger(Doctor.class);
    private int id_doctor;

    private String name;

    private String address;

    private int telephone;


    private String password;

    /**
     *
     */
    public Doctor() {logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * @param id_doctor
     * @param name
     * @param address
     * @param telephone
     * @param password
     */
    public Doctor(int id_doctor, String name, String address, int telephone, String password) {
        this.id_doctor = id_doctor;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.password = password;
    }

    /**
     * @return
     */
    public int getId_doctor() {
        return id_doctor;
    }

    /**
     * @param id_doctor
     */
    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
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
        this.name ="Dr."+ name;
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
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id_doctor=" + id_doctor +
                ", name='" + name +
                ", address='" + address +
                ", telephone=" + telephone +
                ", password='" + password +
                '}';
    }
}
