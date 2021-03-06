/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.mirage.lourd.views;

import fr.miage.toulouse.mirage.lourd.controler.MirageControler;
import fr.miage.xfe.mirageshared.utilities.CompetenceExport;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author calme
 */
public class PanelFDPCreator extends javax.swing.JPanel {

    private MirageControler ctrl;
    private CheckboxGroup groupeCompetences;
    
    /**
     * Creates new form PanelFDPCreator
     */
    public PanelFDPCreator(MirageControler ctrl) {
        initComponents();
        this.ctrl = ctrl;
        fillCompetences();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PanelEntreprise = new javax.swing.JScrollPane();
        TxtEntreprise = new javax.swing.JTextArea();
        PanelPoste = new javax.swing.JScrollPane();
        TxtPoste = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ButtonAnnuler = new javax.swing.JButton();
        ButtonValider = new javax.swing.JButton();
        PanelCompetences = new javax.swing.JPanel();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(854, 712));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("FDP Creator");

        TxtEntreprise.setColumns(20);
        TxtEntreprise.setRows(5);
        PanelEntreprise.setViewportView(TxtEntreprise);

        TxtPoste.setColumns(20);
        TxtPoste.setRows(5);
        PanelPoste.setViewportView(TxtPoste);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Description de l'entreprise");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Description du poste");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Compétences");

        ButtonAnnuler.setText("Annuler");
        ButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAnnulerActionPerformed(evt);
            }
        });

        ButtonValider.setText("Valider");
        ButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCompetencesLayout = new javax.swing.GroupLayout(PanelCompetences);
        PanelCompetences.setLayout(PanelCompetencesLayout);
        PanelCompetencesLayout.setHorizontalGroup(
            PanelCompetencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelCompetencesLayout.setVerticalGroup(
            PanelCompetencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(ButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(ButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(PanelEntreprise, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                            .addComponent(PanelPoste)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(PanelCompetences, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelEntreprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(PanelPoste, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCompetences, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAnnulerActionPerformed
        ((JFrame)getParent().getParent().getParent().getParent()).dispose();
    }//GEN-LAST:event_ButtonAnnulerActionPerformed

    private void ButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonValiderActionPerformed
        String presentationPoste = this.TxtPoste.getText();
        String presentationEntreprise = this.TxtEntreprise.getText();
        Integer idCompetence = Integer.parseInt(this.groupeCompetences.getSelectedCheckbox().getName()); 
        if(!"".equals(presentationEntreprise) && !"".equals(presentationPoste) && idCompetence!=null){
            CompetenceExport cmp = this.ctrl.getCompetence(idCompetence);
            this.ctrl.addFDP(cmp, presentationEntreprise, presentationPoste);
            ((JFrame)getParent().getParent().getParent().getParent()).dispose();          
        }else{
            javax.swing.JOptionPane.showMessageDialog(this,"Erreur: Formulaire incomplet");            
        }
    }//GEN-LAST:event_ButtonValiderActionPerformed

    private void fillCompetences(){
        Object[][] donnees = this.ctrl.getAllCompetences();
        int nbColumns = donnees.length/5;
        this.PanelCompetences.setLayout(new GridLayout(5, nbColumns));
        CheckboxGroup groupCompetences = new CheckboxGroup();
        for (Object[] donnee : donnees) {
            Checkbox c = new Checkbox((String)donnee[1]);
            System.out.println(((Integer)donnee[0]).toString());
            c.setName(((Integer)donnee[0]).toString());
            
            c.setCheckboxGroup(groupCompetences);
            c.setState(true);
            this.PanelCompetences.add(c);
        }
        this.groupeCompetences = groupCompetences;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAnnuler;
    private javax.swing.JButton ButtonValider;
    private javax.swing.JPanel PanelCompetences;
    private javax.swing.JScrollPane PanelEntreprise;
    private javax.swing.JScrollPane PanelPoste;
    private javax.swing.JTextArea TxtEntreprise;
    private javax.swing.JTextArea TxtPoste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
