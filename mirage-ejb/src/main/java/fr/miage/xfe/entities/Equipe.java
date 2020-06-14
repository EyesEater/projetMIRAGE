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
@Table(name = "EQUIPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e")
    , @NamedQuery(name = "Equipe.findByIdequipe", query = "SELECT e FROM Equipe e WHERE e.idequipe = :idequipe")
    , @NamedQuery(name = "Equipe.findByNomequipe", query = "SELECT e FROM Equipe e WHERE e.nomequipe = :nomequipe")})
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEQUIPE")
    private Integer idequipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMEQUIPE")
    private String nomequipe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipe1")
    private Collection<Demandecompetence> demandecompetenceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipe")
    private Collection<Collaborateur> collaborateurCollection;
    @JoinColumn(name = "MANAGER", referencedColumnName = "IDCOLLABORATEUR")
    @ManyToOne(optional = false)
    private Collaborateur manager;
    @JoinColumn(name = "COMPETENCES", referencedColumnName = "IDCOMPETENCE")
    @ManyToOne(optional = false)
    private Competence competences;

    public Equipe() {
    }

    public Equipe(Integer idequipe) {
        this.idequipe = idequipe;
    }

    public Equipe(Integer idequipe, String nomequipe) {
        this.idequipe = idequipe;
        this.nomequipe = nomequipe;
    }

    public Integer getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Integer idequipe) {
        this.idequipe = idequipe;
    }

    public String getNomequipe() {
        return nomequipe;
    }

    public void setNomequipe(String nomequipe) {
        this.nomequipe = nomequipe;
    }

    @XmlTransient
    public Collection<Demandecompetence> getDemandecompetenceCollection() {
        return demandecompetenceCollection;
    }

    public void setDemandecompetenceCollection(Collection<Demandecompetence> demandecompetenceCollection) {
        this.demandecompetenceCollection = demandecompetenceCollection;
    }

    @XmlTransient
    public Collection<Collaborateur> getCollaborateurCollection() {
        return collaborateurCollection;
    }

    public void setCollaborateurCollection(Collection<Collaborateur> collaborateurCollection) {
        this.collaborateurCollection = collaborateurCollection;
    }

    @XmlTransient
    public Collaborateur getManager() {
        return manager;
    }

    public void setManager(Collaborateur manager) {
        this.manager = manager;
    }

    public Competence getCompetences() {
        return competences;
    }

    public void setCompetences(Competence competences) {
        this.competences = competences;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipe != null ? idequipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.idequipe == null && other.idequipe != null) || (this.idequipe != null && !this.idequipe.equals(other.idequipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Equipe[ idequipe=" + idequipe + " ]";
    }
    
}
