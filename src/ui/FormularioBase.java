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
import entidades.Banco;
import entidades.Cliente;

public class FormularioBase extends JFrame implements ActionListener {
	private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton10, boton11, boton12,
			boton13;
	private JLabel userText, claveText;
	private JTextField usuario;
	private JPasswordField clave;
	private Banco banco;
	private Cliente elCliente;

	public FormularioBase(Banco banco) {
		super("Log In");
		this.banco = banco;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		userText = new JLabel("Usuario");
		claveText = new JLabel("Contraseña");
		usuario = new JTextField(10);
		clave = new JPasswordField(5);
		boton1 = new JButton("Aceptar");
		;
		boton1.addActionListener(this);
		boton2 = new JButton("Borrar");
		boton2.addActionListener(this);
		boton3 = new JButton("Salir");
		boton3.addActionListener(this);
		boton4 = new JButton("Caja de ahorro");
		boton4.addActionListener(this);
		boton4.setVisible(false);
		boton5 = new JButton("CTA CTE");
		boton5.addActionListener(this);
		boton5.setVisible(false);
		boton6 = new JButton("Pedido de saldo");
		boton6.addActionListener(this);
		boton6.setVisible(false);
		boton7 = new JButton("Transferencia");
		boton7.addActionListener(this);
		boton7.setVisible(false);
		boton8 = new JButton("Extracción");
		boton8.addActionListener(this);
		boton8.setVisible(false);
		boton9 = new JButton("Depósito");
		boton9.addActionListener(this);
		boton9.setVisible(false);
		boton10 = new JButton("Pedido de saldo");
		boton10.addActionListener(this);
		boton10.setVisible(false);
		boton11 = new JButton("Transferencia");
		boton11.addActionListener(this);
		boton11.setVisible(false);
		boton12 = new JButton("Extracción");
		boton12.addActionListener(this);
		boton12.setVisible(false);
		boton13 = new JButton("Depósito");
		boton13.addActionListener(this);
		boton13.setVisible(false);

		JPanel panelUsuario = new JPanel();
		panelUsuario.add(userText);
		panelUsuario.add(usuario);
		JPanel panelClave = new JPanel();
		panelClave.add(claveText);
		panelClave.add(clave);
		JPanel panelBotonesPrincipales = new JPanel();
		panelBotonesPrincipales.add(boton1);
		panelBotonesPrincipales.add(boton2);
		panelBotonesPrincipales.add(boton3);
		JPanel panelBotonesSecundarios = new JPanel();
		panelBotonesSecundarios.add(boton4);
		panelBotonesSecundarios.add(boton5);
		JPanel panelBotonesDeCajaAhorro = new JPanel();
		panelBotonesDeCajaAhorro.add(boton6);
		panelBotonesDeCajaAhorro.add(boton7);
		panelBotonesDeCajaAhorro.add(boton8);
		panelBotonesDeCajaAhorro.add(boton9);
		JPanel panelBotonesDeCTACTE = new JPanel();
		panelBotonesDeCTACTE.add(boton10);
		panelBotonesDeCTACTE.add(boton11);
		panelBotonesDeCTACTE.add(boton12);
		panelBotonesDeCTACTE.add(boton13);

		Container grillaContenedoraPaneles = getContentPane();
		grillaContenedoraPaneles.setLayout(new GridLayout(2, 4));
		grillaContenedoraPaneles.add(panelUsuario);
		grillaContenedoraPaneles.add(panelClave);
		grillaContenedoraPaneles.add(panelBotonesPrincipales);
		grillaContenedoraPaneles.add(panelBotonesSecundarios);
		grillaContenedoraPaneles.add(panelBotonesDeCajaAhorro);
		grillaContenedoraPaneles.add(panelBotonesDeCTACTE);

		setSize(400, 400);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == boton1) {
				if (validarDatos()) {
					elCliente = banco.buscarCliente(usuario.getText(), String.valueOf(clave.getPassword()));
					if (elCliente == null) {
						JOptionPane.showMessageDialog(this, "Usuario no encontrado");
						usuario.setText("");
						clave.setText("");
					} else {
						desactiva();
						JOptionPane.showMessageDialog(this, "Bienvenido  " + elCliente.getUsuario());
						this.setTitle("Menú de cuentas");
						boton4.setVisible(true);
						boton5.setVisible(true);
					}
				}
			}
			if (e.getSource() == boton4) {
				this.setTitle("Caja de ahorro");
				desactiva();
				boton6.setVisible(true);
				boton7.setVisible(true);
				boton8.setVisible(true);
				boton9.setVisible(true);
			}
			if (e.getSource() == boton5) {
				this.setTitle("CTA CTE");
				desactiva();
				boton10.setVisible(true);
				boton11.setVisible(true);
				boton12.setVisible(true);
				boton13.setVisible(true);
			}

