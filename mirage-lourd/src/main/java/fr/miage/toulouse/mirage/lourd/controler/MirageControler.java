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
        return new Object[0][0];
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
    
    
}
