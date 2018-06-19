package br.ifsp.edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import br.ifsp.edu.model.Client;
import br.ifsp.edu.view.ClientView;

public class ClientController {

	private ClientView view;
	private Client client;
	private OutputStream ou ;
	private Writer ouw; 
	private BufferedWriter bfw;
	
	public ClientController() {
		this.view = new ClientView();
		String host = this.view.getTxtHost().getText();
		int port = Integer.parseInt(this.view.getTxtPorta().getText());
		this.client = new Client(host, port);
		this.client.connect();
		this.loadListeners();
		this.view.setVisible(true);
		try {
			this.ou = this.client.getSocket().getOutputStream();
			this.ouw = new OutputStreamWriter(ou);
			this.bfw = new BufferedWriter(ouw);
			this.bfw.write(this.view.getTxtNome().getText()+"\r\n");
			this.bfw.flush();
			this.escutar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadListeners() {
		
		this.view.getBtnSend().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String msg = view.getTxtMsg().getText();
					enviarMensagem(msg);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.view.getBtnSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sair();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	
	
public void enviarMensagem(String msg) throws IOException{
	    if(msg.equals("Sair")){
	      bfw.write("Desconectado \r\n");
	      this.view.getTexto().append("Desconectado \r\n");
	    }else{
	      bfw.write(msg+"\r\n");
	      this.view.getTexto().append(this.view.getTxtNome().getText() + " diz -> " +   this.view.getTxtMsg().getText()+"\r\n");
	    }
	     bfw.flush();
	     this.view.getTxtMsg().setText("");        
	}
	
	
	
	public void escutar() throws IOException{
		   InputStream in = this.client.getSocket().getInputStream();
		   InputStreamReader inr = new InputStreamReader(in);
		   BufferedReader bfr = new BufferedReader(inr);
		   String msg = "";
		                          
		    while(!"Sair".equalsIgnoreCase(msg))
		                                     
		       if(bfr.ready()){
		         msg = bfr.readLine();
		       if(msg.equals("Sair"))
		         this.view.getTexto().append("Servidor caiu! \r\n");
		        else
		         this.view.getTexto().append(msg+"\r\n");         
		        }
		}   
	
	
	public void sair() throws IOException{
	    enviarMensagem("Sair");
	    bfw.close();
	    ouw.close();
	    ou.close();
	    this.client.getSocket().close();
	 }
	
	public static void main(String[] args) {
		new ClientController();
	}
}
