/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Comentario;
import model.dao.ComentarioDAO;

/**
 *
 * @author coelh
 */
public class ComentarioControler {
     public static boolean cadastro(Comentario comentario){
        if(verifica(comentario)){
            ComentarioDAO.insere(comentario);
            return true;
        }else{
            return false;
        }
    }
     
     private static boolean verifica(Comentario comentario){
         if(comentario.getCreator().getUsuario().length() < 30){
             return  true;
         }else{
             return false;
         }
     }
}
