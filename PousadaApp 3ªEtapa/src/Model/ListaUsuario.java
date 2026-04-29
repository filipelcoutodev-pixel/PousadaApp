
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FilipeLuizCouto
 */
public class ListaUsuario {
    
   private static final List<Usuario> listaUsuario = new ArrayList<>();
    
    public static List<Usuario> Listar(){
        return listaUsuario;
    }
    
    public  void adicionar(Usuario usuario){
        listaUsuario.add(usuario);
    }
          public boolean validar(String nome, String senha) {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                return true; // Login válido
            }
        }
        return false; // Login inválido
    }
}
