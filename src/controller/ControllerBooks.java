/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Business.BusinessBook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import model.ModelBook;
import viewtable.ViewTableBook;

import view.ViewBooks;

/**
 *
 * @author zyckros
 */
public class ControllerBooks implements ActionListener, MouseListener {

    private final ViewBooks viewBook = new ViewBooks();
    private ViewTableBook viewTableBook = null;
    private BusinessBook businessBook = new BusinessBook();
    
   
    public ControllerBooks() {
        viewBook.setLocationRelativeTo(null);
        viewBook.setDefaultCloseOperation(HIDE_ON_CLOSE);
        initComponents();
        initProcesses();
    
    
    }

    /**
     * This funcion init components with ActionListener from the ViewBooks
     */
    private void initComponents() {
        viewBook.getjButtonDelete().addActionListener(this);
        viewBook.getjButtonModify().addActionListener(this);
        viewBook.getjButtonRecord().addActionListener(this);
        viewBook.getjTableBooks().addMouseListener(this);

    }

    /**
     * This function init process from view, for set data model on table viewBooks
     */
    private void initProcesses() {
        String table = "libros";
        businessBook.select(table);
        viewTableBook = new ViewTableBook(businessBook);
        viewBook.getjTableBooks().setModel(viewTableBook);

    }

    /**
     * this function set visible viewBooks
     */
    public void activeView() {
        viewBook.setVisible(true);
    }

    /**
     * this function set invisible viewBooks
     */
    public void disableView() {
        viewBook.setVisible(false);
    }

    /**
     * This function Create a ModelBook Object and set variable data from form in ViewBook to variable ModelBook object
     * @return ModelBook
     */
    private ModelBook modelBookForm() {
        ModelBook modelBook = new ModelBook();
        
        try{
        modelBook.setAutor(viewBook.getjTextFieldAutor().getText());
        modelBook.setTitle(viewBook.getjTextFieldTitle().getText());
        modelBook.setCode(Integer.parseInt(viewBook.getjTextFieldCode().getText()));
        modelBook.setEditorial(viewBook.getjTextFieldEditorial().getText());
        modelBook.setSignature(viewBook.getjTextFieldSignature().getText());
        modelBook.setState(viewBook.getjTextFieldState().getText());
        
        }catch (Exception ex) {
        modelBook = null;    
        }
        return modelBook;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ModelBook modelBook = modelBookForm();
        
        switch (e.getActionCommand()) {
            case "register":
                businessBook.register(modelBook);
                break;
            case "modify":
                businessBook.modify(modelBook);
                break;
            case "delete":
                businessBook.delete(modelBook);
                break;
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        int column = viewBook.getjTableBooks().getSelectedRow();
        viewBook.getjTextFieldCode().setText(String.valueOf(viewBook.getjTableBooks().getValueAt(column, 0)));
        viewBook.getjTextFieldTitle().setText(String.valueOf(viewBook.getjTableBooks().getValueAt(column, 1)));
        viewBook.getjTextFieldAutor().setText(String.valueOf(viewBook.getjTableBooks().getValueAt(column, 2)));
        viewBook.getjTextFieldEditorial().setText(String.valueOf(viewBook.getjTableBooks().getValueAt(column, 3)));
        viewBook.getjTextFieldSignature().setText(String.valueOf(viewBook.getjTableBooks().getValueAt(column, 4)));
        viewBook.getjTextFieldState().setText(String.valueOf(viewBook.getjTableBooks().getValueAt(column, 5)));
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
