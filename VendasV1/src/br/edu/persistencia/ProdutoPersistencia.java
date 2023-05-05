package br.edu.persistencia;

import java.util.ArrayList;

import br.edu.entidades.Produto;

public class ProdutoPersistencia {
	
	public static ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public static void incluir(Produto produto) {
		produtos.add(produto);
	}

	public static Produto procurar(Produto produto) {
		for(Produto item: produtos) {
			if(item.getNome().equals(produto.getNome())) {
				return item;
			}
		}
		return null;
	}
	
}
