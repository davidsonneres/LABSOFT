package model;

public class Franquia {
	private int idFranquia;
	private String tipoFranquia;
	private float valorFranquia;
	
	public Franquia(int idFranquia, String tipoFranquia, float valorFranquia) {
		this.idFranquia = idFranquia;
		this.tipoFranquia = tipoFranquia;
		this.valorFranquia = valorFranquia;
	}
	
	public int getIdFranquia() {
		return idFranquia;
	}
	
	public String getTipoFranquia() {
		return tipoFranquia;
	}
	
	public float getValorFranquia() {
		return valorFranquia;
	}
}
