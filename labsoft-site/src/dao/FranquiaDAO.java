package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import model.Franquia;

public class FranquiaDAO {
	private Connection connection;
	
	public FranquiaDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Franquia findByPrimaryKey(int id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Franquia WHERE IdFranquia=%d", id));
		Franquia franquia= null;
		if (resultSet.next()) {
			franquia = createFranquia(resultSet);
		}
		statement.close();
		return franquia;
	}
	
	public Franquia findByType(String type) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Franquia WHERE TipoFranquia='%s'", type));
		Franquia franquia = null;
		if (resultSet.next()) {
			franquia = createFranquia(resultSet);
		}
		statement.close();
		return franquia;
	}
	
	public Map<Integer, Franquia> getAll() throws SQLException {
		Map<Integer, Franquia> corretorList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Franquia");
		
		while(resultSet.next()) {
			Franquia franquia = createFranquia(resultSet);

			corretorList.put(resultSet.getInt("IdFranquia"), franquia);
		}
		
		statement.close();
		return corretorList;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	private Franquia createFranquia(ResultSet resultSet) throws SQLException {
		Franquia franquia = new Franquia();
		franquia.setIdFranquia(resultSet.getInt("IdFranquia"));
		franquia.setTipoFranquia(resultSet.getString("TipoFranquia"));
		franquia.setValorFranquia(resultSet.getFloat("ValorFranquia"));
		
		return franquia;
	}
}
