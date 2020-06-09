/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.services;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sagab
 */
@Remote
public interface GestionCompetencesRemote {
   
    public List listerCompCollaborateurs(Object collaborateur);

    public List listerCompACombler();

    public List listerCompEquipe(Object equipe);

    public void gererDemandeComp(Object demandeCompetence);

    public void convertirCompEnFDPoste(Object demandeCompetence, String presentationEntreprise, String presentationPoste);

    public void creerDemandeComp(Object competence, Object equipe);
}
