/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.exposition;

import fr.miage.xfe.entities.Candidat;
import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.Equipe;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.metier.GestionCompetencesLocal;
import fr.miage.xfe.metier.GestionRecrutementLocal;
import java.util.Date;
import java.util.List;
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
    public void candidater(Candidat candidat, Fichedeposte fDPoste, Date dateCandidature, String email, String tel, String cv, String lettreMotivation) {
        this.gestionRecrutement.candidater(candidat, fDPoste, dateCandidature, email, tel, cv, lettreMotivation);
    }

    @Override
    public List<Candidature> listerCandidatures() {
        return this.gestionRecrutement.listerCandidatures();
    }

    @Override
    public void recruter(Candidature candidature, boolean feuxVertCodir) {
        this.gestionRecrutement.recruter(candidature, feuxVertCodir);
    }

    @Override
    public List<Demandecompetence> listerCompACombler() {
        return this.gestionCompetences.listerCompACombler();
    }

    @Override
    public void creerDemandeComp(Competence competence, Equipe equipe) {
        this.gestionCompetences.creerDemandeComp(competence, equipe);
    }

    @Override
    public List<Competence> listerCompEquipe(Equipe equipe) {
        return this.gestionCompetences.listerCompEquipe(equipe);
    }

}
