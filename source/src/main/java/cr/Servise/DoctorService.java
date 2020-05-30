package cr.Servise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Service to get the data from the service
 *
 * @author Javier Garro, Joshua Esquivel
 */
public class DoctorService {
    // Using logger for project
    final Logger logger = LogManager.getLogger(DoctorService.class);
    private static final String REST_URI = Constants.WS_ENDPOINT.concat(Constants.Doctor);
    private Client client = null;

    /**
     * Empty Constructor
     */
    public DoctorService(){
        client = ClientBuilder.newClient();
    }
}
