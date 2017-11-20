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
public class Associado implements Serializable {

    private int codigo;
    private String nome;
    private String endereco;
    private String email;
    private String status;
    private boolean temMulta;
    private int tempoMax;
    public  int valorMulta ;

    public Associado(int codigo, String nome, String endereco, String email, String status) {
        this.valorMulta = 0;
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.status = status;
        this.temMulta = false;
        if (status == "Graduação") {
            this.tempoMax = 7;
        } else if (status == "Pós-graduação") {
            this.tempoMax = 10;
        } else if (status == "Professor") {
            this.tempoMax = 14;
        }

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTempoMax() {
        return tempoMax;
    }

    public void setTempoMax(int tempoMax) {
        this.tempoMax = tempoMax;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTemMulta() {
        return temMulta;
    }

    public void setTemMulta(boolean temMulta) {
        this.temMulta = temMulta;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\n"+getStatus()
                // + "\nNumero: " + listaPublicacao.get(i).getExemplar().getNumero()
                + "\nEditora: " + getStatus()
                + "\nEndereco:" + getEndereco()
                + "\nEmail: " + this.getEmail()
                +"\nMulta: " + this.isTemMulta()
                +"\nValor da multa: "+ this.valorMulta+"\n";

    }
}
