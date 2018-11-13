package model;

public class Corretora {
	private String cnpjCorretora;
	private String razaoSocial;
	private String telefone;
	private String email;
	
	public Corretora(String cnpjCorretora, String razaoSocial, String telefone, String email) {
		this.cnpjCorretora = cnpjCorretora;
		this.razaoSocial = razaoSocial;
		this.telefone = telefone;
		this.email = email;
	}
	
	public String getCNPJCorretora() {
		return cnpjCorretora;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
}
