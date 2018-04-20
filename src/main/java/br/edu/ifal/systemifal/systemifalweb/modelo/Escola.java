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
@Table(name="escola")
public class Escola {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String id;
	
	@Column
	private String nome;
	
	@OneToMany
	private List<Curso> cursos;
	
	@OneToMany
	private List<Professor> professores;
	
	

	public Escola(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Escola() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public String toString() {
		return "Escola [id=" + id + ", nome=" + nome + "]";
	}
	
	
	

}
