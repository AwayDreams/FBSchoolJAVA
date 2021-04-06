/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import ferramentas.FabricaConexao;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Aluno;
import model.Turma;

/**
 *
 * @author coelh
 */
public class TurmaDAO {
    public static boolean insere(Turma turma){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "INSERT INTO turma (id, turno, ano) VALUES(?,?,?)";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, turma.getId());
            trans.setString(2, turma.getTurno());
            trans.setInt(3, turma.getAno());
            
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere TurmaDAO");
            return false;
        }
    }
    
    public static ArrayList<Turma> select(){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT * FROM turma";
            PreparedStatement trans = con.prepareStatement(sql);
            
            ResultSet tuplas = trans.executeQuery();
            ArrayList<Turma> resultado = new ArrayList<>();
            while(tuplas.next()){
                resultado.add(new Turma(tuplas.getString("id"),tuplas.getString("turno"),parseInt(tuplas.getString("ano"))));
            }
            return resultado;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere TurmaDAO");
            return null;
        }
    }
    
    public static Turma select(String id){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT * FROM turma WHERE id=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, id);
            ResultSet tuplas = trans.executeQuery();
            Turma resultado = null;
            if(tuplas.next()){
                resultado = new Turma(tuplas.getString("id"),tuplas.getString("turno"),parseInt(tuplas.getString("ano")));
            }
            return resultado;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere TurmaDAO");
            return null;
        }
    }
    
}

