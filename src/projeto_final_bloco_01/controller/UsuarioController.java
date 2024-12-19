package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import projeto_final_bloco_01.model.Usuario;
import projeto_final_bloco_01.repoisitory.UsuarioRepository;

public class UsuarioController implements UsuarioRepository {

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    public void listarTodas() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("\nNenhum usuário cadastrado!");
        } else {
            for (var usuario : listaUsuarios) {
                System.out.println("Código: " + usuario.getCodigo() + 
                                   " | Nome: " + usuario.getNome() + 
                                   " | Email: " + usuario.getEmail());
            }
        }
    }

    @Override
    public void cadastrar(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("\nO usuário '" + usuario.getNome() + "' foi cadastrado com sucesso!");
    }

    @Override
    public void atualizar(Usuario usuario) {
        var buscarUsuario = buscarNaCollection(usuario.getCodigo());

        if (buscarUsuario != null) {
            listaUsuarios.set(listaUsuarios.indexOf(buscarUsuario), usuario);
            System.out.println("\nO usuário com código: " + usuario.getCodigo() + " foi atualizado com sucesso!");
        } else {
            System.out.println("\nO usuário com código: " + usuario.getCodigo() + " não foi encontrado!");
        }
    }

    private Usuario buscarNaCollection(int codigo) {
        for (var usuario : listaUsuarios) {
            if (usuario.getCodigo() == codigo) {
                return usuario;
            }
        }
        return null;
    }
}
