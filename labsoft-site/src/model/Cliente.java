package model;

import java.util.Date;

public class Cliente {
	private int id;
	private String cpf;
	private String endereco;
	private String telefone;
	private String nome;
	private String email;
	private String sexo;
	private String nacionalidade;
	private Date dataNascimento;
	private String cnh;
	private String senha;
	
	public Cliente() {}
	
	public Cliente(String cpf, String endereco, String telefone, String nome, String email, int id,
			String sexo, String nacionalidade, Date dataNascimento, String cnh, String senha) {
		this.id = id;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
		this.cnh = cnh;
		this.senha = senha;
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
	public void setId(int id) {
		this.id = id;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidade() {
		return this.nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataNascimento() {
		return this.dataNascimento;
	}
	public String getCNH() {
		return this.cnh;
	}
	public void setCNH(String cnh) {
		this.cnh = cnh;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
