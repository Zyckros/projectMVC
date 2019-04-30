/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zyckros
 */
public final class Query {

    private static Connection con;
    private ResultSet resultset = null;

    public Query() {
        con = Connect.getConnection();
        System.out.println(con);

    }

    public ResultSet getResultSet() {
        return resultset;
    }

    public static Connection getCon() {
        return con;
    }

    public ResultSet selectQuery(String sql) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            resultset = stmt.executeQuery(sql);

            return resultset;

        } catch (SQLException ex) {
            return null;
        }
    }

    public int updateQuery(String sql) {
        int i = 0;
        System.out.println(sql);
        try {
            Statement stmt = con.createStatement();
            i = stmt.executeUpdate(sql);

        } catch (Exception ex) {
            System.err.println(ex);
            resultset = null;
        }

        return i;
    }

}
