/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.services;

import fr.miage.xfe.exposition.CandidatExport;
import fr.miage.xfe.exposition.CandidatureExport;
import fr.miage.xfe.exposition.FicheDePosteExport;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sagab
 */
@Remote
public interface GestionRecrutementRemote {
    
    public List<FicheDePosteExport> listerOffres();

    public List<CandidatureExport> listerCandidatures();

    public void candidater(CandidatExport candidat, FicheDePosteExport fDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation);

    public void recruter(CandidatureExport candidature, boolean feuxVertCodir);

    public void concretiserEmbauche(CandidatExport candidat, String role);

    public void supprimerCandidature(CandidatureExport candidature);
}