--<ScriptOptions statementTerminator=";"/>

ALTER TABLE Compra DROP FOREIGN KEY Responsavel;

ALTER TABLE Compra DROP FOREIGN KEY CompraTemFipe;

ALTER TABLE Compra DROP FOREIGN KEY CompraTemFranquia;

ALTER TABLE Compra DROP FOREIGN KEY CompraTemCliente;

ALTER TABLE Compra DROP FOREIGN KEY CompraTemCorretora;

ALTER TABLE Compra DROP FOREIGN KEY CompraTemVeiculo;

ALTER TABLE Compra DROP FOREIGN KEY CompraTemApolice;

ALTER TABLE Veiculo DROP FOREIGN KEY FipeDeVeiculo;

ALTER TABLE AcessorioCompra DROP FOREIGN KEY AcessorioTemCompra;

ALTER TABLE AcessorioCompra DROP FOREIGN KEY CompraTemAcessorio;

ALTER TABLE Corretor DROP PRIMARY KEY;

ALTER TABLE Apolice DROP PRIMARY KEY;

ALTER TABLE Cliente DROP PRIMARY KEY;

ALTER TABLE Compra DROP PRIMARY KEY;

ALTER TABLE FIPE DROP PRIMARY KEY;

ALTER TABLE Franquia  DROP PRIMARY KEY;

ALTER TABLE Acessorios DROP PRIMARY KEY;

ALTER TABLE Corretora DROP PRIMARY KEY;

ALTER TABLE Veiculo DROP PRIMARY KEY;

ALTER TABLE AcessorioCompra DROP PRIMARY KEY;

DROP TABLE Corretor;

DROP TABLE Apolice;

DROP TABLE Cliente;

DROP TABLE Compra;

DROP TABLE FIPE;

DROP TABLE Franquia;

DROP TABLE Acessorios;

DROP TABLE Corretora;

DROP TABLE Veiculo;

DROP TABLE AcessorioCompra;

CREATE TABLE Corretor (
	IdCorretor INT NOT NULL,
	Nome CHAR(50),
	Email CHAR(50),
	Telefone CHAR(20),
	Senha CHAR(50),
	PRIMARY KEY (IdCorretor)
);

CREATE TABLE Apolice (
	IdApolice INT NOT NULL,
	DataInicio DATE,
	DataFim DATE,
	Status CHAR(15),
	PRIMARY KEY (IdApolice)
);

CREATE TABLE Cliente (
	IdCliente INT NOT NULL,
	Nome CHAR(50),
	Endereco CHAR(100),
	CPF CHAR(14),
	Telefone CHAR(20),
	Email CHAR(50),
	Sexo CHAR(20),
	Nacionalidade CHAR(30),
	DataNascimento DATE,
	CNH CHAR(30),
	Senha CHAR(50),
	PRIMARY KEY (IdCliente)
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
	RENAVAM CHAR(20) NOT NULL,
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

CREATE TABLE Veiculo (
	RENAVAM CHAR(20) NOT NULL,
	Modelo CHAR(50) NOT NULL,
	Ano INT NOT NULL,
	Marca CHAR(50) NOT NULL,
	Cor CHAR(20) NOT NULL,
	Placa CHAR(8) NOT NULL,
	IdVeiculo INT NOT NULL,
	PRIMARY KEY (RENAVAM)
);

CREATE TABLE AcessorioCompra (
	IdAcessorioCompra CHAR(5) NOT NULL,
	IdAcessorio INT NOT NULL,
	IdCompra INT NOT NULL,
	PRIMARY KEY (IdAcessorioCompra)
);

ALTER TABLE Compra ADD CONSTRAINT Responsavel FOREIGN KEY (IdCorretor)
	REFERENCES Corretor (IdCorretor)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT CompraTemFipe FOREIGN KEY (IdVeiculo)
	REFERENCES FIPE (IdVeiculo)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT CompraTemFranquia FOREIGN KEY (IdFranquia)
	REFERENCES Franquia  (IdFranquia)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT CompraTemCliente FOREIGN KEY (IdCliente)
	REFERENCES Cliente (IdCliente)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT CompraTemCorretora FOREIGN KEY (CNPJCorretora)
	REFERENCES Corretora (CNPJCorretora)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT CompraTemVeiculo FOREIGN KEY (RENAVAM)
	REFERENCES Veiculo (RENAVAM)
	ON DELETE CASCADE;

ALTER TABLE Compra ADD CONSTRAINT CompraTemApolice FOREIGN KEY (IdApolice)
	REFERENCES Apolice (IdApolice)
	ON DELETE CASCADE;

ALTER TABLE Veiculo ADD CONSTRAINT FipeDeVeiculo FOREIGN KEY (IdVeiculo)
	REFERENCES FIPE (IdVeiculo)
	ON DELETE CASCADE;

ALTER TABLE AcessorioCompra ADD CONSTRAINT AcessorioTemCompra FOREIGN KEY (IdAcessorio)
	REFERENCES Acessorios (IdAcessorio)
	ON DELETE CASCADE;

ALTER TABLE AcessorioCompra ADD CONSTRAINT CompraTemAcessorio FOREIGN KEY (IdCompra)
	REFERENCES Compra (IdCompra)
	ON DELETE CASCADE;

