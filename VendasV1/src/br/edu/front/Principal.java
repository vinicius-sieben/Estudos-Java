package br.edu.front;

import br.edu.persistencia.ClientePersistencia;
import br.edu.persistencia.ProdutoPersistencia;
import br.edu.persistencia.VendaPersistencia;
import br.edu.persistencia.VendedorPersistencia;
import br.edu.entidades.Cliente;
import br.edu.entidades.ItemVenda;
import br.edu.entidades.Produto;
import br.edu.entidades.Venda;
import br.edu.entidades.Vendedor;
import br.edu.negocios.Menu;
import br.edu.negocios.ProdutoNegocio;
import br.edu.negocios.isCPF;

public class Principal {

	public static void main(String[] args) {
		
		int opcao;
		String resposta = "";
		
		Cliente objCliente;
		Vendedor objVendedor;
		Venda objVenda;
		ItemVenda objItemVenda;
		Produto objProduto;
		
        do {
        	Menu.mostrarMenu();
            opcao = Console.readInt("Opção selecionada: ");

            switch (opcao) {
                case 1:
                	// Cadastro de cliente
                	System.out.println("\n| Menu de cadastro de clientes |\n");
                	objCliente = new Cliente();
                	String cpfCliente = Console.readString("Informe o CPF: ");

                	// Validando o CPF do cliente
                	if (isCPF.validar(cpfCliente) != false) {  
                		objCliente.setCpf(cpfCliente);

                		// Checando se o CPF informado já foi registrado posteriormente 
                		if (ClientePersistencia.procurar(objCliente) == null) {
                			objCliente.setNome(Console.readString("Insira o nome do cliente: "));
                			ClientePersistencia.incluir(objCliente);
                			System.out.println("Cliente registrado com sucesso.\n");
                		} else {
                			System.out.println("O CPF informado já foi registrado.\n");
                		}
                		
                	} else {
                		System.out.println("O CPF informado é inválido, tente novamente.\n");
                	}
                    break;
                    
                case 2:
                	// Cadastro de vendedor
                	System.out.println("\n| Menu de cadastro de vendedores |\n");
                	objVendedor = new Vendedor();
                	String cpfVendedor = Console.readString("Informe o CPF: ");
                	
                	// Validando o CPF do vendedor
                	if(isCPF.validar(cpfVendedor) != false) {
                		objVendedor.setCpf(cpfVendedor);
                		
                		// Checando se o CPF informado já foi registrado posteriormente
                		if(VendedorPersistencia.buscar(objVendedor) == null) {
                			objVendedor.setNome(Console.readString("Informe o nome do vendedor: "));
                			objVendedor.setTaxaComissao(Console.readFloat("Informe a taxa de comissão: "));
                			VendedorPersistencia.incluir(objVendedor);
                			System.out.println("Vendedor registrado com sucesso.\n");
                		} else {
                			System.out.println("O CPF informado já foi registrado.\n");
                		}
                	} else {
                		System.out.println("O CPF informado é inválido, tente novamente.\n");
                	}
                    break;
                    
                case 3:
                	System.out.println("\n| Menu de cadastro de produtos |\n");
                	objProduto = new Produto();
                	objProduto.setNome(Console.readString("Informe o nome do produto: "));
                	if(ProdutoPersistencia.procurar(objProduto) == null) {
                		objProduto.setPrecoCompra(Console.readFloat("Informe o preco de compra: "));
                		objProduto.setMarkup(Console.readFloat("Informe o markup: "));
                		ProdutoPersistencia.incluir(objProduto);
                		System.out.println("Produto registrado com sucesso.\n");
                	} else {
                		System.out.println("Produto já registrado.\n");
                	}
                    break;
                    
                case 4:
                	System.out.println("\n| Menu de cadastro de vendas |\n");
                	objVenda = new Venda();
                	objVenda.setId(Console.readInt("Informe o ID da venda: "));
                	if (VendaPersistencia.procurar(objVenda) == null) {
                		objCliente = new Cliente();
                		objCliente.setCpf(Console.readString("Informe o CPF do cliente: "));
                		if(isCPF.validar(objCliente.getCpf()) == true) {
                			objCliente = ClientePersistencia.procurar(objCliente);
                			if(objCliente != null) {
                				objVenda.setCliente(objCliente);
                				objVendedor = new Vendedor();
                				objVendedor.setCpf(Console.readString("Informe o CPF do vendedor: "));
                				if(isCPF.validar(objVendedor.getCpf()) == true) {
                					objVendedor = VendedorPersistencia.buscar(objVendedor);
                					if(objVendedor != null) {
                						objVenda.setVendedor(objVendedor);
                						objVenda.setDataVenda(Console.readString("Informe a data da venda: "));
                						float precoVenda;
                						do {
                							objItemVenda = new ItemVenda();
                							objProduto = new Produto();
                							objProduto.setNome(Console.readString("Informe o nome do produto: "));
                							if(ProdutoPersistencia.procurar(objProduto) != null) {
                								objItemVenda.setProduto(objProduto);
                								objItemVenda.setQuantidade(Console.readInt("Informe a quantidade: "));
                								precoVenda = ProdutoNegocio.calcularPrecoVenda(objProduto);
                								objItemVenda.setValorUnitario(precoVenda);
                								System.out.println("Valor unitário: " + precoVenda);
                								objVenda.getItens().add(objItemVenda);
                								resposta = Console.readString("Mais produtos? S/N: ");
                							} else {
                								System.out.println("Não há nenhum produto registrado com esse nome, tente novamente.");
                							}
                						} while (resposta.equals("S"));
                						System.out.println("Venda registrada com sucesso.\n");
                						
            						} else {
            							System.out.println("Não há nenhum vendedor registrado com esse CPF, tente novamente.\n");
            						}
                					
                				} else {
                					System.out.println("O CPF informado é inválido, tente novamente.\n");
                				}
                				
                			} else {
                				System.out.println("Produto não encontrado, tente novamente.");
                			}
                			
                		} else {
                			System.out.println("O CPF informado é inválido, tente novamente.\n");
                		}
                		
                	} else {
                		System.out.println("Já existe uma venda registrada com esse ID.");
                	}
                    break;
                    
                case 5:
                	System.out.println("\n| Menu de busca de vendas |\n");
                	objVenda = new Venda();
                	objVenda.setId(Console.readInt("Informe o ID da venda: "));
                	objVenda = VendaPersistencia.procurar(objVenda);
                	if(objVenda != null) {
                		System.out.println("\nCliente: " + objVenda.getCliente().getNome());
                		System.out.println("Vendedor: " + objVenda.getVendedor().getNome());
                		System.out.println("Data da venda: " + objVenda.getDataVenda());
                		System.out.println("*** Produtos vendidos ***");
                		for(ItemVenda item: objVenda.getItens()) {
                			System.out.println(item.getProduto().getNome());
                		}
                	} else {
                		System.out.println("\n\nVenda não cadastrada...");
                	}
                    break;
                    
                case 6:
                	System.out.println("\nSistema encerrado.\n");
                    break;
                    
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            
        } while (opcao != 6);

    }

}

