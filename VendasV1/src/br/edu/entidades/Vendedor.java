package br.edu.entidades;

public class Vendedor {
	private String nome;
	private String cpf;		// Não permitir com o mesmo CPF
	private float taxaComissao;
	
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
	
	public float getTaxaComissao() {
		return taxaComissao;
	}
	
	public void setTaxaComissao(float taxaComissao) {
		this.taxaComissao = taxaComissao;
	}
	
}
