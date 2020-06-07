/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sagab
 */
@Entity
@Table(name = "COMPETENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c")
    , @NamedQuery(name = "Competence.findByIdcompetence", query = "SELECT c FROM Competence c WHERE c.idcompetence = :idcompetence")
    , @NamedQuery(name = "Competence.findByNomcompetence", query = "SELECT c FROM Competence c WHERE c.nomcompetence = :nomcompetence")})
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMPETENCE")
    private Integer idcompetence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOMCOMPETENCE")
    private String nomcompetence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competence1")
    private Collection<Demandecompetence> demandecompetenceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competencesfdp")
    private Collection<Fichedeposte> fichedeposteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competences")
    private Collection<Candidat> candidatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competences")
    private Collection<Equipe> equipeCollection;

    public Competence() {
    }

    public Competence(Integer idcompetence) {
        this.idcompetence = idcompetence;
    }

    public Competence(Integer idcompetence, String nomcompetence) {
        this.idcompetence = idcompetence;
        this.nomcompetence = nomcompetence;
    }

    public Integer getIdcompetence() {
        return idcompetence;
    }

    public void setIdcompetence(Integer idcompetence) {
        this.idcompetence = idcompetence;
    }

    public String getNomcompetence() {
        return nomcompetence;
    }

    public void setNomcompetence(String nomcompetence) {
        this.nomcompetence = nomcompetence;
    }

    @XmlTransient
    public Collection<Demandecompetence> getDemandecompetenceCollection() {
        return demandecompetenceCollection;
    }

    public void setDemandecompetenceCollection(Collection<Demandecompetence> demandecompetenceCollection) {
        this.demandecompetenceCollection = demandecompetenceCollection;
    }

    @XmlTransient
    public Collection<Fichedeposte> getFichedeposteCollection() {
        return fichedeposteCollection;
    }

    public void setFichedeposteCollection(Collection<Fichedeposte> fichedeposteCollection) {
        this.fichedeposteCollection = fichedeposteCollection;
    }

    @XmlTransient
    public Collection<Candidat> getCandidatCollection() {
        return candidatCollection;
    }

    public void setCandidatCollection(Collection<Candidat> candidatCollection) {
        this.candidatCollection = candidatCollection;
    }

    @XmlTransient
    public Collection<Equipe> getEquipeCollection() {
        return equipeCollection;
    }

    public void setEquipeCollection(Collection<Equipe> equipeCollection) {
        this.equipeCollection = equipeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompetence != null ? idcompetence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.idcompetence == null && other.idcompetence != null) || (this.idcompetence != null && !this.idcompetence.equals(other.idcompetence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Competence[ idcompetence=" + idcompetence + " ]";
    }
    
}
