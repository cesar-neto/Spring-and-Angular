package com.example.demo.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estado;
import com.example.demo.ws.service.EstadoService;

@RestController
public class EstadoController {
	
	@Autowired
	EstadoService estadoService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/estados", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Estado> cadastrarEstado(@RequestBody Estado estado) {
		// System.out.println("CHAMOU!!!");
		Estado estadoCadastrado = estadoService.cadastrar(estado);
		return new ResponseEntity<>(estadoCadastrado, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/estados", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Collection<Estado>> buscarTodosEstados() {

		Collection<Estado> estadosBuscados = estadoService.buscarTodos();

		return new ResponseEntity<>(estadosBuscados, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/estados/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Estado> detalheEstado(@PathVariable Integer id) {

		Estado detalheEstado = estadoService.buscarPorID(id);

		return new ResponseEntity<>(detalheEstado, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/estados/{id}")

	public ResponseEntity<Estado> excluirEstado(@PathVariable Integer id) {

		Estado estadoEncontrado = estadoService.buscarPorID(id);
		
		if(estadoEncontrado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		estadoService.excluir(estadoEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/estados", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Estado> editarEstado(@RequestBody Estado estado) {
		// System.out.println("CHAMOU!!!");
		Estado estadoEditado = estadoService.editar(estado);
		return new ResponseEntity<>(estadoEditado, HttpStatus.OK);

	}
	
}
