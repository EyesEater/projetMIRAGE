/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.metier;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Fichedeposte;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sagab
 */
@Local
public interface GestionRecrutementLocal {
    
    public List<Fichedeposte> listerOffres();

    public List<Candidature> listerCandidatures();
    
    public List<Candidat> listerCandidatsARecruter();

    public void candidater(Integer idCandidat, Integer idFDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation);

    public void recruter(Integer idCandidat, Integer idFDPoste, boolean feuxVertCodir);

    public void concretiserEmbauche(Integer idCandidat, String role);

    public void supprimerCandidature(Integer idCandidat, Integer idFDPoste);
}