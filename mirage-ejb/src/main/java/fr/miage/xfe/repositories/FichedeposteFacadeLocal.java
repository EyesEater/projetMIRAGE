/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Fichedeposte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sagab
 */
@Local
public interface FichedeposteFacadeLocal {

    void create(Fichedeposte fichedeposte);

    void edit(Fichedeposte fichedeposte);

    void remove(Fichedeposte fichedeposte);

    Fichedeposte find(Object id);

    List<Fichedeposte> findAll();

    List<Fichedeposte> findRange(int[] range);

    int count();
    
}
