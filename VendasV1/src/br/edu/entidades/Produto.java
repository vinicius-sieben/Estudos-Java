package br.edu.entidades;

public class Produto {
	private String nome; 	// Não permitir com o mesmo nome
	private float precoCompra;
	private float markup;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPrecoCompra() {
		return precoCompra;
	}
	
	public void setPrecoCompra(float preco) {
		this.precoCompra = preco;
	}
	
	public float getMarkup() {
		return markup;
	}
	
	public void setMarkup(float markup) {
		this.markup = markup;
	}
	
 
}
