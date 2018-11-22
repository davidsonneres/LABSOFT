package dao;

import java.util.Map;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import model.Corretor;

public class CorretorDAO {
	private Connection connection;
	
	public CorretorDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Corretor findByPrimaryKey(int id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Corretor WHERE IdCorretor=%d", id));
		statement.close();
		return createCorretor(resultSet);
	}
	
	public Map<Integer, Corretor> getAll() throws SQLException {
		Map<Integer, Corretor> corretorList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Corretor");
		
		while(resultSet.next()) {
			Corretor corretor = createCorretor(resultSet);

			corretorList.put(resultSet.getInt("IdCorretor"), corretor);
		}
		
		statement.close();
		return corretorList;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	private Corretor createCorretor(ResultSet resultSet) throws SQLException {
		Corretor corretor = new Corretor();
		corretor.setIdCorretor(resultSet.getInt("IdCorretor"));
		corretor.setTelefone(resultSet.getString("Telefone"));
		corretor.setNome(resultSet.getString("Nome"));
		corretor.setEmail(resultSet.getString("Email"));
		corretor.setSenha(resultSet.getString("Senha"));
		return corretor;
	}
}
