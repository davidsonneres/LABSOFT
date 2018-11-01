package model;

public class Cliente {
	private String CPF;
	private String Endereco;
	private String Telefone;
	private String Nome;
	private String Email;
	private int id;
	
	public Cliente(String string, String string2, String string3, String string4, String string5, int i) {
		// TODO Auto-generated constructor stub
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getId() {
		return id;
	}
	
}
