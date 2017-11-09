/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

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
    private Exemplar exemplar;

    public Publicacao(int ISBN, String titulo, String autor, String editora, String status, Exemplar exemplar) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.status = status;
        this.exemplar = exemplar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String  getExemplar() {
        return "Numero:" + exemplar.getNumero();
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
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
