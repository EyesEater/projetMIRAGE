/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.services;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sagab
 */
@Remote
public interface GestionRecrutementRemote {
    
    public List listerOffres();

    public List listerCandidatures();

    public void candidater(Object candidat, Object fDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation);

    public void recruter(Object candidature, boolean feuxVertCodir);

    public void concretiserEmbauche(Object candidat, String role);

    public void supprimerCandidature(Object candidature);
}