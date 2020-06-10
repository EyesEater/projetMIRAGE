/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Demandecompetence;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author sagab
 */
@Stateless
public class DemandecompetenceFacade extends AbstractFacade<Demandecompetence> implements DemandecompetenceFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.xfe_mirage-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemandecompetenceFacade() {
        super(Demandecompetence.class);
    }
    
    @Override
    public void supprimerDemandeComp(Demandecompetence demandecompetence) {
        remove(demandecompetence);
    }
    
    @Override
    public void gererDemandeComp(Demandecompetence demandecompetence) {
        demandecompetence.setFeuxvertcodir(Boolean.TRUE);
        edit(demandecompetence);
    }
    
    @Override
    public void creerDemandeComp(Demandecompetence demandecompetence) {
        create(demandecompetence);
    }
    
    @Override
    public List<Demandecompetence> listerCompACombler() {
        return em.createQuery("SELECT d FROM Demandecompetence d WHERE d.feuxvertcodir = 0").getResultList();
    }
}
