
public class Principal {

	public static void main(String[] args) {
		int opcao, valor, valor1, resposta;
		char operador;
		
			do {
				desenharMenu();
				opcao = Console.readInt("Informe opção: ");
				
				switch (opcao) {
				case 1:
					valor = Console.readInt("Informe o valor: ");
					System.out.println("O Valor é" + Metodos.verificarValor(valor));
					break;
					
				case 2:
					valor = Console.readInt("Informe o valor: "); 
					resposta = Metodos.calcularQuadrado(valor);
					System.out.println("O quadrado é: " + resposta);
					break;
				case 3:
					valor = Console.readInt("Informe o primeiro valor: ");
					operador = Console.readChar("Operação (+, -, *, /): ");
					valor1 = Console.readInt("Informe o segundo valor: ");
				}
			} while (opcao != 4);
			
		}
		
		private static void desenharMenu() {
			System.out.println("\n\n1 - Verificar valor");
			System.out.println("2 - Calcular quadrado");
			System.out.println("3 - Calculadora");
			System.out.println("4 - Sair");
		}

	}

