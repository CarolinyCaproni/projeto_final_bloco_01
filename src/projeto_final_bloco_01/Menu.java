package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.controller.UsuarioController;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.Usuario;

public class Menu {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        // Controllers
        ProdutoController produtoController = new ProdutoController();
        UsuarioController usuarioController = new UsuarioController();

        // Variáveis auxiliares
        int opcao = 0;

        while (true) {
            System.out.println("\n*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                   Lojinha On-line                   ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Usuário                        ");
            System.out.println("            2 - Atualizar Usuário                    ");
            System.out.println("            3 - Cadastrar Produto                    ");
            System.out.println("            4 - Listar Produtos                      ");
            System.out.println("            5 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     ");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            if (opcao == 5) {
                System.out.println("\nObrigado por nos escolher!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("\nCriar Usuário");
                    Usuario novoUsuario = new Usuario();
                    
                    System.out.print("Digite o nome do usuário: ");
                    leia.skip("\\R?");
                    novoUsuario.setNome(leia.nextLine());
                    
                    System.out.print("Digite o e-mail do usuário: ");
                    novoUsuario.setEmail(leia.nextLine());
                    
                    System.out.print("Digite a senha do usuário: ");
                    novoUsuario.setSenha(leia.nextLine());

                    usuarioController.cadastrar(novoUsuario);
                    keyPress();
                    break;

                case 2:
                    System.out.println("\nAtualizar Usuário");
                    System.out.print("Digite o código do usuário para atualizar: ");
                    int codigoUsuario = leia.nextInt();
                    
                    Usuario usuarioAtualizar = usuarioController.buscarNaCollection(codigoUsuario);
                    if (usuarioAtualizar != null) {
                        System.out.print("Digite o novo nome: ");
                        leia.skip("\\R?");
                        usuarioAtualizar.setNome(leia.nextLine());

                        System.out.print("Digite o novo e-mail: ");
                        usuarioAtualizar.setEmail(leia.nextLine());

                        System.out.print("Digite a nova senha: ");
                        usuarioAtualizar.setSenha(leia.nextLine());

                        usuarioController.atualizar(usuarioAtualizar);
                    } else {
                        System.out.println("\nUsuário não encontrado!");
                    }
                    keyPress();
                    break;

                case 3:
                    System.out.println("\nCadastrar Produto");
                    Produto novoProduto = new Produto();
                    
                    System.out.print("Digite o nome do produto: ");
                    leia.skip("\\R?");
                    novoProduto.setNome(leia.nextLine());

                    System.out.print("Digite o valor do produto: ");
                    novoProduto.setValor(leia.nextFloat());

                    produtoController.cadastrar(novoProduto);
                    keyPress();
                    break;

                case 4:
                    System.out.println("\nListar Produtos");
                    produtoController.listarTodas();
                    keyPress();
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");
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
