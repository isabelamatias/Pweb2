package br.edu.ifal.systemifal.systemifalweb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.systemifal.systemifalweb.modelo.Escola;

public interface EscolaRepository 
	extends JpaRepository<Escola, Integer> {

}
