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
import javax.validation.constraints.NotNull;

/**
 *
 * @author eyeseater
 */
@Entity
public class FicheDePoste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFDP;
    
    @ManyToMany
    private List<Competence> competencesFDP;
    
    @NotNull
    private String presentationEntrepriseFDP;
    
    @NotNull
    private String presentationPosteFDP;

    @ManyToMany(mappedBy = "candidater")
    private List<Candidat> candidats;

    public FicheDePoste() {
    }

    public Long getId() {
        return idFDP;
    }

    public void setId(Long id) {
        this.idFDP = id;
    }

    public Long getIdFDP() {
        return idFDP;
    }

    public void setIdFDP(Long idFDP) {
        this.idFDP = idFDP;
    }

    public List<Competence> getCompetencesFDP() {
        return competencesFDP;
    }

    public void setCompetencesFDP(List<Competence> competencesFDP) {
        this.competencesFDP = competencesFDP;
    }

    public String getPresentationEntrepriseFDP() {
        return presentationEntrepriseFDP;
    }

    public void setPresentationEntrepriseFDP(String presentationEntrepriseFDP) {
        this.presentationEntrepriseFDP = presentationEntrepriseFDP;
    }

    public String getPresentationPosteFDP() {
        return presentationPosteFDP;
    }

    public void setPresentationPosteFDP(String presentationPosteFDP) {
        this.presentationPosteFDP = presentationPosteFDP;
    }

    public List<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(List<Candidat> candidats) {
        this.candidats = candidats;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFDP != null ? idFDP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FicheDePoste)) {
            return false;
        }
        FicheDePoste other = (FicheDePoste) object;
        if ((this.idFDP == null && other.idFDP != null) || (this.idFDP != null && !this.idFDP.equals(other.idFDP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.FicheDePoste[ id=" + idFDP + " ]";
    }
    
}
