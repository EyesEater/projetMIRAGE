/*
 Compétences
 */
insert into COMPETENCE(IDCOMPETENCE,NOMCOMPETENCE) values (1,'Java');
insert into COMPETENCE(IDCOMPETENCE,NOMCOMPETENCE) values (2,'Regex');
insert into COMPETENCE(IDCOMPETENCE,NOMCOMPETENCE) values (3,'Javas cool');
insert into COMPETENCE(IDCOMPETENCE,NOMCOMPETENCE) values (4,'Microsoft Word');

/*
 CANDIDATS
 */
insert into CANDIDAT(IDCANDIDAT,PRENOMCANDIDAT,NOMCANDIDAT,FEUXVERTCODIR,COMPETENCES) values (1,'Edmond','Fyon',0,1);
insert into CANDIDAT(IDCANDIDAT,PRENOMCANDIDAT,NOMCANDIDAT,FEUXVERTCODIR,COMPETENCES) values (2,'Bob','Marlex',0,2);
insert into CANDIDAT(IDCANDIDAT,PRENOMCANDIDAT,NOMCANDIDAT,FEUXVERTCODIR,COMPETENCES) values (3,'Didier','Tripoo',0,4);
insert into CANDIDAT(IDCANDIDAT,PRENOMCANDIDAT,NOMCANDIDAT,FEUXVERTCODIR,COMPETENCES) values (4,'Quentin','Beaussart',0,4);
insert into CANDIDAT(IDCANDIDAT,PRENOMCANDIDAT,NOMCANDIDAT,FEUXVERTCODIR,COMPETENCES) values (5,'Dimitri','Calmels',0,1);
insert into CANDIDAT(IDCANDIDAT,PRENOMCANDIDAT,NOMCANDIDAT,FEUXVERTCODIR,COMPETENCES) values (6,'Xavier','Fernandez',0,1);
insert into CANDIDAT(IDCANDIDAT,PRENOMCANDIDAT,NOMCANDIDAT,FEUXVERTCODIR,COMPETENCES) values (7,'Nathan','Dias',0,3);

/*
 COLLABORATEURS
 */
 insert into COLLABORATEUR(IDCOLLABORATEUR,ROLE,CANDIDAT,EQUIPE,MANAGER) values (1,'Big Boss',4,null,null);
 insert into COLLABORATEUR(IDCOLLABORATEUR,ROLE,CANDIDAT,EQUIPE,MANAGER) values (2,'Développeur Front',5,null,1);
 insert into COLLABORATEUR(IDCOLLABORATEUR,ROLE,CANDIDAT,EQUIPE,MANAGER) values (3,'Développeur Back',6,null,1);
 insert into COLLABORATEUR(IDCOLLABORATEUR,ROLE,CANDIDAT,EQUIPE,MANAGER) values (4,'Homme à tout faire',7,null,null);

/*
 EQUIPES
 */
 insert into EQUIPE(IDEQUIPE,NOMEQUIPE,MANAGER,COMPETENCES) values (1,'Le JEE',1,1);
 insert into EQUIPE(IDEQUIPE,NOMEQUIPE,MANAGER,COMPETENCES) values (2,'La tristesse',4,3);

update COLLABORATEUR set EQUIPE=1 where IDCOLLABORATEUR<4;
update COLLABORATEUR set EQUIPE=2 where IDCOLLABORATEUR=4;

/*
 DEMANDE COMP
 */
 insert into DEMANDECOMPETENCE(COMPETENCE,EQUIPE,FEUXVERTCODIR) values (2,1,1);
 insert into DEMANDECOMPETENCE(COMPETENCE,EQUIPE,FEUXVERTCODIR) values (1,2,0);

/*
 FDP
 */
insert into FICHEDEPOSTE(IDFPD,ARCHIVEE,PRESENTATIONENTREPRISEFDP,PRESENTATIONPOSTEFDP,COMPETENCESFDP) values(1,0,'La MIAGE est une grande famille','Expert REGEX',2);
insert into FICHEDEPOSTE(IDFPD,ARCHIVEE,PRESENTATIONENTREPRISEFDP,PRESENTATIONPOSTEFDP,COMPETENCESFDP) values(2,0,'La MIAGE est une grande famille','Expert Word',4);
insert into FICHEDEPOSTE(IDFPD,ARCHIVEE,PRESENTATIONENTREPRISEFDP,PRESENTATIONPOSTEFDP,COMPETENCESFDP) values(3,1,'La MIAGE est une grande famille','Larbin',1);

/*
 CANDIDATURES
 */
 insert into CANDIDATURE(FICHEDEPOSTE,CANDIDAT,CV,EMAIL,LETTREMOTIVATION,TELEPHONE,DATECANDIDATURE) values (1,2,'Je fais du regex','bob@marlex.fr','je suis motivé','06060606060606',CURRENT DATE);
 insert into CANDIDATURE(FICHEDEPOSTE,CANDIDAT,CV,EMAIL,LETTREMOTIVATION,TELEPHONE,DATECANDIDATURE) values (1,3,'Je fais du tripoux','didier@tripoo.fr','je suis motivé','06060606060606',CURRENT DATE);
 insert into CANDIDATURE(FICHEDEPOSTE,CANDIDAT,CV,EMAIL,LETTREMOTIVATION,TELEPHONE,DATECANDIDATURE) values (2,1,'Je fais du java','ed@monfyon.fr','je suis motivé','06060606060606',CURRENT DATE);