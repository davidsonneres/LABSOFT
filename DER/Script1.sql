--<ScriptOptions statementTerminator=";"/>

ALTER TABLE Veiculo DROP FOREIGN KEY tem;

ALTER TABLE Compra DROP FOREIGN KEY compra tem o veiculo;

ALTER TABLE Compra DROP FOREIGN KEY compra tem a apolice;

ALTER TABLE Compra DROP FOREIGN KEY responsavel;

ALTER TABLE Compra DROP FOREIGN KEY compra tem fipe;

ALTER TABLE Compra DROP FOREIGN KEY compra tem franquia;

ALTER TABLE Compra DROP FOREIGN KEY compra tem cliente;

ALTER TABLE Compra DROP FOREIGN KEY compra tem corretora;

ALTER TABLE Acessorios DROP FOREIGN KEY compra tem varios acessorios;

ALTER TABLE Corretor DROP PRIMARY KEY;

ALTER TABLE Apólice DROP PRIMARY KEY;

ALTER TABLE Cliente DROP PRIMARY KEY;

ALTER TABLE Veiculo DROP PRIMARY KEY;

ALTER TABLE Compra DROP PRIMARY KEY;

ALTER TABLE FIPE DROP PRIMARY KEY;

ALTER TABLE Franquia  DROP PRIMARY KEY;

ALTER TABLE Acessorios DROP PRIMARY KEY;

ALTER TABLE Corretora DROP PRIMARY KEY;

DROP VIEW View1;

DROP TABLE Corretor;

DROP TABLE Apólice;

DROP TABLE Cliente;

DROP TABLE Veiculo;

DROP TABLE Compra;

DROP TABLE FIPE;

DROP TABLE Franquia;

DROP TABLE Acessorios;

DROP TABLE Corretora;

CREATE TABLE Corretor (
	IdCorretor INT NOT NULL,
	Nome CHAR(50),
	Email CHAR(50),
	Telefone CHAR(20),
	IdCompra INT NOT NULL,
	PRIMARY KEY (IdCorretor)
);

CREATE TABLE Apólice (
	IdApolice INT NOT NULL,
	DataInicio DATE,
	DataFim DATE,
	Status CHAR(15),
	IdVeiculo INT NOT NULL,
	IdCliente INT NOT NULL,
	PRIMARY KEY (IdApolice)
);

CREATE TABLE Cliente (
	IdCliente INT NOT NULL,
	Nome CHAR(50),
	Endereco CHAR(100),
	CPF CHAR(14),
	Telefone CHAR(20),
	Email CHAR(50),
	PRIMARY KEY (IdCliente)
);

CREATE TABLE Veiculo (
	Modelo CHAR(50),
	Ano INT,
	Marca CHAR(50),
	Cor CHAR(20),
	Placa CHAR(8),
	IdCompra INT NOT NULL,
	IdVeiculo INT NOT NULL,
	IdFranquia INT NOT NULL,
	IdApolice INT,
	PRIMARY KEY (RENAVAM)
);

CREATE TABLE Compra (
	IdCompra INT NOT NULL,
	IdVeiculo INT NOT NULL,
	IdCorretor INT NOT NULL,
	CNPJCorretora CHAR(50) NOT NULL,
	TipoValores FLOAT,
	ValorLiquidoPremios FLOAT,
	ValorIOF FLOAT,
	ValorCobertura FLOAT,
	ValorFIPE FLOAT,
	ValorDeterminado FLOAT,
	IdApolice INT NOT NULL,
	RENAVAM CHAR(5) NOT NULL,
	IdFranquia INT NOT NULL,
	IdCliente INT NOT NULL,
	PRIMARY KEY (IdCompra)
);

CREATE TABLE FIPE (
	IdVeiculo INT NOT NULL,
	ValorFIPE FLOAT,
	PRIMARY KEY (IdVeiculo)
);

CREATE TABLE Franquia  (
	TipoFranquia CHAR(20),
	ValorFranquia FLOAT,
	IdFranquia INT NOT NULL,
	PRIMARY KEY (IdFranquia)
);

CREATE TABLE Acessorios (
	IdAcessorio INT NOT NULL,
	TipoAcessorio CHAR(50),
	ValorAcessorio FLOAT,
	IdCompra INT NOT NULL,
	PRIMARY KEY (IdAcessorio)
);

CREATE TABLE Corretora (
	RazaoSocial CHAR(50),
	CNPJCorretora CHAR(18) NOT NULL,
	Endereco CHAR(100),
	Telefone CHAR(20),
	Email CHAR(50),
	PRIMARY KEY (CNPJCorretora)
);

CREATE VIEW View1 AS;

ALTER TABLE Veiculo ADD CONSTRAINT tem FOREIGN KEY (null)
	REFERENCES Compra (IdCompra)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT compra tem o veiculo FOREIGN KEY (RENAVAM)
	REFERENCES Veiculo (RENAVAM)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT compra tem a apolice FOREIGN KEY (IdApolice)
	REFERENCES Apólice (IdApolice)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT responsavel FOREIGN KEY (IdCorretor)
	REFERENCES Corretor (IdCorretor)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT compra tem fipe FOREIGN KEY (IdVeiculo)
	REFERENCES FIPE (IdVeiculo)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT compra tem franquia FOREIGN KEY (IdFranquia)
	REFERENCES Franquia  (IdFranquia)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT compra tem cliente FOREIGN KEY (IdCliente)
	REFERENCES Cliente (IdCliente)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT compra tem corretora FOREIGN KEY (CNPJCorretora)
	REFERENCES Corretora (CNPJCorretora)
	ON DELETE CASCADE;

ALTER TABLE Acessorios ADD CONSTRAINT compra tem varios acessorios FOREIGN KEY (IdCompra)
	REFERENCES Compra (IdCompra)
	ON DELETE CASCADE;

