package una.ac.cr.View;


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
public class PatientView extends JFrame {

    // Create views swing UI components

    //Formulario de Registro
    JButton buttonAdd;
    JButton buttonCancel;
    private JButton buttonUpDate;
    private JButton buttonDelete;

    JLabel labelNamePatient;
    JLabel labelDateBornPatient;
    JLabel labelTelephonPersonalPatient;
    JLabel labelAddressPatient;
    JLabel labelAssociateDiseasesPatient;
    JLabel labelObservationPatient;


    JTextField textFieldNamePatient;
    JTextField textFieldDateBornPatient;
    JTextField textFieldTelephonPersonalPatient;
    JTextField textFieldAddressPatient;


    JScrollPane scrollPaneAssociatedDiseasesPatient;
    JScrollPane scrollPaneObservationPatient;

    JTextArea textAreaAssosiateDiseasesPatient;
    JTextArea textAreaObservationPatient;

    // Create views swing UI components

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

    public PatientView(String titleView) {
        super(titleView);

        // Using logger for project
        final Logger logger = LogManager.getLogger(PatientView.class);

        logger.debug("Design Pattern MVC: [VIEW]");

        this.getContentPane().setBackground(Color.lightGray);
        this.setSize(750, 670);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        buttonCancel = new JButton("Back");
        buttonCancel.setBounds(20, 20, 100, 30);
        buttonAdd = new JButton("Save");
        buttonAdd.setBounds(190, 330, 100, 30);
        buttonUpDate = new JButton("UpDate");
        buttonUpDate.setBounds(310, 330, 100, 30);
        buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(430, 330, 100, 30);
        buttonFilter = new JButton("Filter");
        buttonFilter.setBounds(230, 380, 100, 20);

        labelNamePatient = new JLabel("Patient Name");
        labelNamePatient.setBounds(175, 30, 180, 20);
        labelDateBornPatient = new JLabel("Patient Date Born-> dd/mm/yyyy ");
        labelDateBornPatient.setBounds(175, 60, 180, 20);
        labelTelephonPersonalPatient = new JLabel("Personal Phone");
        labelTelephonPersonalPatient.setBounds(175, 90, 100, 20);
        labelAddressPatient = new JLabel("Patient Address");
        labelAddressPatient.setBounds(175, 120, 200, 20);
        labelAssociateDiseasesPatient = new JLabel("Patient Associate Diseases");
        labelAssociateDiseasesPatient.setBounds(175, 180, 200, 20);
        labelObservationPatient = new JLabel("Observation");
        labelObservationPatient.setBounds(175, 280, 100, 20);


        textFieldNamePatient = new JTextField();
        textFieldNamePatient.setBounds(370, 30, 150, 20);
        textFieldDateBornPatient = new JTextField();
        textFieldDateBornPatient.setBounds(370, 60, 150, 20);
        textFieldTelephonPersonalPatient = new JTextField();
        textFieldTelephonPersonalPatient.setBounds(370, 90, 150, 20);
        textFieldAddressPatient = new JTextField();
        textFieldAddressPatient.setBounds(370, 120, 150, 20);
        textFieldSearch = new JTextField();
        textFieldSearch.setBounds(350, 380, 150, 20);

        textAreaAssosiateDiseasesPatient = new JTextArea();
        textAreaAssosiateDiseasesPatient.setLineWrap(true);
        scrollPaneAssociatedDiseasesPatient = new JScrollPane(textAreaAssosiateDiseasesPatient);
        scrollPaneAssociatedDiseasesPatient.setBounds(350, 150, 200, 80);
        textAreaObservationPatient = new JTextArea();
        textAreaObservationPatient.setLineWrap(true);
        scrollPaneObservationPatient = new JScrollPane(textAreaObservationPatient);
        scrollPaneObservationPatient.setBounds(350, 240, 200, 80);

        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setName("mainTable");
        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 415, 710, 200);

