package cr.View;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * PatientRegistrationView
 *
 * @author JavierGarro y JosuaEsquivel
 */
public class DoctorOfficeView extends JFrame {

    // Create views swing UI components

    //Formulario de Registro
    JButton buttonAdd;
    JButton buttonCancel;
    private JButton buttonUpDate;
    private JButton buttonDelete;

    JLabel labelNameDoctorOffice;
    JLabel labelSchedule;
    JLabel labelTelephone;
    JLabel labelAddress;

    JTextField textFieldNameDocctorOffice;
    JTextField textFieldSchecule;
    JTextField textFieldTelephone;
    JTextField textFieldAddress;

    //Vista de la Lista

    private JTextField textFieldSearch;
    private JButton buttonFilter;
    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Main Constructor
     *
     * @param titleView the name of the View
     */
    public DoctorOfficeView(String titleView) {
        super(titleView);

        // Using logger for project
        final Logger logger = LogManager.getLogger(DoctorOfficeView.class);

        logger.debug("Design Pattern MVC: [VIEW]");

        this.getContentPane().setBackground(Color.lightGray);
        this.setSize(750, 550);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Para que se maximise
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonCancel = new JButton("Back");
        buttonCancel.setBounds(20, 20, 100, 30);
        buttonAdd = new JButton("Save");
        buttonAdd.setBounds(190, 150, 100, 30);
        buttonUpDate = new JButton("UpDate");
        buttonUpDate.setBounds(310, 150, 100, 30);
        buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(430, 150, 100, 30);
        buttonFilter = new JButton("Filter");
        buttonFilter.setBounds(225, 220, 100, 20);

        labelNameDoctorOffice = new JLabel("Name");
        labelNameDoctorOffice.setBounds(240, 30, 180, 20);
        labelSchedule = new JLabel("Schedule");
        labelSchedule.setBounds(240, 60, 80, 20);
        labelTelephone = new JLabel("Telephone");
        labelTelephone.setBounds(240, 90, 100, 20);
        labelAddress = new JLabel("Address");
        labelAddress.setBounds(240, 120, 200, 20);

        textFieldNameDocctorOffice = new JTextField();
        textFieldNameDocctorOffice.setBounds(340, 30, 150, 20);
        textFieldSchecule = new JTextField();
        textFieldSchecule.setBounds(340, 60, 150, 20);
        textFieldTelephone = new JTextField();
        textFieldTelephone.setBounds(340, 90, 150, 20);
        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(340, 120, 150, 20);
        textFieldSearch = new JTextField();
        textFieldSearch.setBounds(345, 220, 150, 20);


        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setName("mainTable");
        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 255, 700, 200);

        add(labelNameDoctorOffice);
        add(textFieldNameDocctorOffice);
        add(labelSchedule);
        add(textFieldSchecule);
        add(labelTelephone);
        add(textFieldTelephone);
        add(labelAddress);
        add(textFieldAddress);
        add(textFieldSearch);
        add(buttonAdd);
        add(buttonUpDate);
        add(buttonDelete);
        add(buttonFilter);
        add(buttonCancel);

        add(scrollPane);


    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(JButton buttonAdd) {
        this.buttonAdd = buttonAdd;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JButton getButtonUpDate() {
        return buttonUpDate;
    }

    public void setButtonUpDate(JButton buttonUpDate) {
        this.buttonUpDate = buttonUpDate;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(JButton buttonDelete) {
        this.buttonDelete = buttonDelete;
    }

    public JLabel getLabelNameDoctorOffice() {
        return labelNameDoctorOffice;
    }

    public void setLabelNameDoctorOffice(JLabel labelNameDoctorOffice) {
        this.labelNameDoctorOffice = labelNameDoctorOffice;
    }

    public JLabel getLabelSchedule() {
        return labelSchedule;
    }

    public void setLabelSchedule(JLabel labelSchedule) {
        this.labelSchedule = labelSchedule;
    }

    public JLabel getLabelTelephone() {
        return labelTelephone;
    }

    public void setLabelTelephone(JLabel labelTelephone) {
        this.labelTelephone = labelTelephone;
    }

    public JLabel getLabelAddress() {
        return labelAddress;
    }

    public void setLabelAddress(JLabel labelAddress) {
        this.labelAddress = labelAddress;
    }


    public JTextField getTextFieldNameDocctorOffice() {
        return textFieldNameDocctorOffice;
    }

    public void setTextFieldNameDocctorOffice(JTextField textFieldNameDocctorOffice) {
        this.textFieldNameDocctorOffice = textFieldNameDocctorOffice;
    }

    public JTextField getTextFieldSchecule() {
        return textFieldSchecule;
    }

    public void setTextFieldSchecule(JTextField textFieldSchecule) {
        this.textFieldSchecule = textFieldSchecule;
    }

    public JTextField getTextFieldTelephone() {
        return textFieldTelephone;
    }

    public void setTextFieldTelephone(JTextField textFieldTelephone) {
        this.textFieldTelephone = textFieldTelephone;
    }

    public JTextField getTextFieldAddress() {
        return textFieldAddress;
    }

    public void setTextFieldAddress(JTextField textFieldAddress) {
        this.textFieldAddress = textFieldAddress;
    }


    public JTextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public void setTextFieldSearch(JTextField textFieldSearch) {
        this.textFieldSearch = textFieldSearch;
    }

    public JButton getButtonFilter() {
        return buttonFilter;
    }

    public void setButtonFilter(JButton buttonFilter) {
        this.buttonFilter = buttonFilter;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
}
