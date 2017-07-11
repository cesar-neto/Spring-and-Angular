package com.example.demo.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("Select u from Usuario u where u.nome=:pnome")
	public Usuario buscaPorNome(@Param("pnome") String nome);
	
}
