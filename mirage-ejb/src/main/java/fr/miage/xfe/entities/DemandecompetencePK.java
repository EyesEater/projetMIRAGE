/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sagab
 */
@Embeddable
public class DemandecompetencePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPETENCE")
    private int competence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQUIPE")
    private int equipe;

    public DemandecompetencePK() {
    }

    public DemandecompetencePK(int competence, int equipe) {
        this.competence = competence;
        this.equipe = equipe;
    }

    public int getCompetence() {
        return competence;
    }

    public void setCompetence(int competence) {
        this.competence = competence;
    }

    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) competence;
        hash += (int) equipe;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandecompetencePK)) {
            return false;
        }
        DemandecompetencePK other = (DemandecompetencePK) object;
        if (this.competence != other.competence) {
            return false;
        }
        if (this.equipe != other.equipe) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.DemandecompetencePK[ competence=" + competence + ", equipe=" + equipe + " ]";
    }
    
}
