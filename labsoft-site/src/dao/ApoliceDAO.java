package dao;

import java.util.Map;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import model.Apolice;

public class ApoliceDAO {
	private Connection connection;
	
	public ApoliceDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean create(Apolice apolice) throws SQLException{
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("INSERT INTO Apolice (IdApolice, DataInicio, DataFim, Status)"
						+ "VALUES (%d, %s, %s, %s)", 
						apolice.getId(), apolice.getDataInicio(), apolice.getDataFim(), apolice.getStatus()));
		
		statement.close();
		
		return true;
	}
	
	public Apolice findByPrimaryKey(int id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Apolice WHERE IdApolice=%d", id));
		statement.close();
		return createApolice(resultSet);
	}
	
	public Map<Integer, Apolice> getAll() throws SQLException {
		Map<Integer, Apolice> apoliceList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente");
		
		while(resultSet.next()) {
			Apolice apolice = createApolice(resultSet);

			apoliceList.put(resultSet.getInt("IdCliente"), apolice);
		}
		
		statement.close();
		return apoliceList;
	}
	
	public boolean update(Apolice apolice) throws SQLException {
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("UPDATE Apolice (IdApolice, DataInicio, DataFim, Status) "
						+ "SET IdApolice = %d, DataInicio = %s, DataFim = %s, Status = %s", 
						apolice.getId(), apolice.getDataInicio(), apolice.getDataFim(), apolice.getStatus()));
		statement.close();
		
		return true;
	}
	
	public boolean remove(int id) throws SQLException {
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("DELETE FROM Apolice WHERE IdApolice=%d", id));
		
		statement.close();
		
		return true;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	private Apolice createApolice(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("IdApolice");
		Date dataInicio = resultSet.getDate("DataInicio");
		Date dataFim = resultSet.getDate("DataFim");
		String status = resultSet.getString("Status");
		
		Apolice apolice = new Apolice(id, dataInicio, dataFim, status);
		return apolice;
	}
}
