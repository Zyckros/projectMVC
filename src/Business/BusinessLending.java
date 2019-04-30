/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import connection.Query;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelLending;

/**
 *
 * @author zyckros
 */
public class BusinessLending {

    private Query query;
    private ResultSet resultset;

    public BusinessLending() {
        query = new Query();
    }

    /**
     * This function get a Strting parameter that is the name on table in
     * database and use this parameter for use Select query and send query to
     * selectQuery function on Query class.
     *
     * @param String - table
     */
    public void select(String table) {

        try {
            resultset = query.selectQuery("select * from " + table);

        } catch (SQLException ex) {
            Logger.getLogger(BusinessBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet getResultset() {
        return resultset;
    }

    /**
     * This function calculate and return number of records in ResultSet
     *
     * @return int - resultset.getRow()
     * @throws SQLException
     */
    public int numberOfRecords() throws SQLException {
        resultset.last();
        return resultset.getRow();
    }

    /**
     * This function calculate and return number of columns in ResultsetMetadata
     *
     * @return int - resultsetmetadata.getColumnCount()
     * @throws SQLException
     */
    public int numberOfColumns() throws SQLException {
        ResultSetMetaData resultsetmetadata;
        resultsetmetadata = resultset.getMetaData();
        return resultsetmetadata.getColumnCount();
    }

    /**
     * This function get a int parameter index and return name of columns from
     * the table
     *
     * @param index
     * @return
     */
    public String nameOfColumn(int index) {
        String[] columnTitle = {"ID", "Code Student", "Code Book", "Lending Date", "Devolution Date", "State"};
        return columnTitle[index];
    }

    /**
     * This function get a int parameter and return ModelLending object with
     * data from row selected
     *
     * @param row
     * @return modelLending
     * @throws SQLException
     */
    public ModelLending getLending(int row) throws SQLException {
        ModelLending modelLending = null;

        if (resultset.absolute(row)) {
            modelLending = new ModelLending();
            modelLending.setId(resultset.getInt("id"));
            modelLending.setStudentCode(resultset.getString("codAlumno"));
            modelLending.setBookCode(resultset.getString("codLibros"));
            modelLending.setLendingDate(resultset.getString("FechaPrestamo"));
            modelLending.setDevolutionDate(resultset.getString("FechaDevolucion"));
            modelLending.setState(resultset.getString("estado"));
        }
        return modelLending;
    }

    /**
     * This function get a ModelLending object parameter and send INSERT query
     * to Query Class with viarable Object
     *
     * @param ModelLending
     */
    public void register(ModelLending modelLending) {

        if (modelLending == null) {
            JOptionPane.showMessageDialog(null, "Error en los campos de texto");
        } else {
            String sql = "insert into prestamos(codAlumno, codLibros, estado, fechaDevolucion, FechaPrestamo, id) VALUES(" + modelLending.getStudentCode() + ",'" + modelLending.getBookCode() + "', '" + modelLending.getState()
                    + "','" + modelLending.getDevolutionDate() + "','" + modelLending.getLendingDate() + "','" + modelLending.getId() + "');";

            int i = query.updateQuery(sql);

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "El prestamo del libro " + modelLending.getBookCode() + " con ID" + modelLending.getId() + " se ha insertado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "El prestamo del libro " + modelLending.getBookCode() + " con ID " + modelLending.getId() + " ya existe en la base de datos");
            }
        }
    }

    /**
     * This function get a ModelLeding object parameter and send UPDATE query to
     * Query Class with viarable Object
     *
     * @param ModelLending
     */
    public void modify(ModelLending modelLending) {

        if (modelLending == null) {
            JOptionPane.showMessageDialog(null, "Error en los campos de texto");
        } else {
            String sql = "UPDATE prestamos SET codAlumno=" + modelLending.getStudentCode() + ", codLibros='" + modelLending.getBookCode() + "', estado='" + modelLending.getState() + "', FechaDevolucion='" + modelLending.getDevolutionDate()
                    + "', FechaPrestamo='" + modelLending.getLendingDate() + "', id='" + modelLending.getId() + "' WHERE id=" + modelLending.getId() + ";";
            int i = query.updateQuery(sql);

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "El prestamo con ID " + modelLending.getId() + " se ha modificado con exito");
            }
        }
    }

    /**
     * This function get a ModelLending object parameter and send DELETE query
     * to Query Class with viarable Object
     *
     * @param ModelLending
     */
    public void delete(ModelLending modelLending) {

        if (modelLending == null) {
            JOptionPane.showMessageDialog(null, "Error en los campos de texto");
        } else {

            String sql = "DELETE FROM prestamos where id = " + modelLending.getId();
            int i = query.updateQuery(sql);

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "El prestamo con ID " + modelLending.getId() + " se ha eliminado con exito");
            }
        }
    }

}
