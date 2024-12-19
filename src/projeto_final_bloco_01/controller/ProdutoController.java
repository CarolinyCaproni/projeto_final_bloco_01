package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repoisitory.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

    private ArrayList<Produto> listaProdutos = new ArrayList<>();

    @Override
    public void listarTodas() {
        if (listaProdutos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado!");
        } else {
            for (var produto : listaProdutos) {
                System.out.println("Código: " + produto.getCodigo() + 
                                   " | Nome: " + produto.getNome() + 
                                   " | Valor: R$ " + produto.getValor());
            }
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("\nO produto '" + produto.getNome() + "' foi cadastrado com sucesso!");
    }
}
