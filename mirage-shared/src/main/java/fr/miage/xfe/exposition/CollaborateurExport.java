/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

/**
 *
 * @author sagab
 */
public class CollaborateurExport {
    
    private Integer id;
    
    private CandidatExport candidat;
    private String role;

    public CollaborateurExport(Integer id, CandidatExport candidat, String role) {
        this.id = id;
        this.candidat = candidat;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CandidatExport getCandidat() {
        return candidat;
    }

    public void setCandidat(CandidatExport candidat) {
        this.candidat = candidat;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
