package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Corretora;

public class CorretoraTest {
	Corretora corretora;
	@Before
	public void cria() {
		corretora = new Corretora("11.222.333/4444-55", "SP Corretora", "(11)22223333", "spcorretora@corretora.com");
	}
	@Test
	public void testGetCNPJCorretora() {
		assertEquals("Erro", "11.222.333/4444-55", corretora.getCNPJCorretora());
	}

	@Test
	public void testGetRazaoSocial() {
		assertEquals("Erro", "SP Corretora", corretora.getRazaoSocial());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("Erro", "(11)22223333", corretora.getTelefone());
	}

	@Test
	public void testGetEmail() {
		assertEquals("Erro", "spcorretora@corretora.com", corretora.getEmail());
	}

}
