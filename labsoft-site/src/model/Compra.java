package model;

import java.util.List;

public class Compra {
	private int idCompra;
	private String cnpjCorretora;
	private String tipoValor;
	private float valorLiquidoPremios;
	private float valorIOF;
	private float valorCobertura;
	private float valorDeterminado = 0;
	private Veiculo veiculo;
	private Cliente cliente;
	private List<Acessorio> acessorioList;
	private String tipoFranquia;
	private Apolice apolice;
	private Corretor corretor;
	private Corretora corretora;
	private Franquia franquia;
	
	public Compra() {}
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public Franquia getFranquia() {
		return franquia;
	}
	public void setFranquia(Franquia franquia) {
		this.franquia = franquia;
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
	public Apolice getApolice() {
		return this.apolice;
	}
	public void setApolice(Apolice apolice) {
		this.apolice = apolice;
	}
	public Corretor getCorretor() {
		return this.corretor;
	}
	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}
	public Corretora getCorretora() {
		return this.corretora;
	}
	public void setCorretora(Corretora corretora) {
		this.corretora = corretora;
	}
	
}
