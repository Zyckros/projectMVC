/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewInit;

/**
 *
 * @author zyckros
 */
public class ControllerMain implements ActionListener {

    
    private final ViewInit viewInit = new ViewInit();
    private final ControllerBooks ctrlBooks;
    private final ControllerStudents ctrlStudents;
    private final ControllerLending ctrlLending;

    
    public ControllerMain(ControllerBooks ctrlBooks, ControllerStudents ctrlStudents, ControllerLending ctrlLending) {
        this.ctrlBooks = ctrlBooks;
        this.ctrlLending = ctrlLending;
        this.ctrlStudents = ctrlStudents;
        
        initComponents();
        initProcess();
    }

    /**
     * This funcion init components with ActionListener from the ViewInit
     */
    private void initComponents() {
        viewInit.getjButtonBooks().addActionListener(this);
        viewInit.getjButtonLending().addActionListener(this);
        viewInit.getjButtonStudents().addActionListener(this);
    }

    /**
     * This function init process of ViewInit
     */
    private void initProcess(){
        viewInit.setVisible(true);
        viewInit.setLocationRelativeTo(null);
        
    }
    
    /**
     * This function set visible viewInit
     */
    public void activeView() {
        viewInit.setVisible(true);
    }

    /**
     * this function set invisible ViewInit
     */
    public void disableView() {
        viewInit.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("books")) {
            ctrlBooks.activeView();
        }
        if (e.getActionCommand().equalsIgnoreCase("lending")) {
            ctrlLending.activeView();
        }
        if (e.getActionCommand().equalsIgnoreCase("students")) {
            ctrlStudents.activeView();
        }
    }
}
