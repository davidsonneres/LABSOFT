package model;

public class Franquia {
	private int idFranquia;
	private String tipoFranquia;
	private float valorFranquia;
	
	public Franquia(){}
	
	public Franquia(int idFranquia, String tipoFranquia, float valorFranquia) {
		this.idFranquia = idFranquia;
		this.tipoFranquia = tipoFranquia;
		this.valorFranquia = valorFranquia;
	}
	
	public int getIdFranquia() {
		return idFranquia;
	}
	public void setIdFranquia(int idFranquia) {
		this.idFranquia = idFranquia;
	}
	
	public String getTipoFranquia() {
		return tipoFranquia;
	}
	public void setTipoFranquia(String tipoFranquia) {
		this.tipoFranquia = tipoFranquia;
	}
	
	public float getValorFranquia() {
		return valorFranquia;
	}
	public void setValorFranquia(float valorFranquia) {
		this.valorFranquia = valorFranquia;
	}
}
