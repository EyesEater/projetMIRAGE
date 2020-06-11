/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.metier;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Equipe;
import fr.miage.xfe.repositories.CandidatFacadeLocal;
import fr.miage.xfe.repositories.CollaborateurFacadeLocal;
import fr.miage.xfe.repositories.EquipeFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sagab
 */
@Stateless
public class GestionPersonnel implements GestionPersonnelLocal {

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private CandidatFacadeLocal candidatFacade;

    @Override
    public List<Equipe> listerEquipes() {
        return this.equipeFacade.findAll();
    }

    @Override
    public List<Candidat> listerCandidats() {
        return this.candidatFacade.findAll();
    }

    @Override
    public List<Collaborateur> listerCollaborateurs() {
        return this.collaborateurFacade.findAll();
    }
}
