DROP procedure IF EXISTS `inserirMotorista`;
DELIMITER $$
USE `bdempresa`$$
CREATE PROCEDURE `inserirMotorista`;nome_ varchar(45), cnh_ varchar(11), idade_ int(11))
BEGIN
	insert into motorista(nome,cnh,idade) values (nome_,cnh_,idade_);
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `editarMotorista`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `editarMotorista` (idmotorista_ int(11), nome_ varchar(45), cnh_ varchar(11), idade_ int(11))
BEGIN
	update motorista set nome = nome_, cnh = cnh_, idade = idade_ where idMotorista = idmotorista_;
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `inserirPacote`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `inserirPacote` (descricao_ varchar(45), peso_ decimal(10,2), volume_ decimal(10,2), destinatario_ varchar(45), idveiculo_ int)
BEGIN
	insert into pacote (descricao,peso,volume,destinatario,idveiculo) values (descricao_,peso_,volume_,destinatario_,idveiculo_);
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `editarPacote`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `editarPacote` (idpacote_ int, descricao_ varchar(45), peso_ decimal(10,2), volume_ decimal(10,2), destinatario_ varchar(45), idveiculo_ int)
BEGIN
	 update pacote set descricao = descricao_, peso = peso_, volume = volume_, destinatario = destinatario_, idveiculo = idveiculo_ where idpacote = idpacote_;
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `inserirRota`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `inserirRota` (descricao_ varchar(45))
BEGIN
	insert into rota(descricao) values(descricao_);
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `editarRota`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `editarRota`;idrota_ int, descricao_ varchar(45))
BEGIN
	update rota set descricao = descricao_ where idrota = idrota_;
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `inserirVeiculo`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `inserirVeiculo`;modelo_ varchar(45), placa_ varchar(45), idmotorista_ int)
BEGIN
	insert into veiculo(modelo,placa,idmotorista) values (modelo_,placa_,idmotorista_);
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `editarVeiculo`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `editarVeiculo`;idveiculo_ int, modelo_ varchar(45), placa_ varchar(45), idmotorista_ int)
BEGIN
	update veiculo set modelo = modelo_, placa = placa_, idmotorista = idmotorista_ where idveiculo = idveiculo_;
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `inserirVeiculoRota`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `inserirVeiculoRota` (idrota_ int, id_veiculo_ int)
BEGIN
	insert into veiculo_rota (idrota,id_veiculo) values (idrota_,id_veiculo_);
END$$
DELIMITER;

USE `bd_logistica`;
DROP procedure IF EXISTS `editarVeiculoRota`;
DELIMITER $$
USE `bd_logistica`$$
CREATE PROCEDURE `editarVeiculoRota` (idveiculo_rota_ int, idrota_ int, id_veiculo_ int)
BEGIN
	update veiculo_rota set idrota = idrota_, id_veiculo = id_veiculo_ where idveiculo_rota = idveiculo_rota_;
END$$
DELIMITER;