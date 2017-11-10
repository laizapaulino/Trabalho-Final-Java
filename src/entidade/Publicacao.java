/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import controle.controleExemplar;
import javax.swing.JOptionPane;

/**
 *
 * @author Laiza
 */
public class Publicacao {

    private int ISBN;
    private String titulo;
    private String autor;
    private String editora;
    private String status;
    private Exemplar exemplarPublicacao;
    private controleExemplar exemplar = new controleExemplar();

    public Publicacao(int ISBN, String titulo, String autor, String editora) {
        try{
        exemplarPublicacao = this.exemplar.procuraExemplar(ISBN);
            this.ISBN = ISBN;
            this.titulo = titulo;
            this.autor = autor;
            this.editora = editora;
            this.status = "Disponivel";
        }catch(NullPointerException exc){System.out.print("ou aqui");
            JOptionPane.showMessageDialog(null, "ISBN inválido\n\nCadastre um exemplar \nou informe um ISBN válido");
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

}
