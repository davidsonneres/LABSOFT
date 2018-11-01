package dao;

import java.util.Map;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import model.Cliente;

public class ClientDAO {
	private Connection connection;
	
	public ClientDAO() {
		try {
			Class.forName("org.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcs3643");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean create(Cliente cliente){
		
		return true;
	}
	
	public Cliente findByPrimaryKey(int id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM cliente WHERE id=%d", id));
		return createClient(resultSet);
	}
	
	public Map<Integer, Cliente> getAll() throws SQLException {
		Map<Integer, Cliente> clientList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente");
		
		while(resultSet.next()) {
			Cliente cliente = createClient(resultSet);

			clientList.put(resultSet.getInt("id"), cliente);
		}
		
		statement.close();
		return clientList;
	}
	
	public boolean update(Cliente cliente) {
		return true;
	}
	
	public boolean remove(int id) {
		return true;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	private Cliente createClient(ResultSet resultSet) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(resultSet.getInt("id"));
		cliente.setCPF(resultSet.getString("cpf"));
		cliente.setEndereco(resultSet.getString("endereco"));
		cliente.setTelefone(resultSet.getString("telefone"));
		cliente.setNome(resultSet.getString("nome"));
		cliente.setEmail(resultSet.getString("email"));
		
		return cliente;
	}
}
