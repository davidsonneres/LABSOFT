package model;

public class Compra {
	private int idCompra;
	private int idVeiculo;
	private int idCorretor;
	private int idApolice;
	private int idFranquia;
	private int idCliente;
	private String cnpjCorretora;
	private String tipoValor;
	private float valorLiquidoPremios;
	private float valorIOF;
	private float valorFIPE;
	private float valorCobertura;
	private float valorDeterminado;
	private Veiculo veiculo;
	
	public Compra(int idCompra, int idVeiculo, int idCorretor, int idApolice, int idFranquia, int idCliente,
			String cnpjCorretora, String tipoValor, float valorLiquidoPremios, float valorIOF, float valorFIPE,
			float valorCobertura, float valorDeterminado, Veiculo veiculo){
		this.idCompra = idCompra;
		this.idVeiculo = idVeiculo;
		this.idCorretor = idCorretor;
		this.idApolice = idApolice;
		this.idFranquia = idFranquia;
		this.idCliente = idCliente;
		this.cnpjCorretora = cnpjCorretora;
		this.tipoValor = tipoValor;
		this.valorLiquidoPremios = valorLiquidoPremios;
		this.valorIOF = valorIOF;
		this.valorFIPE = valorFIPE;
		this.valorCobertura = valorCobertura;
		this.valorDeterminado = valorDeterminado;
		this.veiculo = veiculo;
	}
	
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
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
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	public float getValorFIPE() {
		return valorFIPE;
	}
	public void setValorFIPE(float valorFIPE) {
		this.valorFIPE = valorFIPE;
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
	
	
}
