package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.Cliente;

public class ClienteTest {
	Cliente tester;
	@Before 
	public void cria(){
		tester = new Cliente("123.123.132-99", "Rua Cebola", "(11)99999999", "Joao Silva", "joao.silva@email.com", 333333,
			"masculino", "brasileira", new Date(1540144800), "12312312312", "12345");
	}
	
	@Test
	public void testGetCPF() {
		assertEquals("CPF diferente", "123.123.132-99", tester.getCPF());
	}

	@Test
	public void testSetCPF() {
		tester.setCPF("123.123.999-99");
		assertEquals("Erro", "123.123.999-99", tester.getCPF());
	}

	@Test
	public void testGetEndereco() {
		assertEquals("Erro", "Rua Cebola", tester.getEndereco());
	}

	@Test
	public void testSetEndereco() {
		tester.setEndereco("Rua Cenoura");
		assertEquals("Erro", "Rua Cenoura", tester.getEndereco());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("Erro", "(11)99999999", tester.getTelefone());
	}

	@Test
	public void testSetTelefone() {
		tester.setTelefone("(11)91234567");
		assertEquals("Erro", "(11)91234567", tester.getTelefone());
	}

	@Test
	public void testGetNome() {
		assertEquals("Erro", "Joao Silva", tester.getNome());
	}

	@Test
	public void testSetNome() {
		tester.setNome("Maria da Silva");
		assertEquals("Erro", "Maria da Silva", tester.getNome());
	}

	@Test
	public void testGetEmail() {
		assertEquals("Erro", "joao.silva@email.com", tester.getEmail());
	}

	@Test
	public void testSetEmail() {
		tester.setEmail("maria.silva@email.com");
		assertEquals("Erro", "maria.silva@email.com", tester.getEmail());
	}

	@Test
	public void testGetId() {
		assertEquals("Erro", 333333, tester.getId());
	}

	@Test
	public void testSetId() {
		tester.setId(98765);
		assertEquals("Errro", 98765, tester.getId());
	}

	@Test
	public void testGetSexo() {
		assertEquals("Erro", "masculino", tester.getSexo());
	}

	@Test
	public void testSetSexo() {
		tester.setSexo("feminino");
		assertEquals("Erro", "feminino", tester.getSexo());
	}

	@Test
	public void testGetNacionalidade() {
		assertEquals("Erro", "brasileira", tester.getNacionalidade());
	}

	@Test
	public void testSetNacionalidade() {
		tester.setNacionalidade("francesa");
		assertEquals("Erro", "francesa", tester.getNacionalidade());
	}

	@Test
	public void testSetDataNascimento() {
		tester.setDataNascimento(new Date(1540100000));
		assertEquals("Erro", new Date(1540100000), tester.getDataNascimento());
	}

	@Test
	public void testGetDataNascimento() {
		assertEquals("Erro", new Date(1540144800), tester.getDataNascimento());
	}

	@Test
	public void testGetCNH() {
		assertEquals("Erro", "12312312312", tester.getCNH());
	}

	@Test
	public void testSetCNH() {
		tester.setCNH("32132132132");
		assertEquals("Erro", "32132132132", tester.getCNH());
	}

	@Test
	public void testGetSenha() {
		assertEquals("Erro", "12345", tester.getSenha());
	}

	@Test
	public void testSetSenha() {
		tester.setSenha("abacaxi98");
		assertEquals("Erro", "abacaxi98", tester.getSenha());
	}

}
