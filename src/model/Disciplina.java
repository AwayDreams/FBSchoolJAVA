/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Disciplina {
    private String nome;
    private int cargahoraria;

    public Disciplina(String nome, int cargahoraria) {
        this.nome = nome;
        this.cargahoraria = cargahoraria;
    }
    
    public Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
    
    
}
