SELECT `motorista`.`idmotorista`,
    `motorista`.`nome`,
    `motorista`.`cnh`,
    `motorista`.`idade`
FROM `bd_logistica`.`motorista`;

SELECT `pacote`.`idpacote`,
    `pacote`.`descricao`,
    `pacote`.`peso`,
    `pacote`.`volume`,
    `pacote`.`destinatario`,
    `pacote`.`idveiculo`
FROM `bd_logistica`.`pacote`;

SELECT `rota`.`idrota`,
    `rota`.`descricao`
FROM `bd_logistica`.`rota`;

SELECT `veiculo`.`idveiculo`,
    `veiculo`.`modelo`,
    `veiculo`.`placa`,
    `veiculo`.`idmotorista`
FROM `bd_logistica`.`veiculo`;

SELECT `veiculo_rota`.`idveiculo_rota`,
    `veiculo_rota`.`idrota`,
    `veiculo_rota`.`id_veiculo`
FROM `bd_logistica`.`veiculo_rota`;

SELECT `lixeira_motorista`.`idlixeira_motorista`,
    `lixeira_motorista`.`nome`,
    `lixeira_motorista`.`cnh`,
    `lixeira_motorista`.`idade`
FROM `bd_logistica`.`lixeira_motorista`;

SELECT `lixeira_pacote`.`idlixeira_pacote`,
    `lixeira_pacote`.`descricao`,
    `lixeira_pacote`.`peso`,
    `lixeira_pacote`.`volume`,
    `lixeira_pacote`.`destinatario`,
    `lixeira_pacote`.`idveiculo`
FROM `bd_logistica`.`lixeira_pacote`;

SELECT `lixeira_veiculo`.`idlixeira_veiculo`,
    `lixeira_veiculo`.`modelo`,
    `lixeira_veiculo`.`placa`,
    `lixeira_veiculo`.`idmotorista`
FROM `bd_logistica`.`lixeira_veiculo`;