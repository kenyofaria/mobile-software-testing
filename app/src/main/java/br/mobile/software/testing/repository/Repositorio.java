package br.mobile.software.testing.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.mobile.software.testing.entity.Usuario;

public class Repositorio {

    private static List<Usuario> usuarios;

    static{
        usuarios = new ArrayList<>(Arrays.asList(new Usuario("kenyo", "123"), new Usuario("auri", "333")));
    }

    public static void cadastraUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public static Usuario get(String login){
        for (Usuario u: usuarios) {
            if(u.getLogin().equals(login)){
                return u;
            }
        }
        return null;
    }

    public static Usuario get(String login, String senha){
        for (Usuario u: usuarios) {
            if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
                return u;
            }
        }
        return null;
    }

}
