/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.CandidaturePK;
import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.repositories.CandidatureFacade;
import fr.miage.xfe.repositories.CollaborateurFacade;
import fr.miage.xfe.repositories.FichedeposteFacade;
import fr.miage.xfe.services.GestionRecrutementRemote;
import java.util.ArrayList;
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
    public List<FicheDePosteExport> listerOffres() {
        FichedeposteFacade fichedeposteFacade = new FichedeposteFacade();
        List<FicheDePosteExport> fiches = new ArrayList<>();
        for(Fichedeposte f : fichedeposteFacade.listerOffres()) {
            fiches.add(new FicheDePosteExport(f.getIdfpd(), f.getPresentationentreprisefdp(), f.getPresentationpostefdp(), f.getArchivee(), new CompetenceExport(f.getCompetencesfdp().getIdcompetence(), f.getCompetencesfdp().getNomcompetence())));
        }
        return fiches;
    }

    @Override
    public List<CandidatureExport> listerCandidatures() {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        List<CandidatureExport> candidatures = new ArrayList<>();
        for(Candidature c : candidatureFacade.listerCandidatures()) {
            CandidatExport candidat = new CandidatExport(c.getCandidat1().getIdcandidat(), c.getCandidat1().getNomcandidat(), c.getCandidat1().getPrenomcandidat(), c.getCandidat1().getFeuxvertcodir());
            FicheDePosteExport poste = new FicheDePosteExport(c.getFichedeposte1().getIdfpd(), c.getFichedeposte1().getPresentationentreprisefdp(), c.getFichedeposte1().getPresentationpostefdp(), c.getFichedeposte1().getArchivee(), new CompetenceExport(c.getFichedeposte1().getCompetencesfdp().getIdcompetence(), c.getFichedeposte1().getCompetencesfdp().getNomcompetence()));
            candidatures.add(new CandidatureExport(candidat, poste, c.getDatecandidature(), c.getTelephone(), c.getEmail(), c.getCv(), c.getLettremotivation()));
        }
        return candidatures;
    }

    @Override
    public void candidater(CandidatExport candidat, FicheDePosteExport fDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation) {
        Candidat c = new Candidat(candidat.getId(), candidat.getNom(), candidat.getPrenom(), candidat.isFeuxVertCodir());
        Fichedeposte f = new Fichedeposte(fDPoste.getId(), fDPoste.getPresentationEntreprise(), fDPoste.getPresentationPoste(), fDPoste.isArchivee(), new Competence(fDPoste.getCompetence().getId(), fDPoste.getCompetence().getNomCompetence()));
        Candidature candidature = new Candidature(c, f, dateCandidature, email, tel, cv, lettreMotivation);
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        candidatureFacade.candidater(candidature);
    }

    @Override
    public void recruter(CandidatureExport candidature, boolean feuxVertCodir) {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        Candidature c = new Candidature(new CandidaturePK(candidature.getCandidat().getId(), candidature.getFicheDePoste().getId()), candidature.getDateCandidature(), candidature.getEmail(), candidature.getTel(), candidature.getCv(), candidature.getLettreMotiv());
        candidatureFacade.recruter(c, feuxVertCodir);
    }

    @Override
    public void concretiserEmbauche(CandidatExport candidat, String role) {
        CollaborateurFacade collaborateurFacade = new CollaborateurFacade();
        Candidat c = new Candidat(candidat.getId(), candidat.getNom(), candidat.getPrenom(), candidat.isFeuxVertCodir());
        collaborateurFacade.concretiserEmbauche(new Collaborateur(c, role));
    }

    @Override
    public void supprimerCandidature(CandidatureExport candidature) {
        CandidatureFacade candidatureFacade = new CandidatureFacade();
        Candidature c = new Candidature(new CandidaturePK(candidature.getCandidat().getId(), candidature.getFicheDePoste().getId()), candidature.getDateCandidature(), candidature.getEmail(), candidature.getTel(), candidature.getCv(), candidature.getLettreMotiv());
        candidatureFacade.supprimerCandidature(c);
    }
}
