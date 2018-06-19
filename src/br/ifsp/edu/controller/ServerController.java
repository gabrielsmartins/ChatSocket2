package br.ifsp.edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.ifsp.edu.model.Server;
import br.ifsp.edu.model.Servidor;
import br.ifsp.edu.view.ServerView;

public class ServerController {

	private ServerView view;
	private Server server;

	public ServerController() {
		this.view = new ServerView();
		this.loadListeners();
		this.view.setVisible(true);

	}

	public void loadListeners() {
		
		this.view.getBtnCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				System.exit(0);
			}
		});

		this.view.getBtnConectar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(view.getTxtPorta().getText());
					
					
					try {
						ServerSocket serverSocket = new ServerSocket(port);
	
						while (true) {
							 System.out.println("Aguardando conexão...");
						     Socket con = serverSocket.accept();
						     System.out.println("Cliente conectado...");
						     Thread t = new Servidor(con);
						      t.start();   
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					
					
					view.getLblStatusValue().setText("Conectado");
					view.getBtnConectar().setEnabled(false);
					view.getTxtPorta().setEnabled(false);
				
			}
		});

		
	}

	public static void main(String[] args) {
		new ServerController();

	}
}
