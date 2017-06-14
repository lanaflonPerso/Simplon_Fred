Use Ecole;

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE matiere (
  mat_id SMALLINT,
  mat_nom VARCHAR(64) NOT NULL
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `j_mat_prof`;
CREATE TABLE j_mat_prof (
  jmp_id SMALLINT,
  jmp_mat_k SMALLINT,
  jmp_prof_k SMALLINT
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE professeur (
  prof_id SMALLINT,
  prof_nom VARCHAR(64) NOT NULL,
  prof_prenom VARCHAR(64) NOT NULL
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `j_cls_jmp`;
CREATE TABLE j_cls_jmp (
  jcm_id SMALLINT,
  jcm_cls_k SMALLINT,
  jcm_jmp_k SMALLINT
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE eleve (
  elv_id SMALLINT,
  elv_nom VARCHAR(64) NOT NULL,
  elv_prenom VARCHAR(64) NOT NULL,
  elv_cls_k SMALLINT
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `classe`;
CREATE TABLE classe (
  cls_id SMALLINT,
  cls_nom VARCHAR(64) NOT NULL
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- TOC entry 1802 (class 0 OID 16461)
-- Dependencies: 1491
-- Data for Name: classe; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO classe (cls_id, cls_nom) VALUES (1, '6° A');
INSERT INTO classe (cls_id, cls_nom) VALUES (2, '6° B');
INSERT INTO classe (cls_id, cls_nom) VALUES (3, '6° C');
INSERT INTO classe (cls_id, cls_nom) VALUES (4, '5 ° A');
INSERT INTO classe (cls_id, cls_nom) VALUES (5, '5° B');
INSERT INTO classe (cls_id, cls_nom) VALUES (6, '5°C');
INSERT INTO classe (cls_id, cls_nom) VALUES (7, '4°A');
INSERT INTO classe (cls_id, cls_nom) VALUES (8, '4° B');
INSERT INTO classe (cls_id, cls_nom) VALUES (9, '4° C');
INSERT INTO classe (cls_id, cls_nom) VALUES (10, '3° A');
INSERT INTO classe (cls_id, cls_nom) VALUES (11, '3° B');
INSERT INTO classe (cls_id, cls_nom) VALUES (12, '3° C');


--
-- TOC entry 1803 (class 0 OID 16464)
-- Dependencies: 1492
-- Data for Name: eleve; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (1, 'HERBY', 'Cyrille', 1);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (2, 'COURTEL ', 'Angelo', 1);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (3, 'PITON ', 'Thomas', 1);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (4, 'COQUILLE', 'Olivier', 2);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (5, 'SALMON', 'Dylan', 2);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (6, 'MERLET', 'Benoit', 3);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (7, 'LE GALL', 'Yann', 3);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (8, 'LE GALL', 'Morgane', 4);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (9, 'LIGERON', 'Yanninck', 4);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (10, 'LIGERON ', 'Didier', 4);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (11, 'MARLEY', 'Bob', 5);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (12, 'MAHE', 'Marie', 5);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (13, 'PICARD', 'Séverine', 6);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (14, 'PICARD', 'Manuela', 6);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (15, 'BOTTE', 'Jérôme', 6);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (16, 'CARDON', 'Mathieu', 7);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (17, 'MARDET', 'Cécile', 7);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (18, 'BUBUTE', 'Armel', 7);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (19, 'MANIQUE', 'Pascal', 8);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (20, 'ALTE', 'Paul', 8);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (21, 'CORLOT', 'Amandine', 8);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (22, 'KIBOU', 'Bahija', 9);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (23, 'MADI', 'Feti', 9);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (24, 'KERGOULET', 'Erwan', 9);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (25, 'FERNAT', 'Fernand', 10);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (26, 'JOUBERT', 'Aline', 10);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (27, 'TARTUFE', 'Thérèse', 10);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (28, 'MONIN', 'Gérald', 11);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (29, 'DROUIN', 'Albert', 11);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (30, 'NAEMI', 'Toufic', 11);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (31, 'NILBE', 'Nadia', 12);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (32, 'VIVOT', 'Valérie', 12);


--
-- TOC entry 1804 (class 0 OID 16470)
-- Dependencies: 1494
-- Data for Name: j_cls_jmp; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (1, 1, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (2, 1, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (3, 1, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (4, 1, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (5, 2, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (6, 2, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (7, 2, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (8, 2, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (9, 3, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (10, 3, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (11, 3, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (12, 3, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (13, 4, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (14, 4, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (15, 4, 7);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (16, 4, 8);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (19, 4, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (20, 5, 7);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (23, 5, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (24, 5, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (25, 5, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (26, 6, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (27, 6, 7);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (28, 6, 8);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (29, 6, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (30, 7, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (31, 7, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (32, 7, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (33, 7, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (34, 8, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (35, 8, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (36, 8, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (37, 8, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (38, 9, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (39, 9, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (40, 9, 7);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (41, 9, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (42, 10, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (43, 10, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (44, 10, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (45, 10, 8);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (46, 11, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (47, 11, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (48, 11, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (51, 11, 8);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (52, 12, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (53, 12, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (54, 12, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (58, 12, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (61, 1, 11);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (62, 1, 12);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (63, 2, 13);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (64, 2, 14);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (65, 3, 11);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (66, 3, 12);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (67, 4, 13);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (68, 4, 14);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (69, 5, 11);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (70, 6, 12);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (71, 7, 13);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (72, 8, 14);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (75, 7, 12);


--
-- TOC entry 1805 (class 0 OID 16473)
-- Dependencies: 1495
-- Data for Name: j_mat_prof; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (1, 1, 1);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (2, 1, 2);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (3, 2, 3);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (4, 2, 4);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (5, 3, 5);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (6, 3, 6);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (7, 4, 7);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (8, 4, 8);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (11, 5, 1);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (12, 5, 2);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (13, 6, 3);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (14, 6, 4);


--
-- TOC entry 1806 (class 0 OID 16476)
-- Dependencies: 1496
-- Data for Name: matiere; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO matiere (mat_id, mat_nom) VALUES (1, 'Mathématiques');
INSERT INTO matiere (mat_id, mat_nom) VALUES (2, 'Français');
INSERT INTO matiere (mat_id, mat_nom) VALUES (3, 'Anglais');
INSERT INTO matiere (mat_id, mat_nom) VALUES (4, 'Physique');
INSERT INTO matiere (mat_id, mat_nom) VALUES (5, 'Biologie');
INSERT INTO matiere (mat_id, mat_nom) VALUES (6, 'Sport');


--
-- TOC entry 1807 (class 0 OID 16479)
-- Dependencies: 1497
-- Data for Name: professeur; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (1, 'MAMOU', 'Daniel');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (2, 'SACRE', 'Sophie');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (3, 'JADEN', 'Boudy');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (4, 'BADEN', 'Baden');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (5, 'MIOU', 'Miou');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (6, 'BORA', 'Kernel');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (7, 'CAISSE', 'Jean');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (8, 'MOISSAT', 'Marc');
