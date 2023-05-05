package br.edu.persistencia;

import java.util.ArrayList;

import br.edu.entidades.Vendedor;

public class VendedorPersistencia {
	public static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>(); 
	
	public static void incluir(Vendedor vendedor) {
		vendedores.add(vendedor);
	}
	
	public static Vendedor buscar(Vendedor vendedor) {
		for(Vendedor item: vendedores) {
			if(item.getCpf().equals(vendedor.getCpf())) {
				return item;
			}
		}
		return null;
	}
}
