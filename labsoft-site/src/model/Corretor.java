package model;

public class Corretor {
	private int idCorretor;
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	private String cpf;
	
	public Corretor(){};
	
	public Corretor (int id, String nome, String telefone, String email, String senha, String cpf){
		this.idCorretor = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
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
	public void setIdCorretor(int idCorretor) {
		this.idCorretor = idCorretor;
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
		this.senha = senha;
	}
	
	public String getCPF() {
		return this.cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
}
