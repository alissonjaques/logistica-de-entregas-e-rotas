create database bd_logistica;

use bd_logistica;

CREATE TABLE `motorista` (
  `idmotorista` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cnh` varchar(45) NOT NULL,
  `idade` int NOT NULL,
  PRIMARY KEY (`idmotorista`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pacote` (
  `idpacote` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `peso` decimal(10,2) NOT NULL,
  `volume` decimal(10,2) NOT NULL,
  `destinatario` varchar(45) NOT NULL,
  `idveiculo` int NOT NULL,
  PRIMARY KEY (`idpacote`),
  KEY `idveiculo_idx` (`idveiculo`),
  CONSTRAINT `idveiculo` FOREIGN KEY (`idveiculo`) REFERENCES `veiculo` (`idveiculo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `rota` (
  `idrota` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`idrota`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `veiculo` (
  `idveiculo` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(45) NOT NULL,
  `placa` varchar(45) NOT NULL,
  `idmotorista` int NOT NULL,
  PRIMARY KEY (`idveiculo`),
  KEY `idmotorista_idx` (`idmotorista`),
  CONSTRAINT `idmotorista` FOREIGN KEY (`idmotorista`) REFERENCES `motorista` (`idmotorista`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `veiculo_rota` (
  `idveiculo_rota` int NOT NULL AUTO_INCREMENT,
  `idrota` int NOT NULL,
  `id_veiculo` int NOT NULL,
  PRIMARY KEY (`idveiculo_rota`),
  KEY `idrota_idx` (`idrota`),
  KEY `idveiculo_idx` (`id_veiculo`),
  CONSTRAINT `id_veiculo` FOREIGN KEY (`id_veiculo`) REFERENCES `veiculo` (`idveiculo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idrota` FOREIGN KEY (`idrota`) REFERENCES `rota` (`idrota`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bd_logistica`.`lixeira_motorista` (
  `idlixeira_motorista` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cnh` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`idlixeira_motorista`));

CREATE TABLE `bd_logistica`.`lixeira_veiculo` (
  `idlixeira_veiculo` INT NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `idmotorista` INT NOT NULL,
  PRIMARY KEY (`idlixeira_veiculo`));

CREATE TABLE `bd_logistica`.`lixeira_pacote` (
  `idlixeira_pacote` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `peso` DECIMAL(10,2) NOT NULL,
  `volume` DECIMAL(10,2) NOT NULL,
  `destinatario` VARCHAR(45) NOT NULL,
  `idveiculo` INT NOT NULL,
  PRIMARY KEY (`idlixeira_pacote`));
 