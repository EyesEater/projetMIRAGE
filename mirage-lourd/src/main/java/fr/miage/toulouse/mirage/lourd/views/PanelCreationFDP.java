/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.mirage.lourd.views;

import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author calme
 */
public class PanelCreationFDP extends javax.swing.JPanel {

    private Component dynamicPanel;
    
    /**
     * Creates new form PanelCreationFDP
     */
    public PanelCreationFDP() {
        initComponents();
        this.dynamicPanel = this.PanelView;
        fillPanelView();
    }
    
    
    private void fillPanelView(){
        this.remove(this.dynamicPanel);
        this.dynamicPanel = this.add(new PanelListeDemandesCompetences());
        this.revalidate();
        this.repaint();
        System.out.println("HELLO");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelView = new javax.swing.JPanel();
        PanelFooter = new javax.swing.JPanel();
        ButtonFDPCreator = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(854, 712));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Créer Fiche de Poste");

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(605, Short.MAX_VALUE))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        add(PanelHeader, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout PanelViewLayout = new javax.swing.GroupLayout(PanelView);
        PanelView.setLayout(PanelViewLayout);
        PanelViewLayout.setHorizontalGroup(
            PanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
        );
        PanelViewLayout.setVerticalGroup(
            PanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        add(PanelView, java.awt.BorderLayout.CENTER);

        ButtonFDPCreator.setText("Création Fiche de Poste libre");
        ButtonFDPCreator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFDPCreatorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFooterLayout = new javax.swing.GroupLayout(PanelFooter);
        PanelFooter.setLayout(PanelFooterLayout);
        PanelFooterLayout.setHorizontalGroup(
            PanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFooterLayout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(ButtonFDPCreator)
                .addContainerGap(348, Short.MAX_VALUE))
        );
        PanelFooterLayout.setVerticalGroup(
            PanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFooterLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(ButtonFDPCreator)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        add(PanelFooter, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonFDPCreatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFDPCreatorActionPerformed
        JFrame framePDFCreator = new JFrame();
        framePDFCreator.add(new PanelFDPCreator());
        framePDFCreator.setVisible(true);
        framePDFCreator.pack();
    }//GEN-LAST:event_ButtonFDPCreatorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonFDPCreator;
    private javax.swing.JPanel PanelFooter;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelView;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
