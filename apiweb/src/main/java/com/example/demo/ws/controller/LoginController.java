package com.example.demo.ws.controller;

import java.util.Date;

import javax.servlet.ServletException;

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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {	
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE)

	public MyToken autenticar(@RequestBody Usuario usuario) throws ServletException {
		
		if(usuario.getNome() == null || usuario.getSenha() == null){
			throw new ServletException("Nome e senha obrigatorios");
		}
		
		System.out.println(usuario.getNome() + " " + usuario.getSenha());
		Usuario usuarioAutenticado = usuarioService.buscaPorNome(usuario.getNome());
		
		if(usuarioAutenticado == null){
			throw new ServletException("Usuário não encontrado");
		}
		
		if(!usuarioAutenticado.getSenha().equals(usuario.getSenha())){
			throw new ServletException("Usuário ou senha inválido");
		}
		
		//Token
		String token = Jwts.builder()
				.setSubject(usuarioAutenticado.getNome())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + (60*1000)))
				.compact();
		
		
		return new MyToken(token);
	}
	
	private class MyToken{
		
		public String token;

		public MyToken(String token) {
			this.token = token;
		}
		
		public String getToken() {
			return token;
		}
		
	}

}
