/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modelotabela;

import control.RelatorioControler;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Comentario;

/**
 *
 * @author coelh
 */
public class ModeloTabelaComentario extends AbstractTableModel {
    private ArrayList<Comentario> comentarios;
    
    public ModeloTabelaComentario(int id){
        carregaTodosComentarios(id);
    }
    
    private void carregaTodosComentarios(int id ) {
        this.comentarios = RelatorioControler.getComentarios(id);
    }
    
    
    @Override
    public int getRowCount() {
       return this.comentarios.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:{
                return this.comentarios.get(linha).getCreator().getUsuario();
            }
            case 1:{
                return this.comentarios.get(linha).getConteudo();
            }
            default:{
                return null;
            }
                
        }
    }

    
    
}
