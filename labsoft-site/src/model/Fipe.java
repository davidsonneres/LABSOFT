package model;

public class Fipe {
	private int idVeiculo;
	private float valorFIPE;
	
	public Fipe(int idVeiculo, float valorFIPE) {
		this.idVeiculo = idVeiculo;
		this.valorFIPE = valorFIPE;
	}
	
	public int getIdVeiculo() {
		return idVeiculo;
	}
	
	public float getValorFIPE() {
		return valorFIPE;
	}
}
