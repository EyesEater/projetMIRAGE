/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.xfe.ws;

import fr.miage.xfe.entities.Candidature;
import fr.miage.xfe.entities.Competence;
import fr.miage.xfe.entities.Demandecompetence;
import fr.miage.xfe.entities.Fichedeposte;
import fr.miage.xfe.exposition.ExpoLegereLocal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author sagab
 */
@WebService(serviceName = "WSLeger")
public class WSLeger {

    @EJB
    private ExpoLegereLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "listerOffres")
    public List<Fichedeposte> listerOffres() {
        return ejbRef.listerOffres();
    }

    @WebMethod(operationName = "candidater")
    @Oneway
    public void candidater(@WebParam(name = "candidat") String idCandidat, @WebParam(name = "fDPoste") String idFDPoste, @WebParam(name = "dateCandidature") String dateCandidature, @WebParam(name = "email") String email, @WebParam(name = "tel") String tel, @WebParam(name = "cv") String cv, @WebParam(name = "lettreMotivation") String lettreMotivation) {
        Date dateC = Date.from(Instant.parse(dateCandidature));
        ejbRef.candidater(idCandidat, idFDPoste, dateC, email, tel, cv, lettreMotivation);
    }

    @WebMethod(operationName = "listerCandidatures")
    public List<Candidature> listerCandidatures() {
        return ejbRef.listerCandidatures();
    }

    @WebMethod(operationName = "recruter")
    @Oneway
    public void recruter(@WebParam(name = "candidature") String idCandidature, @WebParam(name = "feuxVertCodir") boolean feuxVertCodir) {
        
        ejbRef.recruter(idCandidature, feuxVertCodir);
    }

    @WebMethod(operationName = "listerCompACombler")
    public List<Demandecompetence> listerCompACombler() {
        return ejbRef.listerCompACombler();
    }

    @WebMethod(operationName = "creerDemandeComp")
    @Oneway
    public void creerDemandeComp(@WebParam(name = "competence") String idCompetence, @WebParam(name = "equipe") String idEquipe) {
        ejbRef.creerDemandeComp(idCompetence, idEquipe);
    }

    @WebMethod(operationName = "listerCompEquipe")
    public List<Competence> listerCompEquipe(@WebParam(name = "equipe") String idEquipe) {
        return ejbRef.listerCompEquipe(idEquipe);
    }
    
}
