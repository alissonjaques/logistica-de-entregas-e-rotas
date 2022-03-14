USE `bd_logistica`;
CREATE  OR REPLACE VIEW `vw_veiculo_motorista` AS
SELECT bd_logistica.veiculo.idveiculo,
	bd_logistica.veiculo.modelo,
	bd_logistica.veiculo.placa,
	bd_logistica.motorista.nome
FROM bd_logistica.veiculo
	INNER JOIN bd_logistica.motorista ON 
	 bd_logistica.veiculo.idmotorista = bd_logistica.motorista.idmotorista;

USE `bd_logistica`;
CREATE  OR REPLACE VIEW `vw_pacote_veiculo` AS SELECT bd_logistica.pacote.idpacote,
	bd_logistica.pacote.descricao,
	bd_logistica.pacote.peso,
	bd_logistica.pacote.volume,
	bd_logistica.pacote.destinatario,
	bd_logistica.veiculo.placa
FROM bd_logistica.pacote
	INNER JOIN bd_logistica.veiculo ON 
	 bd_logistica.pacote.idveiculo = bd_logistica.veiculo.idveiculo;

USE `bd_logistica`;
CREATE  OR REPLACE VIEW `vw_idveiculos_pacotes` AS SELECT bd_logistica.veiculo.idveiculo
FROM bd_logistica.pacote
	INNER JOIN bd_logistica.veiculo ON 
	 bd_logistica.pacote.idveiculo = bd_logistica.veiculo.idveiculo;
	 
USE `bd_logistica`;
CREATE  OR REPLACE VIEW `vw_idmotoristas_veiculos` AS SELECT bd_logistica.motorista.idmotorista
FROM bd_logistica.veiculo
	INNER JOIN bd_logistica.motorista ON 
	 bd_logistica.veiculo.idmotorista = bd_logistica.motorista.idmotorista;

USE `bd_logistica`;
CREATE  OR REPLACE VIEW `vw_veiculo_rota` AS SELECT bd_logistica.veiculo_rota.idveiculo_rota,
	bd_logistica.veiculo.placa,
	bd_logistica.rota.descricao
FROM bd_logistica.veiculo_rota
	INNER JOIN bd_logistica.veiculo ON 
	 bd_logistica.veiculo_rota.id_veiculo = bd_logistica.veiculo.idveiculo 
	INNER JOIN bd_logistica.rota ON 
	 bd_logistica.veiculo_rota.idrota = bd_logistica.rota.idrota;