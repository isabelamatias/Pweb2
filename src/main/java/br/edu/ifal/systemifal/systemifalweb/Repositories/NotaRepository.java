package br.edu.ifal.systemifal.systemifalweb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.systemifal.systemifalweb.modelo.Nota;

public interface NotaRepository 
	extends JpaRepository<Nota, Integer> {

}
