package br.edu.ifal.systemifal.systemifalweb.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue ("P")
public class Professor extends Pessoa{
	

	@OneToMany
	private List<Disciplina> disciplinas;
	
	@Column(name = "cargo_professor", nullable = false)
	@Enumerated(EnumType.STRING)
	private CargoProfessor cargoProfessor;

	public Professor(String id, String nome, String cpf) {
		setNome(nome);
		setId(id);
		setCpf(cpf);
	}

	public Professor() {
		super();
	}
	

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public CargoProfessor getCargoProfessor() {
		return cargoProfessor;
	}

	public void setCargoProfessor(CargoProfessor cargoProfessor) {
		this.cargoProfessor = cargoProfessor;
	}
	

}
