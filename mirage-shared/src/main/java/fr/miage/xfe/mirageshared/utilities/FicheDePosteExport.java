/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.mirageshared.utilities;

/**
 *
 * @author sagab
 */
public class FicheDePosteExport {
    
    private Integer id;
    
    private String presentationEntreprise;
    private String presentationPoste;
    private boolean archivee;
    private CompetenceExport competence;

    public FicheDePosteExport(Integer id, String presentationEntreprise, String presentationPoste, boolean archivee, CompetenceExport competence) {
        this.id = id;
        this.presentationEntreprise = presentationEntreprise;
        this.presentationPoste = presentationPoste;
        this.archivee = archivee;
        this.competence = competence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPresentationEntreprise() {
        return presentationEntreprise;
    }

    public void setPresentationEntreprise(String presentationEntreprise) {
        this.presentationEntreprise = presentationEntreprise;
    }

    public String getPresentationPoste() {
        return presentationPoste;
    }

    public void setPresentationPoste(String presentationPoste) {
        this.presentationPoste = presentationPoste;
    }

    public boolean isArchivee() {
        return archivee;
    }

    public void setArchivee(boolean archivee) {
        this.archivee = archivee;
    }

    public CompetenceExport getCompetence() {
        return competence;
    }

    public void setCompetence(CompetenceExport competence) {
        this.competence = competence;
    }
}
