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
	public void testGetDataInicio() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataFim() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStatus() {
		fail("Not yet implemented");
	}

}
