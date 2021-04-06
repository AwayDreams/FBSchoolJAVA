/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class Relatorio {
   private int id;
   private Usuario usuario;
   private int qualidade;
   private String descricao;
   private Aula aula;
   private ArrayList<Comentario> cometarios;

    public Relatorio(int id, String usuario, int qualidade, String descricao, int aula) {
        this.id = id;
        this.usuario = new Usuario(usuario, null, null);
        this.qualidade = qualidade;
        this.descricao = descricao;
        this.aula = new Aula(aula, null, null, null);
    }
    
    public Relatorio(String usuario, int qualidade, String descricao, int aula) {
        this.id = id;
        this.usuario = new Usuario(usuario, null, null);
        this.qualidade = qualidade;
        this.descricao = descricao;
        this.aula = new Aula(aula, null, null, null);
    }
    
    public Relatorio(String usuario, int qualidade, String descricao) {
        this.id = id;
        this.usuario = new Usuario(usuario, null, null);
        this.qualidade = qualidade;
        this.descricao = descricao;
        this.aula = null;
    }
     public Relatorio(int id, String usuario, int qualidade, String descricao) {
        this.id = id;
        this.usuario = new Usuario(usuario, null, null);
        this.qualidade = qualidade;
        this.descricao = descricao;
        this.aula = null;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public int getId() {
        return id;
    }
    

    public int getQualidade() {
        return qualidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
