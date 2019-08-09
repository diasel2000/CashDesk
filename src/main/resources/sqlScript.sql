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
-- Table `cash desk`.`caisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`caisher` (
  `id_caisher` INT(11) NOT NULL AUTO_INCREMENT,
  `caisher_name` VARCHAR(15) NOT NULL,
  `caisher_last_name` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_caisher`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
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
  INDEX `fk_product_check_idx` (`product_name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`check`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`check` (
  `id_check` INT(11) NOT NULL AUTO_INCREMENT,
  `product_quantity` INT(11) NOT NULL,
  `price_sum` DECIMAL(5,2) NOT NULL,
  `id_product` INT(11) NOT NULL,
  PRIMARY KEY (`id_check`),
  INDEX `fk_check_prod_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `fk_check_prod`
    FOREIGN KEY (`id_product`)
    REFERENCES `cash desk`.`product` (`id_product`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`senior_caisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`senior_caisher` (
  `id_scaisher` INT(11) NOT NULL AUTO_INCREMENT,
  `senior_caisher_name` VARCHAR(15) NOT NULL,
  `senior_caisher_lastname` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_scaisher`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`supervisor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`supervisor` (
  `id_supervisor` INT(11) NOT NULL AUTO_INCREMENT,
  `supervisor_name` VARCHAR(15) NOT NULL,
  `supervisor_lastname` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_supervisor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cash desk`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cash desk`.`users` (
  `id_users` INT(11) NOT NULL AUTO_INCREMENT,
  `user_login` VARCHAR(15) NOT NULL,
  `user_pass` VARCHAR(15) NOT NULL,
  `user_role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_users`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
