
-- test.autori definition

CREATE TABLE `autori` (
  `CodiceA` int NOT NULL AUTO_INCREMENT,
  `NomeA` varchar(50) NOT NULL,
  `CognomeA` varchar(50) NOT NULL,
  `AnnoN` int NOT NULL,
  `AnnoM` int DEFAULT NULL,
  `Sesso` varchar(1) NOT NULL,
  `Nazione` varchar(50) NOT NULL,
  PRIMARY KEY (`CodiceA`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.editore definition

CREATE TABLE `editore` (
  `CodiceE` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CodiceE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.genere definition

CREATE TABLE `genere` (
  `codiceG` int NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codiceG`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.libri definition

CREATE TABLE `libri` (
  `CodiceR` int NOT NULL AUTO_INCREMENT,
  `Titolo` varchar(100) NOT NULL,
  `CodiceA` int NOT NULL,
  `numPag` int NOT NULL,
  `Anno` int NOT NULL,
  `CodiceG` int DEFAULT NULL,
  `codiceE` int DEFAULT NULL,
  PRIMARY KEY (`CodiceR`),
  KEY `CodiceA` (`CodiceA`),
  KEY `libri_FK` (`CodiceG`),
  KEY `fk_codiceE` (`codiceE`),
  CONSTRAINT `fk_codiceE` FOREIGN KEY (`codiceE`) REFERENCES `editore` (`CodiceE`),
  CONSTRAINT `libri_FK` FOREIGN KEY (`CodiceG`) REFERENCES `genere` (`codiceG`),
  CONSTRAINT `libri_ibfk_1` FOREIGN KEY (`CodiceA`) REFERENCES `autori` (`CodiceA`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO test.autori (NomeA,CognomeA,AnnoN,AnnoM,Sesso,Nazione) VALUES
	 ('Alessandro','Manzoni',1785,1873,'M','Italia'),
	 ('Lev','Tolstoj',1828,1910,'M','Russia'),
	 ('Bruno','Vespa',1944,NULL,'M','Italia'),
	 ('Stephen','King',1947,NULL,'M','Stati Uniti'),
	 ('Ernest','Hemingway',1899,1961,'M','Stati Uniti'),
	 ('Umberto','Eco',1932,2016,'M','Italia'),
	 ('Susanna','Tamaro',1957,NULL,'F','Italia'),
	 ('Virginia','Woolf',1882,1941,'F','Regno Unito'),
	 ('Agatha','Christie',1890,1976,'F','Regno Unito');
INSERT INTO test.editore (nome) VALUES
	 ('Rizzoli'),
	 ('Mondadori');
INSERT INTO test.genere (descrizione) VALUES
	 ('gialli'),
	 ('horror'),
	 ('storici'),
	 ('romanzi');
INSERT INTO test.libri (Titolo,CodiceA,numPag,Anno,CodiceG,codiceE) VALUES
	 ('I Promessi Sposi',1,600,1827,3,1),
	 ('Storia della colonna infame',1,700,1843,3,1),
	 ('Guerra e pace',2,600,1876,3,1),
	 ('Anna Karenina',2,700,1877,4,2),
	 ('Donne al potere',3,600,2022,4,1),
	 ('La grande tempesta',3,700,2022,4,2),
	 ('Misery',4,670,1987,2,1),
	 ('IT',4,600,1986,2,2),
	 ('Shining',4,670,1977,2,2),
	 ('Il vecchio e il mare',5,760,1952,4,1);
INSERT INTO test.libri (Titolo,CodiceA,numPag,Anno,CodiceG,codiceE) VALUES
	 ('Per chi suona la campana',5,700,1940,4,1),
	 ('Fiesta',5,700,1926,4,2),
	 ('Il nome della rosa',6,600,1980,1,2),
	 ('Il pendolo di Foucault',6,670,1988,4,2),
	 ('Va dove ti porta il cuore',7,760,1944,4,2),
	 ('Gita al faro',8,600,1927,4,2),
	 ('Orlando',8,700,1928,4,2),
	 ('Assassinio sullOrient Express',9,670,1934,1,1),
	 ('Sipario',9,760,1975,1,2);

CREATE FUNCTION get_age_by_autore(nome VARCHAR(55), cognome VARCHAR(55))
RETURNS INT deterministic
BEGIN
    DECLARE eta INT;
    SELECT YEAR(CURRENT_DATE()) - AnnoN INTO eta
    FROM autori
    WHERE nomeA = nome AND cognomeA = cognome;
    RETURN eta;
END;



CREATE PROCEDURE test.get_age_autori_nazione(in nazioneA varchar(55))
begin
drop table if exists autori_eta_temp;
create table autori_eta_temp (nome varchar(55), cognome varchar(55), eta int );
insert into autori_eta_temp(nome,cognome,eta) select nomeA,cognomeA,get_age_by_autore(nomeA,cognomeA) as eta from test.autori 
where nazioneA=nazione and AnnoM is null ;
select * from autori_eta_temp;
END