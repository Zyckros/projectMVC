/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewtable;

import Business.BusinessBook;
import javax.swing.table.AbstractTableModel;
import model.ModelBook;


/**
 *
 * @author zyckros
 */
public class ViewTableBook extends AbstractTableModel {

    BusinessBook businessBook;
    

    public ViewTableBook(BusinessBook businessBook) {
        this.businessBook = businessBook;

    }

    @Override
    public int getRowCount() {

        int numberofRows = 0;
        try {
            numberofRows = businessBook.numberOfRecords();
        } catch (Exception ex) {
               System.err.println("Error on getRowCount: " + ex);
        }
        return numberofRows;
    }

    @Override
    public int getColumnCount() {
        int numberOfColumns = 0;
        try {
            numberOfColumns = businessBook.numberOfColumns();
        } catch (Exception ex) {
                System.err.println("Error on getColmnCount: " + ex);
        }
        return numberOfColumns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        try {
            rowIndex += 1;
            ModelBook modelbook = businessBook.getBook(rowIndex);

            switch (columnIndex) {
                case 0:
                    return modelbook.getCode();
                case 1:
                    return modelbook.getTitle();
                case 2:
                    return modelbook.getAutor();
                case 3:
                    return modelbook.getEditorial();
                case 4:
                    return modelbook.getSignature();
                case 5:
                    return modelbook.getState();

            }
        } catch (Exception ex) {
                System.err.println("Error on getVAlueAt: " + ex);
        }
        return "";
    }

    @Override
    public String getColumnName(int column){
        return businessBook.nameOfColumn(column);
    }
    
    
}
