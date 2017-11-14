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
public class Emprestimo implements Serializable{
    private int numeroExemplar;
    private int ISBN;
    private int codigoAssociado;
    private int tempoMaximo;
    private Data data; 

    public Emprestimo(int numeroExemplar, int ISBN, int dia, int mes, int ano, int codigoAssociado, int tempoMax) {
        this.data = new Data(dia, mes, ano);//dia, mes, ano
        this.numeroExemplar = numeroExemplar;
        this.ISBN = ISBN;
        this.tempoMaximo = tempoMax;
        this.codigoAssociado = codigoAssociado;
    }

    public int getNumeroExemplar() {
        return numeroExemplar;
    }

    public void setNumeroExemplar(int numeroExemplar) {
        this.numeroExemplar = numeroExemplar;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }



    
    public int getTempoMaximo() {
        return tempoMaximo;
    }

    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }
    
    
    public void mudaStatusEmprestado(int ISBN, int numExemplar){///Implementar no controle principal
        
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getCodigoAssociado() {
        return codigoAssociado;
    }

    public void setCodigoAssociado(int codigoAssociado) {
        this.codigoAssociado = codigoAssociado;
    }
    
    
}
