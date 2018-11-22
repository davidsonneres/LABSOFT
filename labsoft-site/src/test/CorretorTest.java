package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Corretor;

public class CorretorTest {

	Corretor corretor;
	@Before
	public void cria(){
		corretor = new Corretor(1234, "Marcelo Santos", "(11)98765432", "marcelo.silva@corretora.com", "54321");
	}

	@Test
	public void testGetIdCorretor() {
		assertEquals("Erro", 1234,corretor.getIdCorretor());
	}

	@Test
	public void testGetNome() {
		assertEquals("Erro", "Marcelo Santos", corretor.getNome());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("Erro", "(11)98765432", corretor.getTelefone());
	}

	@Test
	public void testGetEmail() {
		assertEquals("Erro", "marcelo.silva@corretora.com", corretor.getEmail());
	}

	@Test
	public void testSetIdCorretor() {
		corretor.setIdCorretor(4321);
		assertEquals("Erro", 4321, corretor.getIdCorretor());
	}

	@Test
	public void testSetNome() {
		corretor.setNome("Mario Dantas");
		assertEquals("Erro", "Mario Dantas", corretor.getNome());
	}

	@Test
	public void testSetTelefone() {
		corretor.setTelefone("(11)43434343");
		assertEquals("Erro", "(11)43434343", corretor.getTelefone());
	}

	@Test
	public void testSetEmail() {
		corretor.setEmail("mario.dantas@email.com");
		assertEquals("Erro", "mario.dantas@email.com", corretor.getEmail());
	}

	@Test
	public void testGetSenha() {
		assertEquals("Erro", "54321", corretor.getSenha());
	}

	@Test
	public void testSetSenha() {
		corretor.setSenha("cenoura123");
		assertEquals("Erro", "cenoura123", corretor.getSenha());
	}

}
