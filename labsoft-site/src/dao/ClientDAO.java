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
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean create(Cliente cliente) throws SQLException{
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("INSERT INTO cliente (IdCliente, Nome, Endereco, Telefone, Email) "
						+ "VALUES (%d, %s, %s, %s, %s)", 
						cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getEndereco(), cliente.getEmail()));
		
		statement.close();
		
		return true;
	}
	
	public Cliente findByPrimaryKey(int id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM cliente WHERE id=%d", id));
		statement.close();
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
	
	public boolean update(Cliente cliente) throws SQLException {
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("UPDATE cliente (IdCliente, Nome, Endereco, Telefone, Email) "
						+ "SET IdCliente = %d, Nome = %s, Endereco = %s, Telefone = %s, Email = %s", 
						cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getEndereco(), cliente.getEmail()));
		
		statement.close();
		
		return true;
	}
	
	public boolean remove(int id) throws SQLException {
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("DELETE FROM cliente WHERE id=%d", id));
		
		statement.close();
		
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
