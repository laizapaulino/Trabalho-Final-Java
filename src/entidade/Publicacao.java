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
    private String status;
    private Exemplar exemplarPublicacao;

    public Publicacao(int ISBN, String titulo, String autor, String editora) {
        controleExemplar exemplar = new controleExemplar();
        controlePublicacao pub = new controlePublicacao();

        exemplar.lerExemplar();
        pub.lerPublicacoes();
        try {
            this.ISBN = exemplar.procuraExemplar(ISBN).getISBN();
            this.titulo = titulo;
            this.autor = autor;
            this.editora = editora;
            this.status = "Disponivel";
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Operação inválida");

        }

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Exemplar getExemplar() {
        return this.exemplarPublicacao;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplarPublicacao = exemplar;
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
        return this.autor + " - " + this.editora + " - " + " - " + this.status + "Titulo " + this.titulo;
    }

}
