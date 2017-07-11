package com.example.demo.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estado;
import com.example.demo.ws.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	
	public Estado cadastrar(Estado estado) {

		return estadoRepository.save(estado);
	}

	public Collection<Estado> buscarTodos() {

		return estadoRepository.findAll();

	}
	
	public void excluir(Estado estado){
		estadoRepository.delete(estado);
	}
	
	public Estado buscarPorID(Integer id){
		return estadoRepository.findOne(id);
	}
	
	public Estado editar(Estado estado){
		return estadoRepository.save(estado);
	}
	
}

