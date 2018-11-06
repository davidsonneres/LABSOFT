--<ScriptOptions statementTerminator=";"/>

ALTER TABLE Apólice DROP FOREIGN KEY Apólice_Cliente_FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Cliente_FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Apólice_FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_FIPE_FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Veiculo_FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Apólice_FK1;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Corretor_FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Corretora_FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Acessorios_FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Franquia _FK;

ALTER TABLE Compra DROP FOREIGN KEY Compra_Franquia _FK1;

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
	PRIMARY KEY (IdCorretor)
);

CREATE TABLE Apólice (
	IdApolice INT NOT NULL,
	DataInicio DATE,
	DataFim DATE,
	Status CHAR(15),
	IdVeiculo INT NOT NULL,
	IdCliente INT NOT NULL,
	PRIMARY KEY (IdApolice,IdVeiculo,IdCliente)
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
	RENAVAM INT NOT NULL,
	Modelo CHAR(50),
	Ano INT,
	Marca CHAR(50),
	Cor CHAR(20),
	Placa CHAR(8),
	PRIMARY KEY (RENAVAM)
);

CREATE TABLE Compra (
	IdCompra INT NOT NULL,
	IdVeiculo INT NOT NULL,
	IdCliente INT NOT NULL,
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
	IdAcessorio INT NOT NULL,
	IdFranquia INT NOT NULL,
	PRIMARY KEY (IdCompra,IdVeiculo,IdCorretor,RENAVAM,IdApolice,IdCliente,IdAcessorio,CNPJCorretora,IdFranquia)
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

ALTER TABLE Apólice ADD CONSTRAINT Apólice_Cliente_FK FOREIGN KEY (IdCliente)
	REFERENCES Cliente (IdCliente)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Cliente_FK FOREIGN KEY (IdCliente)
	REFERENCES Cliente (IdCliente)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Apólice_FK FOREIGN KEY (null)
	REFERENCES Apólice (IdApolice, IdVeiculo, IdCliente)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_FIPE_FK FOREIGN KEY (IdVeiculo)
	REFERENCES FIPE (IdVeiculo)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Veiculo_FK FOREIGN KEY (RENAVAM)
	REFERENCES Veiculo (RENAVAM)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Apólice_FK1 FOREIGN KEY (IdApolice, IdVeiculo, IdCliente)
	REFERENCES Apólice (IdApolice, IdVeiculo, IdCliente)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Corretor_FK FOREIGN KEY (IdCorretor)
	REFERENCES Corretor (IdCorretor)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Corretora_FK FOREIGN KEY (CNPJCorretora)
	REFERENCES Corretora (CNPJCorretora)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Acessorios_FK FOREIGN KEY (IdAcessorio)
	REFERENCES Acessorios (IdAcessorio)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Franquia _FK FOREIGN KEY (IdFranquia)
	REFERENCES Franquia  (IdFranquia)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT Compra_Franquia _FK1 FOREIGN KEY (IdFranquia)
	REFERENCES Franquia  (IdFranquia)
	ON DELETE CASCADE;

