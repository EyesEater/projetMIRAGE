/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.services;

import fr.miage.xfe.exposition.CollaborateurExport;
import fr.miage.xfe.exposition.CompetenceExport;
import fr.miage.xfe.exposition.DemandeCompetenceExport;
import fr.miage.xfe.exposition.EquipeExport;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sagab
 */
@Remote
public interface GestionCompetencesRemote {
   
    public List<CompetenceExport> listerCompCollaborateurs(CollaborateurExport collaborateur);

    public List<DemandeCompetenceExport> listerCompACombler();

    public List<CompetenceExport> listerCompEquipe(EquipeExport equipe);

    public void gererDemandeComp(DemandeCompetenceExport demandeCompetence);

    public void convertirCompEnFDPoste(DemandeCompetenceExport demandeCompetence, String presentationEntreprise, String presentationPoste);

    public void creerDemandeComp(CompetenceExport competence, EquipeExport equipe);
}
