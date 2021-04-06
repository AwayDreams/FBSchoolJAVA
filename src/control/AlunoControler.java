/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Aluno;
import model.Aula;
import model.Disciplina;
import model.Turma;
import model.dao.AlunoDAO;
import model.dao.ProfessorDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author coelh
 */
public class AlunoControler {
    
    public static boolean cadastro(Aluno aluno){
        return AlunoDAO.insere(aluno);
    }
    
    public static Aluno buscaAluno(String usuario){
        return AlunoDAO.select(usuario);
    }
    
    public static boolean atualizaTurma(Aluno aluno){
         if(AlunoDAO.update(aluno)){
            AlunoDAO.insere(aluno);
            return true;
        }else{
            return false;
        }
    }
    
    public static ArrayList<Disciplina> getDisciplina(String usuario){
        return AlunoDAO.getDisciplina(usuario);
    }
    
     public static ArrayList<Aula> getAula(String usuario){
        return AlunoDAO.getAula(usuario);
    }
    
    
    private static boolean verifica(Aluno aluno){
        if( (aluno.getTurma().getId().length() < 10) && (aluno.getUsuario().length() < 30) ){
            return true;
        }
        return false;
    }
    
    
    
    
}
