/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Competence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author eyeseater
 */
@Local
public interface CompetenceFacadeLocal {

    void create(Competence competence);

    void edit(Competence competence);

    void remove(Competence competence);

    Competence find(Object id);

    List<Competence> findAll();

    List<Competence> findRange(int[] range);

    int count();
    
}
