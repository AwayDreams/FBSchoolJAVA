/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Vector;
import model.Aula;
import model.dao.AulaDAO;


/**
 *
 * @author coelh
 */
public class AulaControler {
    public static boolean cadastro(Aula aula){
        if(verifica(aula)){
            AulaDAO.insere(aula);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Aula>  buscaAula(String usuario){
        return AulaDAO.select(usuario);
    }
    
    public static ArrayList<Aula> buscaAula(){
        return AulaDAO.select();
    }
    
    private static boolean verifica(Aula aula){
        if((aula.getTurma().getId().length() < 10) && (aula.getDisciplina().getNome().length() < 30) && (aula.getProfessor().getUsuario().length() < 30) ){
            return true;
        }
        return false;
    }
    
    
}
