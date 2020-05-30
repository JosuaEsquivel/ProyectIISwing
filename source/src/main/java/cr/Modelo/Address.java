package cr.Modelo;



/**
 * Address Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity Address
 */
public class Address {

    // Using logger for project
    final Logger logger = LogManager.getLogger(Address.class);
    private int id_address;
    private String type_address;

    /**
     *
     */
    public Address() {logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * @param id_address
     * @param type_address
     */
    public Address(int id_address, String type_address) {
        this.id_address = id_address;
        this.type_address = type_address;
    }

    /**
     * @return
     */
    public int getId_address() {
        return id_address;
    }

    /**
     * @param id_address
     */
    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    /**
     * @return
     */
    public String getType_address() {
        return type_address;
    }

    /**
     * @param type_address
     */
    public void setType_address(String type_address) {
        this.type_address = type_address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id_address=" + id_address +
                ", type_address=" + type_address +
                '}';
    }
}



