package TestSpark;

public class Estacao {
	private int codigo;
	private String estacao;
	private String uf;
	private double latitude;
	private double longitude;

	public Estacao(int code, String codigoLinha, String nomeLinha, double latitude, double longitude) {
	super();
	this.codigo = code;
	this.estacao = codigoLinha;
	this.uf = nomeLinha;
	this.latitude = latitude;
	this.longitude = longitude;
	}

	public int getCodigo() {
	return codigo;
	}
	public void setCode(int codigo) {
	this.codigo = codigo;
	}
	public String getEstacao() {
	return estacao;
	}
	public void setEstacao(String estacao) {
	this.estacao = estacao;
	}
	public String getUf() {
	return uf;
	}
	public void setUf(String uf) {
	this.uf = uf;
	}
	public double getLatitude() {
	return latitude;
	}
	public void setLatitude(double latitude) {
	this.latitude = latitude;
	}
	public double getLongitude() {
	return longitude;
	}
	public void setLongitude(double longitude) {
	this.longitude = longitude;
	}

	
}
