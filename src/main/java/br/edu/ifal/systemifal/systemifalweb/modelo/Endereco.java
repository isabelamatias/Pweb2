package br.edu.ifal.systemifal.systemifalweb.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	@Column
	private String cep;
	@Column
	private String logradouro;
	@Column
	private String numero;
	@Column
	private String bairro;
	@Column
	private String cidade;
	@Column
	private String estado;
	
	public Endereco() {
		
	}
	
	public Endereco(String cep, String logradouro, String numero, String bairro, String cidade, String estado) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
	
	
	
	
}
