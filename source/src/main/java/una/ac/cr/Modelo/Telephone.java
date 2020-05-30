package una.ac.cr.Modelo;

//import javax.persistence.*;

/**
 * Telephone Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity Telephone
 */
public class Telephone {
    // Using logger for project
    final Logger logger = LogManager.getLogger(Patient.class);

    private int id_telephone;
    private String type_telephone;

    /**
     *
     */
    public Telephone() {logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * @param id_telephone
     * @param type_telephone
     */
    public Telephone(int id_telephone, String type_telephone) {
        this.id_telephone = id_telephone;
        this.type_telephone = type_telephone;
    }

    /**
     * @return
     */
    public int getId_telephone() {
        return id_telephone;
    }

    /**
     * @param id_telephone
     */
    public void setId_telephone(int id_telephone) {
        this.id_telephone = id_telephone;
    }

    /**
     * @return
     */
    public String getType_telephone() {
        return type_telephone;
    }

    /**
     * @param type_telephone
     */
    public void setType_telephone(String type_telephone) {
        this.type_telephone = type_telephone;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "id_telephone=" + id_telephone +
                ", type_telephone=" + type_telephone +
                '}';
    }
}
