/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Business.BusinessLending;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import model.ModelLending;

import view.ViewLending;
import viewtable.ViewTableLending;

/**
 *
 * @author zyckros
 */
public class ControllerLending implements ActionListener, MouseListener {

    private final ViewLending viewLending = new ViewLending();
    private ViewTableLending viewTableLending;
    private final BusinessLending businessLending = new BusinessLending();

    
    public ControllerLending() {
        viewLending.setLocationRelativeTo(null);
        viewLending.setDefaultCloseOperation(HIDE_ON_CLOSE);
        initComponents();
        initProcesses();
    }

    /**
     * This funcion init components with ActionListener from the ViewLending
     */
    private void initComponents() {
        viewLending.getjButtonDelete().addActionListener(this);
        viewLending.getjButtonModify().addActionListener(this);
        viewLending.getjButtonRegister().addActionListener(this);
        viewLending.getjTableLending().addMouseListener(this);

    }

    /**
     * This function init process from view, for set data model on table
     * ViewLending
     */
    private void initProcesses() {
        String table = "prestamos";
        businessLending.select(table);
        viewTableLending = new ViewTableLending(businessLending);
        viewLending.getjTableLending().setModel(viewTableLending);
    }

    /**
     * This function show ViewStudents
     */
    public void activeView() {
        viewLending.setVisible(true);
    }

    /**
     * This function Create a ModelLending Object and set variable data from
     * form in ViewLending to variable ModelLending object
     *
     * @return ModelLending
     */
    private ModelLending modelLendingForm() {

        ModelLending modelLending = new ModelLending();

        try {
            modelLending.setBookCode(viewLending.getjTextFieldBookCode().getText());
            modelLending.setDevolutionDate(viewLending.getjTextFieldReturnDate().getText());
            modelLending.setId(Integer.parseInt(viewLending.getjTextFieldId().getText()));
            modelLending.setLendingDate(viewLending.getjTextFieldLendingDate().getText());
            modelLending.setState((viewLending.getjTextFieldState().getText()));
            modelLending.setStudentCode(viewLending.getjTextFieldStudentCode().getText());

        } catch (Exception ex) {
            System.err.println("Error into modelLEndingForm(): " + ex);
            modelLending = null;
        }
        return modelLending;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ModelLending modelLending = modelLendingForm();

        switch (e.getActionCommand()) {
            case "register":
                businessLending.register(modelLending);
                break;
            case "modify":
                businessLending.modify(modelLending);
                break;
            case "delete":
                businessLending.delete(modelLending);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int column = viewLending.getjTableLending().getSelectedRow();

        viewLending.getjTextFieldBookCode().setText(String.valueOf(viewLending.getjTableLending().getValueAt(column, 2)));
        viewLending.getjTextFieldId().setText(String.valueOf(viewLending.getjTableLending().getValueAt(column, 0)));
        viewLending.getjTextFieldLendingDate().setText(String.valueOf(viewLending.getjTableLending().getValueAt(column, 3)));
        viewLending.getjTextFieldReturnDate().setText(String.valueOf(viewLending.getjTableLending().getValueAt(column, 4)));
        viewLending.getjTextFieldState().setText(String.valueOf(viewLending.getjTableLending().getValueAt(column, 5)));
        viewLending.getjTextFieldStudentCode().setText(String.valueOf(viewLending.getjTableLending().getValueAt(column, 1)));

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
