/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;

/**
 *
 * @author Laiza
 */
public class Exemplar implements Serializable {

    private int numero;
    private int ISBN;
    private float preco;
    private String status;
    Publicacao publicacao = new Publicacao();

    public Exemplar(Publicacao pub, int numero, int ISBN, float preco) {
        this.publicacao = pub;
        this.numero = numero;
        this.ISBN = ISBN;
        this.preco = preco;
        this.status = "Disponivel";

    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    public String getTitulo(){
        return publicacao.getTitulo();
    }
    @Override
    public String toString() {
        return "TITULO: "+getTitulo()+
                "\nNumero do Exemplar: " + numero + 
                "\nISBN: " + ISBN + 
                " \nStatus: "+status+"\n";// + "Preço: " + preco;
    }

}
