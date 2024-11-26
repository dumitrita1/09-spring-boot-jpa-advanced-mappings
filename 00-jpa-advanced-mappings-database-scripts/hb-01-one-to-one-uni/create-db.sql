DROP SCHEMA IF EXISTS `hitec-gmbh`;

CREATE SCHEMA `hitec-gmbh`;

use ``hitec-gmbh``;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE Makler (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  vorname VARCHAR(255) NOT NULL,
  telefonnummer VARCHAR(255) NOT NULL
);

CREATE TABLE Immobilientype (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE Eigentuemer (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  vorname VARCHAR(255) NOT NULL,
  telefonnummer VARCHAR(255) NOT NULL
);

CREATE TABLE Interessent (
  id SERIAL PRIMARY KEY,
  addresse VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  vorname VARCHAR(255) NOT NULL,
  telefonnummer VARCHAR(255) NOT NULL
);

CREATE TABLE Immobilie (
  id SERIAL PRIMARY KEY,
  adresse VARCHAR(255) NOT NULL,
  eigentümer_id INT NOT NULL,
  wohnflache DECIMAL(10,0) NOT NULL,
  anzahl_zimmer INT NOT NULL,
  preis INT NOT NULL,
  einstellungsdatum DATE NOT NULL,
  verkaufsdatum DATE,
  baujahr INT NOT NULL,
  immobilientyp INT NOT NULL,
  makler_id INT NOT NULL,
  FOREIGN KEY (makler_id) REFERENCES Makler (id),
  FOREIGN KEY (immobilientyp) REFERENCES Immobilientype (id),
  FOREIGN KEY (eigentümer_id) REFERENCES Eigentuemer (id)
);

CREATE TABLE Besuchstermin (
  id SERIAL PRIMARY KEY,
  datum DATE NOT NULL,
  uhrzeit TIME NOT NULL,
  immobilien_id INT NOT NULL,
  interessenten_id INT NOT NULL,
  FOREIGN KEY (immobilien_id) REFERENCES Immobilie (id),
  FOREIGN KEY (interessenten_id) REFERENCES Interessent (id)
);

CREATE TABLE Gebot (
  id SERIAL PRIMARY KEY,
  gebot DECIMAL(10,0) NOT NULL,
  angenommen BOOLEAN NOT NULL,
  interessent_id INT NOT NULL,
  immobilie_id INT NOT NULL,
  FOREIGN KEY (immobilie_id) REFERENCES Immobilie (id),
  FOREIGN KEY (interessent_id) REFERENCES Interessent (id)
);

SET FOREIGN_KEY_CHECKS = 1;
