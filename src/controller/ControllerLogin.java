/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelLogin;
import view.ViewLogin;

/**
 *
 * @author zyckros
 */
public class ControllerLogin implements ActionListener {

    private final ViewLogin viewLogin = new ViewLogin();
    private final ModelLogin modelLogin = new ModelLogin();

    public ControllerLogin() {

        initComponents();
        initProcess();
    }

    /**
     * this function init components on 
     */
    private void initComponents() {
        
    }

    
    /**
     * This function init process
     */
    private void initProcess() {

        viewLogin.setVisible(true);
    }

    /**
     * this function set user and passowrd login on a modelLogin
     *
     * @return ModelLogin
     */
    private ModelLogin modelLoginForm() {

        ModelLogin modelLogin = new ModelLogin();

        modelLogin.setUser(viewLogin.getjTextFieldUser().getText());
        modelLogin.setUser(viewLogin.getjTextFieldPassword().getText());

        return modelLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ModelLogin modelLogin = modelLoginForm();

    }

}
