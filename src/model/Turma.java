/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Turma {
    
    private String id;
    private String turno;
    private int ano;

    public Turma(String id, String turno, int ano) {
        this.id = id;
        this.turno = turno;
        this.ano = ano;
    }
    
    public Turma(String id) {
        this.id = id;
        this.turno = null;
    }

    public String getId() {
        return id;
    }

    public String getTurno() {
        return turno;
    }

    public int getAno() {
        return ano;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
}
