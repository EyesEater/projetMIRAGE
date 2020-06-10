/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.metier;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.CandidaturePK;
import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.repositories.CandidatFacade;
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
public class GestionRecrutement implements GestionRecrutementLocal {
    
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
    public void candidater(Long idCandidat, Long idFDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation) {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        CandidatFacade candidatFacade = new CandidatFacade();
        FichedeposteFacade facade = new FichedeposteFacade();
        Candidature candidature = new Candidature(candidatFacade.find(idCandidat), facade.find(idFDPoste), dateCandidature, email, tel, cv, lettreMotivation);
        candidatureFacade.candidater(candidature);
    }

    @Override
    public void recruter(Long idCandidature, boolean feuxVertCodir) {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        Candidature candidature = candidatureFacade.find(idCandidature);
        candidatureFacade.recruter(candidature, feuxVertCodir);
    }

    @Override
    public void concretiserEmbauche(Long idCandidat, String role) {
        CollaborateurFacade collaborateurFacade = new CollaborateurFacade();
        CandidatFacade candidatFacade = new CandidatFacade();
        Candidat candidat = candidatFacade.find(idCandidat);
        collaborateurFacade.concretiserEmbauche(new Collaborateur(candidat, role));
    }

    @Override
    public void supprimerCandidature(Long idCandidat, Long idFDposte) {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        Candidature candidature = candidatureFacade.find(new CandidaturePK(idCandidat.intValue(), idFDposte.intValue()));
        candidatureFacade.supprimerCandidature(candidature);
    }

    @Override
    public List<Candidat> listerCandidatsARecruter() {
        CandidatFacade candidatFacade = new CandidatFacade();
        return candidatFacade.listerCandidatARecruter();
    }
}
