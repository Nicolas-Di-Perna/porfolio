-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema porfolioAp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema porfolioAp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `porfolioAp` DEFAULT CHARACTER SET utf8 ;
USE `porfolioAp` ;

-- -----------------------------------------------------
-- Table `porfolioAp`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `porfolioAp`.`persona` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `domicilio` VARCHAR(45) NULL,
  `fechaNac` DATE NULL,
  `edad` DATE NULL,
  `correo` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `user` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `img` VARCHAR(150) NULL,
  `sobreMi` VARCHAR(500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `porfolioAp`.`social`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `porfolioAp`.`social` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `link` VARCHAR(150) NULL,
  `icono` VARCHAR(45) NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  CONSTRAINT `fk_social_persona`
    FOREIGN KEY (`persona_id`)
    REFERENCES `porfolioAp`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `porfolioAp`.`expLaboral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `porfolioAp`.`expLaboral` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `fechaInicio` DATE NULL,
  `fechaFin` DATE NULL,
  `area` VARCHAR(45) NULL,
  `img` VARCHAR(150) NULL,
  `referencia` VARCHAR(45) NULL,
  `contacto` VARCHAR(45) NULL,
  `descripcion` VARCHAR(250) NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  CONSTRAINT `fk_expLaboral_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `porfolioAp`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `porfolioAp`.`formacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `porfolioAp`.`formacion` (
  `id` INT NOT NULL,
  `instituto` VARCHAR(45) NULL,
  `titulo` VARCHAR(45) NULL,
  `link` VARCHAR(150) NULL,
  `fechaInicio` DATE NULL,
  `fechaFin` DATE NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  CONSTRAINT `fk_formacion_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `porfolioAp`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `porfolioAp`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `porfolioAp`.`proyecto` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(350) NULL,
  `img` VARCHAR(150) NULL,
  `link` VARCHAR(150) NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  CONSTRAINT `fk_proyecto_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `porfolioAp`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `porfolioAp`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `porfolioAp`.`skill` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `icono` VARCHAR(45) NULL,
  `porcentaje` INT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  CONSTRAINT `fk_skill_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `porfolioAp`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
