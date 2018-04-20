package br.edu.ifal.systemifal.systemifalweb.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@DiscriminatorValue ("A")
public class Aluno extends Pessoa{
		
	@Column
	private String matricula;

	

	
	public Aluno(String id, String cpf, String nome) {
		setNome(nome);
		setId(id);
		setCpf(cpf);
	}

	public Aluno() {
		super();
	}
	
	

}
