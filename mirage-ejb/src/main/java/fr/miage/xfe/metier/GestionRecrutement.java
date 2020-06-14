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
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.repositories.CandidatFacadeLocal;
import fr.miage.xfe.repositories.CandidatureFacadeLocal;
import fr.miage.xfe.repositories.CollaborateurFacadeLocal;
import fr.miage.xfe.repositories.FichedeposteFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sagab
 */
@Stateless
public class GestionRecrutement implements GestionRecrutementLocal {

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    @EJB
    private CandidatFacadeLocal candidatFacade;

    @EJB
    private CandidatureFacadeLocal candidatureFacade;

    @EJB
    private FichedeposteFacadeLocal fichedeposteFacade;
    
    @Override
    public List<Fichedeposte> listerOffres() {
        return this.fichedeposteFacade.listerOffres();
    }

    @Override
    public List<Candidature> listerCandidatures() {
        return this.candidatureFacade.listerCandidatures();
    }

    @Override
    public void candidater(Integer idCandidat, Integer idFDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation) {
        Candidature candidature = new Candidature(candidatFacade.find(idCandidat), fichedeposteFacade.find(idFDPoste), dateCandidature, email, tel, cv, lettreMotivation);
        candidatureFacade.candidater(candidature);
    }

    @Override
    public void recruter(Integer idCandidat, boolean feuxVertCodir) {
        Candidat candidat = candidatFacade.find(idCandidat);
        candidat.setFeuxvertcodir(feuxVertCodir);
        candidatFacade.edit(candidat);
    }

    @Override
    public void concretiserEmbauche(Candidature candidature, String role) {        
        Candidat candidat = candidatFacade.find(candidature.getCandidat1().getIdcandidat());
        collaborateurFacade.concretiserEmbauche(new Collaborateur(candidat, role));
        
        Fichedeposte fichedeposte = fichedeposteFacade.find(candidature.getFichedeposte1().getIdfpd());
        fichedeposte.setArchivee(true);
        fichedeposteFacade.edit(fichedeposte);
        
        candidatureFacade.remove(candidature);
    }

    @Override
    public void supprimerCandidature(Integer idCandidat, Integer idFDposte) {
        Candidature candidature = candidatureFacade.find(new CandidaturePK(idCandidat, idFDposte));
        candidatureFacade.remove(candidature);
    }

    @Override
    public List<Candidat> listerCandidatsARecruter() {
        return candidatFacade.listerCandidatARecruter();
    }

    @Override
    public List<Candidature> listerCandidaturesParOffre(Integer idFDPoste) {
        return this.candidatureFacade.listerCandidatureParOffre(idFDPoste);
    }

    @Override
    public List<Fichedeposte> listerFDPostes() {
        return this.fichedeposteFacade.findAll();
    }

    @Override
    public void ajouterFicheDePoste(Fichedeposte fichedeposte) {
        this.fichedeposteFacade.creerFDPoste(fichedeposte);
    }

    @Override
    public Candidature findCandidature(Integer idCandidat, Integer idFDPoste) {
        CandidaturePK candidaturePK = new CandidaturePK(idCandidat, idFDPoste);
        return this.candidatureFacade.find(candidaturePK);
    }
}
