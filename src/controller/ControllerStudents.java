/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import view.ViewStudents;

/**
 *
 * @author zyckros
 */
public class ControllerStudents implements ActionListener {

    private final ViewStudents viewStudents = new ViewStudents();

    public ControllerStudents() {
        viewStudents.setLocationRelativeTo(null);
        viewStudents.setDefaultCloseOperation(HIDE_ON_CLOSE);
        initComponents();
    }

    /**
     * This funcion init components with ActionListener from the ViewStudents
     */
    private void initComponents() {
        viewStudents.getjButtonDelete().addActionListener(this);
        viewStudents.getjButtonModify().addActionListener(this);
        viewStudents.getjButtonRegister().addActionListener(this);
        
    }

    /**
     * This function show ViewStudents
     */
    public void activeView() {
        viewStudents.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
