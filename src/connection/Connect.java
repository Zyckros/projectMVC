/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zyckros
 */
public final class Connect {

    private static final String hostName = Conf.getHostName();
    private static final String port = Conf.getPort();
    private static final String database = Conf.getDatabase();
    private static final String user = Conf.getUser();
    private static final String password = Conf.getPassword();
    private static Connection connection = null;

    public static void openConnection() {
        try {

            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(hostName + ":" + port + "/" + database + "?zeroDateTimeBehavior=convertToNull", user, password);
            System.out.println(connection);
        } catch (Exception ex) {

            System.out.println("Fallo de conexion en la base de datos: ");
        }

    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection(){
        try {
            System.out.println("connection close");
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
