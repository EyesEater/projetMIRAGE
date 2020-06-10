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

    public void candidater(Candidat candidat, Fichedeposte fDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation);

    public void recruter(Candidature candidature, boolean feuxVertCodir);

    public void concretiserEmbauche(Candidat candidat, String role);

    public void supprimerCandidature(Candidature candidature);
}