/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import view.ViewInit;
import view.ViewInit;
import view.ViewLending;

/**
 *
 * @author zyckros
 */
public class ControllerLending implements ActionListener {

    private final ViewLending viewLending = new ViewLending();

    public ControllerLending() {
        viewLending.setLocationRelativeTo(null);
        viewLending.setDefaultCloseOperation(HIDE_ON_CLOSE);
        initComponents();
    }

    /**
     * This funcion init components with ActionListener from the ViewLending
     */
    private void initComponents() {
        viewLending.getjButtonDelete().addActionListener(this);
        viewLending.getjButtonModify().addActionListener(this);
        viewLending.getjButtonRegister().addActionListener(this);
        
    }

    /**
     * This function show ViewStudents
     */
    public void activeView() {
        viewLending.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
