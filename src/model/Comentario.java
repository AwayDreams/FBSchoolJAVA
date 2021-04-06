/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Comentario {
    private int id;
    private int relatorio;
    private Usuario creator;
    private String conteudo;

    public Comentario(int id, int relatorio, String creator, String conteudo) {
        this.id = id;
        this.relatorio = relatorio;
        this.creator = new Usuario(creator, null, null);
        this.conteudo = conteudo;
    }
    
    public Comentario(int relatorio, String creator, String conteudo) {
        this.relatorio = relatorio;
        this.creator = new Usuario(creator, null, null);
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public int getRelatorio() {
        return relatorio;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRelatorio(int relatorio) {
        this.relatorio = relatorio;
    }

    public Usuario getCreator() {
        return creator;
    }

    public void setCreator(Usuario creator) {
        this.creator = creator;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    
}
