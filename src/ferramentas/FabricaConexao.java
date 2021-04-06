/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FabricaConexao {
    private static final String ip = "localhost:3306";
    private static final String usuario = "root";
    private static final String senha = "37501";
    private static final String banco = "projeto";
    
    private static Connection conexaoBD;
    
    public static Connection getConexao(){
        try{
            if(conexaoBD == null || conexaoBD.isClosed()){
                Connection conexaoBD = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + banco, usuario, senha);
                return conexaoBD;
            }else{
                return conexaoBD;
            }
        }catch(SQLException ex){
            System.err.println("Não foi possivel conectar ao banco");
            return null;
        }
        
    }
    
  
    
}
