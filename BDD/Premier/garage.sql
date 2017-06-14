-- MySQL Script generated by MySQL Workbench
-- Wed Feb 22 12:17:33 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering
USE garage;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema garage
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `garage` ;

-- -----------------------------------------------------
-- Schema garage
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `garage` DEFAULT CHARACTER SET utf8 ;
USE `garage` ;

-- -----------------------------------------------------
-- Table `garage`.`Voiture`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `garage`.`Voiture` ;

CREATE TABLE IF NOT EXISTS `garage`.`Voiture` (
  `idVoiture` INT NOT NULL AUTO_INCREMENT,
  `modele` VARCHAR(45) NULL,
  `idCouleur` INT NULL,
  PRIMARY KEY (`idVoiture`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garage`.`Couleur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `garage`.`Couleur` ;

CREATE TABLE IF NOT EXISTS `garage`.`Couleur` (
  `idCouleur` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `Voiture_idVoiture` INT NOT NULL,
  PRIMARY KEY (`idCouleur`),
  INDEX `fk_Couleur_Voiture_idx` (`Voiture_idVoiture` ASC),
  CONSTRAINT `fk_Couleur_Voiture`
    FOREIGN KEY (`Voiture_idVoiture`)
    REFERENCES `garage`.`Voiture` (`idVoiture`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO Voiture (modele, idCouleur)
VALUES ('Ford', 1),
('Ferrari', 1),
('Clio', 2),
('Mercedes', 2);

INSERT INTO Couleur (nom, Voiture_idVoiture)
VALUES ('rouge', 1),
('bleu', 2);