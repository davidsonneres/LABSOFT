--<ScriptOptions statementTerminator=";"/>
ALTER TABLE Compra
DROP COLUMN IdVeiculo;

ALTER TABLE Compra REMOVE CONSTRAINT CompraTemFipe FOREIGN KEY (IdVeiculo)
	REFERENCES FIPE (IdVeiculo)
	ON DELETE CASCADE;



