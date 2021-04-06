/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modelotabela;

import control.AulaControler;
import control.ProfessorControler;
import control.RelatorioControler;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Aula;
import model.Comentario;
import model.Disciplina;
import model.Perfil;
import model.Relatorio;

/**
 *
 * @author coelh
 */
public class ModeloTabelaRelatorio extends AbstractTableModel {
    private ArrayList<Relatorio> relatorios ;
    
    public ModeloTabelaRelatorio(){
        carregaTodosRelatorios();
    }
    
    private void carregaTodosRelatorios() {
        this.relatorios = RelatorioControler.obterRelatoriosProfessor(Perfil.usuario.getUsuario());
    }
    
    
    @Override
    public int getRowCount() {
       return this.relatorios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:{
                return this.relatorios.get(linha).getQualidade();
            }
            case 1:{
                return this.relatorios.get(linha).getUsuario();
            }
            case 2:{
                return this.relatorios.get(linha).getDescricao();
            }
            default:{
                return null;
            }
                
        }
    }

    
    
}
