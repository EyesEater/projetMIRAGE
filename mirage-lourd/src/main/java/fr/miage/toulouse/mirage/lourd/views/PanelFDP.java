/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.mirage.lourd.views;

import fr.miage.toulouse.mirage.lourd.controler.MirageControler;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author calme
 */
public class PanelFDP extends javax.swing.JPanel {

    private MirageControler ctrl;
    
    /**
     * Creates new form PanelFDP
     */
    public PanelFDP(String idFDP,MirageControler ctrl) {
        initComponents();
        this.ctrl = ctrl;
        fillFDP(idFDP);
    }

    private void fillFDP(String idFDP){
        this.TxtPoste.setText("OI?IOC?EO?Z");
        this.TxtPoste.setEditable(false);
        
        String[] candidats = {"1","2","3"};
        this.PanelCandidats.setLayout(new GridLayout(candidats.length, 2));
        for (String candidat : candidats) {
            this.PanelCandidats.add(new PanelCandidat(candidat,this.ctrl));
        }
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPoste = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtPoste = new javax.swing.JTextArea();
        PanelCandidats = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(848, 606));
        setLayout(new java.awt.BorderLayout());

        PanelPoste.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Poste");

        TxtPoste.setColumns(20);
        TxtPoste.setRows(5);
        jScrollPane1.setViewportView(TxtPoste);

        javax.swing.GroupLayout PanelPosteLayout = new javax.swing.GroupLayout(PanelPoste);
        PanelPoste.setLayout(PanelPosteLayout);
        PanelPosteLayout.setHorizontalGroup(
            PanelPosteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPosteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelPosteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPosteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPosteLayout.setVerticalGroup(
            PanelPosteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPosteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        add(PanelPoste, java.awt.BorderLayout.PAGE_START);

        PanelCandidats.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Candidats", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        PanelCandidats.setLayout(new javax.swing.BoxLayout(PanelCandidats, javax.swing.BoxLayout.PAGE_AXIS));
        add(PanelCandidats, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCandidats;
    private javax.swing.JPanel PanelPoste;
    private javax.swing.JTextArea TxtPoste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
