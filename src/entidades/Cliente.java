package entidades;

public class Cliente 
{
	private String usuario, clave;
	private int id, nroCajaAhorro, nroCtaCte;
	private double saldoCajaAhorro, saldoCtaCte;

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNroCajaAhorro() {
		return nroCajaAhorro;
	}
	public void setNroCajaAhorro(int nroCajaAhorro) {
		this.nroCajaAhorro = nroCajaAhorro;
	}
	public int getNroCtaCte() {
		return nroCtaCte;
	}
	public void setNroCtaCte(int nroCtaCte) {
		this.nroCtaCte = nroCtaCte;
	}
	public double getSaldoCajaAhorro() {
		return saldoCajaAhorro;
	}
	public void setSaldoCajaAhorro(double saldoCajaAhorro) {
		this.saldoCajaAhorro = saldoCajaAhorro;
	}
	public double getSaldoCtaCte() {
		return saldoCtaCte;
	}
	public void setSaldoCtaCte(double saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}
	public Cliente (String usuario, String clave, int id, int nroCajaAhorro, int nroCtaCte, double saldoCajaAhorro, double saldoCtaCte) {
		this.usuario = usuario;
		this.clave = clave;
		this.id = id;
		this.nroCajaAhorro = nroCajaAhorro;
		this.nroCtaCte = nroCtaCte;
		this.saldoCajaAhorro = saldoCajaAhorro;
		this.saldoCtaCte = saldoCtaCte;
	}
	
}
