package br.ifsp.edu.test.model;

import org.junit.jupiter.api.Test;

import br.ifsp.edu.model.Server;

class ServerTest {

	@Test
	void conectarServidor() {
		Server server = new Server(12345);
		server.connect();
	}

}
