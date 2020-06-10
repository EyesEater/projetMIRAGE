/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.metier;

import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sagab
 */
@Local
public interface GestionCompetencesLocal {
   
    public List<Competence> listerCompCollaborateurs(Collaborateur collaborateur);

    public List<Demandecompetence> listerCompACombler();

    public List<Competence> listerCompEquipe(Integer idEquipe);

    public void gererDemandeComp(Demandecompetence demandeCompetence);

    public void convertirCompEnFDPoste(Demandecompetence demandeCompetence, String presentationEntreprise, String presentationPoste);

    public void creerDemandeComp(Integer idCompetence, Integer idEquipe);
}
