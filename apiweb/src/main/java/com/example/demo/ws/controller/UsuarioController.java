package com.example.demo.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.ws.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Usuario> cadastrarCliente(@RequestBody Usuario usuario) {
		// System.out.println("CHAMOU!!!");
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);

	}

}
