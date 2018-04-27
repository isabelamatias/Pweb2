package br.edu.ifal.systemifal.systemifalweb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.systemifal.systemifalweb.modelo.Professor;

public interface ProfessorRepository 
	extends JpaRepository<Professor, Integer>{

}
