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
import javax.swing.JOptionPane;
import model.ModelBook;
import model.ModelStudent;

/**
 *
 * @author zyckros
 */
public class BusinessStudent {

    private Query query;
    private ResultSet resultset;

    public BusinessStudent() {
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
        resultset = query.getResultSet();
        return resultset;
    }

    /**
     * This function calculate and return number of records in ResultSet
     *
     * @return
     * @throws SQLException
     */
    public int numberOfRecords() throws SQLException {
        resultset.last();
        return resultset.getRow();
    }

    /**
     * This function calculate and return number of columns in ResultsetMetadata
     *
     * @return
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
        String[] columnTitle = {"registro", "nombre", "apellido 1", "apellido 2", "dni"};
        return columnTitle[index];
    }

    /**
     * This function get a int parameter and return ModelStudent object with
     * data from row selected
     *
     * @param row
     * @return ModelStudent
     * @throws SQLException
     */
    public ModelStudent getStudent(int row) throws SQLException {

        ModelStudent modelStudent = null;
        if (resultset.absolute(row)) {
            modelStudent = new ModelStudent();

            int register = resultset.getInt("registro");

            modelStudent.setDni(resultset.getString("dni"));
            modelStudent.setFirstSurname(resultset.getString("apellido1"));
            modelStudent.setName(resultset.getString("nombre"));
            modelStudent.setRegister(resultset.getInt("registro"));
            modelStudent.setSecondSurname(resultset.getString("apellido2"));

        }

        return modelStudent;
    }

    /**
     * This function get a ModelStudent object parameter and send INSERT query
     * to Query Class with viarable Object
     *
     * @param modelStudent
     */
    public void register(ModelStudent modelStudent) {

        if (modelStudent == null) {
            JOptionPane.showMessageDialog(null, "Error: modelStudent = null");
        } else {
            int result = 0;
            String sql = "insert into alumnos(registro, nombre, dni, apellido1, apellido2) values(" + modelStudent.getRegister() + ", '" + modelStudent.getName() + "', '"
                    + modelStudent.getDni() + "', '" + modelStudent.getFirstSurname() + "', '" + modelStudent.getSecondSurname() + "');";
            //System.out.println(sql);

            result = query.updateQuery(sql);

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Registrado con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "Fallo en el registro");
            }
        }
    }

    /**
     * This function get a ModelStudent object parameter and send UPDATE query
     * to Query Class with viarable Object
     *
     * @param modelStudent
     */
    public void modify(ModelStudent modelStudent) {

        if (modelStudent == null) {
            JOptionPane.showMessageDialog(null, "Error: modelStudent = null");
        } else {
            int result = 0;

            String sql = "UPDATE alumnos SET dni='" + modelStudent.getDni() + "', nombre='" + modelStudent.getName() + "', apellido1='" + modelStudent.getFirstSurname() + "', apellido2='"
                    + modelStudent.getSecondSurname() + "' where registro=" + modelStudent.getRegister() + ";";
            result = query.updateQuery(sql);

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Modificado con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "Fallo en la modificacion");
            }
        }
    }

    /**
     * This function get a ModelStudent object parameter and send DELETE query to
     * Query Class with viarable Object
     *
     * @param ModelStudent
     */
    public void delete(ModelStudent modelStudent) {

        if (modelStudent == null) {
            JOptionPane.showMessageDialog(null, "Error: modelStudent = null");
        } else {
            int result = 0;

            String sql = "delete from alumnos where registro = " + modelStudent.getRegister() + ";";
            result = query.updateQuery(sql);

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Eliminado con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "Fallo en la eliminacion");
            }
        }
    }
}
