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
		for (int i = 0; i < arraySize; i++) {
			
			Cliente cliente = this.clientes.get(i);
			System.out.println("Usuario: " +cliente.getUsuario()+ "Clave:  " +cliente.getClave()+ "Id:" +String.valueOf(cliente.getId()));
			
		}
		
	}
	public Cliente buscarCliente (String user, String password)
	{
		int arraySize = this.clientes.size();
		int i = 0;
		Cliente cliente = this.clientes.get(i);
		while (!(cliente.getUsuario().equals(user) && cliente.getClave().equals(password)) && i < arraySize)
		{
			i++;
			if (i < arraySize ) cliente = this.clientes.get(i); 
		}
		if (i == arraySize) cliente = null;
		return cliente;
	}
}