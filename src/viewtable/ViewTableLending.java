/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewtable;

import Business.BusinessLending;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.ModelLending;

/**
 *
 * @author zyckros
 */
public class ViewTableLending extends AbstractTableModel {

    private BusinessLending businessLending;

    public ViewTableLending(BusinessLending businessLending) {
        this.businessLending = businessLending;
    }

    @Override
    public int getRowCount() {

        int numberOfRow = 0;
        try {
            numberOfRow = businessLending.numberOfRecords();

        } catch (SQLException ex) {
            Logger.getLogger(ViewTableLending.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numberOfRow;
    }

    @Override
    public int getColumnCount() {
        
        int numberOfColumns = 0;
        try {
            numberOfColumns = businessLending.numberOfColumns();   
        } catch (SQLException ex) {
            System.err.println("");
        }
        return numberOfColumns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        
        try{
        
        rowIndex +=1;
        ModelLending modelLending = businessLending.getLending(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return modelLending.getId();
            case 1:
                return modelLending.getStudentCode();
            case 2:
                return modelLending.getBookCode();
            case 3:
                return modelLending.getLendingDate();
            case 4:
                return modelLending.getDevolutionDate();
            case 5: 
                return modelLending.getState();
        }
        }catch (Exception ex) {
            System.err.println("Error on getValueAt: " + ex);
        }
    
    return null;
    }

     
    public String getColumnName(int column){
        return businessLending.nameOfColumn(column);
    }
}
