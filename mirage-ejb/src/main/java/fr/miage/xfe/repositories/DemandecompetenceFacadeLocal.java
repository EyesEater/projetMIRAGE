/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Demandecompetence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sagab
 */
@Local
public interface DemandecompetenceFacadeLocal {

    void create(Demandecompetence demandecompetence);

    void edit(Demandecompetence demandecompetence);

    void remove(Demandecompetence demandecompetence);

    Demandecompetence find(Object id);

    List<Demandecompetence> findAll();

    List<Demandecompetence> findRange(int[] range);

    int count();
    
}
