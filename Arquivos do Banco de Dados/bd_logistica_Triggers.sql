use bd_logistica;

delimiter //
	CREATE TRIGGER coloca_na_lixeira_motorista
	AFTER delete ON motorista
	FOR EACH ROW
	BEGIN
		insert into lixeira_motorista values (old.idmotorista,old.nome,old.cnh,old.idade);
	END //
delimiter ;

delimiter //
	CREATE TRIGGER coloca_na_lixeira_veiculo
	AFTER delete ON veiculo
	FOR EACH ROW
	BEGIN
		insert into lixeira_veiculo values (old.idveiculo,old.modelo,old.placa,old.idmotorista);
	END //
delimiter ;

delimiter //
	CREATE TRIGGER coloca_na_lixeira_pacote
	AFTER delete ON pacote
	FOR EACH ROW
	BEGIN
		insert into lixeira_pacote values (old.idpacote,old.descricao,old.peso,old.volume,old.destinatario,old.idveiculo);
	END //
delimiter ;