package br.ifsp.edu.test.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.ifsp.edu.model.Client;
import br.ifsp.edu.model.Server;

class ClientTest {
	
	private static Server server;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		/*server = new Server(12345);
		server.connect();
		server.start();*/
	}

	@Test
	void conectarCliente() {
	Client cliente = new Client("127.0.0.1",12345);
	cliente.connect();
	}

}
