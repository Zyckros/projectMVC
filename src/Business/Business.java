/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import connection.Query;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zyckros
 */
public class Business {

    private Query query;
    private ResultSet resultset;

    public Business() {
        query = new Query();
    }

    public void select() {

        try {
            resultset = query.selectQuery("select * from libros");
        } catch (SQLException ex) {
            Logger.getLogger(Business.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet getResultset() {
        return resultset;
    }

    public int numberOfRecords() throws SQLException {
        resultset.last();
        return resultset.getRow();
    }

    public int numberOfColumns() throws SQLException {
        ResultSetMetaData resultsetmetadata;
        resultsetmetadata = resultset.getMetaData();
        return resultsetmetadata.getColumnCount();
    }

    public String nameOfColumn(int index) {

        String[] columnTitle = {"Code", "Title", "Editorial", "Autor", "Signature", "State"};
        return columnTitle[index];
    }

}
