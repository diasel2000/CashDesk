-- MySQL Script generated by MySQL Workbench
-- Tue Aug 13 08:36:58 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cash desk
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cash desk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cash desk` DEFAULT CHARACTER SET latin1 ;
USE `cash desk` ;

-- -----------------------------------------------------
-- Table `cash desk`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`users` (
  `id_users` INT(11) NOT NULL AUTO_INCREMENT,
  `user_login` VARCHAR(15) NOT NULL,
  `user_pass` VARCHAR(95) NOT NULL,
  `user_role` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_users`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`caisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`caisher` (
  `id_caisher` INT(11) NOT NULL AUTO_INCREMENT,
  `caisher_name` VARCHAR(15) NULL DEFAULT NULL,
  `caisher_last_name` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id_caisher`),
  CONSTRAINT `fkuser`
    FOREIGN KEY (`id_caisher`)
    REFERENCES `cash desk`.`users` (`id_users`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`product` (
  `id_product` INT(11) NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(25) NOT NULL,
  `price` DECIMAL(5,2) NOT NULL,
  `code` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id_product`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
  INDEX `fk_product_check_idx` (`product_name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 553
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`check`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`check` (
  `id_check` INT(11) NOT NULL AUTO_INCREMENT,
  `price_sum` DECIMAL(5,2) NOT NULL,
  `product_code` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id_check`),
  INDEX `fkprt_idx` (`product_code` ASC) VISIBLE,
  CONSTRAINT `che_pro`
    FOREIGN KEY (`product_code`)
    REFERENCES `cash desk`.`product` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`senior_caisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`senior_caisher` (
  `id_scaisher` INT(11) NOT NULL AUTO_INCREMENT,
  `senior_caisher_name` VARCHAR(15) NULL DEFAULT NULL,
  `senior_caisher_lastname` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id_scaisher`),
  CONSTRAINT `fktouser`
    FOREIGN KEY (`id_scaisher`)
    REFERENCES `cash desk`.`users` (`id_users`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`supervisor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`supervisor` (
  `id_supervisor` INT(11) NOT NULL AUTO_INCREMENT,
  `supervisor_name` VARCHAR(15) NULL DEFAULT NULL,
  `supervisor_lastname` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id_supervisor`),
  CONSTRAINT `fkidusers`
    FOREIGN KEY (`id_supervisor`)
    REFERENCES `cash desk`.`users` (`id_users`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
