package dao;

import java.util.Map;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import model.Cliente;

public class ClienteDAO {
	private Connection connection;
	
	public ClienteDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean create(Cliente cliente) throws SQLException{
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("INSERT INTO Cliente (IdCliente, Nome, Endereco, CPF, Telefone, Email, Sexo, Nacionalidade, DataNascimento, CNH, Senha)) "
						+ "VALUES (%d, %s, %s, %s, %s, %s)", 
						cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getCPF(), cliente.getEndereco(), 
						cliente.getEmail(), cliente.getSexo(), cliente.getNacionalidade(), cliente.getDataNascimento(), cliente.getCNH(),
						cliente.getSenha()));
		
		statement.close();
		
		return true;
	}
	
	public Cliente findByPrimaryKey(int id) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Cliente WHERE IdCliente=%d", id));
		Cliente cliente = null;
		if (resultSet.next()) {
			cliente = createClient(resultSet);
		} 
		statement.close();
		return cliente;
	}
	
	
	public Cliente findByPrimaryCPF(String cpf) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Cliente WHERE CPF='%s'", cpf));
		Cliente cliente = null;
		if (resultSet.next()) {
			cliente = createClient(resultSet);
		} 
		statement.close();
		return cliente;
	}
	public Map<Integer, Cliente> getAll() throws SQLException {
		Map<Integer, Cliente> clientList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente");
		
		while(resultSet.next()) {
			Cliente cliente = createClient(resultSet);

			clientList.put(resultSet.getInt("IdCliente"), cliente);
		}
		
		statement.close();
		return clientList;
	}
	
	public boolean update(Cliente cliente) throws SQLException {
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("UPDATE Cliente (IdCliente, Nome, Endereco, CPF, Telefone, Email, Sexo, Nacionalidade, DataNascimento, CNH, Senha)) "
						+ "SET IdCliente = %d, Nome = %s, Endereco = %s, CPF = %s, Telefone = %s, Email = %s, Sexo = %s, Nacionalidade = %s, DataNascimento = %s, CNH = %s, Senha = %s", 
						cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getCPF(), cliente.getEndereco(), cliente.getEmail(), 
						cliente.getSexo(), cliente.getNacionalidade(), cliente.getDataNascimento(), cliente.getCNH(), cliente.getSenha()));
		statement.close();
		
		return true;
	}
	
	public boolean remove(int id) throws SQLException {
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(
				String.format("DELETE FROM Cliente WHERE IdCliente=%d", id));
		
		statement.close();
		
		return true;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	private Cliente createClient(ResultSet resultSet) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(resultSet.getInt("IdCliente"));
		cliente.setCPF(resultSet.getString("CPF"));
		cliente.setEndereco(resultSet.getString("Endereco"));
		cliente.setTelefone(resultSet.getString("Telefone"));
		cliente.setNome(resultSet.getString("Nome"));
		cliente.setEmail(resultSet.getString("Email"));
		cliente.setSexo(resultSet.getString("Sexo"));
		cliente.setNacionalidade(resultSet.getString("Nacionalidade"));
		cliente.setDataNascimento(resultSet.getDate("DataNascimento"));
		cliente.setCNH(resultSet.getString("CNH"));
		cliente.setSenha(resultSet.getString("Senha"));
		return cliente;
	}
}
