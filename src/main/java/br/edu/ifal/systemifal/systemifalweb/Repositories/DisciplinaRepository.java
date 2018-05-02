package br.edu.ifal.systemifal.systemifalweb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.systemifal.systemifalweb.modelo.Disciplina;

public interface DisciplinaRepository 
	extends JpaRepository<Disciplina, Integer>{
	
}
