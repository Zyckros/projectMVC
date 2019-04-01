/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

import java.sql.Statement;

/**
 *
 * @author zyckros
 */
public final class connection {

    private static final String hostName = Conf.getHostName();
    private static final String port = Conf.getPort();
    private static final String database = Conf.getDatabase();
    private static final String user = Conf.getUser();
    private static final String password = Conf.getPassword();
    private static Connection connection = null;

    public static void openConnection() {
        try {

            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(hostName + ":" + port + "/" + database, user, password);
            System.out.println(connection);
        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    public static Connection getConnection() {
        return connection;
    }

}
