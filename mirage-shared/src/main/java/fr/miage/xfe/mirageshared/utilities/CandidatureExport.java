/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.mirageshared.utilities;

import java.util.Date;

/**
 *
 * @author sagab
 */
public class CandidatureExport {
    
    private CandidatExport candidat;
    private FicheDePosteExport ficheDePoste;
    
    private Date dateCandidature;
    private String tel;
    private String email;
    private String cv;
    private String lettreMotiv;

    public CandidatureExport(CandidatExport candidat, FicheDePosteExport ficheDePoste, Date dateCandidature, String tel, String email, String cv, String lettreMotiv) {
        this.candidat = candidat;
        this.ficheDePoste = ficheDePoste;
        this.dateCandidature = dateCandidature;
        this.tel = tel;
        this.email = email;
        this.cv = cv;
        this.lettreMotiv = lettreMotiv;
    }

    public CandidatExport getCandidat() {
        return candidat;
    }

    public void setCandidat(CandidatExport candidat) {
        this.candidat = candidat;
    }

    public FicheDePosteExport getFicheDePoste() {
        return ficheDePoste;
    }

    public void setFicheDePoste(FicheDePosteExport ficheDePoste) {
        this.ficheDePoste = ficheDePoste;
    }

    public Date getDateCandidature() {
        return dateCandidature;
    }

    public void setDateCandidature(Date dateCandidature) {
        this.dateCandidature = dateCandidature;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettreMotiv() {
        return lettreMotiv;
    }

    public void setLettreMotiv(String lettreMotiv) {
        this.lettreMotiv = lettreMotiv;
    }
    
    
    
}
