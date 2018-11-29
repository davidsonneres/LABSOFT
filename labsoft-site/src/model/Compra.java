package model;

import java.util.List;

public class Compra {
	private int idCompra;
	private int idCorretor;
	private int idApolice;
	private int idFranquia;
	private String cnpjCorretora;
	private String tipoValor;
	private float valorLiquidoPremios;
	private float valorIOF;
	private float valorCobertura;
	private float valorDeterminado;
	private Veiculo veiculo;
	private Cliente cliente;
	private List<Acessorio> acessorioList;
	private String tipoFranquia;
	
	public Compra() {}
	
	public Compra(int idCompra, int idCorretor, int idApolice, int idFranquia,
			String cnpjCorretora, String tipoValor, float valorLiquidoPremios, float valorIOF, float valorFIPE,
			float valorCobertura, float valorDeterminado, Veiculo veiculo, Cliente cliente, List<Acessorio> acessorioList, String tipoFranquia){
		this.idCompra = idCompra;
		this.idCorretor = idCorretor;
		this.idApolice = idApolice;
		this.idFranquia = idFranquia;
		this.cnpjCorretora = cnpjCorretora;
		this.tipoValor = tipoValor;
		this.valorLiquidoPremios = valorLiquidoPremios;
		this.valorIOF = valorIOF;
		this.valorCobertura = valorCobertura;
		this.valorDeterminado = valorDeterminado;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.acessorioList = acessorioList;
		this.tipoFranquia = tipoFranquia;
	}
	
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getIdCorretor() {
		return idCorretor;
	}
	public void setIdCorretor(int idCorretor) {
		this.idCorretor = idCorretor;
	}
	public int getIdApolice() {
		return idApolice;
	}
	public void setIdApolice(int idApolice) {
		this.idApolice = idApolice;
	}
	public int getIdFranquia() {
		return idFranquia;
	}
	public void setIdFranquia(int idFranquia) {
		this.idFranquia = idFranquia;
	}
	public String getCnpjCorretora() {
		return cnpjCorretora;
	}
	public void setCnpjCorretora(String cnpjCorretora) {
		this.cnpjCorretora = cnpjCorretora;
	}
	public String getTipoValor() {
		return tipoValor;
	}
	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}
	public float getValorLiquidoPremios() {
		return valorLiquidoPremios;
	}
	public void setValorLiquidoPremios(float valorLiquidoPremios) {
		this.valorLiquidoPremios = valorLiquidoPremios;
	}
	public float getValorIOF() {
		return valorIOF;
	}
	public void setValorIOF(float valorIOF) {
		this.valorIOF = valorIOF;
	}
	public float getValorCobertura() {
		return valorCobertura;
	}
	public void setValorCobertura(float valorCobertura) {
		this.valorCobertura = valorCobertura;
	}
	public float getValorDeterminado() {
		return valorDeterminado;
	}
	public void setValorDeterminado(float valorDeterminado) {
		this.valorDeterminado = valorDeterminado;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Acessorio> getAcessorios() {
		return this.acessorioList;
	}
	public void setAcessorios(List<Acessorio> acessorioList) {
		this.acessorioList = acessorioList;
	}
	public String getTipoFranquia() {
		return this.tipoFranquia;
	}
	
	public void setTipoFranquia(String tipoFranquia) {
		this.tipoFranquia = tipoFranquia;
	}
	
	
}
