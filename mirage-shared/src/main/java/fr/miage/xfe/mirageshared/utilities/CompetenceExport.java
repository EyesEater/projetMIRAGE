/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.mirageshared.utilities;

import java.io.Serializable;

/**
 *
 * @author sagab
 */
public class CompetenceExport implements Serializable {
    
    private Integer id;
    
    private String nomCompetence;

    public CompetenceExport(Integer id, String nomCompetence) {
        this.id = id;
        this.nomCompetence = nomCompetence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }
}
