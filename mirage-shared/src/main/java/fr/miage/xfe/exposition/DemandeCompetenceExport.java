/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

/**
 *
 * @author sagab
 */
public class DemandeCompetenceExport {
    
    private CompetenceExport competence;
    private EquipeExport equipe;
    
    private boolean feuxVertCodir;

    public DemandeCompetenceExport(CompetenceExport competence, EquipeExport equipe, boolean feuxVertCodir) {
        this.competence = competence;
        this.equipe = equipe;
        this.feuxVertCodir = feuxVertCodir;
    }

    public CompetenceExport getCompetence() {
        return competence;
    }

    public void setCompetence(CompetenceExport competence) {
        this.competence = competence;
    }

    public EquipeExport getEquipe() {
        return equipe;
    }

    public void setEquipe(EquipeExport equipe) {
        this.equipe = equipe;
    }

    public boolean isFeuxVertCodir() {
        return feuxVertCodir;
    }

    public void setFeuxVertCodir(boolean feuxVertCodir) {
        this.feuxVertCodir = feuxVertCodir;
    }   
}
