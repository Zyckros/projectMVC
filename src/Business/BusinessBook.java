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

/**
 *
 * @author zyckros
 */
public class BusinessBook {

    private Query query;
    private ResultSet resultset;

    public BusinessBook() {
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
     * This function get a int parameter index and return name of columns from the table
     *
     * @param index
     * @return
     */
    public String nameOfColumn(int index) {
        String[] columnTitle = {"Code", "Title", "Autor", "Editorial", "Signature", "State"};
        return columnTitle[index];
    }

    /**
     * This function get a int parameter and return ModelBook object with data from row selected
     *
     * @param row
     * @return modelBook
     * @throws SQLException
     */
    public ModelBook getBook(int row) throws SQLException {
        ModelBook modelbook = null;
        if (resultset.absolute(row)) {
            modelbook = new ModelBook();
            modelbook.setCode(resultset.getInt("codigo"));
            modelbook.setTitle(resultset.getString("Titulo"));
            modelbook.setAutor(resultset.getString("Autor"));
            modelbook.setEditorial(resultset.getString("Editorial"));
            modelbook.setSignature(resultset.getString("Asignatura"));
            modelbook.setState(resultset.getString("estado"));
        }

        return modelbook;
    }

    /**
     * This function get a ModelBook object parameter and send INSERT query to Query Class with viarable Object
     *
     * @param modelBook
     */
    public void register(ModelBook modelBook) {

        if (modelBook == null) {
            JOptionPane.showMessageDialog(null, "Error en los campos de texto");
        } else {
            String sql = "insert into libros(codigo, Titulo, Autor, Editorial, Asignatura, estado) VALUES(" + modelBook.getCode() + ",'" + modelBook.getTitle() + "', '" + modelBook.getAutor()
                    + "','" + modelBook.getEditorial() + "','" + modelBook.getSignature() + "','" + modelBook.getState() + "');";

            int i = query.updateQuery(sql);

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "El libro " + modelBook.getTitle() + " se ha insertado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "El libro " + modelBook.getTitle() + " con codigo " + modelBook.getCode() + " ya existe en la base de datos");
            }
        }
    }

    /**
     * This function get a ModelBook object parameter and send UPDATE query to Query Class with viarable Object
     *
     * @param modelBook
     */
    public void modify(ModelBook modelBook) {

        if (modelBook == null) {
            JOptionPane.showMessageDialog(null, "Error en los campos de texto");
        } else {
            String sql = "UPDATE libros SET codigo=" + modelBook.getCode() + ", Titulo='" + modelBook.getTitle() + "', Asignatura='" + modelBook.getSignature() + "', Autor='" + modelBook.getAutor()
                    + "', EdiTorial='" + modelBook.getEditorial() + "', estado='" + modelBook.getState() + "' WHERE codigo=" + modelBook.getCode() + ";";
            int i = query.updateQuery(sql);

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "El libro " + modelBook.getTitle() + " se ha modificado con exito");
            }
        }

    }

    
    /**
     * This function get a ModelBook object parameter and send DELETE query to Query Class with viarable Object
     *
     * @param ModelBook
     */
    public void delete(ModelBook modelBook) {

        if (modelBook == null) {
            JOptionPane.showMessageDialog(null, "Error en los campos de texto");
        } else {

            String sql = "DELETE FROM libros where codigo = " + modelBook.getCode();
            int i = query.updateQuery(sql);

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "El libro " + modelBook.getTitle() + " se ha eliminado con exito");
            }
        }
    }

}
