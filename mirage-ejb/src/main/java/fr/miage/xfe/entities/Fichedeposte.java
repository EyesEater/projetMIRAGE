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
@Table(name = "FICHEDEPOSTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichedeposte.findAll", query = "SELECT f FROM Fichedeposte f")
    , @NamedQuery(name = "Fichedeposte.findByIdfpd", query = "SELECT f FROM Fichedeposte f WHERE f.idfpd = :idfpd")
    , @NamedQuery(name = "Fichedeposte.findByPresentationentreprisefdp", query = "SELECT f FROM Fichedeposte f WHERE f.presentationentreprisefdp = :presentationentreprisefdp")
    , @NamedQuery(name = "Fichedeposte.findByPresentationpostefdp", query = "SELECT f FROM Fichedeposte f WHERE f.presentationpostefdp = :presentationpostefdp")
    , @NamedQuery(name = "Fichedeposte.findByArchivee", query = "SELECT f FROM Fichedeposte f WHERE f.archivee = :archivee")})
public class Fichedeposte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFPD")
    private Integer idfpd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PRESENTATIONENTREPRISEFDP")
    private String presentationentreprisefdp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PRESENTATIONPOSTEFDP")
    private String presentationpostefdp;
    @Column(name = "ARCHIVEE")
    private Boolean archivee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichedeposte1")
    private Collection<Candidature> candidatureCollection;
    @JoinColumn(name = "COMPETENCESFDP", referencedColumnName = "IDCOMPETENCE")
    @ManyToOne(optional = false)
    private Competence competencesfdp;

    public Fichedeposte() {
    }

    public Fichedeposte(Integer idfpd) {
        this.idfpd = idfpd;
    }

    public Fichedeposte(Integer idfpd, String presentationentreprisefdp, String presentationpostefdp) {
        this.idfpd = idfpd;
        this.presentationentreprisefdp = presentationentreprisefdp;
        this.presentationpostefdp = presentationpostefdp;
    }

    public Integer getIdfpd() {
        return idfpd;
    }

    public void setIdfpd(Integer idfpd) {
        this.idfpd = idfpd;
    }

    public String getPresentationentreprisefdp() {
        return presentationentreprisefdp;
    }

    public void setPresentationentreprisefdp(String presentationentreprisefdp) {
        this.presentationentreprisefdp = presentationentreprisefdp;
    }

    public String getPresentationpostefdp() {
        return presentationpostefdp;
    }

    public void setPresentationpostefdp(String presentationpostefdp) {
        this.presentationpostefdp = presentationpostefdp;
    }

    public Boolean getArchivee() {
        return archivee;
    }

    public void setArchivee(Boolean archivee) {
        this.archivee = archivee;
    }

    @XmlTransient
    public Collection<Candidature> getCandidatureCollection() {
        return candidatureCollection;
    }

    public void setCandidatureCollection(Collection<Candidature> candidatureCollection) {
        this.candidatureCollection = candidatureCollection;
    }

    public Competence getCompetencesfdp() {
        return competencesfdp;
    }

    public void setCompetencesfdp(Competence competencesfdp) {
        this.competencesfdp = competencesfdp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfpd != null ? idfpd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichedeposte)) {
            return false;
        }
        Fichedeposte other = (Fichedeposte) object;
        if ((this.idfpd == null && other.idfpd != null) || (this.idfpd != null && !this.idfpd.equals(other.idfpd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Fichedeposte[ idfpd=" + idfpd + " ]";
    }
    
}
