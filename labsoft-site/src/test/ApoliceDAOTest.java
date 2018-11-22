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
	// Valores previamente gravados no banco de dados
	
	private static ApoliceDAO apoliceDAO;
	private int apoliceId = 1000;
	private Date dataInicio = new Date(1483294332000L);
	private Date dataFim = new Date(1485972732000L);
	private String status = "cancelada";
	private Apolice apoliceTest = new Apolice(apoliceId, dataInicio, dataFim, status);
	// 1483236000 milliseconds = 01 de Janeiro de 2017
	// 1485914400 milliseconds = 01 de Fevereiro de 2017
	
	@BeforeClass
	public static void setup() throws SQLException{
		apoliceDAO = new ApoliceDAO();
	}

	@Test
	public void readApolice() throws SQLException {
		Apolice apolice = apoliceDAO.findByPrimaryKey(1000);
		checkApolice(apoliceTest, apolice);
	}
	
	@Test
	public void readUnknownApolice() throws SQLException {
		Apolice apolice = apoliceDAO.findByPrimaryKey(999999);
		assertNull("deveria retornar uma apólice null", apolice);
	}
	
	@Test
	public void updateApolice() throws SQLException{
		Apolice oldApolice = apoliceDAO.findByPrimaryKey(1001);
		Date newDataInicio = new Date(1541099532000L); // 01-11-2018
		Date newDataFim = new Date(1542910332000L); // 22-11-2018
		String newStatus = "ativa";
		
		Apolice newApolice = new Apolice(oldApolice.getId(), newDataInicio, newDataFim, newStatus);
		apoliceDAO.update(newApolice);
		
		Apolice readApolice = apoliceDAO.findByPrimaryKey(1001);
		checkApolice(newApolice, readApolice);
		
		// retorna ao estado original da apólice no banco de dados
		apoliceDAO.update(oldApolice);
		
		readApolice = apoliceDAO.findByPrimaryKey(1001);
		checkApolice(oldApolice, readApolice);
	}
	
	@Test
	public void createAndDeleteApolice() throws SQLException{
		apoliceDAO.create(new Apolice(1002, dataInicio, dataFim, status));
		
		Apolice apolice = apoliceDAO.findByPrimaryKey(1002);
		checkApolice(apoliceTest, apolice);
		
		apoliceDAO.delete(1002);
		Apolice deletedApolice = apoliceDAO.findByPrimaryKey(1002);
		assertNull("apólice não foi deletada", deletedApolice);
	}
	
	
	private void checkApolice(Apolice apoliceBase, Apolice apolice) {
		assertEquals("a data de início deve ser a mesma da apólice registrada", 
				apoliceBase.getDataInicio().toString(), apolice.getDataInicio().toString());
		assertEquals("a data de fim deve ser a mesma da apólice registrada", 
				apoliceBase.getDataFim().toString(), apolice.getDataFim().toString());
		assertEquals("o status deve ser o mesmo da apólice registrada", 
				apoliceBase.getStatus(), apolice.getStatus());
	}
}
