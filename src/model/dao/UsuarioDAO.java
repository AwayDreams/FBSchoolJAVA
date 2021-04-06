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
import model.Perfil;
import model.Usuario;

/**
 *
 * @author coelh
 */
public class UsuarioDAO {
    
    public static boolean insere(Usuario usuario){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "INSERT INTO usuario(nome, usuario, senha) VALUES(?,?,?)";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario.getNome());
            trans.setString(2, usuario.getUsuario());
            trans.setString(3, usuario.getSenha());     
            
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em insere UsuarioDAO");
            return false;
        }
    }
    
    public static boolean update(Usuario usuario){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "UPDATE usuario SET nome=?, senha=? WHERE usuario =?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario.getNome());
            trans.setString(2, usuario.getSenha());
            trans.setString(3, usuario.getUsuario());     
            
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em update UsuarioDAO");
            return false;
        }
    }
    
    
    public static Usuario Login(Usuario usuario){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "select * from usuario where usuario=? and senha=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario.getUsuario());
            trans.setString(2, usuario.getSenha());
            trans.execute();
          
            ResultSet tuplas = trans.executeQuery();
            Usuario resultado = null;
            if(tuplas.next()){
                 resultado = new Usuario(tuplas.getString("usuario"),tuplas.getString("nome"),tuplas.getString("senha"));
            }
            if(resultado != null){
                Perfil.usuario = usuario;
            }
            return resultado;
            
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em Login UsuarioDAO");
            return null;
        }
    }
    
    public static Usuario select(String usuario){
        try(Connection con = FabricaConexao.getConexao()){
            String sql =  "select * from usuario where usuario=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario);
            trans.execute();
          
            ResultSet tuplas = trans.executeQuery();
            Usuario resultado = null;
            if(tuplas.next()){
                 resultado = new Usuario(tuplas.getString("usuario"),tuplas.getString("nome"),tuplas.getString("senha"));
            }
            return resultado;
            
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em Login UsuarioDAO");
            return null;
        }
    }
    
    public static boolean LoginAeP(Usuario usuario){
        try(Connection con = FabricaConexao.getConexao()){
            String sql = "select * from professor where usuario=?";
            PreparedStatement trans = con.prepareStatement(sql);
            trans.setString(1, usuario.getUsuario());
            trans.execute();
          
            ResultSet tuplas = trans.executeQuery();
            int resultado = 0;
            if(tuplas.next()){
                 resultado = 1;
            }
            if(resultado == 1){
                Perfil.tipo = 2;
            }else{
                Perfil.tipo = 1;
            }
            return true;
            
        }catch(SQLException ex){
            System.err.println("ocorreu um erro em LoginAeP UsuarioDAO");
            return false;
        }
    }
    
    
    
}
