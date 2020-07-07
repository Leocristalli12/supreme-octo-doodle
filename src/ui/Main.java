package ui;
import entidades.Banco;
public class Main {
	public static void main(String[] args)
	{	
		
		Banco banco = new Banco();
		banco.cargarClientesDePrueba();
		FormularioBase formulario = new FormularioBase(banco);
		//banco.mostrarClientes();
	}
	
}