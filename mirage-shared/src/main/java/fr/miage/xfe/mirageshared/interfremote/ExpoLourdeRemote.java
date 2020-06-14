/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.mirageshared.interfremote;

import fr.miage.xfe.mirageshared.utilities.CandidatExport;
import fr.miage.xfe.mirageshared.utilities.CompetenceExport;
import fr.miage.xfe.mirageshared.utilities.DemandeCompetenceExport;
import fr.miage.xfe.mirageshared.utilities.CandidatureExport;
import fr.miage.xfe.mirageshared.utilities.CollaborateurExport;
import fr.miage.xfe.mirageshared.utilities.EquipeExport;
import fr.miage.xfe.mirageshared.utilities.FicheDePosteExport;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sagab
 */
@Remote
public interface ExpoLourdeRemote {
    
    public List<CompetenceExport> listerCompCollaborateur(CollaborateurExport collaborateurExport);
    
    public void concretiserEmbauche(CandidatExport candidatExport, String role);
    
    public List<CandidatureExport> listerCandidatures();
    
    public List<CandidatExport> listerCandidatsARecruter();
    
    public void supprimerCandidature(CandidatureExport candidatureExport);
    
    public void convertirCompEnFDPoste(DemandeCompetenceExport demandeCompetenceExport, String presentationEntreprise, String presentationPoste);
    
    public List<CandidatExport> listerCandidats();
    
    public List<EquipeExport> listerEquipes();
    
    public List<CollaborateurExport> listerCollaborateurs();
    
    public List<CandidatureExport> listerCandidaturesParOffre(FicheDePosteExport ficheDePosteExport);
    
    public List<CompetenceExport> listerCompetences();
    
    public List<CompetenceExport> listerCompEquipe(EquipeExport equipeExport);
    
    public List<DemandeCompetenceExport> listerDemandesCompetences();
    
    public void ajouterFDPoste(CompetenceExport competenceExport, String presentationEntreprise, String presentationPoste);
    
    public List<FicheDePosteExport> listerFDPoste();
}
