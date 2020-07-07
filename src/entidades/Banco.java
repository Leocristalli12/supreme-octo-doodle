package entidades;

import java.util.ArrayList;

public class Banco 
{

	private ArrayList<Cliente> clientes;

	public void cargarClientesDePrueba() {

		clientes = new ArrayList<Cliente>();
		Cliente cliente1 = new Cliente("Jumba123", "12345678", 1, 1, 1, 1000000.75, 1000000.75);
		this.clientes.add(cliente1);
		Cliente cliente2 = new Cliente("Katniss1", "87654321", 2, 2, 2, 1000000.5, 1000000.5);
		this.clientes.add(cliente2);
		Cliente cliente3 = new Cliente("ThomYork", "12121212", 3, 3, 3, 3.1415926, 2.71828);
		this.clientes.add(cliente3);
		Cliente cliente4 = new Cliente("adminadmin", "11111111", 4, 4, 4, 1010110, 1010101);
		this.clientes.add(cliente4);

	}

	public int getClientesSize() {

		int size = this.clientes.size();
		return size;

	}

	public ArrayList<Cliente> getClientes() {

		return clientes;
	}

	public void mostrarClientes() {

		int arraySize = this.clientes.size();
		for (int i = 0; i < arraySize; i++) 
		{

			Cliente cliente = this.clientes.get(i);
			System.out.println("Usuario: " + cliente.getUsuario() + "   Clave: " + cliente.getClave() + "  Id: "+ cliente.getId()+ "   SaldoCaja: "+cliente.getSaldoCajaAhorro()+ "  SaldoCtaCte: "+cliente.getSaldoCtaCte());
		}

	}
	public Cliente buscarCliente(String user, String password) {
		int arraySize = this.clientes.size();
		int i = 0;
		Cliente cliente = this.clientes.get(i);
		while (!(cliente.getUsuario().equals(user) && cliente.getClave().equals(password)) && i < arraySize) 
		{
			i++;
			if (i < arraySize) cliente = this.clientes.get(i);
		}
		if (i == arraySize) cliente = null;
		return cliente;
	}
	public int buscarPosCliente (int id)
	{
		int arraySize = this.clientes.size();
		int i = 0;
		Cliente cliente = this.clientes.get(i);
		while ( (cliente.getId() != id) && ( i < arraySize ) ) 
		{
			i++;
			if (i < arraySize) cliente = this.clientes.get(i);
		}
		return i;
	}
	public int buscarNumCtaCte (int nro)
	{
		int arraySize = this.clientes.size();
		int i = 0;
		Cliente cliente = this.clientes.get(i);
		while ( (cliente.getNroCtaCte() != nro) && ( i < arraySize ) ) 
		{
			i++;
			if (i < arraySize) cliente = this.clientes.get(i);
		}
		return i;
	}
	public void transferOwnCtaCte (int monto, Cliente elCliente)
	{
		double totalCaja = elCliente.getSaldoCajaAhorro();
		totalCaja -= monto;
		elCliente.setSaldoCajaAhorro(totalCaja);
		double totalCtaCte = elCliente.getSaldoCtaCte();
		totalCtaCte += monto; 
		elCliente.setSaldoCtaCte(totalCtaCte);
		int posArray = buscarPosCliente (elCliente.getId());
		clientes.set(posArray, elCliente);
	}
	public void transferCtaCte (Cliente elCliente, int monto, int posBeneficiario)
	{
		double totalCtaCteCli = elCliente.getSaldoCtaCte();
		totalCtaCteCli -= monto;
		elCliente.setSaldoCtaCte(totalCtaCteCli);
		Cliente beneficiario = this.clientes.get(posBeneficiario);
		double totalCtaCteBene = beneficiario.getSaldoCtaCte();
		totalCtaCteBene += monto; 
		beneficiario.setSaldoCtaCte(totalCtaCteBene);
		int posCli = buscarPosCliente (elCliente.getId());
		clientes.set(posCli, elCliente);
		clientes.set(posBeneficiario, beneficiario);
	}
	public void extraccionCaja (int monto, Cliente elCliente)
	{
		int posArray = buscarPosCliente (elCliente.getId());
		double totalCaja = elCliente.getSaldoCajaAhorro();
		totalCaja -= monto;
		elCliente.setSaldoCajaAhorro(totalCaja);
		clientes.set(posArray, elCliente);
	}
	public void extraccionCtaCte (int monto, Cliente elCliente)
	{
		int posArray = buscarPosCliente (elCliente.getId());
		double totalCtaCte = elCliente.getSaldoCtaCte();
		totalCtaCte -= monto;
		elCliente.setSaldoCtaCte(totalCtaCte);
		clientes.set(posArray, elCliente);
	}
	
}