			if (e.getSource() == boton6) {
				JOptionPane.showMessageDialog(this, String.valueOf(elCliente.getSaldoCajaAhorro()));
			}
			if (e.getSource() == boton10) {
				JOptionPane.showMessageDialog(this, String.valueOf(elCliente.getSaldoCtaCte()));
			}
			if (e.getSource() == boton7) {
				if (elCliente.getSaldoCajaAhorro() > 0) {
					int monto = Integer
							.parseInt(JOptionPane.showInputDialog("Ingresa el monto a transferir a tu CTA CTE"));
					if (elCliente.getSaldoCajaAhorro() >= monto)
						banco.transferOwnCtaCte(monto, elCliente);
					else
						JOptionPane.showMessageDialog(this, "No tiene fondo suficiente");
				} else
					JOptionPane.showMessageDialog(this, "No tiene fondos");
			}
			if (e.getSource() == boton11) {
				if (elCliente.getSaldoCtaCte() > 0) {
					int numCtaCtebeneficiario = Integer
							.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la CTA CTE a depositar"));
					int posBeneficiario = banco.buscarNumCtaCte(numCtaCtebeneficiario);
					if (posBeneficiario != banco.getClientesSize()) {
						int monto = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el monto a transferir"));
						if (elCliente.getSaldoCtaCte() >= monto)
							banco.transferCtaCte(elCliente, monto, posBeneficiario);
						else
							JOptionPane.showMessageDialog(this, "Fondos insuficientes");
					} else
						JOptionPane.showMessageDialog(this, "No existe el numero de CTA CTE ingresado");
				} else
					JOptionPane.showMessageDialog(this, "No tiene fondos");
			}
			if (e.getSource() == boton8) {
				if (elCliente.getSaldoCajaAhorro() > 0) {
					int monto = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el monto a extraer"));
					if (elCliente.getSaldoCajaAhorro() >= monto)
						banco.extraccionCaja(monto, elCliente);
					else
						JOptionPane.showMessageDialog(this, "No tiene fondo suficiente");
				} else
					JOptionPane.showMessageDialog(this, "No tiene fondos");
			}
			if (e.getSource() == boton12) {
				if (elCliente.getSaldoCtaCte() > 0) {
					int monto = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el monto a extraer"));
					if (elCliente.getSaldoCtaCte() >= monto)
						banco.extraccionCtaCte(monto, elCliente);
					else
						JOptionPane.showMessageDialog(this, "No tiene fondo suficiente");
				} else
					JOptionPane.showMessageDialog(this, "No tiene fondos");
			}
			if (e.getSource() == boton2) {
				usuario.setText("");
				clave.setText("");
			}
			if (e.getSource() == boton3) {
				System.exit(0);
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Algo se bardió " + exc.getMessage());
		}
	}

	public void desactiva() {
		usuario.setVisible(false);
		userText.setVisible(false);
		clave.setVisible(false);
		claveText.setVisible(false);
		boton1.setVisible(false);
		boton2.setVisible(false);
		boton3.setVisible(false);
		boton4.setVisible(false);
		boton5.setVisible(false);
		boton6.setVisible(false);
		boton7.setVisible(false);
		boton8.setVisible(false);
		boton9.setVisible(false);
	}

	private boolean validarDatos() {

		if (usuario.getText().equals("") || String.copyValueOf(clave.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
			usuario.setText("");
			clave.setText("");
			return false;
		} else if (!usuario.getText().matches("[a-zA-Z0-9]{8,20}")) {
			JOptionPane.showMessageDialog(this, "El usuario debe contener entre 8 y 30 caracteres");
			usuario.setText("");
			clave.setText("");
			return false;
		} else if (!String.valueOf(clave.getPassword()).matches("^[0-9]{8}$")) {
			JOptionPane.showMessageDialog(this, "La contraseña debe tener 8 digitos");
			usuario.setText("");
			clave.setText("");
			return false;
		} else
			return true;
	}
}