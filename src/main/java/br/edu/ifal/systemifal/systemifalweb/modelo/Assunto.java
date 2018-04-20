package br.edu.ifal.systemifal.systemifalweb.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assunto {
	
	@Id
	private String id;
	
	private String texto;
	
	
	@ManyToOne
	@JoinColumn(name="id_disciplina")
	private Disciplina disciplina;
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
