package test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import model.Apolice;

public class ApoliceTest {
	Apolice apolice;
	
	@Before
	public void cria() {
		apolice = new Apolice(44444, new Date(1540112345), new Date(1540198765L), "ativo");
	}
	@Test
	public void testGetId() {
		assertEquals("Erro", 44444, apolice.getId());
	}

	@Test
	public void testSetId() {
		apolice.setId(55555);
		assertEquals("Erro", 55555, apolice.getId());
	}

	@Test
	public void testGetDataInicio() {
		assertEquals("Erro", new Date(1540112345), apolice.getDataInicio());
	}

	@Test
	public void testSetDataInicio() {
		apolice.setDataInicio(new Date(1540154321));
		assertEquals("Erro", new Date(1540154321), apolice.getDataInicio());
	}

	@Test
	public void testGetDataFim() {
		assertEquals("Erro", new Date(1540212345), apolice.getDataFim());
	}

	@Test
	public void testSetDataFim() {
		apolice.setDataFim(new Date(1540254321));
		assertEquals("Erro", new Date(1540254321), apolice.getDataFim());
	}

	@Test
	public void testGetStatus() {
		assertEquals("Erro", "Ativo", apolice.getStatus());
	}

	@Test
	public void testSetStatus() {
		apolice.setStatus("Cancelado");
		assertEquals("Erro", "Cancelado", apolice.getStatus());
	}

}
