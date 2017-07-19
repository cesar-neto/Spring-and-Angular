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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

				//tudo que passar por /admin irá ser verificado no filtro de segurança
@RestController
@RequestMapping("/admin")
@Api(value="ClientesControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	// end points

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Register a new Client to BD")
	@ApiResponses(value={@ApiResponse(code=200, message="ok", response=Cliente.class)})
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Gets the existing clients")
	@ApiResponses(value={@ApiResponse(code=200, message="ok", response=Cliente.class)})
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();

		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("View details of a client specified by id")
	@ApiResponses(value={@ApiResponse(code=200, message="ok", response=Cliente.class)})
	public ResponseEntity<Cliente> detalheCliente(@PathVariable Integer id) {

		Cliente detalheCliente = clienteService.buscarPorID(id);

		return new ResponseEntity<>(detalheCliente, HttpStatus.OK);
		

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	@ApiOperation("Delete a client specified by id")
	@ApiResponses(value={@ApiResponse(code=200, message="ok", response=Cliente.class)})
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clientesEncontrado = clienteService.buscarPorID(id);
		
		if(clientesEncontrado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		clienteService.excluir(clientesEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);

	} 
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Edit an existing client")
	@ApiResponses(value={@ApiResponse(code=200, message="ok", response=Cliente.class)})
	public ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente) {
		// System.out.println("CHAMOU!!!");
		Cliente clienteEditado = clienteService.editar(cliente);
		return new ResponseEntity<>(clienteEditado, HttpStatus.OK);

	}
}
