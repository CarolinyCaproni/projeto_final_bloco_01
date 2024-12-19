package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		String usuario, produto;
		int opcao;
		float preço;
		
		Scanner leia = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                   Lojinha On-line                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Cadastrar produto                    ");
			System.out.println("            3 - Listar todas os produtos             ");
			System.out.println("            4 - Buscar Produto                       ");
			System.out.println("            5 - Atualizar Dados da Conta             ");
			System.out.println("            6 - Apagar Conta                         ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
	
		try {
			opcao = leia.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("\nDigite valores inteiros!");
			leia.nextLine();
			opcao=0;
		}

		if (opcao == 9) {
			System.out.println("\nObrigada por nos escolher!!");
			sobre();
			leia.close();
			System.exit(0);
		}
		switch (opcao) {
		case 1:
			System.out.println("\nCriar Conta");
			System.out.println("Digite seu nome: ");
			leia.skip("\\R?");
			usuario = leia.next();
			keyPress();
			break;
		case 2: 
			System.out.println("Cadastrar Produto");
			System.out.println("Digite o nome do produto: ");
			leia.skip("\\R?");
			produto = leia.next();
			keyPress();
			break;
		case 3:
			System.out.println("Listar Produtos");
			keyPress();
			break;
		case 4:
			System.out.print("Buscar Produto");
			keyPress();
			break;
		case 5:
			System.out.println("Atualizar Conta");
			keyPress();
			break;
		case 6:
			System.out.println("Apagar conta");
			keyPress();
			break;
		default:
			System.out.println("\nOpção Invalida\n");
			keyPress();
			break;
			
			
			
			
			
			
			
			
		}
		}

}
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Caroliny Caproni - caroliny.caproni@hotmail.com");
		System.out.println("github.com/CarolinyCaproni");
		System.out.println("*********************************************************");
	}
	
	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
