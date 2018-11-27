package model;

public class Veiculo {
	private String renavam;
	private String modelo;
	private int ano;
	private String marca;
	private String cor;
	private String placa;
	private Fipe fipe;
	
	public Veiculo(){}
	
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
	
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Fipe getFipe() {
		return fipe;
	}
	
	public void setFipe(Fipe fipe) {
		this.fipe = fipe;
	}
}
