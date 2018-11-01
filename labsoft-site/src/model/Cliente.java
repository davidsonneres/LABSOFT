package model;

public class Cliente {
	private String cpf;
	private String endereco;
	private String telefone;
	private String nome;
	private String email;
	private int id;
	
	public Cliente(String cpf, String endereco, String telefone, String nome, String email, int id) {
		this.id = id;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
	}
	public String getCPF() {
		return this.cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return this.telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	
}
