package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import model.Corretora;

public class CorretoraDAO {
	private Connection connection;
	
	public CorretoraDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Corretora findByPrimaryKey(String cnpjCorretora) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Corretora WHERE CNPJCorretora='%s'", cnpjCorretora));
		Corretora corretora = null;
		if (resultSet.next()) {
			corretora = createCorretora(resultSet);
		}
		statement.close();
		return corretora;
	}
	
	public Map<String, Corretora> getAll() throws SQLException {
		Map<String, Corretora> corretorList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Corretora");
		
		while(resultSet.next()) {
			Corretora corretora = createCorretora(resultSet);

			corretorList.put(resultSet.getString("CNPJCorretora"), corretora);
		}
		
		statement.close();
		return corretorList;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	private Corretora createCorretora(ResultSet resultSet) throws SQLException {
		Corretora corretora = new Corretora();
		corretora.setCNPJCorretora(resultSet.getString("CNPJCorretora"));
		corretora.setRazaoSocial(resultSet.getString("RazaoSocial"));
		corretora.setTelefone(resultSet.getString("Telefone"));
		corretora.setEmail(resultSet.getString("Email"));
		corretora.setEndereco(resultSet.getString("Endereco"));

		return corretora;
	}
}
