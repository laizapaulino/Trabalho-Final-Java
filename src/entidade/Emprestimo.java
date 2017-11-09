/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;
import org.; 

/**
 *
 * @author Laiza
 */
public class Emprestimo {
    private int numeroExemplar;
    private int ISBN;
    private int codigoAssociado;
    private int tempoMaximo;
    private DateTime data; 

    public Emprestimo(int numeroExemplar, int ISBN, int dia, int mes, int ano, int codigoAssociado) {
        this.data.set(ano, mes, dia);//Ano mes dia
        this.numeroExemplar = numeroExemplar;
        this.ISBN = ISBN;
        
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    
    public int getTempoMaximo() {
        return tempoMaximo;
    }

    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }
    
    
    public void mudaStatusEmprestado(int ISBN, int numExemplar){///Implementar no controle principal
        
    }
    
}
