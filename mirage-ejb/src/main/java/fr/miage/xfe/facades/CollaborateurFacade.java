/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.facades;

import fr.miage.xfe.entities.Collaborateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eyeseater
 */
@Stateless
public class CollaborateurFacade extends AbstractFacade<Collaborateur> implements CollaborateurFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.xfe_mirage-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CollaborateurFacade() {
        super(Collaborateur.class);
    }
    
}
