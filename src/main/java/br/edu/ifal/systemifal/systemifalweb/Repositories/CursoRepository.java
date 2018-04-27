package br.edu.ifal.systemifal.systemifalweb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.systemifal.systemifalweb.modelo.Curso;

public interface CursoRepository 
	extends JpaRepository<Curso, Integer>{

}
