package br.edu.ifal.systemifal.systemifalweb.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "nota")
public class Nota {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Disciplina disciplina;
	
	@Column
	private Double valor;
	
	@ElementCollection
	private List<Double> notas = new ArrayList<Double>();
	
	public Nota(Integer id, Aluno aluno, Disciplina disciplina, double valor) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.valor = valor;
		this.notas = new ArrayList<Double>();
	}


	public Nota() {
		super();
		this.notas = new ArrayList<Double>();
	}
	//////////////////////////////////////////////
	public Nota(int id2, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

/////////////////////////////////////////////////
	public void adiconarNota(double nota){
		notas.add(new Double(nota));		
	}


	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public List<Double> getNotas() {
		return notas;
	}


	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	
}
