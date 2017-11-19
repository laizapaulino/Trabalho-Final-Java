/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Laiza
 */
public class controlePublicacao {

    ArrayList<Publicacao> listaPublicacao;
    final String nome = "Publicacoes.ser";

    public controlePublicacao() {
        
        this.listaPublicacao = new ArrayList<>();
        this.lerPublicacoes();
    }
    ///Verficar mesmo ISBNe mesmo CODIGO

    /* public Exemplar verificaSeExisteExemplar(int ISBN) {
        controleExemplar exemplar = new controleExemplar();
        for (int i = 0; i < exemplar.listaExemplar.size(); i++) {
            if (exemplar.listaExemplar.get(i).getISBN() == ISBN) {
                return exemplar.listaExemplar.get(i);
            }
        }
        return null;
    }*/
    public Publicacao verificaSeISBNExiste(int ISBN) {
        for (int i = 0; i < listaPublicacao.size(); i++) {
            if (listaPublicacao.get(i).getISBN() == ISBN/*
                    && listaPublicacao.get(i).getStatusEmprestado().equalsIgnoreCase("Disponivel")*/) {
                return listaPublicacao.get(i);
            }
        }
        return null;
    }

    public void cadastraPublicacao(Publicacao novaPublicacao) {
        listaPublicacao.add(novaPublicacao);
    }

   

    public Publicacao procura(int ISBN) {
        for (int i = 0; i < listaPublicacao.size(); i++) {
            if (listaPublicacao.get(i).getISBN() == ISBN) {
                return listaPublicacao.get(i);
            }

        }
        return null;
    }

   
    public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream(nome);
//            System.out.print("1\n");

            ObjectOutputStream out = new ObjectOutputStream(arquivo);

            //System.out.print("2\n");
            out.writeObject(listaPublicacao);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo Lista de Exemplares não encontrado!");
        }
    }

    public void lerPublicacoes() {
        try {
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            listaPublicacao = (ArrayList<Publicacao>) in.readObject();
            in.close();
            //System.out.println("Arroz");
        } catch (Exception ex) {
            listaPublicacao = new ArrayList<>();
        }
    }

    public String getListaPublicacao() {
        String isso = "";
        //System.out.println("---" + listaPublicacao.size());
        for (int i = 0; i < listaPublicacao.size(); i++) {
            isso += listaPublicacao.get(i).toString();
                    

        }
        return isso;
    }

}
