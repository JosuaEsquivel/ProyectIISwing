package una.ac.cr;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Controller.MenusController;

import javax.swing.*;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Swing MVC Example
 *
 * @author mguzmana
 */
public class SwingMVCExample {

    // Using logger for project
    private static final Logger logger = LogManager.getLogger(una.ac.cr.SwingMVCExample.class);

    /**
     * Main Method
     * @param args the arguments for the main
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();

                } catch (JsonGenerationException e) {
                    logger.error("Error cuando se parsea el archivo de JSon: ", e);
                } catch (JsonMappingException e) {
                    logger.error("Error cuando se Mapea el archivo de JSon: ", e);
                } catch (IOException e) {
                    logger.error("Error al leer el archivo: ", e);
                } catch (Exception e) {
                    logger.error("Error general: ", e);
                    showMessageDialog(null, "Error General " + e);
                }
            }
        });
    }

    /**
     * Create the GUI
     * 
     * @throws Exception
     */
    public static void createAndShowGUI() throws Exception {
        logger.debug("Running the MVC Example - Calling the Controller");

        MenusController menusController= new MenusController();

    }
}
