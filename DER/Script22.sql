--<ScriptOptions statementTerminator=";"/>

ALTER TABLE Compra DROP FOREIGN KEY Responsavel;

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

ALTER TABLE Acessorios DROP PRIMARY KEY;

ALTER TABLE Corretora DROP PRIMARY KEY;

ALTER TABLE Veiculo DROP PRIMARY KEY;

ALTER TABLE AcessorioCompra DROP PRIMARY KEY;

DROP TABLE Corretor;

DROP TABLE Apolice;

DROP TABLE Cliente;

DROP TABLE Compra;

DROP TABLE FIPE;

DROP TABLE Acessorios;

DROP TABLE Corretora;

DROP TABLE Veiculo;

DROP TABLE AcessorioCompra;

