package br.edu.persistencia;

import java.util.ArrayList;

import br.edu.entidades.Cliente;

public class ClientePersistencia {
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();	// Collection (lista) para armazenar os objetos do tipo Cliente
	
	public static void incluir(Cliente cliente) {
		clientes.add(cliente);
	}

	public static Cliente procurar(Cliente cliente) {
		for(Cliente item: clientes) {
			if(item.getCpf().equals(cliente.getCpf())) {
				return item;
			}
		}
		return null;
	}
	

	
}
