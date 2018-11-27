package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import model.Veiculo;
import model.Fipe;

public class VeiculoDAO {
	private Connection connection;
	
	public VeiculoDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Veiculo findByPrimaryKey(String renavam) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM (Veiculo INNER JOIN FIPE) WHERE RENAVAM='%s'", renavam));
		Veiculo veiculo = null;
		if (resultSet.next()) {
			veiculo = createVeiculo(resultSet);
		}
		statement.close();
		return veiculo;
	}
	
	public Map<String, Veiculo> getAll() throws SQLException {
		Map<String, Veiculo> veiculoList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM (Veiculo INNER JOIN FIPE)");
		
		while(resultSet.next()) {
			Veiculo veiculo = createVeiculo(resultSet);

			veiculoList.put(resultSet.getString("RENAVAM"), veiculo);
		}
		
		statement.close();
		return veiculoList;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	private Veiculo createVeiculo(ResultSet resultSet) throws SQLException {
		Veiculo veiculo = new Veiculo();
		veiculo.setRenavam(resultSet.getString("RENAVAM"));
		veiculo.setModelo(resultSet.getString("Modelo"));
		veiculo.setAno(resultSet.getInt("Ano"));
		veiculo.setMarca(resultSet.getString("Marca"));
		veiculo.setCor(resultSet.getString("Cor"));
		veiculo.setPlaca(resultSet.getString("Placa"));
		
		int idVeiculo = resultSet.getInt("IdVeiculo");
		float valorFipe = resultSet.getFloat("ValorFIPE");
		veiculo.setFipe(new Fipe(idVeiculo, valorFipe));

		return veiculo;
	}
}
