/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.services;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.repositories.CandidatureFacade;
import fr.miage.xfe.repositories.CollaborateurFacade;
import fr.miage.xfe.repositories.FichedeposteFacade;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sagab
 */
@Stateless
public class GestionRecrutement implements GestionRecrutementRemote {
    
    @Override
    public List<Fichedeposte> listerOffres() {
        FichedeposteFacade fichedeposteFacade = new FichedeposteFacade();
        return fichedeposteFacade.listerOffres();
    }

    @Override
    public List<Candidature> listerCandidatures() {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        return candidatureFacade.listerCandidatures();
    }

    @Override
    public void candidater(Object candidat, Object fDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation) {
        Candidature candidature = new Candidature((Candidat) candidat, (Fichedeposte) fDPoste, dateCandidature, email, tel, cv, lettreMotivation);
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        candidatureFacade.candidater(candidature);
    }

    @Override
    public void recruter(Object candidature, boolean feuxVertCodir) {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        candidatureFacade.recruter((Candidature) candidature, feuxVertCodir);
    }

    @Override
    public void concretiserEmbauche(Object candidat, String role) {
        CollaborateurFacade collaborateurFacade = new CollaborateurFacade();
        collaborateurFacade.concretiserEmbauche(new Collaborateur((Candidat) candidat, role));
    }

    @Override
    public void supprimerCandidature(Object candidature) {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        candidatureFacade.supprimerCandidature((Candidature) candidature);
    }
}
