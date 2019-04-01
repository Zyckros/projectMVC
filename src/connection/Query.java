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
public class Query {

    private Connection con;
    private ResultSet resultset = null;
    
    
    public Query(){
        connection.openConnection();
        con = connection.getConnection();
        System.out.println(con);
    }
    
    
    public ResultSet selectQuery(String sql) throws SQLException{
      try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = stmt.executeQuery(sql);
            return resultset;

        } catch (SQLException ex) {
            return null;
        }
    }
}
