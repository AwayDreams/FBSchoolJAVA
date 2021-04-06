/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Turma;
import model.dao.TurmaDAO;

/**
 *
 * @author coelh
 */
public class TurmaControler {
    
    public static boolean insere(Turma turma){
        if(verifica(turma)){
            TurmaDAO.insere(turma);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Turma> select(){
        return TurmaDAO.select();
    }
    
    public static Turma select(String id){
        return TurmaDAO.select(id);
    }
 
    private static boolean verifica(Turma turma){
        if(turma.getTurno().length() < 30){
            return true;
        }else{
            return false;
        }
    }
}
