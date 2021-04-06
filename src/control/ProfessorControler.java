/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Aula;
import model.Disciplina;
import model.Professor;
import model.dao.AlunoDAO;
import model.dao.ProfessorDAO;

/**
 *
 * @author coelh
 */
public class ProfessorControler {
    public static boolean cadastro(Professor professor){
        return ProfessorDAO.insere(professor);
    }

    public static Professor buscaProfessor(String usuario){
        return ProfessorDAO.select(usuario);
    }
    public static ArrayList<Disciplina> getDisciplina(String usuario){
        return ProfessorDAO.getDisciplina(usuario);
    }
    
    public static ArrayList<Aula> getAula(String usuario){
        return ProfessorDAO.getAula(usuario);
    }
    
    private static boolean verifica(Professor professor){
        if(professor.getUsuario().length() < 30){
            return true;
        }else{
            return false;
        }
    }
}
