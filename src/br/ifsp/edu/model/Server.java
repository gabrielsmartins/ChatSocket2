package br.ifsp.edu.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
	
	private static ArrayList<BufferedWriter>clientes;  
	private ServerSocket serverSocket;
	private int port;
	private Socket con;
	private String nome;
	private InputStream in;  
	private InputStreamReader inr;  
	private BufferedReader bfr;
	
	public Server(int port) {
		this.clientes = new ArrayList<>();
	}
	
	public void connect() {
		try {
			this.serverSocket = new ServerSocket(this.port);
			
			while (true) {
				System.out.println("Aguardando conexão...");
				this.con = serverSocket.accept();
	
					in  = this.con.getInputStream();
					inr = new InputStreamReader(in);
			        bfr = new BufferedReader(inr);
			    	System.out.println("Cliente conectado...");
					this.start();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	

	
	@Override
	public void run() {
		 try{
             
			    String msg;
			    OutputStream ou =  this.con.getOutputStream();
			    Writer ouw = new OutputStreamWriter(ou);
			    BufferedWriter bfw = new BufferedWriter(ouw); 
			    clientes.add(bfw);
			    nome = msg = bfr.readLine();
			              
			    while(!"Sair".equalsIgnoreCase(msg) && msg != null)
			      {           
			       msg = bfr.readLine();
			       sendToAll(bfw, msg);
			       System.out.println(msg);                                              
			       }
			                                     
			   }catch (Exception e) {
			     e.printStackTrace();
			   
			   }                   
	}
	
	
	 public void sendToAll(BufferedWriter bwSaida, String msg) throws  IOException 
	  {
	    BufferedWriter bwS;
	     
	    for(BufferedWriter bw : clientes){
	     bwS = (BufferedWriter)bw;
	     if(!(bwSaida == bwS)){
	       bw.write(nome + " -> " + msg+"\r\n");
	       bw.flush(); 
	     }
	    }          
	  }

}
