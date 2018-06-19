package br.ifsp.edu.model;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	
	private Socket socket;
	private String host;
	private int port;

	
	public Client(String host,int port) {
		this.host = host;
		this.port = port;
	}
	
	public void connect() {
		try {
			JOptionPane.showMessageDialog(null, host + port);
			this.socket = new Socket(this.host, this.port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}
	
	

}
