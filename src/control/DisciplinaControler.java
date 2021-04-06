/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Disciplina;
import model.dao.DisciplinaDAO;

/**
 *
 * @author coelh
 */
public class DisciplinaControler {
    public static Disciplina buscaDisciplina(String nome){
        if(verifica(nome)){
            return DisciplinaDAO.select(nome);
        }else{
            return null;
        }
    }
    
    public static ArrayList<Disciplina> select(){
        return DisciplinaDAO.select();
    }
    
    
    private static boolean verifica(String nome){
        if(nome.length() < 30){
            return true;
        }else{
            return false;
        }
    }
}
