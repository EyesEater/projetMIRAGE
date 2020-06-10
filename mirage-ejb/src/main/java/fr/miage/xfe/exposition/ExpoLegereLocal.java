/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.Fichedeposte;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sagab
 */
@Local
public interface ExpoLegereLocal {
    
    public List<Fichedeposte> listerOffres();
    
    public void candidater(String idCandidat, String idFDPoste, String dateCandidature, String email, String tel, String cv, String lettreMotivation);
    
    public List<Candidature> listerCandidatures();
    
    public void recruter(String idCandidat, String idFDPoste, String feuxVertCodir);
    
    public List<Demandecompetence> listerCompACombler();
    
    public void creerDemandeComp(String idCompetence, String idEquipe);
    
    public List<Competence> listerCompEquipe(String idEquipe);
}
