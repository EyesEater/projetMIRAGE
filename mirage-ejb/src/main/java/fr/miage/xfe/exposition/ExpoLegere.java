/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.metier.GestionCompetencesLocal;
import fr.miage.xfe.metier.GestionRecrutementLocal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sagab
 */
@Stateless
public class ExpoLegere implements ExpoLegereLocal {

    @EJB
    private GestionRecrutementLocal gestionRecrutement;

    @EJB
    private GestionCompetencesLocal gestionCompetences;

    @Override
    public List<Fichedeposte> listerOffres() {
        return this.gestionRecrutement.listerOffres();
    }

    @Override
    public void candidater(String idCandidat, String idFDPoste, String dateCandidature, String email, String tel, String cv, String lettreMotivation) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCandidature);
        } catch (ParseException ex) {
            Logger.getLogger(ExpoLegere.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gestionRecrutement.candidater(Integer.parseInt(idCandidat), Integer.parseInt(idFDPoste), date, email, tel, cv, lettreMotivation);
    }

    @Override
    public List<Candidature> listerCandidatures() {
        return this.gestionRecrutement.listerCandidatures();
    }

    @Override
    public void recruter(String idCandidat, String idFDPoste, String feuxVertCodir) {
        this.gestionRecrutement.recruter(Integer.parseInt(idCandidat), Integer.parseInt(idFDPoste), feuxVertCodir.equals("1"));
    }

    @Override
    public List<Demandecompetence> listerCompACombler() {
        return this.gestionCompetences.listerCompACombler();
    }

    @Override
    public void creerDemandeComp(String idCompetence, String idEquipe) {
        this.gestionCompetences.creerDemandeComp(Integer.parseInt(idCompetence), Integer.parseInt(idEquipe));
    }

    @Override
    public List<Competence> listerCompEquipe(String idEquipe) {
        return this.gestionCompetences.listerCompEquipe(Integer.parseInt(idEquipe));
    }
}
