/**
 * Atelier de gestion de projet
 * Script de création de la base de données
 */

-- Suppression de la base de données
DROP DATABASE IF EXISTS travelDB;


-- Création de la base de données
CREATE DATABASE travelDB;
USE DATABASE travelDB;


-- Création des tables
CREATE TABLE Island (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE Place (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(20),
  type ENUM('historic', 'activity'),
  visitDuration FLOAT,
  entrancePrice FLOAT,

  latitude FLOAT,
  longitude FLOAT,

  idIsland INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (idIsland) REFERENCES Island (id)
);

CREATE TABLE Hotel (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(20),
  pricePerDay FLOAT,

  latitude FLOAT,
  longitude FLOAT,

  idIsland INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (idIsland) REFERENCES Island (id)
);


-- Remplissage
/*
INSERT INTO Island (id, name) VALUES
  (0, ...),
  (1, ...);

INSERT INTO Place (id, name, type, visitDuration, entrancePrice,
  latitude, longitude, idIsland) VALUES
  (0, ...),
  (1, ...);

INSERT INTO Hotel (id, name, pricePerDay, latitude, longitude, idIsland) VALUES
  (0, ...),
  (1, ...);
*/
