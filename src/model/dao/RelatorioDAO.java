/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import ferramentas.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import model.Comentario;
import model.Relatorio;

/**
 *
 * @author coelh
 */
public class RelatorioDAO {
    
    public static boolean insere(Relatorio relatorio){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "INSERT INTO relatorio(qualidade, descricao, aula, usuario) VALUES(?,?,?,?)";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setInt(1, relatorio.getQualidade());
            trans.setString(2, relatorio.getDescricao());
            trans.setInt(3, relatorio.getAula().getId());
            trans.setString(4, relatorio.getUsuario().getUsuario());   
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere RelatorioDAO");
            return false;
        }
    }
    
    public static ArrayList<Comentario> selectTodosComentarios(int relatorioId){ //tenho duvidas
        ArrayList<Comentario> comentarios = new ArrayList();
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT * FROM comentario WHERE relatorio=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setInt(1, relatorioId);
            
            ResultSet tuplas = trans.executeQuery();
            while(tuplas.next()){
                comentarios.add(new Comentario(tuplas.getInt("id"), tuplas.getInt("relatorio"), tuplas.getString("creator"), tuplas.getString("conteudo")));
            }
            return comentarios;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em select AlunoDAO");
        }
        return null;
    }
    
    public static Relatorio select(int relatorioId){ //tenho duvidas
        ArrayList<Comentario> comentarios = new ArrayList();
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT * FROM relatorio WHERE id=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setInt(1, relatorioId);
            
            ResultSet tuplas = trans.executeQuery();
            Relatorio relatorio = null;
            if(tuplas.next()){
                relatorio = new Relatorio(tuplas.getInt("id"), tuplas.getString("usuario"), tuplas.getInt("qualidade"), tuplas.getString("descricao"),tuplas.getInt("aula"));
            }
            return relatorio;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em select AlunoDAO");
        }
        return null;
    }
    
    
    public static ArrayList<Relatorio> selectTodosRelatoriosAluno(String usuario){ //tenho duvidas
        ArrayList<Relatorio> relatorios = new ArrayList();
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT relatorio.id, relatorio.qualidade, relatorio.descricao, relatorio.aula, usuario.usuario, usuario.nome, aula.turma, aula.disciplina, aula.professor  FROM relatorio INNER JOIN usuario ON relatorio.usuario = usuario.usuario INNER JOIN aula ON relatorio.aula = aula.id INNER JOIN aluno ON aluno.turma = aula.turma WHERE aluno.usuario=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario);
            
            ResultSet tuplas = trans.executeQuery();
            while(tuplas.next()){
                relatorios.add(new Relatorio(tuplas.getInt("id"),tuplas.getString("usuario") ,tuplas.getInt("qualidade"), tuplas.getString("descricao")));
            }
            return relatorios;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em selectTodosRelatoriosAluno AlunoDAO");
        }
        return null;
    }
    
    
    public static ArrayList<Relatorio> selectTodosRelatoriosProfessor(String usuario){ //tenho duvidas
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT relatorio.id, relatorio.qualidade, relatorio.descricao, relatorio.usuario, usuario.nome, aula.disciplina, aula.professor FROM relatorio INNER JOIN usuario ON relatorio.usuario = usuario.usuario INNER JOIN aula ON relatorio.aula = aula.id WHERE aula.professor =?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario);
            
            ResultSet tuplas = trans.executeQuery();
            ArrayList<Relatorio> relatorios = new ArrayList();
            while(tuplas.next()){
                relatorios.add(new Relatorio(tuplas.getInt("id"), tuplas.getString("usuario"),tuplas.getInt("qualidade"),tuplas.getString("descricao")));
            }
            return relatorios;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em selectTodosRelatoriosProfessor RelatorioDAO");
        }
        return null;
    }
    
    public static boolean delete(int id){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "DELETE FROM relatorio WHERE id =?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setInt(1, id);
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere ProfessorDAO");
            return false;
        }
    }
    
    
}