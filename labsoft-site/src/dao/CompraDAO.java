package dao;

import java.util.Map;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Acessorio;
import model.Apolice;
import model.Compra;
import model.Veiculo;

public class CompraDAO {
	private Connection connection;
	private VeiculoDAO veiculoDAO = new VeiculoDAO();
	private ClienteDAO clienteDAO = new ClienteDAO();
	private CorretorDAO corretorDAO = new CorretorDAO();
	private ApoliceDAO apoliceDAO = new ApoliceDAO();
	private AcessorioDAO acessorioDAO = new AcessorioDAO();
	private FranquiaDAO franquiaDAO = new FranquiaDAO();
	private CorretoraDAO corretoraDAO = new CorretoraDAO();
	
	
	public CompraDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean create(Compra compra) throws SQLException{
		Statement statement = connection.createStatement();
		statement.executeUpdate(
				String.format("INSERT INTO Compra (IdCompra, IdVeiculo, IdCorretor, CNPJCorretora,"
						+ "TipoValores, ValorLiquidoPremios, ValorIOF, ValorCobertura, ValorFIPE,"
						+ "ValorDeterminado, IdApolice, RENAVAM, IdFranquia, IdCliente)"
						+ "VALUES (%d,%d,%d, '%s', '%s', '%s','%s', '%s', '%s','%s', %d,'%s',%d,%d);", 
						compra.getIdCompra(), compra.getVeiculo().getFipe().getIdVeiculo(),
						compra.getCorretor().getIdCorretor(), compra.getCnpjCorretora(),
						compra.getTipoValor(), compra.getValorLiquidoPremios(),
						compra.getValorIOF(), compra.getValorCobertura(), 
						compra.getVeiculo().getFipe().getValorFIPE(), compra.getValorDeterminado(),
						compra.getApolice().getId(), compra.getVeiculo().getRenavam(), 
						compra.getFranquia().getIdFranquia(), compra.getCliente().getId()));
		
		for (Acessorio acessorio : compra.getAcessorios()) {
			statement.executeUpdate(
				String.format("INSERT INTO AcessorioCompra (IdAcessorio, IdCompra) "
						+ "VALUES (%d, %d);", acessorio.getId(), compra.getIdCompra()));
		}
		
		statement.close();
		
		return true;
	}


	   
	public Map<Integer, Compra> getAll() throws SQLException {
		Map<Integer, Compra> compraList = new HashMap<>();
		Statement statement = connection.createStatement();
//		ResultSet resultSet = statement.executeQuery(
//				"SELECT * FROM ((Compra INNER JOIN AcessorioCompra ON Compra.IdCompra = AcessorioCompra.IdCompra) "
//							+ "INNER JOIN Acessorio ON AcessorioCompra.IdAcessorio = Acessorio.IdAcessorio);");
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Compra;");
		
		while(resultSet.next()) {
			int idCompra = resultSet.getInt("IdCompra");
			ResultSet acessorioSet = statement.executeQuery(String.format("SELECT * FROM (AcessorioCompra INNER JOIN Acessorio ON AcessorioCompra.IdAcessorio = Acessorio.IdAcessorio) WHERE IdCompra=%d;", idCompra));
			Compra compra = createCompra(resultSet, createAcessorio(acessorioSet));

			compraList.put(idCompra, compra);
		}
		
		statement.close();
		return compraList;
	}
	
	
	
	
	private Compra createCompra(ResultSet resultSet, List<Acessorio> acessorioList) throws SQLException {
		Compra compra = new Compra();
		compra.setIdCompra(resultSet.getInt("IdCompra"));
		compra.setAcessorios(acessorioList);
		compra.setVeiculo(veiculoDAO.findByPrimaryKey(resultSet.getString("RENAVAM")));	
		compra.setCorretor(corretorDAO.findByPrimaryKey(resultSet.getInt("IdCorretor")));
		compra.setApolice(apoliceDAO.findByPrimaryKey(resultSet.getInt("IdApolice")));
		compra.setFranquia(franquiaDAO.findByPrimaryKey(resultSet.getInt("IdFranquia")));;
		compra.setCliente(clienteDAO.findByPrimaryKey(resultSet.getInt("IdCliente")));
		compra.setCorretora(corretoraDAO.findByPrimaryKey(resultSet.getString("CNPJCorretora")));
		compra.setTipoValor(resultSet.getString("TipoValores"));;
		compra.setValorLiquidoPremios(resultSet.getFloat("ValorLiquidoPremios"));;
		compra.setValorIOF(resultSet.getFloat("ValorIOF"));
		compra.setValorCobertura(resultSet.getFloat("ValorCobertura"));
		compra.setValorDeterminado(resultSet.getFloat("ValorDeterminado"));

		return compra;
	}
	
	private List<Acessorio> createAcessorio(ResultSet acessorioSet) throws SQLException {
		List<Acessorio> acessorioList = new ArrayList<>();
		while (acessorioSet.next()) {
			acessorioList.add(acessorioDAO.createAcessorio(acessorioSet));
		}
		return acessorioList;
	}
	
	public int getLastCompraId() throws SQLException {
		Statement statement = connection.createStatement();
		int lastCompraId = 0;
		ResultSet resultSet = statement.executeQuery("SELECT IdCompra FROM Compra ORDER BY IdCompra DESC;");
		if (resultSet.next()) {
			lastCompraId = resultSet.getInt("IdCompra");
		}
		return lastCompraId;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


