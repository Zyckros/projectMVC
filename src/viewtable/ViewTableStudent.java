/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewtable;

import Business.BusinessStudent;
import javax.swing.table.AbstractTableModel;
import model.ModelLending;
import model.ModelStudent;

/**
 *
 * @author zyckros
 */
public class ViewTableStudent extends AbstractTableModel {

    private BusinessStudent businessStudent;

    public ViewTableStudent(BusinessStudent businessStudent) {
        
        this.businessStudent = businessStudent;
    }

    public void setBusinessStudent(BusinessStudent businessStudent) {
        this.businessStudent = businessStudent;
    }
    
    

    @Override
    public int getRowCount() {
        int numberOfRecords = 0;

        try {
            numberOfRecords = businessStudent.numberOfRecords();
        } catch (Exception ex) {
            numberOfRecords = 0;
        }

        return numberOfRecords;

    }

    @Override
    public int getColumnCount() {

        int numberOfColumns = 0;

        try {
            numberOfColumns = businessStudent.numberOfColumns();

        } catch (Exception ex) {
            numberOfColumns = 0;
        }

        return numberOfColumns;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rowIndex += 1;
            ModelStudent modelStudent = businessStudent.getStudent(rowIndex);

            switch (columnIndex) {
                case 0:
                    return modelStudent.getRegister();

                case 1:
                    return modelStudent.getName();
                    
                case 2:
                    return modelStudent.getFirstSurname();
                
                case 3:
                    return modelStudent.getSecondSurname();
                
                case 4:
                    return modelStudent.getDni();

            }
        } catch (Exception ex) {
            System.err.println("Error on getValueAt: " + ex);
        }

        return null;

    }

    public String getColumnName(int column) {
        return businessStudent.nameOfColumn(column);
    }

}
