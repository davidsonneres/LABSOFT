package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Compra;
import model.Fipe;
import model.Veiculo;

public class CompraTest {
	Compra compra;
	@Before
	public void cria() {
		compra = new Compra(11, 22, 33, 44, 55, 66,
				"00.111.222/3333-44", "determinado", (float)100, (float)200, (float)300,
				(float)400, (float)500, new Veiculo("789456123", "Gol", 2000, "Volkswagen", "Prata", "GOL-2000", new Fipe(789, (float) 365.5)));
	}
	@Test
	public void testGetIdCompra() {
		assertEquals("Erro", 11, compra.getIdCompra());
	}

	@Test
	public void testSetIdCompra() {
		compra.setIdCompra(111);
		assertEquals("Erro", 111, compra.getIdCompra());
	}

	@Test
	public void testGetIdVeiculo() {
		assertEquals("Erro", 22, compra.getIdVeiculo());
	}

	@Test
	public void testSetIdVeiculo() {
		compra.setIdVeiculo(222);
		assertEquals("Erro", 222, compra.getIdVeiculo());
	}

	@Test
	public void testGetIdCorretor() {
		assertEquals("Erro", 33, compra.getIdCorretor());
	}

	@Test
	public void testSetIdCorretor() {
		compra.setIdCorretor(333);
		assertEquals("Erro", 333, compra.getIdCorretor());
	}

	@Test
	public void testGetIdApolice() {
		assertEquals("Erro", 44, compra.getIdApolice());
	}

	@Test
	public void testSetIdApolice() {
		compra.setIdApolice(444);
		assertEquals("Erro", 444, compra.getIdApolice());
	}

	@Test
	public void testGetIdFranquia() {
		assertEquals("Erro", 55, compra.getIdFranquia());
	}

	@Test
	public void testSetIdFranquia() {
		compra.setIdFranquia(555);
		assertEquals("Erro", 555, compra.getIdFranquia());
	}

	@Test
	public void testGetIdCliente() {
		assertEquals("Erro", 66, compra.getIdCliente());
	}

	@Test
	public void testSetIdCliente() {
		compra.setIdCliente(666);
		assertEquals("Erro", 666, compra.getIdCliente());
	}

	@Test
	public void testGetCnpjCorretora() {
		assertEquals("Erro", "00.111.222/3333-44", compra.getCnpjCorretora());
	}

	@Test
	public void testSetCnpjCorretora() {
		compra.setCnpjCorretora("00.111.222/3333-55");
		assertEquals("Erro", "00.111.222/3333-55", compra.getCnpjCorretora());
	}

	@Test
	public void testGetTipoValor() {
		assertEquals("Erro", "determinado", compra.getTipoValor());
	}

	@Test
	public void testSetTipoValor() {
		compra.setTipoValor("outro valor");
		assertEquals("Erro", "outro valor", compra.getTipoValor());
	}

	@Test
	public void testGetValorLiquidoPremios() {
		assertEquals("Erro", 100, compra.getValorLiquidoPremios(), 0.0001);
	}

	@Test
	public void testSetValorLiquidoPremios() {
		compra.setValorLiquidoPremios(120);
		assertEquals("Erro", 120, compra.getValorLiquidoPremios(), 0.0001);
	}

	@Test
	public void testGetValorIOF() {
		assertEquals("Erro", 200, compra.getValorIOF(), 0.0001);
	}

	@Test
	public void testSetValorIOF() {
		compra.setValorIOF(220);
		assertEquals("Erro", 220, compra.getValorIOF(), 0.0001);
	}

	@Test
	public void testGetValorFIPE() {
		assertEquals("Erro", 300, compra.getValorFIPE(), 0.0001);
	}

	@Test
	public void testSetValorFIPE() {
		compra.setValorFIPE(330);
		assertEquals("Erro", 330, compra.getValorFIPE(), 0.0001);
	}

	@Test
	public void testGetValorCobertura() {
		assertEquals("Erro", 400, compra.getValorCobertura(), 0.0001);
	}

	@Test
	public void testSetValorCobertura() {
		compra.setValorCobertura(440);
		assertEquals("Erro", 440, compra.getValorCobertura(), 0.0001);
	}

	@Test
	public void testGetValorDeterminado() {
		assertEquals("Erro", 500, compra.getValorDeterminado(), 0.0001);
	}

	@Test
	public void testSetValorDeterminado() {
		compra.setValorDeterminado(550);
		assertEquals("Erro", 550, compra.getValorDeterminado(), 0.0001);
	}

	@Test
	public void testGetVeiculo() {
		assertNotNull("Objeto nulo", compra.getVeiculo());
	}

//	@Test
	//public void testSetVeiculo() {
//		compra.setVeiculo(veiculo);
//		fail("Not yet implemented");
//	}

}
