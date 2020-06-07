/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

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
public class FichedeposteFacade extends AbstractFacade<Fichedeposte> implements FichedeposteFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.xfe_mirage-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichedeposteFacade() {
        super(Fichedeposte.class);
    }
    
    public List<Fichedeposte> listerOffres() {
        return em.createQuery("SELECT fdp FROM FICHEDEPOSTE fdp WHERE fdp.archivee = FALSE").getResultList();
    }
}
