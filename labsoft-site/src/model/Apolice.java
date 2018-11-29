package model;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Apolice {
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private int id;
	private Date dataInicio;
	private Date dataFim;
	private String status;
//	private Cliente cliente;
//	private Veiculo veiculo;
//	private Compra compra;
	
	public Apolice(int id, Date dataInicio, Date dataFim, String status){
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataInicio(){
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

	
	
	
	
	
	
	
//	public Cliente getCliente() {
//		return cliente;
//	}
//	
//	public Veiculo getVeiculo() {
//		return veiculo;
//	}
//	
//	public Compra getCompra() {
//		return compra;
//	}
}
