package una.ac.cr;

import java.util.Arrays;
import java.util.Vector;

public class Constants {
    /**
     *
     */
    public static final String WS_ENDPOINT = "http://localhost:8083/api/";
    public static final String Patient="patients";
    public static final String DoctorOffice="doctorOffices";
    public static final String Doctor="doctor";


    /**
     *
     */
    public static final Vector<String> TABLE_HEADER = new Vector(
            Arrays.asList(new String[]{"Identificacion","Fecha de Nacimiento", "Nombre", "Direccion","Telefono","Enfermedades Asociadas ", "Observaciones"}));

    /**
     *
     */
    public static final Vector<String> TABLE_HEADER_Medical_Office = new Vector(
            Arrays.asList(new String[]{"Identificacion", "Nombre", "Horario","Telefono","Direccion"}));
    /**
     *
     */
    public static final Vector<String> TABLE_HEADER_Doctor = new Vector(
            Arrays.asList(new String[]{"Identificacion", "Nombre", "Tipo Doctor","Premium"}));


}
