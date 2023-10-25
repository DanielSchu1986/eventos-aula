CREATE TABLE `evento` (
`id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
`data` DATE NOT NULL,
`data_fim_insc` datetime(6) NOT NULL,
`data_inicio_insc` datetime(6) NOT NULL,
`descricao` varchar(255) DEFAULT NULL,
`nome` varchar(255) NOT NULL,
`status` enum('ABERTO', 'CANCELADO', 'ENCERRADO', 'PREVISTO') DEFAULT NULL
);