        add(labelNamePatient);
        add(textFieldNamePatient);
        add(labelDateBornPatient);
        add(textFieldDateBornPatient);
        add(labelTelephonPersonalPatient);
        add(textFieldTelephonPersonalPatient);
        add(labelAddressPatient);
        add(textFieldAddressPatient);
        add(labelAssociateDiseasesPatient);
        add(scrollPaneAssociatedDiseasesPatient);
        add(labelObservationPatient);
        add(scrollPaneObservationPatient);
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

    public JLabel getLabelNamePatient() {
        return labelNamePatient;
    }

    public void setLabelNamePatient(JLabel labelNamePatient) {
        this.labelNamePatient = labelNamePatient;
    }

    public JLabel getLabelDateBornPatient() {
        return labelDateBornPatient;
    }

    public void setLabelDateBornPatient(JLabel labelDateBornPatient) {
        this.labelDateBornPatient = labelDateBornPatient;
    }

    public JLabel getLabelTelephonPersonalPatient() {
        return labelTelephonPersonalPatient;
    }

    public void setLabelTelephonPersonalPatient(JLabel labelTelephonPersonalPatient) {
        this.labelTelephonPersonalPatient = labelTelephonPersonalPatient;
    }

    public JLabel getLabelAddressPatient() {
        return labelAddressPatient;
    }

    public void setLabelAddressPatient(JLabel labelAddressPatient) {
        this.labelAddressPatient = labelAddressPatient;
    }

    public JLabel getLabelAssociateDiseasesPatient() {
        return labelAssociateDiseasesPatient;
    }

    public void setLabelAssociateDiseasesPatient(JLabel labelAssociateDiseasesPatient) {
        this.labelAssociateDiseasesPatient = labelAssociateDiseasesPatient;
    }

    public JLabel getLabelObservationPatient() {
        return labelObservationPatient;
    }

    public void setLabelObservationPatient(JLabel labelObservationPatient) {
        this.labelObservationPatient = labelObservationPatient;
    }

    public JTextField getTextFieldNamePatient() {
        return textFieldNamePatient;
    }

    public void setTextFieldNamePatient(JTextField textFieldNamePatient) {
        this.textFieldNamePatient = textFieldNamePatient;
    }

    public JTextField getTextFieldDateBornPatient() {
        return textFieldDateBornPatient;
    }

    public void setTextFieldDateBornPatient(JTextField textFieldDateBornPatient) {
        this.textFieldDateBornPatient = textFieldDateBornPatient;
    }

    public JTextField getTextFieldTelephonPersonalPatient() {
        return textFieldTelephonPersonalPatient;
    }

    public void setTextFieldTelephonPersonalPatient(JTextField textFieldTelephonPersonalPatient) {
        this.textFieldTelephonPersonalPatient = textFieldTelephonPersonalPatient;
    }

    public JTextField getTextFieldAddressPatient() {
        return textFieldAddressPatient;
    }

    public void setTextFieldAddressPatient(JTextField textFieldAddressPatient) {
        this.textFieldAddressPatient = textFieldAddressPatient;
    }

    public JScrollPane getScrollPaneAssociatedDiseasesPatient() {
        return scrollPaneAssociatedDiseasesPatient;
    }

    public void setScrollPaneAssociatedDiseasesPatient(JScrollPane scrollPaneAssociatedDiseasesPatient) {
        this.scrollPaneAssociatedDiseasesPatient = scrollPaneAssociatedDiseasesPatient;
    }

    public JScrollPane getScrollPaneObservationPatient() {
        return scrollPaneObservationPatient;
    }

    public void setScrollPaneObservationPatient(JScrollPane scrollPaneObservationPatient) {
        this.scrollPaneObservationPatient = scrollPaneObservationPatient;
    }

    public JTextArea getTextAreaAssosiateDiseasesPatient() {
        return textAreaAssosiateDiseasesPatient;
    }

    public void setTextAreaAssosiateDiseasesPatient(JTextArea textAreaAssosiateDiseasesPatient) {
        this.textAreaAssosiateDiseasesPatient = textAreaAssosiateDiseasesPatient;
    }

    public JTextArea getTextAreaObservationPatient() {
        return textAreaObservationPatient;
    }

    public void setTextAreaObservationPatient(JTextArea textAreaObservationPatient) {
        this.textAreaObservationPatient = textAreaObservationPatient;
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
