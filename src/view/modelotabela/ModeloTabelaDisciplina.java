/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modelotabela;

import control.AlunoControler;
import control.ProfessorControler;
import control.RelatorioControler;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Aula;
import model.Comentario;
import model.Disciplina;
import model.Perfil;

/**
 *
 * @author coelh
 */
public class ModeloTabelaDisciplina extends AbstractTableModel {
    private ArrayList<Aula> aulas;
    
    public ModeloTabelaDisciplina(){
        carregaTodosDisciplinas();
    }
    
    private void carregaTodosDisciplinas() {
        if(Perfil.tipo == 2){
            this.aulas = ProfessorControler.getAula(Perfil.usuario.getUsuario());
        }else{
            this.aulas = AlunoControler.getAula(Perfil.usuario.getUsuario());
        }
    }
    
    
    @Override
    public int getRowCount() {
       return this.aulas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:{
                return this.aulas.get(linha).getDisciplina().getNome();
            }
            case 1:{
                return this.aulas.get(linha).getProfessor().getUsuario();
            }
            case 2:{
                return this.aulas.get(linha).getTurma().getId();
            }
                        
            default:{
                return null;
            }
                
        }
    }

    
    
}
