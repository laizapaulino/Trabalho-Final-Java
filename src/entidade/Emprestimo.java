/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Laiza
 */
public class Emprestimo implements Serializable {

    private final Exemplar numeroExemplar;
    private int ISBN;
    private int codigoAssociado;
    private int tempoMaximo;
    private GregorianCalendar dataa;
    private Data data;

    public Emprestimo(GregorianCalendar d, Exemplar numeroExemplar, int ISBN, /*int dia, int mes, int ano,*/ int codigoAssociado, int tempoMax) {
        this.dataa = d;
        //this.data = new Data(dia, mes, ano);//dia, mes, ano
        this.numeroExemplar = numeroExemplar;
        this.ISBN = ISBN;
        this.tempoMaximo = tempoMax;
        this.codigoAssociado = codigoAssociado;
    }

    public GregorianCalendar getDataa() {
        return dataa;
    }

    public void setDataa(GregorianCalendar dataa) {
        this.dataa = dataa;
    }

    public Exemplar getExemplar() {
        return numeroExemplar;
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

    public void mudaStatusEmprestado(int ISBN, int numExemplar) {///Implementar no controle principal

    }

   
    public int getCodigoAssociado() {
        return codigoAssociado;
    }

    public void setCodigoAssociado(int codigoAssociado) {
        this.codigoAssociado = codigoAssociado;
    }
    
    @Override
    public String toString() {
        return "Titulo: "+numeroExemplar.getTitulo()
                +"\nISBN: "+getISBN()+
                "\nCodigo Associado: " + codigoAssociado + 
                " \nData de emprestimo: "+dataa.getTime().getDate()+"/"+(dataa.getTime().getMonth()+1)+"\n\n";// + "Preço: " + preco;
    }


}