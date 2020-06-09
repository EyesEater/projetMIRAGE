/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.services;

import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.Equipe;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sagab
 */
@Remote
public interface GestionCompetencesRemote {
   
    public List<Competence> listerCompCollaborateurs(Collaborateur collaborateur);

    public List<Demandecompetence> listerCompACombler();

    public List<Competence> listerCompEquipe(Equipe equipe);

    public void gererDemandeComp(Demandecompetence demandeCompetence);

    public void convertirCompEnFDPoste(Demandecompetence demandeCompetence, String presentationEntreprise, String presentationPoste);

    public void creerDemandeComp(Competence competence, Equipe equipe);
}
