package com.example.demo.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.ws.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario) {

		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscaPorNome(String nome){
		return usuarioRepository.buscaPorNome(nome);
	}

}
