package model;

public class Corretor {
	private int idCorretor;
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	
	public Corretor (int id, String nome, String telefone, String email){
		this.idCorretor = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public int getIdCorretor(){
		return idCorretor;
	}
	public String getNome(){
		return nome;
	}
	public String getTelefone(){
		return telefone;
	}
	public String getEmail(){
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha
	}
}
