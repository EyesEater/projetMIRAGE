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
    public List<Competence> listerCompCollaborateurs(Collaborateur collaborateur) {
        CollaborateurFacade collaborateurFacade = new CollaborateurFacade();
        return collaborateurFacade.listerCompCollaborateur(collaborateur);
    }

    @Override
    public List<Demandecompetence> listerCompACombler() {
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        return demandecompetenceFacade.listerCompACombler();
    }

    @Override
    public List<Competence> listerCompEquipe(Equipe equipe) {
        EquipeFacade equipeFacade = new EquipeFacade();
        return equipeFacade.listerCompEquipe(equipe);
    }

    @Override
    public void gererDemandeComp(Demandecompetence demandeCompetence) {
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        demandecompetenceFacade.gererDemandeComp(demandeCompetence);
    }

    @Override
    public void convertirCompEnFDPoste(Demandecompetence demandeCompetence, String presentationEntreprise, String presentationPoste) {
        FichedeposteFacade fichedeposteFacade = new FichedeposteFacade();
        Fichedeposte fichedeposte = new Fichedeposte(presentationEntreprise, presentationPoste, demandeCompetence.getCompetence1());
        fichedeposteFacade.creerFDPoste(fichedeposte);
        
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        demandecompetenceFacade.supprimerDemandeComp(demandeCompetence);
    }

    @Override
    public void creerDemandeComp(Competence competence, Equipe equipe) {
        DemandecompetencePK demandecompetencePK = new DemandecompetencePK(competence.getIdcompetence(), equipe.getIdequipe());
        Demandecompetence demandecompetence = new Demandecompetence(demandecompetencePK);
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        demandecompetenceFacade.creerDemandeComp(demandecompetence);
    }
}
