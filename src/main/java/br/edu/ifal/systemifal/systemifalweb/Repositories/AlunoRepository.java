package br.edu.ifal.systemifal.systemifalweb.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.systemifal.systemifalweb.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
		List<Aluno> findByNomeLike(String nome);
	

}
