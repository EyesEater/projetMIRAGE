/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

import fr.miage.xfe.mirageshared.utilities.CandidatExport;
import fr.miage.xfe.mirageshared.utilities.CompetenceExport;
import fr.miage.xfe.mirageshared.utilities.DemandeCompetenceExport;
import fr.miage.xfe.mirageshared.utilities.CandidatureExport;
import fr.miage.xfe.mirageshared.utilities.FicheDePosteExport;
import fr.miage.xfe.mirageshared.utilities.CollaborateurExport;
import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.DemandecompetencePK;
import fr.miage.xfe.entities.Fichedeposte;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.miage.xfe.metier.GestionCompetencesLocal;
import fr.miage.xfe.metier.GestionRecrutementLocal;
import java.util.ArrayList;
import fr.miage.xfe.mirageshared.interfremote.ExpoLourdeRemote;

/**
 *
 * @author sagab
 */
@Stateless
public class ExpoLourde implements ExpoLourdeRemote {

    @EJB
    private GestionRecrutementLocal gestionRecrutement;

    @EJB
    private GestionCompetencesLocal gestionCompetences;

    @Override
    public List<CompetenceExport> listerCompCollaborateur(CollaborateurExport collaborateurExport) {
        Collaborateur collaborateur = new Collaborateur(collaborateurExport.getId(), collaborateurExport.getRole());
        List<CompetenceExport> competences = new ArrayList<>();
        for(Competence c : this.gestionCompetences.listerCompCollaborateurs(collaborateur)) {
            competences.add(new CompetenceExport(c.getIdcompetence(), c.getNomcompetence()));
        }
        return competences;
    }

    @Override
    public void concretiserEmbauche(CandidatExport candidatExport, String role) {
        this.gestionRecrutement.concretiserEmbauche(candidatExport.getId().longValue(), role);
    }

    @Override
    public List<CandidatureExport> listerCandidatures() {
        List<CandidatureExport> candidatures = new ArrayList<>();
        for(Candidature c : this.gestionRecrutement.listerCandidatures()) {
            Candidat candTemp = c.getCandidat1();
            CandidatExport cand = new CandidatExport(candTemp.getIdcandidat(), candTemp.getNomcandidat(), candTemp.getPrenomcandidat(), candTemp.getFeuxvertcodir());
            Fichedeposte f = c.getFichedeposte1();
            FicheDePosteExport fiche = new FicheDePosteExport(f.getIdfpd(), f.getPresentationentreprisefdp(), f.getPresentationpostefdp(), f.getArchivee(), new CompetenceExport(f.getCompetencesfdp().getIdcompetence(), f.getCompetencesfdp().getNomcompetence()));
            candidatures.add(new CandidatureExport(cand, fiche, c.getDatecandidature(), c.getTelephone(), c.getEmail(), c.getCv(), c.getLettremotivation()));
        }
        return candidatures;
    }

    @Override
    public List<CandidatExport> listerCandidatsARecruter() {
        List<CandidatExport> candidats = new ArrayList<>();
        for(Candidat c : this.gestionRecrutement.listerCandidatsARecruter()) {
            candidats.add(new CandidatExport(c.getIdcandidat(), c.getNomcandidat(), c.getPrenomcandidat(), c.getFeuxvertcodir()));
        }
        return candidats;
    }

    @Override
    public void supprimerCandidature(CandidatureExport candidatureExport) {
        this.gestionRecrutement.supprimerCandidature(candidatureExport.getCandidat().getId().longValue(), candidatureExport.getFicheDePoste().getId().longValue());
    }

    @Override
    public void convertirComEnFDPoste(DemandeCompetenceExport demandeCompetenceExport, String presentationEntreprise, String presentationPoste) {
        Demandecompetence demande = new Demandecompetence(new DemandecompetencePK(demandeCompetenceExport.getCompetence().getId(), demandeCompetenceExport.getEquipe().getId()), demandeCompetenceExport.isFeuxVertCodir());
        this.gestionCompetences.convertirCompEnFDPoste(demande, presentationEntreprise, presentationPoste);
    }
}
