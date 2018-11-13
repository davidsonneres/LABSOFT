package model;

public class Veiculo {
	private String renavam;
	private String modelo;
	private int ano;
	private String marca;
	private String cor;
	private String placa;
	private Fipe fipe;
	
	public Veiculo(String renavam, String modelo, int ano, String marca, String cor, String placa, Fipe fipe) {
		this.renavam = renavam;
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
		this.cor = cor;
		this.placa = placa;
		this.fipe = fipe;
	}
	
	public String getRenavam() {
		return renavam;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getCor() {
		return cor;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public Fipe getFipe() {
		return fipe;
	}
}
