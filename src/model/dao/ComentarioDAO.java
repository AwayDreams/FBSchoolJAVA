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
import model.Comentario;


/**
 *
 * @author coelh
 */
public class ComentarioDAO {
    
    public static boolean insere(Comentario comentario){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "INSERT INTO comentario(creator, conteudo, relatorio) VALUES(?,?,?)";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, comentario.getCreator().getUsuario());
            trans.setString(2, comentario.getConteudo());
            trans.setInt(3, comentario.getRelatorio());      
            
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere ProfessorDAO");
            return false;
        }
    }
    
    
    
    
    
    
}
