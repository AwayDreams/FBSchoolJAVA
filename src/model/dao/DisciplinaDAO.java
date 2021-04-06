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
import model.Disciplina;

/**
 *
 * @author coelh
 */
public class DisciplinaDAO {
    
    public static Disciplina select(String nome){
        Disciplina resultado = null;
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT * FROM disciplina WHERE nome=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, nome);
            
            ResultSet tuplas = trans.executeQuery();
            if(tuplas.next()){
                resultado = new Disciplina(tuplas.getString("nome"), tuplas.getInt("cargahoraria"));
            }
            return resultado;

        }catch(SQLException ex){
            System.err.println("ocorreu um erro em select AlunoDAO");
        }
        return null;
    }
    
    public static ArrayList<Disciplina> select(){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "SELECT * FROM disciplina";
            PreparedStatement trans = con.prepareStatement(sql);
            
            ResultSet tuplas = trans.executeQuery();
            ArrayList<Disciplina> resultado = new ArrayList<>();
            while(tuplas.next()){
                resultado.add(new Disciplina(tuplas.getString("nome"),parseInt(tuplas.getString("cargahoraria"))));
            }
            return resultado;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em select DisciplinaDAO");
            return null;
        }
    }
    
    
}
