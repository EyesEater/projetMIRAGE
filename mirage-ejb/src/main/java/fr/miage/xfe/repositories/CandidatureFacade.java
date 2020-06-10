/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Fichedeposte;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sagab
 */
@Stateless
public class CandidatureFacade extends AbstractFacade<Candidature> implements CandidatureFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.xfe_mirage-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatureFacade() {
        super(Candidature.class);
    }
    
    @Override
    public void candidater(Candidature candidature) {
        create(candidature);
    }
    
    @Override
    public void recruter(Candidature candidature, boolean feuxVertCodir) {     
        supprimerCandidature(candidature);
    }
    
    @Override
    public void supprimerCandidature(Candidature candidature) {
        remove(candidature);
    }
    
    @Override
    public List<Candidature> listerCandidatures() {
        return em.createQuery("SELECT c FROM Candidature c").getResultList();
    }
}
