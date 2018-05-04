package br.edu.ifal.systemifal.systemifalweb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.systemifal.systemifalweb.modelo.Aluno;

public interface AlunoRepository 
	extends JpaRepository<Aluno, Integer>{
	

}
