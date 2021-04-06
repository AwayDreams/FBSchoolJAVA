/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author coelh
 */
public class UsuarioControler {
    
    public static boolean cadastro(Usuario usuario){
        if(verifica(usuario)){
            UsuarioDAO.insere(usuario);
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean Login(String usuario, String senha){
        Usuario user = new Usuario(usuario, null, senha); 
        if(UsuarioDAO.Login(user) != null){
            return UsuarioDAO.LoginAeP(user);
        }else{
            return false;
        }
    }
    
    
    public static boolean atualiza(Usuario usuario){
        return UsuarioDAO.update(usuario);
    }
    
    public static Usuario getUsuario(String usuario){
        return UsuarioDAO.select(usuario);
    }
    
    
    private static boolean verifica(Usuario usuario){
        if((usuario.getNome().length() < 30) && (usuario.getUsuario().length() < 30) && (usuario.getSenha().length() < 30) ){
            return true;
        }else{
            return false;
        }
    }
    
    
    
    
}
