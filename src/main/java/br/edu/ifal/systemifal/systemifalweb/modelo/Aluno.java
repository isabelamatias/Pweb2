package br.edu.ifal.systemifal.systemifalweb.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String cpf;
		
	@Column
	private String matricula;


	public Aluno() {
		super();
	}

	public Aluno(String nome, String cpf, String matricula) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void addDisciplina(Aluno disciplina) {
		// TODO Auto-generated method stub
		
	}

	public Collection<Aluno> getDisciplinas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
