-- CLIENTES
INSERT INTO Cliente (IdCliente, Nome, Endereco, CPF, Telefone, Email, Sexo, Nacionalidade, DataNascimento, CNH, Senha)
VALUES (1, "Bob Esponja", "Fundo do Mar", "111.111.111-12", "(11)99999-9999", "bob.esponja@gmail.com", "Masculino", "Americano", "1980-12-16", "35014701803", "1234");

INSERT INTO Cliente (IdCliente, Nome, Endereco, CPF, Telefone, Email, Sexo, Nacionalidade, DataNascimento, CNH, Senha)
VALUES (2, "Bethany K. Braatz", "Rua Dublim, 1562", "119.404.584-71 ", "(27)6374-7949", "BethanyKBraatz@jourrapide.com", "Feminino", "Brasileira", "1991-06-17", "21137472610", "1234");

INSERT INTO Cliente (IdCliente, Nome, Endereco, CPF, Telefone, Email, Sexo, Nacionalidade, DataNascimento, CNH, Senha)
VALUES (3, "Carole E. Carson", "Rua Várzea do Paulista, 1336", "469.401.289-48", "(81)5465-8186", "CaroleECarson@jourrapide.com", "Feminino", "Húngara", "1979-10-12", "04348172474", "1234");

INSERT INTO Cliente (IdCliente, Nome, Endereco, CPF, Telefone, Email, Sexo, Nacionalidade, DataNascimento, CNH, Senha)
VALUES (4, "Lois J. Claussen", "Rua Nestor Alves de Campos, 744", "736.289.174-17", "(42)9807-7698", "LoisJClaussen@jourrapide.com", "Masculino", "Japonês", "1974-09-25", "63185863492", "1234");


-- ACESSÓRIOS
INSERT INTO Acessorios (IdAcessorio, TipoAcessorio, ValorAcessorio)
VALUES (1, "Vidro", 5000.00);

INSERT INTO Acessorios (IdAcessorio, TipoAcessorio, ValorAcessorio)
VALUES (2, "Retrovisor", 2000.00);


-- APÓLICES
INSERT INTO Apolice (IdApolice, DataInicio, DataFim, Status)
VALUES (1, "1990-05-03", "1995-10-10", "Cancelado");

INSERT INTO Apolice (IdApolice, DataInicio, DataFim, Status)
VALUES (2, "1990-05-03", "1995-10-10", "Ativo");

INSERT INTO Apolice (IdApolice, DataInicio, DataFim, Status)
VALUES (3, "1992-05-03", "1997-10-10", "Vencido");

INSERT INTO Apolice (IdApolice, DataInicio, DataFim, Status)
VALUES (20, "1996-05-03", "2000-10-10", "Pendente");

-- CORRETOR
INSERT INTO Corretor (IdCorretor, Nome, Email, Telefone, Senha, CPF)
VALUES (1, "Carolyn C Patrick", "bbentoanthonynascimento@land.com.br", "(96) 98553-0826", "319.032.943-55", "319.032.943-55");

INSERT INTO Corretor (IdCorretor, Nome, Email, Telefone, Senha, CPF)
VALUES (2, "Nair Catarina Teixeira", "naircatarinateixeira@cartovale.com.br", "(85) 98228-4561", "107.248.563-07", "107.248.563-07");

-- CORRETORA
INSERT INTO Corretora (CNPJCorretora, RazaoSocial, Endereco, Telefone, Email)
VALUES ("29.777.007/0001-04", "Sônia e Luís Marketing Ltda", "Praça Universo", "(11) 3681-3785", "contabilidade@soniaeluismarketingltda.com.br");

-- FIPE
INSERT INTO FIPE (IdVeiculo, ValorFipe)
VALUES (1, 50000.00);

INSERT INTO FIPE (IdVeiculo, ValorFipe)
VALUES (2, 100000.00);

INSERT INTO FIPE (IdVeiculo, ValorFipe)
VALUES (3, 150000.00);

INSERT INTO FIPE (IdVeiculo, ValorFipe)
VALUES (4, 200000.00);

-- VEÍCULO
INSERT INTO Veiculo (RENAVAM, Modelo, Ano, Marca, Cor, Placa, IdVeiculo)
VALUES ("05721178473", "Airtrek 2.4 16V 163cv/ 136cv 4x4 5p Aut.", 2003, "Mitsubishi", "Verde", "JZL-0761", 1);

INSERT INTO Veiculo (RENAVAM, Modelo, Ano, Marca, Cor, Placa, IdVeiculo)
VALUES ("31851002781", "Buggy W. Turing/Luxo/M-11 Absolvt 1.6 8V", 2005, "BRM", "Cinza", "MZS-9367", 2);

INSERT INTO Veiculo (RENAVAM, Modelo, Ano, Marca, Cor, Placa, IdVeiculo)
VALUES ("70988870046", "J6 2.0 JET Flex 5p Mec.", 2015, "JAC", "Azul", "NAX-1410", 3);

INSERT INTO Veiculo (RENAVAM, Modelo, Ano, Marca, Cor, Placa, IdVeiculo)
VALUES ("37458080976", "HOVER CUV 2.4 16V 5p Mec.", 2008, "GREAT WALL", "Prata", "MMN-0363", 4);

-- COMPRA
INSERT INTO Compra (IdCompra, IdCorretor, CNPJCorretora, TipoValor, 
					ValorLiquidoPremios, ValorIOF, ValorCobertura, ValorFIPE,
					ValorDeterminado, IdApolice, RENAVAM, TipoFranquia, IdCliente)
VALUES (1, 1, "29.777.007/0001-04", "FIPE", 2000, 200, 100000, 50000, 0, 1, "05721178473", "Majorada", 1);

INSERT INTO Compra (IdCompra, IdCorretor, CNPJCorretora, TipoValor, 
					ValorLiquidoPremios, ValorIOF, ValorCobertura, ValorFIPE,
					ValorDeterminado, IdApolice, RENAVAM, TipoFranquia, IdCliente)
VALUES (2, 2, "29.777.007/0001-04", "Determinado", 3000, 200, 100000, 50000, 150000, 2, "05721178473", "Reduzida", 2);

-- ACESSORIOCOMPRA
INSERT INTO AcessorioCompra (IdAcessorio, IdCompra)
VALUES (1, 1);

INSERT INTO AcessorioCompra (IdAcessorio, IdCompra)
VALUES (2, 1);