package br.edu.ifal.systemifal.systemifalweb.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	//@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	
	@OneToMany
	private List<Disciplina> disciplina;
	
	@Column
	private String nome;

	public Curso(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Disciplina> getdisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", disciplina=" + disciplina + ", nome=" + nome + "]";
	}
	
	
	

}
