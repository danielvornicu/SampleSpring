INSERT INTO ADRESSE(LIGNE1, LIGNE2, CODE_POSTAL, VILLE) VALUES ('16 rue des lilas d''Espagne', 'Appartement 12', 92400, 'Courbevoie');
INSERT INTO ADRESSE(LIGNE1, LIGNE2, CODE_POSTAL, VILLE) VALUES ('Rue1', 'Appt1', 92140, 'CLAMART');
INSERT INTO ADRESSE(LIGNE1, LIGNE2, CODE_POSTAL, VILLE) VALUES ('Rue1', 'Appt2', 91260, 'JUVISY');
INSERT INTO CLIENT (PRENOM, NOM, ADRESSE_ID) VALUES ('ERIC', 'SIBER', 1);
INSERT INTO CLIENT(PRENOM, NOM, ADRESSE_ID) VALUES ('DANIEL', 'VORNICU', 2);
INSERT INTO CLIENT(PRENOM, NOM, ADRESSE_ID) VALUES ('ALINA', 'VORNICU', 3);
INSERT INTO COMMANDE (NOMBRE_PRODUITS, MONTANT, DATE_COMMANDE, CLIENT_ID) VALUES (2, 150, CURRENT_DATE, 1);
INSERT INTO COMMANDE(NOMBRE_PRODUITS, MONTANT, DATE_COMMANDE, CLIENT_ID) VALUES (1, 100, CURRENT_DATE, 2);