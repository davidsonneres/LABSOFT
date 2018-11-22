package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Fipe;
import model.Veiculo;

public class VeiculoTest {
	Veiculo veiculo;
	@Before
	public void cria() {
		veiculo = new Veiculo("789456123", "Gol", 2000, "Volkswagen", "Prata", "GOL-2000", new Fipe(789, (float) 365.5));
	}
	@Test
	public void testGetRenavam() {
		assertEquals("Erro", "789456123", veiculo.getRenavam());
	}

	@Test
	public void testGetModelo() {
		assertEquals("Erro", "Gol", veiculo.getModelo());
	}

	@Test
	public void testGetAno() {
		assertEquals("Erro", 2000, veiculo.getAno());
	}

	@Test
	public void testGetMarca() {
		assertEquals("Erro", "Volkswagen", veiculo.getMarca());
	}

	@Test
	public void testGetCor() {
		assertEquals("Erro", "Prata", veiculo.getCor());
	}

	@Test
	public void testGetPlaca() {
		assertEquals("Erro", "GOL-2000", veiculo.getPlaca());
	}

	@Test
	public void testGetFipe() {
		assertNotNull("Objeto nulo", veiculo.getFipe());
	}

}
