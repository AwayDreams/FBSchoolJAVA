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
import model.Aluno;
import model.Aula;
import model.Disciplina;


/**
 *
 * @author coelh
 */
public class AlunoDAO {
    
    public static boolean insere(Aluno aluno){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "INSERT INTO aluno(usuario, ra) VALUES(?,?)";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, aluno.getUsuario());
            trans.setInt(2, aluno.getRa());
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere AlunoDAO");
            return false;
        }
    }
    
    
    public static Aluno select(String usuario){
        Aluno resultado = null;
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT * FROM usuario INNER JOIN aluno ON aluno.usuario = usuario.usuario WHERE usuario.usuario= ?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario);
            
            ResultSet tuplas = trans.executeQuery();
            if(tuplas.next()){
                resultado = new Aluno(tuplas.getString("usuario"),tuplas.getString("nome"),tuplas.getString("senha"),tuplas.getString("turma"),tuplas.getInt("ra"));
            }
            return resultado;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em select AlunoDAO");
        }
        return null;
    }
    
    public static ArrayList<Disciplina> getDisciplina(String usuario){
        try(Connection con = FabricaConexao.getConexao()){
            ArrayList<Disciplina> disciplinas = new ArrayList();
            String sql =  "SELECT * FROM aluno INNER JOIN aula ON aluno.turma = aula.turma INNER JOIN usuario ON aula.professor = usuario.usuario WHERE aluno.usuario=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1,usuario);
            ResultSet tuplas = trans.executeQuery();
            while(tuplas.next()){
                disciplinas.add(new Disciplina(tuplas.getString("nome"), tuplas.getInt("cargahoraria")));        
            }
            return disciplinas;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em getDisciplina AlunoDAO");
        }
        return null;
    }
    
    public static ArrayList<Aula> getAula(String usuario){
        try(Connection con = FabricaConexao.getConexao()){
            ArrayList<Aula> aulas = new ArrayList();
            String sql =  "SELECT * FROM aluno INNER JOIN aula ON aluno.turma = aula.turma INNER JOIN usuario ON aula.professor = usuario.usuario WHERE aluno.usuario=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1,usuario);
            ResultSet tuplas = trans.executeQuery();
            while(tuplas.next()){
                aulas.add(new Aula(tuplas.getInt("id"), tuplas.getString("disciplina"), tuplas.getString("turma"), tuplas.getString("professor")));        
            }
            return aulas;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em getAula AlunoDAO");
        }
        return null;
    }
    
    public static boolean update(Aluno aluno){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "UPDATE aluno SET turma=? WHERE usuario =?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, aluno.getTurma().getId());
            trans.setString(2, aluno.getUsuario()); 
            
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em update Aluno");
            return false;
        }
    }
    
    
    
}
