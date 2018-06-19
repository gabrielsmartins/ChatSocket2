package br.ifsp.edu.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerView extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	
	private JPanel panel;
	private JLabel lblMessage;
	private JLabel lblStatus;
	private JLabel lblStatusValue;
	private JTextField txtPorta;
	private JButton btnConectar;
	private JButton btnCancelar;
	
	
	public ServerView() {
		this.setTitle("Servidor");
		this.setSize(400, 150);
		this.setLocationRelativeTo(null);
		this.initComps();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	

	  
	public void initComps() {
		this.panel = new JPanel(new GridLayout(3, 2));
	    this.lblMessage = new JLabel("Porta do Servidor:");
	    this.lblStatus = new JLabel("Status:");
	    this.lblStatusValue = new JLabel("Desconectado");
	    this.txtPorta = new JTextField("12345");
	    this.btnConectar = new JButton("Conectar");
	    this.btnCancelar = new JButton("Cancelar");
	    this.panel.add(lblMessage);
	    this.panel.add(txtPorta);
	    this.panel.add(lblStatus);
	    this.panel.add(lblStatusValue);
	    this.panel.add(btnConectar);
	    this.panel.add(btnCancelar);
	    Container contentPane = this.getContentPane();
	    contentPane.add(this.panel, BorderLayout.CENTER);
	}



	public JTextField getTxtPorta() {
		return txtPorta;
	}



	public JButton getBtnConectar() {
		return btnConectar;
	}



	public JButton getBtnCancelar() {
		return btnCancelar;
	}



	public JLabel getLblStatusValue() {
		return lblStatusValue;
	}
	  
	
	
	  
	
	  
	  
	  
	  

}