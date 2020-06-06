/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.mirage.lourd.others;

import java.awt.Component;
import javax.swing.JTable;

/**
 *
 * @author calme
 */
public class TableFunctions {
    public static void formatTable(JTable tableau){
        for (int row = 0; row < tableau.getRowCount(); row++){
            int rowHeight = tableau.getRowHeight();
            for (int column = 0; column < tableau.getColumnCount(); column++){
                Component comp = tableau.prepareRenderer(tableau.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }
            tableau.setRowHeight(row, rowHeight);
        }
        //return tableau;  
    }
}
