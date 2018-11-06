--<ScriptOptions statementTerminator=";"/>

CREATE TABLE Corretor (
	IdCorretor INT NOT NULL,
	Nome CHAR(50),
	Email CHAR(50),
	Telefone CHAR(20),
	IdCompra INT NOT NULL,
	PRIMARY KEY (IdCorretor)
);

CREATE TABLE Apolice (
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

CREATE TABLE Veiculo (
	RENAVAM CHAR(20) NOT NULL,
	Modelo CHAR(50) NOT NULL,
	Ano INT NOT NULL,
	Marca CHAR(50) NOT NULL,
	Cor CHAR(20) NOT NULL,
	Placa CHAR(8) NOT NULL,
	IdCompra INT NOT NULL,
	IdVeiculo INT NOT NULL,
	IdFranquia INT NOT NULL,
	IdApolice INT NOT NULL,
	PRIMARY KEY (RENAVAM)
);

ALTER TABLE Compra ADD CONSTRAINT CompraTemApolice FOREIGN KEY (IdApolice)
	REFERENCES Apolice (IdApolice)
	ON DELETE CASCADE;

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

ALTER TABLE Acessorios ADD CONSTRAINT CompraTemVariosAcessorios FOREIGN KEY (IdCompra)
	REFERENCES Compra (IdCompra)
	ON DELETE CASCADE;

