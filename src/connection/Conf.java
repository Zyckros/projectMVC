/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *  this class is used for the configuration data of the database
 * @author zyckros
 */
public final class Conf {
    
    private static final String hostName = "jdbc:mysql://localhost";
    private static final String port = "3306";
    private static final String database = "biblioteca";
    private static final String user = "root";
    private static final String password = "";

    
    public static String getHostName() {
        return hostName;
    }

    public static String getPort() {
        return port;
    }

    public static String getDatabase() {
        return database;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    

}
