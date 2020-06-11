/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.metier;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Collaborateur;
import fr.miage.xfe.entities.Equipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sagab
 */
@Local
public interface GestionPersonnelLocal {
    
    public List<Equipe> listerEquipes();

    public List<Candidat> listerCandidats();
    
    public List<Collaborateur> listerCollaborateurs();
}
