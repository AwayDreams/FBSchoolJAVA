/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Comentario;
import model.Relatorio;
import model.dao.RelatorioDAO;

/**
 *
 * @author coelh
 */
public class RelatorioControler {
    
    public static boolean cadastro(Relatorio relatorio){
        if(verifica(relatorio)){
            RelatorioDAO.insere(relatorio);
            return true;
        }else{
            return false;
        }
    }
    
    public static Relatorio select(int id){
        return RelatorioDAO.select(id);
    }
    
    public static ArrayList<Comentario> getComentarios(int relatorioID){
        return RelatorioDAO.selectTodosComentarios(relatorioID);
    }
    
    public static ArrayList<Relatorio> obterRelatoriosAluno(String usuario){
        return RelatorioDAO.selectTodosRelatoriosAluno(usuario);
    }
    
    public static ArrayList<Relatorio> obterRelatoriosProfessor(String usuario){
        return RelatorioDAO.selectTodosRelatoriosProfessor(usuario);
    }
    
    public static boolean deleteRelatorio(int id){
        return RelatorioDAO.delete(id);
    }
    
    
    private static boolean verifica(Relatorio relatorio){
        if((relatorio.getUsuario().getUsuario().length() < 30) && (relatorio.getQualidade() < 5) && (relatorio.getQualidade() > -1)){
            return true;
        }else{
            return false;
        }
    }
}
