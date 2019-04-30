/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Business.BusinessStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import model.ModelStudent;
import view.ViewStudents;
import viewtable.ViewTableStudent;

/**
 *
 * @author zyckros
 */
public class ControllerStudents implements ActionListener, MouseListener {

    private final ViewStudents viewStudents = new ViewStudents();
    private ViewTableStudent viewTableStudent = null;
    private final BusinessStudent businessStudent = new BusinessStudent();

    public ControllerStudents() {
        viewStudents.setLocationRelativeTo(null);
        viewStudents.setDefaultCloseOperation(HIDE_ON_CLOSE);
        initComponents();
        initProcesses();
    }

    /**
     * This funcion init components with ActionListener from the ViewStudents
     */
    private void initComponents() {
        viewStudents.getjButtonDelete().addActionListener(this);
        viewStudents.getjButtonModify().addActionListener(this);
        viewStudents.getjButtonRegister().addActionListener(this);
        viewStudents.getjTableStudent().addMouseListener(this);
        
    }
    
    /**
     * This function init process of ViewStudent
     */
    private void initProcesses(){
        String table = "alumnos";
        businessStudent.select(table);
        viewTableStudent = new ViewTableStudent(businessStudent);
        viewStudents.getjTableStudent().setModel(viewTableStudent);
        
    }
    
    
    /**
     * This function set visible ViewStudents
     */
    public void activeView() {
        viewStudents.setVisible(true);
    }
    
    /**
     * This function Create a ModelStudent Object and set variable data from form in ViewBook to variable ModelBook object
     * @return ModelStudent
     */
    private ModelStudent modelStudentForm() {
        ModelStudent modelStudent = new ModelStudent();
        
        try{
            
            modelStudent.setDni(viewStudents.getjTextFieldDni().getText());
            modelStudent.setFirstSurname(viewStudents.getjTextFieldFirstSurname().getText());
            modelStudent.setName(viewStudents.getjTextFieldName().getText());
            modelStudent.setRegister(Integer.parseInt(viewStudents.getjTextFieldRegistryNumber().getText()));
            modelStudent.setSecondSurname(viewStudents.getjTextFieldSecondSurname().getText());
        
        }catch (Exception ex) {
        modelStudent = null;    
        }
        return modelStudent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        ModelStudent model = modelStudentForm();
        
        switch(e.getActionCommand()){
            case "register":
                    businessStudent.register(model);
                break;
            case "modify":
                businessStudent.modify(model);
                break;
            case "delete":
                    businessStudent.delete(model);
                break;
        }
        
        businessStudent.select("alumnos");
        viewTableStudent = new ViewTableStudent(businessStudent);
        viewTableStudent.setBusinessStudent(businessStudent);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = viewStudents.getjTableStudent().getSelectedRow();
        
        viewStudents.getjTextFieldDni().setText(String.valueOf(viewStudents.getjTableStudent().getValueAt(row, 4)));
        viewStudents.getjTextFieldFirstSurname().setText(String.valueOf(viewStudents.getjTableStudent().getValueAt(row, 2)));
        viewStudents.getjTextFieldName().setText(String.valueOf(viewStudents.getjTableStudent().getValueAt(row, 1)));
        viewStudents.getjTextFieldRegistryNumber().setText(String.valueOf(viewStudents.getjTableStudent().getValueAt(row, 0)));
        viewStudents.getjTextFieldSecondSurname() .setText(String.valueOf(viewStudents.getjTableStudent().getValueAt(row, 3)));
        
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
