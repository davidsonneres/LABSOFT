package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Date;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import model.Apolice;
import dao.ApoliceDAO;

public class ApoliceDAOTest {
	
	private static ApoliceDAO apoliceDAO;
	private int apoliceId = 999;
	private Date dataInicio = new Date(1483236000L);
	private Date dataFim = new Date(1485914400L);
	private String status = "cancelada";
	private Apolice apoliceTest = new Apolice(apoliceId, dataInicio, dataFim, status);
	// 1483236000 milliseconds = 01 de Janeiro de 2017
	// 1485914400 milliseconds = 01 de Fevereiro de 2017
	
	@BeforeClass
	public static void setup(){
		apoliceDAO = new ApoliceDAO();
	}
	
	@Before
	public void setupBeforeEach() throws SQLException{
		Apolice apolice = apoliceDAO.findByPrimaryKey(apoliceId);
		if (apolice == null) {
			apoliceDAO.create(apoliceTest);
		}
	}

	@Test
	public void readApolice() throws SQLException {
		Apolice apolice = apoliceDAO.findByPrimaryKey(apoliceId);
		assertEquals("a data de início deve ser a mesma da apólice registrada", 
				dataInicio.toString(), apolice.getDataInicio().toString());
		assertEquals("a data de fim deve ser a mesma da apólice registrada", 
				dataFim.toString(), apolice.getDataFim().toString());
		assertEquals("o status deve ser o mesmo da apólice registrada", 
				status, apolice.getStatus());
	}
	
	@Test
	public void readUnknownApolice() throws SQLException {
		Apolice apolice = apoliceDAO.findByPrimaryKey(999999);
		assertNull("deveria retornar uma apólice null", apolice);
	}
	
	@Test
	public void updateApolice() throws SQLException{
		Apolice apolice = apoliceDAO.findByPrimaryKey(apoliceId);
		long dataInicio = 1541099532000L; // 01-11-2018
		long dataFim = 1542910332000L; // 22-11-2018
		
		apolice.setDataInicio(new Date(dataInicio));
	}
	

}
