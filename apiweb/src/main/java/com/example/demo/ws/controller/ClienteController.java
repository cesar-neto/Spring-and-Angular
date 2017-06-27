package com.example.demo.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.ws.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	// end points

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		// System.out.println("CHAMOU!!!");
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();

		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")

	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clientesEncontrado = clienteService.buscarPorID(id);
		
		if(clientesEncontrado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		clienteService.excluir(clientesEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente) {
		// System.out.println("CHAMOU!!!");
		Cliente clienteEditado = clienteService.editar(cliente);
		return new ResponseEntity<>(clienteEditado, HttpStatus.OK);

	}
}
