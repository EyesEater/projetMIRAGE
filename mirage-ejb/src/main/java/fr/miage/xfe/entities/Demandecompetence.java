/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sagab
 */
@Entity
@Table(name = "DEMANDECOMPETENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandecompetence.findAll", query = "SELECT d FROM Demandecompetence d")
    , @NamedQuery(name = "Demandecompetence.findByCompetence", query = "SELECT d FROM Demandecompetence d WHERE d.demandecompetencePK.competence = :competence")
    , @NamedQuery(name = "Demandecompetence.findByEquipe", query = "SELECT d FROM Demandecompetence d WHERE d.demandecompetencePK.equipe = :equipe")
    , @NamedQuery(name = "Demandecompetence.findByFeuxvertcodir", query = "SELECT d FROM Demandecompetence d WHERE d.feuxvertcodir = :feuxvertcodir")})
public class Demandecompetence implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DemandecompetencePK demandecompetencePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEUXVERTCODIR")
    private Boolean feuxvertcodir;
    @JoinColumn(name = "COMPETENCE", referencedColumnName = "IDCOMPETENCE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Competence competence1;
    @JoinColumn(name = "EQUIPE", referencedColumnName = "IDEQUIPE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipe equipe1;

    public Demandecompetence() {
    }

    public Demandecompetence(DemandecompetencePK demandecompetencePK) {
        this.demandecompetencePK = demandecompetencePK;
    }

    public Demandecompetence(DemandecompetencePK demandecompetencePK, Boolean feuxvertcodir) {
        this.demandecompetencePK = demandecompetencePK;
        this.feuxvertcodir = feuxvertcodir;
    }

    public Demandecompetence(int competence, int equipe) {
        this.demandecompetencePK = new DemandecompetencePK(competence, equipe);
    }

    public DemandecompetencePK getDemandecompetencePK() {
        return demandecompetencePK;
    }

    public void setDemandecompetencePK(DemandecompetencePK demandecompetencePK) {
        this.demandecompetencePK = demandecompetencePK;
    }

    public Boolean getFeuxvertcodir() {
        return feuxvertcodir;
    }

    public void setFeuxvertcodir(Boolean feuxvertcodir) {
        this.feuxvertcodir = feuxvertcodir;
    }

    public Competence getCompetence1() {
        return competence1;
    }

    public void setCompetence1(Competence competence1) {
        this.competence1 = competence1;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demandecompetencePK != null ? demandecompetencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demandecompetence)) {
            return false;
        }
        Demandecompetence other = (Demandecompetence) object;
        if ((this.demandecompetencePK == null && other.demandecompetencePK != null) || (this.demandecompetencePK != null && !this.demandecompetencePK.equals(other.demandecompetencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Demandecompetence[ demandecompetencePK=" + demandecompetencePK + " ]";
    }
    
}
