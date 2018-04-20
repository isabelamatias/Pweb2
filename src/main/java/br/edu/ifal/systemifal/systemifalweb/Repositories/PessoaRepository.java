package br.edu.ifal.systemifal.systemifalweb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.systemifal.systemifalweb.modelo.Pessoa;

public interface PessoaRepository 
	extends JpaRepository<Pessoa, String>{
		
	}


