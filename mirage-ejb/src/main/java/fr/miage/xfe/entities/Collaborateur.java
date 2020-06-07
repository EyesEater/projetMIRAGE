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
@Table(name = "COLLABORATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collaborateur.findAll", query = "SELECT c FROM Collaborateur c")
    , @NamedQuery(name = "Collaborateur.findByIdcollaborateur", query = "SELECT c FROM Collaborateur c WHERE c.idcollaborateur = :idcollaborateur")
    , @NamedQuery(name = "Collaborateur.findByRole", query = "SELECT c FROM Collaborateur c WHERE c.role = :role")})
public class Collaborateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOLLABORATEUR")
    private Integer idcollaborateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ROLE")
    private String role;
    @JoinColumn(name = "CANDIDAT", referencedColumnName = "IDCANDIDAT")
    @ManyToOne(optional = false)
    private Candidat candidat;
    @OneToMany(mappedBy = "manager")
    private Collection<Collaborateur> collaborateurCollection;
    @JoinColumn(name = "MANAGER", referencedColumnName = "IDCOLLABORATEUR")
    @ManyToOne
    private Collaborateur manager;
    @JoinColumn(name = "EQUIPE", referencedColumnName = "IDEQUIPE")
    @ManyToOne(optional = false)
    private Equipe equipe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private Collection<Equipe> equipeCollection;

    public Collaborateur() {
    }

    public Collaborateur(Integer idcollaborateur) {
        this.idcollaborateur = idcollaborateur;
    }

    public Collaborateur(Integer idcollaborateur, String role) {
        this.idcollaborateur = idcollaborateur;
        this.role = role;
    }
    
    public Collaborateur(Candidat candidat, String role) {
        this.candidat = candidat;
        this.role = role;
    }

    public Integer getIdcollaborateur() {
        return idcollaborateur;
    }

    public void setIdcollaborateur(Integer idcollaborateur) {
        this.idcollaborateur = idcollaborateur;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @XmlTransient
    public Collection<Collaborateur> getCollaborateurCollection() {
        return collaborateurCollection;
    }

    public void setCollaborateurCollection(Collection<Collaborateur> collaborateurCollection) {
        this.collaborateurCollection = collaborateurCollection;
    }

    public Collaborateur getManager() {
        return manager;
    }

    public void setManager(Collaborateur manager) {
        this.manager = manager;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
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
        hash += (idcollaborateur != null ? idcollaborateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collaborateur)) {
            return false;
        }
        Collaborateur other = (Collaborateur) object;
        if ((this.idcollaborateur == null && other.idcollaborateur != null) || (this.idcollaborateur != null && !this.idcollaborateur.equals(other.idcollaborateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Collaborateur[ idcollaborateur=" + idcollaborateur + " ]";
    }
    
}
