/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Candidature;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sagab
 */
@Local
public interface CandidatureFacadeLocal {

    void create(Candidature candidature);

    void edit(Candidature candidature);

    void remove(Candidature candidature);

    Candidature find(Object id);

    List<Candidature> findAll();

    List<Candidature> findRange(int[] range);

    int count();

    public List<Candidature> listerCandidatures();

    public void candidater(Candidature candidature);

    public void recruter(Candidature candidature, boolean feuxVertCodir);

    public List<Candidature> listerCandidatureParOffre(Integer idFDPoste);
    
}
