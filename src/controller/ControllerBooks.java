/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Business.Business;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import projectmvc.ViewTable;
import view.ViewBooks;

/**
 *
 * @author zyckros
 */
public class ControllerBooks implements ActionListener {

    private final ViewBooks viewBooks = new ViewBooks();
    private ViewTable viewTable = null;
    private Business business = new Business();
    

    public ControllerBooks() {
        viewBooks.setLocationRelativeTo(null);
        viewBooks.setDefaultCloseOperation(HIDE_ON_CLOSE);
        initComponents();
        initProcesses();
    }

    /**
     * This funcion init components with ActionListener from the ViewBooks
     */
    private void initComponents() {
       viewBooks.getjButtonDelete().addActionListener(this);
       viewBooks.getjButtonModify().addActionListener(this);
       viewBooks.getjButtonRecord().addActionListener(this);
      
       
    }

    
    private void initProcesses(){
       business.select();
       viewTable = new ViewTable(business);
       viewBooks.getjTableBooks().setModel(viewTable);
       
       
    }
    
    public void activeView(){
        viewBooks.setVisible(true);
    }
    
    
    public void disableView(){
        viewBooks.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "register":
                
                break;
            default:
                throw new AssertionError();
        }
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
