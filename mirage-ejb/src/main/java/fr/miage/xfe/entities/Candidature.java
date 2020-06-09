/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sagab
 */
@Entity
@Table(name = "CANDIDATURE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidature.findAll", query = "SELECT c FROM Candidature c")
    , @NamedQuery(name = "Candidature.findByCandidat", query = "SELECT c FROM Candidature c WHERE c.candidaturePK.candidat = :candidat")
    , @NamedQuery(name = "Candidature.findByFichedeposte", query = "SELECT c FROM Candidature c WHERE c.candidaturePK.fichedeposte = :fichedeposte")
    , @NamedQuery(name = "Candidature.findByDatecandidature", query = "SELECT c FROM Candidature c WHERE c.datecandidature = :datecandidature")
    , @NamedQuery(name = "Candidature.findByEmail", query = "SELECT c FROM Candidature c WHERE c.email = :email")
    , @NamedQuery(name = "Candidature.findByTelephone", query = "SELECT c FROM Candidature c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Candidature.findByCv", query = "SELECT c FROM Candidature c WHERE c.cv = :cv")
    , @NamedQuery(name = "Candidature.findByLettremotivation", query = "SELECT c FROM Candidature c WHERE c.lettremotivation = :lettremotivation")})
public class Candidature implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CandidaturePK candidaturePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECANDIDATURE")
    @Temporal(TemporalType.DATE)
    private Date datecandidature;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 255)
    @Column(name = "CV")
    private String cv;
    @Size(max = 255)
    @Column(name = "LETTREMOTIVATION")
    private String lettremotivation;
    @JoinColumn(name = "CANDIDAT", referencedColumnName = "IDCANDIDAT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Candidat candidat1;
    @JoinColumn(name = "FICHEDEPOSTE", referencedColumnName = "IDFPD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fichedeposte fichedeposte1;

    public Candidature() {
    }

    public Candidature(CandidaturePK candidaturePK) {
        this.candidaturePK = candidaturePK;
    }

    public Candidature(int candidat, int fichedeposte) {
        this.candidaturePK = new CandidaturePK(candidat, fichedeposte);
    }
    
    public Candidature(Candidat candidat, Fichedeposte fichedeposte, Date date, String email, String tel, String cv, String lettreMotivation) {
        this.candidaturePK = new CandidaturePK(candidat.getIdcandidat(), fichedeposte.getIdfpd());
        this.datecandidature = date;
        this.email = email;
        this.telephone = tel;
        this.cv = cv;
        this.lettremotivation = lettreMotivation;
        this.candidat1 = candidat;
        this.fichedeposte1 = fichedeposte;
    }

    public Candidature(CandidaturePK candidaturePK, Date datecandidature, String email, String telephone, String cv, String lettremotivation) {
        this.candidaturePK = candidaturePK;
        this.datecandidature = datecandidature;
        this.email = email;
        this.telephone = telephone;
        this.cv = cv;
        this.lettremotivation = lettremotivation;
    }

    public CandidaturePK getCandidaturePK() {
        return candidaturePK;
    }

    public void setCandidaturePK(CandidaturePK candidaturePK) {
        this.candidaturePK = candidaturePK;
    }

    public Date getDatecandidature() {
        return datecandidature;
    }

    public void setDatecandidature(Date datecandidature) {
        this.datecandidature = datecandidature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettremotivation() {
        return lettremotivation;
    }

    public void setLettremotivation(String lettremotivation) {
        this.lettremotivation = lettremotivation;
    }

    public Candidat getCandidat1() {
        return candidat1;
    }

    public void setCandidat1(Candidat candidat1) {
        this.candidat1 = candidat1;
    }

    public Fichedeposte getFichedeposte1() {
        return fichedeposte1;
    }

    public void setFichedeposte1(Fichedeposte fichedeposte1) {
        this.fichedeposte1 = fichedeposte1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidaturePK != null ? candidaturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidature)) {
            return false;
        }
        Candidature other = (Candidature) object;
        if ((this.candidaturePK == null && other.candidaturePK != null) || (this.candidaturePK != null && !this.candidaturePK.equals(other.candidaturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.xfe.entities.Candidature[ candidaturePK=" + candidaturePK + " ]";
    }
    
}
