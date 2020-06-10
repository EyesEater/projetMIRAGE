/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Equipe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sagab
 */
@Stateless
public class EquipeFacade extends AbstractFacade<Equipe> implements EquipeFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.xfe_mirage-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipeFacade() {
        super(Equipe.class);
    }
    
    public void creerEquipe(Equipe equipe) {
        em.getTransaction().begin();
        em.persist(equipe);
        em.getTransaction().commit();
    }
    
    @Override
    public List<Competence> listerCompEquipe(Equipe equipe) {
        return em.createQuery("SELECT c FROM Equipe e, Competence c WHERE e.competences.idcompetence = c.idcompetence").getResultList();
    }
}
