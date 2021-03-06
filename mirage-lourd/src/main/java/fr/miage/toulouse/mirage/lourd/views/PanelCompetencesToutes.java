/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.mirage.lourd.views;

import fr.miage.toulouse.mirage.lourd.controler.MirageControler;
import fr.miage.toulouse.mirage.lourd.others.TableFunctions;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author calme
 */
public class PanelCompetencesToutes extends javax.swing.JPanel {

    private MirageControler ctrl;
    
    /**
     * Creates new form PanelCompetencesToutes
     */
    public PanelCompetencesToutes(MirageControler ctrl) {
        initComponents();
        this.ctrl = ctrl;
        fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(848, 572));
        setLayout(new java.awt.GridLayout(1, 2));
    }// </editor-fold>//GEN-END:initComponents

    private void fillTable(){
        Object[][] donnees = this.ctrl.getAllCompetences();
        String[] entetes = {"ID", "Nom"};
        JTable tableau = new JTable(donnees, entetes);
        TableFunctions.formatTable(tableau);
        tableau.setEnabled(false);
        this.add(tableau.getTableHeader(),BorderLayout.NORTH);
        this.add(new JScrollPane(tableau),BorderLayout.CENTER);        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
