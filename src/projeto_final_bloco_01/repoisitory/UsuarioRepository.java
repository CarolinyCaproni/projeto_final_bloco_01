package projeto_final_bloco_01.repoisitory;

import projeto_final_bloco_01.model.Usuario;

public interface UsuarioRepository {
	
	public void listarTodas();
	public void cadastrar(Usuario usuario);
	public void atualizar(Usuario usuario);
}
