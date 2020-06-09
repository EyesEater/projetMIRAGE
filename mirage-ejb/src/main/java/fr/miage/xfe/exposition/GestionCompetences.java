/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

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
import fr.miage.xfe.services.GestionCompetencesRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sagab
 */
@Stateless
public class GestionCompetences implements GestionCompetencesRemote {

    @Override
    public List<CompetenceExport> listerCompCollaborateurs(CollaborateurExport collaborateur) {
        CollaborateurFacade collaborateurFacade = new CollaborateurFacade();
        Collaborateur collabo = new Collaborateur(collaborateur.getId(), collaborateur.getRole());
        List<CompetenceExport> competences = new ArrayList<>();
        for(Competence c : collaborateurFacade.listerCompCollaborateur(collabo)) {
            competences.add(new CompetenceExport(c.getIdcompetence(), c.getNomcompetence()));
        }
        return competences;
    }

    @Override
    public List<DemandeCompetenceExport> listerCompACombler() {
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        List<DemandeCompetenceExport> demandes = new ArrayList<>();
        for(Demandecompetence demande : demandecompetenceFacade.listerCompACombler()) {
            demandes.add(new DemandeCompetenceExport(new CompetenceExport(demande.getCompetence1().getIdcompetence(), demande.getCompetence1().getNomcompetence()), new EquipeExport(demande.getEquipe1().getIdequipe(), demande.getEquipe1().getNomequipe()), true));
        }
        return demandes;
    }

    @Override
    public List<CompetenceExport> listerCompEquipe(EquipeExport equipe) {
        EquipeFacade equipeFacade = new EquipeFacade();
        Equipe e = new Equipe(equipe.getId(), equipe.getNom());
        List<CompetenceExport> competences = new ArrayList<>();
        for(Competence c : equipeFacade.listerCompEquipe(e)) {
            competences.add(new CompetenceExport(c.getIdcompetence(), c.getNomcompetence()));
        }
        return competences;
    }

    @Override
    public void gererDemandeComp(DemandeCompetenceExport demandeCompetence) {
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        Demandecompetence demande = new Demandecompetence(demandeCompetence.getCompetence().getId(), demandeCompetence.getEquipe().getId());
        demandecompetenceFacade.gererDemandeComp(demande);
    }

    @Override
    public void convertirCompEnFDPoste(DemandeCompetenceExport demandeCompetence, String presentationEntreprise, String presentationPoste) {
        FichedeposteFacade fichedeposteFacade = new FichedeposteFacade();
        Demandecompetence demande = new Demandecompetence(demandeCompetence.getCompetence().getId(), demandeCompetence.getEquipe().getId());
        Fichedeposte fichedeposte = new Fichedeposte(presentationEntreprise, presentationPoste, demande.getCompetence1());
        fichedeposteFacade.creerFDPoste(fichedeposte);
        
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        demandecompetenceFacade.supprimerDemandeComp(demande);
    }

    @Override
    public void creerDemandeComp(CompetenceExport competence, EquipeExport equipe) {
        Competence comp = new Competence(competence.getId(), competence.getNomCompetence());
        Equipe eq = new Equipe(equipe.getId(), equipe.getNom());
        DemandecompetencePK demandecompetencePK = new DemandecompetencePK(comp.getIdcompetence(), eq.getIdequipe());
        Demandecompetence demandecompetence = new Demandecompetence(demandecompetencePK);
        DemandecompetenceFacade demandecompetenceFacade = new DemandecompetenceFacade();
        demandecompetenceFacade.creerDemandeComp(demandecompetence);
    }
}
