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
import fr.miage.xfe.entities.Equipe;
import fr.miage.xfe.entities.Fichedeposte;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.miage.xfe.metier.GestionCompetencesLocal;
import fr.miage.xfe.metier.GestionPersonnelLocal;
import fr.miage.xfe.metier.GestionRecrutementLocal;
import java.util.ArrayList;
import fr.miage.xfe.mirageshared.interfremote.ExpoLourdeRemote;
import fr.miage.xfe.mirageshared.utilities.EquipeExport;

/**
 *
 * @author sagab
 */
@Stateless
public class ExpoLourde implements ExpoLourdeRemote {

    @EJB
    private GestionPersonnelLocal gestionPersonnel;

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
        this.gestionRecrutement.concretiserEmbauche(candidatExport.getId(), role);
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
        this.gestionRecrutement.supprimerCandidature(candidatureExport.getCandidat().getId(), candidatureExport.getFicheDePoste().getId());
    }

    @Override
    public void convertirCompEnFDPoste(DemandeCompetenceExport demandeCompetenceExport, String presentationEntreprise, String presentationPoste) {
        Demandecompetence demande = new Demandecompetence(new DemandecompetencePK(demandeCompetenceExport.getCompetence().getId(), demandeCompetenceExport.getEquipe().getId()), demandeCompetenceExport.isFeuxVertCodir());
        this.gestionCompetences.convertirCompEnFDPoste(demande, presentationEntreprise, presentationPoste);
    }

    @Override
    public List<CandidatExport> listerCandidats() {
        List<CandidatExport> candidats = new ArrayList<>();
        for(Candidat c : this.gestionPersonnel.listerCandidats()) {
            candidats.add(new CandidatExport(c.getIdcandidat(), c.getNomcandidat(), c.getPrenomcandidat(), c.getFeuxvertcodir()));
        }
        return candidats;
    }

    @Override
    public List<EquipeExport> listerEquipes() {
        List<EquipeExport> equipes = new ArrayList<>();
        for(Equipe e : this.gestionPersonnel.listerEquipes()) {
            equipes.add(new EquipeExport(e.getIdequipe(), e.getNomequipe()));
        }
        return equipes;
    }

    @Override
    public List<CollaborateurExport> listerCollaborateurs() {
        List<CollaborateurExport> collaborateurs = new ArrayList<>();
        for(Collaborateur c : this.gestionPersonnel.listerCollaborateurs()) {
            collaborateurs.add(new CollaborateurExport(c.getIdcollaborateur(), new CandidatExport(c.getCandidat().getIdcandidat(), c.getCandidat().getNomcandidat(), c.getCandidat().getPrenomcandidat(), c.getCandidat().getFeuxvertcodir()), c.getRole()));
        }
        return collaborateurs;
    }

    @Override
    public List<CandidatureExport> listerCandidaturesParOffre(FicheDePosteExport ficheDePosteExport) {
        List<CandidatureExport> candidatures = new ArrayList<>();
        for(Candidature c : this.gestionRecrutement.listerCandidaturesParOffre(ficheDePosteExport.getId())) {
            CandidatExport candidat = new CandidatExport(c.getCandidat1().getIdcandidat(), c.getCandidat1().getNomcandidat(), c.getCandidat1().getPrenomcandidat(), c.getCandidat1().getFeuxvertcodir());
            candidatures.add(new CandidatureExport(candidat, ficheDePosteExport, c.getDatecandidature(), c.getTelephone(), c.getEmail(), c.getCv(), c.getLettremotivation()));
        }
        return candidatures;
    }

    @Override
    public List<CompetenceExport> listerCompetences() {
        List<CompetenceExport> competences = new ArrayList<>();
        for(Competence c : this.gestionCompetences.listerCompetences()) {
            competences.add(new CompetenceExport(c.getIdcompetence(), c.getNomcompetence()));
        }
        return competences;
    }

    @Override
    public List<CompetenceExport> listerCompEquipe(EquipeExport equipeExport) {
        List<CompetenceExport> competences = new ArrayList<>();
        for(Competence c : this.gestionCompetences.listerCompEquipe(equipeExport.getId())) {
            competences.add(new CompetenceExport(c.getIdcompetence(), c.getNomcompetence()));
        }
        return competences;
    }

    @Override
    public List<DemandeCompetenceExport> listerDemandesCompetences() {
        List<DemandeCompetenceExport> demandeCompetences = new ArrayList<>();
        for(Demandecompetence demande : this.gestionCompetences.listerDemandesCompetences()) {
            CompetenceExport competence = new CompetenceExport(demande.getCompetence1().getIdcompetence(), demande.getCompetence1().getNomcompetence());
            EquipeExport equipe = new EquipeExport(demande.getEquipe1().getIdequipe(), demande.getEquipe1().getNomequipe());
            demandeCompetences.add(new DemandeCompetenceExport(competence, equipe, demande.getFeuxvertcodir()));
        }
        return demandeCompetences;
    }

    @Override
    public void ajouterFDPoste(CompetenceExport competenceExport, String presentationEntreprise, String presentationPoste) {
        Competence competence = new Competence(competenceExport.getId(), competenceExport.getNomCompetence());
        this.gestionRecrutement.ajouterFicheDePoste(competence, presentationEntreprise, presentationPoste);
    }

    @Override
    public List<FicheDePosteExport> listerFDPoste() {
        List<FicheDePosteExport> ficheDePostes = new ArrayList<>();
        for(Fichedeposte f : this.gestionRecrutement.listerFDPostes()) {
            CompetenceExport competenceExport = new CompetenceExport(f.getCompetencesfdp().getIdcompetence(), f.getCompetencesfdp().getNomcompetence());
            ficheDePostes.add(new FicheDePosteExport(f.getIdfpd(), f.getPresentationentreprisefdp(), f.getPresentationpostefdp(), f.getArchivee(), competenceExport));
        }
        return ficheDePostes;
    }
}
