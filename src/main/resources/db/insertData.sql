INSERT INTO ADRESSE(LIGNE1, LIGNE2, CODE_POSTAL, VILLE) VALUES ('16 rue des lilas d''Espagne', 'Appartement 12', 92400, 'Courbevoie');
INSERT INTO ADRESSE(LIGNE1, LIGNE2, CODE_POSTAL, VILLE) VALUES ('127 Avenue Jean Jaures', 'Appt 101', 92140, 'CLAMART');
INSERT INTO ADRESSE(LIGNE1, LIGNE2, CODE_POSTAL, VILLE) VALUES ('36B Rue Monttessuy', 'Etage 6', 91260, 'JUVISY');
INSERT INTO CLIENT(PRENOM, NOM, ADRESSE_ID, DATE_C) VALUES ('DANIEL', 'VORNICU', 2, trunc(sysdate));
INSERT INTO CLIENT(PRENOM, NOM, ADRESSE_ID, DATE_C) VALUES ('ALINA', 'VORNICU', 2, trunc(sysdate));
INSERT INTO CLIENT(PRENOM, NOM, ADRESSE_ID, DATE_C) VALUES ('LUCA', 'VORNICU', 2, trunc(sysdate));
INSERT INTO CLIENT(PRENOM, NOM, ADRESSE_ID, DATE_C) VALUES ('SOFIA', 'VORNICU', 2, trunc(sysdate));
INSERT INTO CLIENT (PRENOM, NOM, ADRESSE_ID, DATE_C) VALUES ('ERIC', 'SIBER', 1, trunc(sysdate));
INSERT INTO COMMANDE (NOMBRE_PRODUITS, MONTANT, DATE_COMMANDE, CLIENT_ID) VALUES (2, 150, CURRENT_DATE, 1);
INSERT INTO COMMANDE(NOMBRE_PRODUITS, MONTANT, DATE_COMMANDE, CLIENT_ID) VALUES (1, 100, CURRENT_DATE, 2);
--
INSERT INTO users VALUES ('dv', 'mdp', true);
INSERT INTO users VALUES ('eric', 'passwordDb', true);
INSERT INTO authorities VALUES ('dv', 'ROLE_ADMIN');
INSERT INTO authorities VALUES ('eric', 'ROLE_USER');
INSERT INTO authorities VALUES ('eric', 'ROLE_ADMIN');