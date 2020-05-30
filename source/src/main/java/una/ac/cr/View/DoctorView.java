package una.ac.cr.View;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DoctorView extends JFrame {

    private JLabel labelName;
    private JLabel labelTypoDoctor;

    private JTextField textFielName;
    private JTextField textFielFilter;

    private JComboBox comboBoxType_Doctor;
    private JCheckBox checkBoxPremium;

    private JButton buttonSave;
    private JButton buttonCancel;
    private JButton buttonDelete;
    private JButton buttonUpDate;
    private JButton buttonFilter;

    private JTable table;
    private DefaultTableModel tableModel;

    public DoctorView(String titleView) {
        super(titleView);

        // Using logger for project
        final Logger logger = LogManager.getLogger(DoctorView.class);

        logger.debug("Design Pattern MVC: [VIEW]");

        this.getContentPane().setBackground(Color.lightGray);
        this.setSize(750, 550);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonSave= new JButton("Save");
        buttonSave.setBounds(5,115,80,20);
        buttonSave.setName("save");
        buttonCancel= new JButton("Back");
        buttonCancel.setBounds(5,5,80,20);
        buttonCancel.setName("cancel");
        buttonDelete= new JButton("Delete");
        buttonDelete.setBounds(85,115,80,20);
        buttonDelete.setName("delete");
        buttonUpDate= new JButton("UpDate");
        buttonUpDate.setBounds(165,115,80,20);
        buttonUpDate.setName("update");
        buttonFilter= new JButton("Filter");
        buttonFilter.setBounds(155,140,100,20);
        buttonFilter.setName("filter");

        labelName = new JLabel("Nombre");
        labelName.setBounds(5,35,80,20);
        labelTypoDoctor = new JLabel("Tipo Doctor");
        labelTypoDoctor.setBounds(5,60,100,20);

        textFielName= new JTextField();
        textFielName.setBounds(70,35,150,20);
        textFielFilter= new JTextField();
        textFielFilter.setBounds(5,140,150,20);

        comboBoxType_Doctor=new JComboBox();
        comboBoxType_Doctor.setBounds(100,60,100,20);
        comboBoxType_Doctor.setName("comboboctypo_doctor");

        checkBoxPremium= new JCheckBox("Premium");
        checkBoxPremium.setBounds(5,85,80,20);
        checkBoxPremium.setName("checkboxpremium");


        table = new JTable();
        tableModel = new DefaultTableModel();

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);
        JScrollPane scrollPane= new JScrollPane(table);
        scrollPane.setBounds(10,170,700,300);

        add(buttonCancel);
        add(labelName);
        add(textFielName);
        add(labelTypoDoctor);
        add(comboBoxType_Doctor);
        add(checkBoxPremium);
        add(buttonSave);
        add(buttonDelete);
        add(buttonUpDate);
        add(textFielFilter);
        add(buttonFilter);
        add(scrollPane);
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public void setLabelName(JLabel labelName) {
        this.labelName = labelName;
    }

    public JLabel getLabelTypoDoctor() {
        return labelTypoDoctor;
    }

    public void setLabelTypoDoctor(JLabel labelTypoDoctor) {
        this.labelTypoDoctor = labelTypoDoctor;
    }

    public JTextField getTextFielName() {
        return textFielName;
    }

    public void setTextFielName(JTextField textFielName) {
        this.textFielName = textFielName;
    }

    public JTextField getTextFielFilter() {
        return textFielFilter;
    }

    public void setTextFielFilter(JTextField textFielFilter) {
        this.textFielFilter = textFielFilter;
    }

    public JComboBox getComboBoxType_Doctor() {
        return comboBoxType_Doctor;
    }

    public void setComboBoxType_Doctor(JComboBox comboBoxType_Doctor) {
        this.comboBoxType_Doctor = comboBoxType_Doctor;
    }

    public JCheckBox getCheckBoxPremium() {
        return checkBoxPremium;
    }

    public void setCheckBoxPremium(JCheckBox checkBoxPremium) {
        this.checkBoxPremium = checkBoxPremium;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(JButton buttonSave) {
        this.buttonSave = buttonSave;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(JButton buttonDelete) {
        this.buttonDelete = buttonDelete;
    }

    public JButton getButtonUpDate() {
        return buttonUpDate;
    }

    public void setButtonUpDate(JButton buttonUpDate) {
        this.buttonUpDate = buttonUpDate;
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
