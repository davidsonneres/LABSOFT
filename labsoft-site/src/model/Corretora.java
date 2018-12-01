package model;

public class Corretora {
	private String cnpjCorretora;
	private String razaoSocial;
	private String telefone;
	private String email;
	private String endereco;
	
	public Corretora(){}
	
	public Corretora(String cnpjCorretora, String razaoSocial, String telefone, String email, String endereco) {
		this.cnpjCorretora = cnpjCorretora;
		this.razaoSocial = razaoSocial;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	public String getCNPJCorretora() {
		return cnpjCorretora;
	}
	
	public void setCNPJCorretora(String cnpjCorretora) {
		this.cnpjCorretora = cnpjCorretora;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
