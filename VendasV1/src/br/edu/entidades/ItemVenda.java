package br.edu.entidades;

public class ItemVenda {
	private Produto produto;
	private int quantidade;
	private float valorUnitario;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
}
