/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.Equipe;
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
    
    public void candidater(Candidat candidat, Fichedeposte fDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation);
    
    public List<Candidature> listerCandidatures();
    
    public void recruter(Candidature candidature, boolean feuxVertCodir);
    
    public List<Demandecompetence> listerCompACombler();
    
    public void creerDemandeComp(Competence competence, Equipe equipe);
    
    public List<Competence> listerCompEquipe(Equipe equipe);
}
