/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.services;

import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.DemandecompetencePK;
import fr.miage.xfe.entities.Equipe;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.repositories.CollaborateurFacade;
import fr.miage.xfe.repositories.DemandecompetenceFacade;
import fr.miage.xfe.repositories.EquipeFacade;
import fr.miage.xfe.repositories.FichedeposteFacade;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sagab
 */
@Stateless
public class GestionCompetences implements GestionCompetencesRemote {

    @Override
    public List listerCompCollaborateurs(Object collaborateur) {
        CollaborateurFacade collaborateurFacade = new CollaborateurFacade();
        return collaborateurFacade.listerCompCollaborateur((Collaborateur) collaborateur);
    }

    @Override
    public List listerCompACombler() {
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        return demandecompetenceFacade.listerCompACombler();
    }

    @Override
    public List listerCompEquipe(Object equipe) {
        EquipeFacade equipeFacade = new EquipeFacade();
        return equipeFacade.listerCompEquipe((Equipe) equipe);
    }

    @Override
    public void gererDemandeComp(Object demandeCompetence) {
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        demandecompetenceFacade.gererDemandeComp((Demandecompetence) demandeCompetence);
    }

    @Override
    public void convertirCompEnFDPoste(Object demandeCompetence, String presentationEntreprise, String presentationPoste) {
        FichedeposteFacade fichedeposteFacade = new FichedeposteFacade();
        Demandecompetence demande = (Demandecompetence) demandeCompetence;
        Fichedeposte fichedeposte = new Fichedeposte(presentationEntreprise, presentationPoste, demande.getCompetence1());
        fichedeposteFacade.creerFDPoste(fichedeposte);
        
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        demandecompetenceFacade.supprimerDemandeComp(demande);
    }

    @Override
    public void creerDemandeComp(Object competence, Object equipe) {
        Competence comp = (Competence) competence;
        Equipe eq = (Equipe) equipe;
        DemandecompetencePK demandecompetencePK = new DemandecompetencePK(comp.getIdcompetence(), eq.getIdequipe());
        Demandecompetence demandecompetence = new Demandecompetence(demandecompetencePK);
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        demandecompetenceFacade.creerDemandeComp(demandecompetence);
    }
}
