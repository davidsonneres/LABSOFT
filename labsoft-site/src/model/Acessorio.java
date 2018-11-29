package model;

public class Acessorio {
	private int idAcessorio;
	private String tipoAcessorio;
	private float valorAcessorio;
	
	public Acessorio(){}
	
	public Acessorio(int idAcessorio, String tipoAcessorio, float valorAcessorio) {
		this.idAcessorio = idAcessorio;
		this.tipoAcessorio = tipoAcessorio;
		this.valorAcessorio = valorAcessorio;
	}
	
	public int getId() {
		return this.idAcessorio;
	}
	public void setId(int idAcessorio){ 
		this.idAcessorio = idAcessorio;
	}
	public String getTipoAcessorio(){
		return this.tipoAcessorio;
	}
	public void setTipoAcessorio(String tipoAcessorio){
		this.tipoAcessorio = tipoAcessorio;
	}
	public float getValorAcessorio(){
		return this.valorAcessorio;
	}
	public void setValorAcessorio(float valorAcessorio) {
		this.valorAcessorio = valorAcessorio;
	}
	
}
