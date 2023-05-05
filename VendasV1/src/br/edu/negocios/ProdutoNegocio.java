package br.edu.negocios;

import br.edu.entidades.Produto;

public class ProdutoNegocio {

	public static float calcularPrecoVenda(Produto produto) {
		return produto.getPrecoCompra() + (produto.getPrecoCompra() * (produto.getMarkup() / 100)); 
	}
	
	
}
