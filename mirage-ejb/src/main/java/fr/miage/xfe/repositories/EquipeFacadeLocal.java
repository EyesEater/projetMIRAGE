/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.repositories;

import fr.miage.xfe.entities.Equipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author eyeseater
 */
@Local
public interface EquipeFacadeLocal {

    void create(Equipe equipe);

    void edit(Equipe equipe);

    void remove(Equipe equipe);

    Equipe find(Object id);

    List<Equipe> findAll();

    List<Equipe> findRange(int[] range);

    int count();
    
}
