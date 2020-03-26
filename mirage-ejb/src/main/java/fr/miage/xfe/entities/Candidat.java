/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author eyeseater
 */
@Entity
public class Candidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCandidat;
    
    private String nomCandidat;
    
    private String prenomCandidat;
    
    @ManyToMany
    private List<Competence> competencesCandidat;
    
    @ManyToMany
    private List<FicheDePoste> candidater;

    public Candidat() {
    }

    public Long getId() {
        return idCandidat;
    }

    public void setId(Long id) {
        this.idCandidat = id;
    }

    public Long getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Long idCandidat) {
        this.idCandidat = idCandidat;
    }

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getPrenomCandidat() {
        return prenomCandidat;
    }

    public void setPrenomCandidat(String prenomCandidat) {
        this.prenomCandidat = prenomCandidat;
    }

    public List<Competence> getCompetencesCandidat() {
        return competencesCandidat;
    }

    public void setCompetencesCandidat(List<Competence> competencesCandidat) {
        this.competencesCandidat = competencesCandidat;
    }

    public List<FicheDePoste> getCandidater() {
        return candidater;
    }

    public void setCandidater(List<FicheDePoste> candidater) {
        this.candidater = candidater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCandidat != null ? idCandidat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.idCandidat == null && other.idCandidat != null) || (this.idCandidat != null && !this.idCandidat.equals(other.idCandidat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Candidat[ id=" + idCandidat + " ]";
    }
    
}
