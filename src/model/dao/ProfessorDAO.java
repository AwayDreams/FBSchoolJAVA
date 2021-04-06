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
import model.Aula;
import model.Disciplina;
import model.Professor;


/**
 *
 * @author coelh
 */
public class ProfessorDAO {
    
    public static boolean insere(Professor professor){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "INSERT INTO professor(usuario, cargahoraria, sobre) VALUES(?,?,?)";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, professor.getUsuario());
            trans.setInt(2, professor.getCargahoraria());
            trans.setString(3, professor.getSobre());      
            
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere AulaDAO");
            return false;
        }
    }
    
    public static ArrayList<Disciplina> getDisciplina(String usuario){
        try(Connection con = FabricaConexao.getConexao()){
            ArrayList<Disciplina> disciplinas = new ArrayList();
            String sql =  "SELECT * FROM aula INNER JOIN professor ON aula.professor = professor.usuario WHERE professor.usuario=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1,usuario);
            ResultSet tuplas = trans.executeQuery();
            while(tuplas.next()){
                disciplinas.add(new Disciplina(tuplas.getString("disciplina"), tuplas.getInt("cargahoraria")));        
            }
            return disciplinas;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em getDisciplina ProfessorDAO2");
        }
        return null;
    }
    
    public static ArrayList<Aula> getAula(String usuario){
        try(Connection con = FabricaConexao.getConexao()){
            ArrayList<Aula> aulas = new ArrayList();
            String sql =  "SELECT * FROM aula INNER JOIN professor ON aula.professor = professor.usuario WHERE professor.usuario=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1,usuario);
            ResultSet tuplas = trans.executeQuery();
            while(tuplas.next()){
                aulas.add(new Aula(tuplas.getInt("id"), tuplas.getString("disciplina"), tuplas.getString("turma"), tuplas.getString("professor")));        
            }
            return aulas;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em getDisciplina ProfessorDAO2");
        }
        return null;
    }
    
    public static Professor select(String usuario){
        Professor resultado = null;
        try(Connection con = FabricaConexao.getConexao()){
            String sql = "SELECT * FROM professor INNER JOIN usuario ON usuario.usuario = professor.usuario WHERE professor.usuario=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario);
            
            ResultSet tuplas = trans.executeQuery();
            if(tuplas.next()){
                resultado = new Professor(tuplas.getString("usuario"),tuplas.getString("nome"),tuplas.getString("senha"), tuplas.getInt("cargahoraria"), tuplas.getString("sobre"));
            }
            return resultado;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em select ProfessorDAO2");
        }
        return null;
    }
    
    
    
    
}