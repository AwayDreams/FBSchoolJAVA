/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Aula {
    private int id;
    private Disciplina disciplina;
    private Turma turma;
    private Professor professor;

    public Aula(int id, String disciplina, String turma, String professor) {
        this.id = id;
        this.disciplina = new Disciplina(disciplina);
        this.turma = new Turma(turma);
        this.professor = new Professor(professor);
    }
    
    public Aula(String disciplina, String turma, String professor) {
        this.disciplina = new Disciplina(disciplina);
        this.turma = new Turma(turma);
        this.professor = new Professor(professor);
    }
    

    public int getId() {
        return id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
   
    public void setId(int id) {
        this.id = id;
    }

    
}
