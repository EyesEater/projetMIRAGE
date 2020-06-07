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
public class CandidaturePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CANDIDAT")
    private int candidat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FICHEDEPOSTE")
    private int fichedeposte;

    public CandidaturePK() {
    }

    public CandidaturePK(int candidat, int fichedeposte) {
        this.candidat = candidat;
        this.fichedeposte = fichedeposte;
    }

    public int getCandidat() {
        return candidat;
    }

    public void setCandidat(int candidat) {
        this.candidat = candidat;
    }

    public int getFichedeposte() {
        return fichedeposte;
    }

    public void setFichedeposte(int fichedeposte) {
        this.fichedeposte = fichedeposte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) candidat;
        hash += (int) fichedeposte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidaturePK)) {
            return false;
        }
        CandidaturePK other = (CandidaturePK) object;
        if (this.candidat != other.candidat) {
            return false;
        }
        if (this.fichedeposte != other.fichedeposte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.CandidaturePK[ candidat=" + candidat + ", fichedeposte=" + fichedeposte + " ]";
    }
    
}
