package model;

import java.util.Date;

public class Apolice {
	private int id;
	private Date dataInicio;
	private Date dataFim;
	private String status;
//	private Cliente cliente;
//	private Veiculo veiculo;
//	private Compra compra;
	
	public Apolice(){}
	
	public int getId(){
		return id;
	}
	
	public Date getDataInicio(){
		return dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	
	public String getStatus() {
		return status;
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
