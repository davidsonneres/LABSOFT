package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import model.Acessorio;

public class AcessorioDAO {
	private Connection connection;
	
	public AcessorioDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Acessorio findByPrimaryKey(int id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Acessorios WHERE IdAcessorio=%d", id));
		Acessorio acessorio = null;
		if (resultSet.next()) {
			acessorio = createAcessorio(resultSet);
		}
		statement.close();
		return acessorio;
	}
	
	public Acessorio findByType(String type) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Acessorios WHERE TipoAcessorio='%s'", type));
		Acessorio acessorio = null;
		if (resultSet.next()) {
			acessorio = createAcessorio(resultSet);
		}
		statement.close();
		return acessorio;
	}
	
	public Map<Integer, Acessorio> getAll() throws SQLException {
		Map<Integer, Acessorio> corretorList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Acessorios");
		
		while(resultSet.next()) {
			Acessorio acessorio = createAcessorio(resultSet);

			corretorList.put(resultSet.getInt("IdAcessorio"), acessorio);
		}
		
		statement.close();
		return corretorList;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	private Acessorio createAcessorio(ResultSet resultSet) throws SQLException {
		Acessorio acessorio = new Acessorio();
		acessorio.setId(resultSet.getInt("IdAcessorio"));
		acessorio.setTipoAcessorio(resultSet.getString("TipoAcessorio"));
		acessorio.setValorAcessorio(resultSet.getFloat("ValorAcessorio"));
		
		return acessorio;
	}
}
