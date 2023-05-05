package br.edu.entidades;

import java.util.ArrayList;

public class Venda {
	private int id;
	private Cliente cliente;
	private Vendedor vendedor;
	private String dataVenda;
	private ArrayList<ItemVenda> itens;
	
	// No momento que instanciamos o objeto venda, também precisamos instanciar o atributo array.
	// Um exemplo de como fazer isso é usando um construtor:
	public Venda () {
		itens = new ArrayList<ItemVenda>(); 
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public String getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public ArrayList<ItemVenda> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<ItemVenda> itens) {
		this.itens = itens;
	}
	
	
}
