/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import viewtable.ViewTableBook;
import Business.BusinessBook;
import Business.BusinessLending;
import controller.ControllerBooks;
import controller.ControllerLending;
import controller.ControllerMain;
import controller.ControllerStudents;

import connection.Connect;
import controller.ControllerLogin;
import viewtable.ViewTableLending;

/**
 *
 * @author zyckros
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        Connect.openConnection();
        
        ControllerBooks controllerBooks = new ControllerBooks();
        ControllerStudents controllerStudent = new ControllerStudents();
        ControllerLending controllerLending = new ControllerLending();
        
        ControllerMain controllerMain = new ControllerMain(controllerBooks, controllerStudent, controllerLending);
        
    }

}
