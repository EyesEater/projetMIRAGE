/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.metier;

import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.Equipe;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.repositories.CollaborateurFacadeLocal;
import fr.miage.xfe.repositories.DemandecompetenceFacadeLocal;
import fr.miage.xfe.repositories.EquipeFacadeLocal;
import fr.miage.xfe.repositories.FichedeposteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sagab
 */
@Stateless
public class GestionCompetences implements GestionCompetencesLocal {

    @EJB
    private FichedeposteFacadeLocal fichedeposteFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private DemandecompetenceFacadeLocal demandecompetenceFacade;

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    @Override
    public List<Competence> listerCompCollaborateurs(Collaborateur collaborateur) {
        return collaborateurFacade.listerCompCollaborateur(collaborateur);
    }

    @Override
    public List<Demandecompetence> listerCompACombler() {
        return demandecompetenceFacade.listerCompACombler();
    }

    @Override
    public List<Competence> listerCompEquipe(Integer idEquipe) {
        Equipe equipe = equipeFacade.find(idEquipe);
        return equipeFacade.listerCompEquipe(equipe);
    }

    @Override
    public void gererDemandeComp(Demandecompetence demandeCompetence) {
        demandecompetenceFacade.gererDemandeComp(demandeCompetence);
    }

    @Override
    public void convertirCompEnFDPoste(Demandecompetence demandeCompetence, String presentationEntreprise, String presentationPoste) {
        Fichedeposte fichedeposte = new Fichedeposte(presentationEntreprise, presentationPoste, demandeCompetence.getCompetence1());
        fichedeposteFacade.creerFDPoste(fichedeposte);
        
        demandecompetenceFacade.supprimerDemandeComp(demandeCompetence);
    }

    @Override
    public void creerDemandeComp(Integer idCompetence, Integer idEquipe) {
        Demandecompetence demandecompetence = new Demandecompetence(idCompetence, idEquipe);
        demandecompetenceFacade.creerDemandeComp(demandecompetence);
    }
}
