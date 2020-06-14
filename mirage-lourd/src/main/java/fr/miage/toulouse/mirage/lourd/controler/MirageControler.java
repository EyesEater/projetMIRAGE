/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.mirage.lourd.controler;

import fr.miage.xfe.mirageshared.interfremote.ExpoLourdeRemote;
import fr.miage.xfe.mirageshared.utilities.CandidatExport;
import fr.miage.xfe.mirageshared.utilities.CollaborateurExport;
import fr.miage.xfe.mirageshared.utilities.CompetenceExport;
import fr.miage.xfe.mirageshared.utilities.DemandeCompetenceExport;
import fr.miage.xfe.mirageshared.utilities.EquipeExport;
import java.util.List;

/**
 *
 * @author calme
 */
public class MirageControler {
    private ExpoLourdeRemote remote;
    
    public MirageControler(ExpoLourdeRemote remote){
        this.remote = remote;
    }
    
    public Object[][] getCompetencesCollaborateurs(){
        Object[][] donnees = new Object[this.remote.listerCollaborateurs().size()][4];
        int count = 0;
        for (CollaborateurExport collaborateur : this.remote.listerCollaborateurs()) {
            donnees[count][0] = collaborateur.getId();
            CandidatExport candidat = collaborateur.getCandidat();
            donnees[count][1] = candidat.getNom();
            donnees[count][2] = candidat.getPrenom();
            String listeComp = "<html><ul>";
            for (CompetenceExport competenceExport : this.remote.listerCompCollaborateur(collaborateur)) {
                listeComp+="<li>"+competenceExport.getNomCompetence()+"</li>";
            }
            listeComp+="</ul></html>";
            donnees[count][3] = listeComp;
            count++;
        }
        return donnees;
    }
    
    public Object[][] getAllCompetences(){
        Object[][] donnees = new Object[this.remote.listerCompetences().size()][2];
        int count = 0;
        for (CompetenceExport competence : this.remote.listerCompetences()) {
            donnees[count][0] = competence.getId();
            donnees[count][1] = competence.getNomCompetence();
            count++;
        }
        return donnees;
    }
    
    public Object[][] getCompetencesEquipes(){
        Object[][] donnees = new Object[this.remote.listerEquipes().size()][3];
        int count = 0;
        for (EquipeExport equipe : this.remote.listerEquipes()) {
            donnees[count][0] = equipe.getId();
            donnees[count][1] = equipe.getNom();
            String listeComp = "<html><ul>";
            for (CompetenceExport competenceExport : this.remote.listerCompEquipe(equipe)) {
                listeComp+="<li>"+competenceExport.getNomCompetence()+"</li>";
            }
            listeComp+="</ul></html>";
            donnees[count][2] = listeComp;
            count++;
        }
        return donnees;
    }
    
    public Object[][] getAllDemandesCompetences(){
        Object[][] donnees = new Object[this.remote.listerDemandesCompetences().size()][4];
        int count = 0;
        for (DemandeCompetenceExport demandeCompetence : this.remote.listerDemandesCompetences()) {
            if(demandeCompetence.isFeuxVertCodir()){
                CompetenceExport competence = demandeCompetence.getCompetence();
                donnees[count][0] = competence.getId();
                donnees[count][1] = competence.getNomCompetence();
                EquipeExport equipe = demandeCompetence.getEquipe();
                donnees[count][2] = equipe.getId();
                donnees[count][3] = equipe.getNom();
                count++;                
            }else{
                Object[][] temp = new Object[donnees.length-1][4];
                System.arraycopy(donnees, 0, temp, 0, donnees.length-1);
                donnees = temp;
            }
        }
        return donnees;
    }
    
    public DemandeCompetenceExport getDemandeCompetence(int idComp,int idEquipe){
        for (DemandeCompetenceExport demandeCompetence : this.remote.listerDemandesCompetences()) {
            if(demandeCompetence.getCompetence().getId()==idComp && demandeCompetence.getEquipe().getId()==idEquipe)
                return demandeCompetence;
        }
        return null;
    }  
    
    public void convertirDemandeCompetence(DemandeCompetenceExport demande, String presentationPoste, String presentationEntreprise){
        this.remote.convertirCompEnFDPoste(demande, presentationPoste, presentationEntreprise);
    }
    
}
