/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Aluno extends Usuario{
    private Turma Turma;
    private int ra;

    public Aluno(String usuario, String turma, int ra) {
        super(usuario, null, null);
        this.Turma = new Turma(turma);
        this.ra = ra;
    }
    
    public Aluno(String usuario, String nome, String senha, String turma, int ra) {
        super(usuario, nome, senha);
        this.Turma = new Turma(turma);
        this.ra = ra;
    }

    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public Turma getTurma() {
        return Turma;
    }

    public void setTurma(Turma Turma) {
        this.Turma = Turma;
    }

}
