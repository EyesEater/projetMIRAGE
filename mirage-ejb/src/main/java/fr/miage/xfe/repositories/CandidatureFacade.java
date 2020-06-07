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
    
    public void candidater(Candidature candidature) {
        em.getTransaction().begin();
        em.persist(candidature);
        em.getTransaction().commit();
    }
    
    public void recruter(Candidature candidature, boolean feuxVertCodir) {     
        if (feuxVertCodir) {
            Candidat candidat = em.find(Candidat.class, candidature.getCandidat1());
            em.getTransaction().begin();
            candidat.setFeuxvertcodir(feuxVertCodir);
            em.getTransaction().commit();

            Fichedeposte fichedeposte = em.find(Fichedeposte.class, candidature.getFichedeposte1());
            em.getTransaction().begin();
            fichedeposte.setArchivee(feuxVertCodir);
            em.getTransaction().commit();
        }
        
        supprimerCandidature(candidature);
    }
    
    public void supprimerCandidature(Candidature candidature) {
        em.getTransaction().begin();
        em.remove(candidature);
        em.getTransaction().commit();
    }
    
    public List<Candidature> listerCandidatures() {
        return em.createQuery("SELECT c FROM Candidature c").getResultList();
    }
}
