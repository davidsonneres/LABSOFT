package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Date;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import model.Cliente;
import dao.ClienteDAO;

public class ClienteDAOTest {
	// Valores previamente gravados no banco de dados
	
	private static ClienteDAO clienteDAO;
	private int clienteId = 50;
	private String nome = "Lauss J. Claussen";
	private String endereco = "Rua Campos, 754";
	private String cpf = "996.289.174-17";
	private String telefone = "(42)9807-1234";
	private String email = "Lololussen@jourrapide.com";
	private String sexo =  "Masculino";
	private String nacionalidade = "Japonês";
	private Date dataNascimento = new Date(157230732000L); //1974-12-25
	private String cnh = "63187963492";
	private String senha =  "1234";
	private Cliente clienteTest = new Cliente(cpf, endereco, telefone, nome, email, clienteId, 
			sexo, nacionalidade, dataNascimento, cnh, senha);

	
	@BeforeClass
	public static void setup() throws SQLException{
		clienteDAO = new ClienteDAO();
	}

	@Test
	public void readCliente() throws SQLException {
		Cliente cliente = clienteDAO.findByPrimaryKey(50);
		checkCliente(clienteTest, cliente);
	}
	
	@Test
	public void readUnknownCliente() throws SQLException {
		Cliente cliente = clienteDAO.findByPrimaryKey(999999);
		assertNull("deveria retornar um cliente null", cliente);
	}
	
	
	private void checkCliente(Cliente clienteBase, Cliente cliente) {
		assertEquals("cpf deve ser igual", clienteBase.getCPF(), cliente.getCPF());
		assertEquals("endereco deve ser igual", clienteBase.getEndereco(), cliente.getEndereco());
		assertEquals("telefone deve ser igual", clienteBase.getTelefone(), cliente.getTelefone());
		assertEquals("nome deve ser igual", clienteBase.getNome(), cliente.getNome());
		assertEquals("email deve ser igual", clienteBase.getEmail(), cliente.getEmail());
		assertEquals("sexo deve ser igual", clienteBase.getSexo(), cliente.getSexo());
		assertEquals("nacionalidade deve ser igual", clienteBase.getNacionalidade(), cliente.getNacionalidade());
		assertEquals("dataNascimento deve ser igual", clienteBase.getDataNascimento().toString(), cliente.getDataNascimento().toString());
		assertEquals("cnh deve ser igual", clienteBase.getCNH(), cliente.getCNH());
		assertEquals("senha deve ser igual", clienteBase.getSenha(), cliente.getSenha());
	}
}
