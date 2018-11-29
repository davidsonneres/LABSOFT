package dao;

import java.util.Map;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.HashMap;


import model.Apolice;
import model.Compra;
import model.Veiculo;

public class CompraDAO {
	private Connection connection;
	
	public CompraDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g8?user=t1g8&password=%25jL*-nLp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean create(Compra compra) throws SQLException{
		Statement statement = connection.createStatement();
		statement.executeUpdate(
				String.format("INSERT INTO Compra (IdCompra, IdVeiculo, IdCorretor, CNPJCorretora,TipoValores,ValorLiquidoPremios,ValorIOF,ValorCobertura,ValorFIPE,ValorDeterminado,IdApolice,RENAVAM,IdFranquia,IdCliente)"
						+ "VALUES (%d,%d,%d, '%s', '%s', '%s','%s', '%s', '%s','%s', %d,'%s',%d,%d);", 
						compra.getIdCompra(),compra.getIdVeiculo(),compra.getIdCorretor(),compra.getCnpjCorretora() ,compra.getTipoValor(),compra.getValorLiquidoPremios(),compra.getValorIOF(),compra.getValorCobertura(),compra.getValorFIPE(),compra.getValorDeterminado(),compra.getIdApolice(), compra.getRENAVAM(), compra.getIdFranquia(),compra.getIdCliente()));
		
		statement.close();
		
		return true;
	}


	   
	public Map<Integer, Compra> getAll() throws SQLException {
		Map<Integer, Compra> compraList = new HashMap<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente;");
		
		while(resultSet.next()) {
			Compra compra = createCompra(resultSet);

			compraList.put(resultSet.getInt("IdCompra"), compra);
		}
		
		statement.close();
		return compraList;
	}
	
	
	
	
	private Compra createCompra(ResultSet resultSet) throws SQLException {
		int idCompra = resultSet.getInt("IdCompra");
		int idVeiculo = resultSet.getInt("IdVeiculo");
		int idCorretor = resultSet.getInt("IdCorretor");
		int idApolice = resultSet.getInt("IdApolice");
		int idFranquia = resultSet.getInt("IdFranquia");
		int idCliente = resultSet.getInt("IdCliente");
		String cnpjCorretora = resultSet.getString("CNPJCorretora");
		String tipoValores = resultSet.getString("TipoValores");
		float valorLiquidoPremios = resultSet.getFloat("ValorLiquidoPremios");
		float valorIOF = resultSet.getFloat("ValorIOF");
		float valorFIPE = resultSet.getFloat("ValorFIPE");
		float valorCobertura = resultSet.getFloat("ValorCobertura");
		float valorDeterminado = resultSet.getFloat("ValorDeterminado");
		String RENAVAM = resultSet.getString("RENAVAM");
		
		
		Compra compra = new Compra(idCompra, idVeiculo, idCorretor, idApolice,idFranquia,idCliente,cnpjCorretora,tipoValores,valorLiquidoPremios,valorIOF,valorFIPE,valorCobertura,valorDeterminado,RENAVAM);
		return compra;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


