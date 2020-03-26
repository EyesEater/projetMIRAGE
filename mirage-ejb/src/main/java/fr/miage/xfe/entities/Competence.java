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
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eyeseater
 */
@Entity
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCompetence;

    @ManyToMany(mappedBy = "competencesCandidat")
    private List<Candidat> candidats;

    @ManyToOne
    private Candidat candidat;
    
    @NotNull
    private String nomCompetence;
    
    @ManyToMany(mappedBy = "competencesFDP")
    private List<FicheDePoste> ficheDePostes;

    public Competence() {
    }

    public Long getId() {
        return idCompetence;
    }

    public void setId(Long id) {
        this.idCompetence = id;
    }

    public List<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(List<Candidat> candidats) {
        this.candidats = candidats;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    public List<FicheDePoste> getFicheDePostes() {
        return ficheDePostes;
    }

    public void setFicheDePostes(List<FicheDePoste> ficheDePostes) {
        this.ficheDePostes = ficheDePostes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompetence != null ? idCompetence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.idCompetence == null && other.idCompetence != null) || (this.idCompetence != null && !this.idCompetence.equals(other.idCompetence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Competence[ id=" + idCompetence + " ]";
    }
    
}
