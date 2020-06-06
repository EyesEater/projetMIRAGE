/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.mirage.lourd.views;

import fr.miage.toulouse.mirage.lourd.others.TableFunctions;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Formattable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author calme
 */
public class PanelCandidat extends javax.swing.JPanel {

    /**
     * Creates new form PanelCandidat
     */
    public PanelCandidat(String idCandidat) {
        initComponents();
        fillCandidat(idCandidat);
    }

    private void fillCandidat(String idCandidat){
        Boolean aConcretiser = true;
        if(Math.random()<0.5)
            aConcretiser = false;
        Object[][] candidat = {{idCandidat,"Edmond","Fyon","<html><ul><li>A</li><li>B</li></ul></html>",aConcretiser}};
        String[] entetes = {"ID","Prénom","Nom","Compétences"};
        JTable tabCandidat = new JTable(candidat, entetes);
        TableFunctions.formatTable(tabCandidat);
        JButton buttonConcretiser = new JButton("Concrétiser");
        if(!(boolean)candidat[0][candidat[0].length-1]){
            buttonConcretiser.setEnabled(false);
        }
        JPanel panTab = new JPanel(new BorderLayout());
        panTab.add(tabCandidat.getTableHeader(),BorderLayout.NORTH);
        panTab.add(tabCandidat,BorderLayout.CENTER);
        this.add(panTab);
        this.add(buttonConcretiser);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}