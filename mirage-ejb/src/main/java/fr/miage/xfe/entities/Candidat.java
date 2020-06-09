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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CANDIDAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c")
    , @NamedQuery(name = "Candidat.findByIdcandidat", query = "SELECT c FROM Candidat c WHERE c.idcandidat = :idcandidat")
    , @NamedQuery(name = "Candidat.findByNomcandidat", query = "SELECT c FROM Candidat c WHERE c.nomcandidat = :nomcandidat")
    , @NamedQuery(name = "Candidat.findByPrenomcandidat", query = "SELECT c FROM Candidat c WHERE c.prenomcandidat = :prenomcandidat")
    , @NamedQuery(name = "Candidat.findByFeuxvertcodir", query = "SELECT c FROM Candidat c WHERE c.feuxvertcodir = :feuxvertcodir")})
public class Candidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCANDIDAT")
    private Integer idcandidat;
    @Size(max = 50)
    @Column(name = "NOMCANDIDAT")
    private String nomcandidat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOMCANDIDAT")
    private String prenomcandidat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEUXVERTCODIR")
    private Boolean feuxvertcodir;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidat1")
    private Collection<Candidature> candidatureCollection;
    @JoinColumn(name = "COMPETENCES", referencedColumnName = "IDCOMPETENCE")
    @ManyToOne(optional = false)
    private Competence competences;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidat")
    private Collection<Collaborateur> collaborateurCollection;

    public Candidat() {
    }

    public Candidat(Integer idcandidat) {
        this.idcandidat = idcandidat;
    }

    public Candidat(Integer idcandidat, String prenomcandidat, Boolean feuxvertcodir) {
        this.idcandidat = idcandidat;
        this.prenomcandidat = prenomcandidat;
        this.feuxvertcodir = feuxvertcodir;
    }

    public Integer getIdcandidat() {
        return idcandidat;
    }

    public void setIdcandidat(Integer idcandidat) {
        this.idcandidat = idcandidat;
    }

    public String getNomcandidat() {
        return nomcandidat;
    }

    public void setNomcandidat(String nomcandidat) {
        this.nomcandidat = nomcandidat;
    }

    public String getPrenomcandidat() {
        return prenomcandidat;
    }

    public void setPrenomcandidat(String prenomcandidat) {
        this.prenomcandidat = prenomcandidat;
    }

    public Boolean getFeuxvertcodir() {
        return feuxvertcodir;
    }

    public void setFeuxvertcodir(Boolean feuxvertcodir) {
        this.feuxvertcodir = feuxvertcodir;
    }

    @XmlTransient
    public Collection<Candidature> getCandidatureCollection() {
        return candidatureCollection;
    }

    public void setCandidatureCollection(Collection<Candidature> candidatureCollection) {
        this.candidatureCollection = candidatureCollection;
    }

    public Competence getCompetences() {
        return competences;
    }

    public void setCompetences(Competence competences) {
        this.competences = competences;
    }

    @XmlTransient
    public Collection<Collaborateur> getCollaborateurCollection() {
        return collaborateurCollection;
    }

    public void setCollaborateurCollection(Collection<Collaborateur> collaborateurCollection) {
        this.collaborateurCollection = collaborateurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcandidat != null ? idcandidat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.idcandidat == null && other.idcandidat != null) || (this.idcandidat != null && !this.idcandidat.equals(other.idcandidat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Candidat[ idcandidat=" + idcandidat + " ]";
    }
    
}
