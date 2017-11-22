/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import controle.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Laiza
 */
public class Publicacao implements Serializable {

    private int ISBN;
    private String titulo;
    private String autor;
    private String editora;

    public Publicacao() {
    }
    
    public Publicacao(int ISBN, String titulo, String autor, String editora, String status) {
            this.ISBN = ISBN;
            this.titulo = titulo;
            this.autor = autor;
            this.editora = editora;     
    }
    
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nTitulo:" + getTitulo()
                   // + "\nNumero: " + listaPublicacao.get(i).getExemplar().getNumero()
                    + "\nISBN: " + getISBN()
                    + "\nAutor: " + getAutor()
                    + "\nEditora: " +getEditora()+"\n\n";
    }

}
