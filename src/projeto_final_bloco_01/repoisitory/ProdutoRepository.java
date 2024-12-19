package projeto_final_bloco_01.repoisitory;

import projeto_final_bloco_01.model.Produto;

public interface ProdutoRepository {
	
	public void listarTodas();
	public void cadastrar(Produto produto);

}
