/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eyeseater
 */
@Entity
public class Collaborateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long idCollaborateur;

    @OneToOne
    private Candidat candidat;
    
    @NotNull
    private String codir;
    
    @ManyToOne
    private Collaborateur manager;
    
    @OneToMany(mappedBy = "manager")
    private List<Collaborateur> collaborateurs;

    public Collaborateur() {
    }

    public Long getId() {
        return idCollaborateur;
    }

    public void setId(Long id) {
        this.idCollaborateur = id;
    }

    public Long getIdCollaborateur() {
        return idCollaborateur;
    }

    public void setIdCollaborateur(Long idCollaborateur) {
        this.idCollaborateur = idCollaborateur;
    }

    public String getCodir() {
        return codir;
    }

    public void setCodir(String codir) {
        this.codir = codir;
    }

    public Collaborateur getManager() {
        return manager;
    }

    public void setManager(Collaborateur manager) {
        this.manager = manager;
    }

    public List<Collaborateur> getCollaborateurs() {
        return collaborateurs;
    }

    public void setCollaborateurs(List<Collaborateur> collaborateurs) {
        this.collaborateurs = collaborateurs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCollaborateur != null ? idCollaborateur.hashCode() : 0);
        return hash;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collaborateur)) {
            return false;
        }
        Collaborateur other = (Collaborateur) object;
        if ((this.idCollaborateur == null && other.idCollaborateur != null) || (this.idCollaborateur != null && !this.idCollaborateur.equals(other.idCollaborateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Collaborateur[ id=" + idCollaborateur + " ]";
    }
    
}
