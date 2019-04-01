/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmvc;

import Business.Business;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.ModelBook;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author zyckros
 */
public class ViewTable extends AbstractTableModel {

    Business business;

    public ViewTable(Business business) {
        this.business = business;

    }

    @Override
    public int getRowCount() {

        int numberofRows = 0;
        try {
            numberofRows = business.numberOfRecords();
        } catch (Exception ex) {

        }
        return numberofRows;
    }

    @Override
    public int getColumnCount() {
        int numberOfColumns = 0;
        try {
            numberOfColumns = business.numberOfColumns();
        } catch (Exception ex) {

        }
        return numberOfColumns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        try {
            rowIndex += 1;
            ModelBook modelbook = new ModelBook();

            switch (columnIndex) {
                case 0:
                    return modelbook.getCode();
                case 1:
                    return modelbook.getTitle();
                case 3:
                    return modelbook.getEditorial();
                case 4:
                    return modelbook.getAutor();
                case 5:
                    return modelbook.getSignature();
                case 6:
                    return modelbook.getState();
                default:
                    throw new AssertionError();
            }
        } catch (Exception ex) {
                Logger.getLogger(ViewTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public String getColumnName(int column){
        return business.nameOfColumn(column);
    }
    
    
}
