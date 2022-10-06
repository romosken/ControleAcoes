create database controleAcoes;

create table controleAcoes.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255) not null unique key,
  senha VARCHAR(255),
  cpf VARCHAR(255),
  nome VARCHAR(255),
  sobrenome VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));

create table controleAcoes.acoes (
  id BIGINT NOT NULL AUTO_INCREMENT,
  ticker VARCHAR(255) not null unique key,
  empresa VARCHAR(255),
  cotacao DOUBLE,
  primary key (id));

create table controleAcoes.transacoes (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idUsuario BIGINT, 
  idAcao BIGINT,
  papel VARCHAR(255),
  data varchar(255),
  tipo VARCHAR(255),
  quantidade INT,
  preco DOUBLE,
  taxas DOUBLE,
  valorOperacao DOUBLE,
  valorLiquido DOUBLE,
  lucro DOUBLE,
  corretora VARCHAR(255),
  primary key (id));

ALTER TABLE controleAcoes.transacoes ADD CONSTRAINT FK_ACA_USU_ID FOREIGN KEY (IDACAO) REFERENCES controleAcoes.ACOES (ID);
ALTER TABLE controleAcoes.transacoes ADD CONSTRAINT FK_USU_ACA_ID FOREIGN KEY (IDUSUARIO) REFERENCES controleAcoes.USUARIOS (ID);  

INSERT INTO `controleAcoes`.`acoes` (`id`, `ticker`, `empresa`, `cotacao`) VALUES ('1', 'SQIA3', 'Sinquia', '23.00');
INSERT INTO `controleAcoes`.`acoes` (`id`, `ticker`, `empresa`, `cotacao`) VALUES ('2', 'IRBR3', 'IRB Brasil RE', '7.18');

INSERT INTO `controleAcoes`.`usuarios` (`id`, `login`, `senha`,`cpf`,`nome`,`sobrenome`, `status`, `tipo`) VALUES ('1', 'rodrigo.mosken@outlook.com', 'admin', '50377768804', 'Rodrigo','Mosken','ATIVO', 'ADM');

INSERT INTO `controleAcoes`.`transacoes` (`id`, `idUsuario`,`idAcao`, `papel`,`data`,`tipo`,`quantidade`,`preco`,`taxas`,`valorOperacao`,`valorLiquido`,`lucro`,`corretora`) VALUES ('1', '1', '1', 'SQIA3','2020-10-10','COMPRA','100','22','1','2200','2201','0','Clear');

