package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Fipe;

public class FipeTest {
	Fipe fipe;
	@Before
	public void cria() {
		fipe = new Fipe(789, (float) 365.5);
	}
	@Test
	public void testGetIdVeiculo() {
		assertEquals("Erro", 789, fipe.getIdVeiculo());
	}

	@Test
	public void testGetValorFIPE() {
		assertEquals("Erro", 365.5, fipe.getValorFIPE(), 0.0001);
	}

}
