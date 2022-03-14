INSERT INTO `bd_logistica`.`motorista`
(`idmotorista`,
`nome`,
`cnh`,
`idade`)
VALUES
(<{idmotorista: }>,
<{nome: }>,
<{cnh: }>,
<{idade: }>);

UPDATE `bd_logistica`.`motorista`
SET
`idmotorista` = <{idmotorista: }>,
`nome` = <{nome: }>,
`cnh` = <{cnh: }>,
`idade` = <{idade: }>
WHERE `idmotorista` = <{expr}>;

DELETE FROM `bd_logistica`.`motorista`
WHERE <{where_expression}>;

INSERT INTO `bd_logistica`.`pacote`
(`idpacote`,
`descricao`,
`peso`,
`volume`,
`destinatario`,
`idveiculo`)
VALUES
(<{idpacote: }>,
<{descricao: }>,
<{peso: }>,
<{volume: }>,
<{destinatario: }>,
<{idveiculo: }>);

UPDATE `bd_logistica`.`pacote`
SET
`idpacote` = <{idpacote: }>,
`descricao` = <{descricao: }>,
`peso` = <{peso: }>,
`volume` = <{volume: }>,
`destinatario` = <{destinatario: }>,
`idveiculo` = <{idveiculo: }>
WHERE `idpacote` = <{expr}>;

DELETE FROM `bd_logistica`.`pacote`
WHERE <{where_expression}>;

INSERT INTO `bd_logistica`.`rota`
(`idrota`,
`descricao`)
VALUES
(<{idrota: }>,
<{descricao: }>);

DELETE FROM `bd_logistica`.`rota`
WHERE <{where_expression}>;

UPDATE `bd_logistica`.`rota`
SET
`idrota` = <{idrota: }>,
`descricao` = <{descricao: }>
WHERE `idrota` = <{expr}>;

INSERT INTO `bd_logistica`.`veiculo`
(`idveiculo`,
`modelo`,
`placa`,
`idmotorista`)
VALUES
(<{idveiculo: }>,
<{modelo: }>,
<{placa: }>,
<{idmotorista: }>);

UPDATE `bd_logistica`.`veiculo`
SET
`idveiculo` = <{idveiculo: }>,
`modelo` = <{modelo: }>,
`placa` = <{placa: }>,
`idmotorista` = <{idmotorista: }>
WHERE `idveiculo` = <{expr}>;

DELETE FROM `bd_logistica`.`veiculo`
WHERE <{where_expression}>;

INSERT INTO `bd_logistica`.`veiculo_rota`
(`idveiculo_rota`,
`idrota`,
`id_veiculo`)
VALUES
(<{idveiculo_rota: }>,
<{idrota: }>,
<{id_veiculo: }>);

UPDATE `bd_logistica`.`veiculo_rota`
SET
`idveiculo_rota` = <{idveiculo_rota: }>,
`idrota` = <{idrota: }>,
`id_veiculo` = <{id_veiculo: }>
WHERE `idveiculo_rota` = <{expr}>;

DELETE FROM `bd_logistica`.`veiculo_rota`
WHERE <{where_expression}>;

INSERT INTO `bd_logistica`.`lixeira_motorista`
(`idlixeira_motorista`,
`nome`,
`cnh`,
`idade`)
VALUES
(<{idlixeira_motorista: }>,
<{nome: }>,
<{cnh: }>,
<{idade: }>);

UPDATE `bd_logistica`.`lixeira_motorista`
SET
`idlixeira_motorista` = <{idlixeira_motorista: }>,
`nome` = <{nome: }>,
`cnh` = <{cnh: }>,
`idade` = <{idade: }>
WHERE `idlixeira_motorista` = <{expr}>;

DELETE FROM `bd_logistica`.`lixeira_motorista`
WHERE <{where_expression}>;

INSERT INTO `bd_logistica`.`lixeira_pacote`
(`idlixeira_pacote`,
`descricao`,
`peso`,
`volume`,
`destinatario`,
`idveiculo`)
VALUES
(<{idlixeira_pacote: }>,
<{descricao: }>,
<{peso: }>,
<{volume: }>,
<{destinatario: }>,
<{idveiculo: }>);

UPDATE `bd_logistica`.`lixeira_pacote`
SET
`idlixeira_pacote` = <{idlixeira_pacote: }>,
`descricao` = <{descricao: }>,
`peso` = <{peso: }>,
`volume` = <{volume: }>,
`destinatario` = <{destinatario: }>,
`idveiculo` = <{idveiculo: }>
WHERE `idlixeira_pacote` = <{expr}>;

DELETE FROM `bd_logistica`.`lixeira_pacote`
WHERE <{where_expression}>;

INSERT INTO `bd_logistica`.`lixeira_veiculo`
(`idlixeira_veiculo`,
`modelo`,
`placa`,
`idmotorista`)
VALUES
(<{idlixeira_veiculo: }>,
<{modelo: }>,
<{placa: }>,
<{idmotorista: }>);

UPDATE `bd_logistica`.`lixeira_veiculo`
SET
`idlixeira_veiculo` = <{idlixeira_veiculo: }>,
`modelo` = <{modelo: }>,
`placa` = <{placa: }>,
`idmotorista` = <{idmotorista: }>
WHERE `idlixeira_veiculo` = <{expr}>;

DELETE FROM `bd_logistica`.`lixeira_veiculo`
WHERE <{where_expression}>;