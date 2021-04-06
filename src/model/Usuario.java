/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Usuario {
    private String usuario;
    private String nome;
    private String senha;

    public Usuario(String usuario, String nome, String senha) {
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
