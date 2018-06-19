package br.ifsp.edu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblMessage;
	private JLabel lblHistorico;
	private JLabel lblMsg;
	private JTextField txtHost;
	private JTextField txtPorta;
	private JTextField txtNome;
	private JPanel panel;
	private JTextArea texto;
	private JTextField txtMsg;
	private JButton btnSend;
	private JButton btnSair;
	private JScrollPane scroll;

	public ClientView() {
		this.initComps();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(250, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initComps() {
		this.lblMessage = new JLabel("Verificar!");
		this.txtHost = new JTextField("127.0.0.1");
		this.txtPorta = new JTextField("12345");
		this.txtNome = new JTextField("Cliente");
		Object[] texts = { lblMessage, txtHost, txtPorta, txtNome };
		JOptionPane.showMessageDialog(null, texts);
		this.panel = new JPanel();
		this.texto = new JTextArea(10, 20);
		this.texto.setEditable(false);
		this.texto.setBackground(new Color(240, 240, 240));
		this.txtMsg = new JTextField(20);
		this.lblHistorico = new JLabel("Chat");
		this.lblMsg = new JLabel("Mensagem");
		this.btnSend = new JButton("Enviar");
		this.btnSend.setToolTipText("Enviar Mensagem");
		this.btnSair = new JButton("Sair");
		this.btnSair.setToolTipText("Sair do Chat");
		this.scroll = new JScrollPane(texto);
		this.texto.setLineWrap(true);
		panel.add(lblHistorico);
		panel.add(scroll);
		panel.add(lblMsg);
		panel.add(txtMsg);
		panel.add(btnSair);
		panel.add(btnSend);
		this.setContentPane(panel);
	}

	public JButton getBtnSend() {
		return btnSend;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	
	
	public JTextField getTxtHost() {
		return txtHost;
	}

	public JTextField getTxtPorta() {
		return txtPorta;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextArea getTexto() {
		return texto;
	}

	public JTextField getTxtMsg() {
		return txtMsg;
	}

	
	
	
	

}