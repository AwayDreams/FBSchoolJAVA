/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Professor extends Usuario{
    private int cargahoraria;
    private String sobre;

    public Professor(String usuario, int cargahoraria, String sobre) {
        super(usuario, null, null);
        this.cargahoraria = cargahoraria;
        this.sobre = sobre;
    }
    
    public Professor(String usuario, String nome, String senha, int cargahoraria, String sobre) {
        super(usuario, nome, senha);
        this.cargahoraria = cargahoraria;
        this.sobre = sobre;
    }
    
    public Professor(String usuario) {
        super(usuario, null, null);
        this.sobre = null;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public String getSobre() {
        return sobre;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
    
    
}
