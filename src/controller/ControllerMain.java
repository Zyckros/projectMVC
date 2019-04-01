/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sun.awt.X11.Screen;
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
        viewInit.setVisible(true);
        viewInit.setLocationRelativeTo(null);
        initComponents();
        
    }

    /**
     * This funcion init components with ActionListener from the ViewInit
     */
    private void initComponents() {
        viewInit.getjButtonBooks().addActionListener(this);
        viewInit.getjButtonLending().addActionListener(this);
        viewInit.getjButtonStudents().addActionListener(this);
    }

    public void activeView() {
        viewInit.setVisible(true);
    }

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
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
