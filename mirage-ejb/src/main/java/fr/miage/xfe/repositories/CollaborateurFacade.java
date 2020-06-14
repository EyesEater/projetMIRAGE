/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Competence;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sagab
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
    
    @Override
    public void concretiserEmbauche(Collaborateur collaborateur) {
        em.getTransaction().begin();
        em.persist(collaborateur);
        em.getTransaction().commit();
    }
    
    @Override
    public List<Competence> listerCompCollaborateur(Collaborateur collaborateur) {
        return em.createQuery("SELECT c FROM Collaborateur c1, Competence c WHERE c1.idcollaborateur IN (c.candidatCollection) AND c1.idcollaborateur = :id").setParameter("id", collaborateur.getIdcollaborateur()).getResultList();
    }
}
