package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Franquia;

public class FranquiaTest {
	Franquia franquia;
	
	@Before
	public void cria() {
		franquia = new Franquia(11111, "tipo franquia", (float)5000);
	}
	
	@Test
	public void testGetIdFranquia() {
		assertEquals("Erro", 11111, franquia.getIdFranquia());
	}

	@Test
	public void testGetTipoFranquia() {
		assertEquals("Erro", "tipo franquia", franquia.getTipoFranquia());
	}

	@Test
	public void testGetValorFranquia() {
		assertEquals("Erro", 5000, franquia.getValorFranquia(), 0.0001);
	}

}
