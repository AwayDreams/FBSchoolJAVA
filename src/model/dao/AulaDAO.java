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
import model.Aula;

/**
 *
 * @author coelh
 */
public class AulaDAO {
    
    public static boolean insere(Aula aula){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "INSERT INTO aula (turma, disciplina, professor) VALUES(?,?,?)";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, aula.getTurma().getId());
            trans.setString(2, aula.getDisciplina().getNome());
            trans.setString(3, aula.getProfessor().getUsuario());      
            
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere AulaDAO");
            return false;
        }
    }
    
    public static ArrayList<Aula> select(String usuario){
        ArrayList<Aula> aulas = new ArrayList();

        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT * FROM aula INNER JOIN usuario ON aula.professor = usuario.usuario WHERE aula.professor=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario);
            
            ResultSet tuplas = trans.executeQuery();
            while(tuplas.next()){
                aulas.add(new Aula(tuplas.getInt("id"), tuplas.getString("disciplina"), tuplas.getString("turma"), tuplas.getString("professor")));
            }
            return aulas;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em select AlunoDAO");
        }
        return null;
    }
    
    
    public static ArrayList<Aula> select(){
        try(Connection con = FabricaConexao.getConexao()){
            ArrayList<Aula> aulas = new ArrayList();
            String sql =  "SELECT * FROM aula INNER JOIN usuario ON aula.professor = usuario.usuario";
            PreparedStatement trans = con.prepareStatement(sql);
            
            ResultSet tuplas = trans.executeQuery();
            while(tuplas.next()){
                aulas.add(new Aula(tuplas.getInt("id"), tuplas.getString("disciplina"), tuplas.getString("turma"), tuplas.getString("professor")));        
            }
            return aulas;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em select AlunoDAO");
        }
        return null;
    }
    
}

