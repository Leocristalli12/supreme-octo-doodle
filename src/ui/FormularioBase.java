package ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FormularioBase extends JFrame implements ActionListener
{
	private JButton boton1,boton2,boton3;
    private JLabel userText, claveText;
    private JTextField usuario;
    private JPasswordField clave;
	public static void main(String[] args) 
	{
		FormularioBase formulario = new FormularioBase();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public FormularioBase() 
	{
		super( "Log In" );
		
		userText = new JLabel("Usuario");
        claveText = new JLabel("Contraseña");
        usuario = new JTextField(10);
        clave = new JPasswordField(5);
        boton1=new JButton("Aceptar");;
        boton1.addActionListener(this);
        boton2=new JButton("Borrar");
        boton2.addActionListener(this);
        boton3=new JButton("Salir");
        boton3.addActionListener(this);  
        
        JPanel panelUsuario = new JPanel();
        panelUsuario.add(userText);
        panelUsuario.add(usuario);
        JPanel panelClave = new JPanel();
        panelClave.add(claveText);
        panelClave.add(clave);
        JPanel panelBotones = new JPanel();
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        
        Container grillaContenedoraPaneles = getContentPane();
        grillaContenedoraPaneles.setLayout(new GridLayout( 2, 3));
        grillaContenedoraPaneles.add(panelUsuario);
        grillaContenedoraPaneles.add(panelClave);
        grillaContenedoraPaneles.add(panelBotones);
        
        setSize(250, 250);
        setVisible(true);
               
	}
	public void actionPerformed(ActionEvent e) 
	{
	        if (e.getSource()==boton1) 
	        {
	        	if (validarDatos())
	        	{
	        		
	        		if ((String.valueOf(clave.getPassword()).equals("12345678")) && usuario.getText().equals("leonardo"))
	        		{
	        			desactiva();
	        			JOptionPane.showMessageDialog(this, "Bienvenido");
	        		}
	        		else
	        		{
	        			JOptionPane.showMessageDialog(this, "Usuario no encontrado");
		        		usuario.setText("");
		                clave.setText("");
	        		}
	        	}
	        }
	        if (e.getSource()==boton2) 
	        {
	            usuario.setText("");
	            clave.setText("");
	        }
	        if (e.getSource()==boton3) 
	        {
	            System.exit(0);
	        }        
	}
	 
	public void desactiva()
    {
    	usuario.setVisible(false);
    	userText.setVisible(false);
    	clave.setVisible(false);
    	claveText.setVisible(false);
    	boton1.setVisible(false);
    	boton2.setVisible(false);
    	boton3.setVisible(false);	
    }		
	private boolean validarDatos()
	{
		
		if ( usuario.getText().equals("") || String.copyValueOf(clave.getPassword()).equals(""))
		{
			JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
			usuario.setText("");
            clave.setText("");
			return false;
		}
		else if ( !usuario.getText().matches("[a-zA-Z0-9]{8,20}"))
		{
			JOptionPane.showMessageDialog(this, "El usuario debe contener entre 8 y 30 caracteres");
			usuario.setText("");
            clave.setText("");
			return false;
		}	
		else if ( !String.valueOf(clave.getPassword()).matches("^[0-9]{8}$"))
		{
			JOptionPane.showMessageDialog(this, "La contraseña debe tener 8 digitos");
			usuario.setText("");
            clave.setText("");
			return false;
		}
		else return true;
	}
}
