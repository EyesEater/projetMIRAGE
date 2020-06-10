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
public class CandidatExport implements Serializable {
    
    private Integer id;
    private String nom;
    private String prenom;
    private boolean feuxVertCodir;

    public CandidatExport(Integer id, String nom, String prenom, boolean feuxVertCodir) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.feuxVertCodir = feuxVertCodir;
    }

    public boolean isFeuxVertCodir() {
        return feuxVertCodir;
    }

    public void setFeuxVertCodir(boolean feuxVertCodir) {
        this.feuxVertCodir = feuxVertCodir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
    
}
