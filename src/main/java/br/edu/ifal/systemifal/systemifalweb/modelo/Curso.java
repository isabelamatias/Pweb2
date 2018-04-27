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
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@OneToMany
	private List<Disciplina> disciplina;
	
	@Column
	private String nome;

	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	public Curso() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
