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

    public void cadastraPublicacao(Publicacao novaPublicacao) {
        listaPublicacao.add(novaPublicacao);
    }

    public String procura(int ISBN) {
        String disp = "Publicações disponiveis:\n\n", empre = "Publicações NÃO disponiveis:\n\n";
        for (int i = 0; i < listaPublicacao.size(); i++) {
            if (listaPublicacao.get(i).getISBN() == ISBN && listaPublicacao.get(i).getStatus() == "Disponivel") {
                disp += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            } else if (listaPublicacao.get(i).getISBN() == ISBN && listaPublicacao.get(i).getStatus() == "Indisponivel") {
                empre += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            }
        }
        return disp + "\n\n\n" + empre;
    }

    public String procuraporTitulo(String titulo) {
        String disp = "Publicações disponiveis:\n\n", empre = "Publicações NÃO disponiveis:\n\n";
        for (int i = 0; i < listaPublicacao.size(); i++) {
            if (listaPublicacao.get(i).getTitulo() == titulo && listaPublicacao.get(i).getStatus() == "Disponivel") {
                disp += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            } else if (listaPublicacao.get(i).getTitulo() == titulo && listaPublicacao.get(i).getStatus() == "Indisponivel") {
                empre += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            }
        }
        return disp + "\n\n\n" + empre;
    }

    public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream(nome);
            System.out.print("1\n");

            ObjectOutputStream out = new ObjectOutputStream(arquivo);

            System.out.print("2\n");
            out.writeObject(listaPublicacao);
            out.flush();
            out.close();
            arquivo.close();
            System.out.print("Foi\n");
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
            System.out.println("Arroz");
        } catch (Exception ex) {
            listaPublicacao = new ArrayList<>();
        }
    }

    public String getListaPublicacao() {
        String isso = "";
        for (int i = 0; i < listaPublicacao.size(); i++) {
            isso += "ISBN: " + listaPublicacao.get(i).getISBN()
                    + "\nTitulo:" + listaPublicacao.get(i).getTitulo()
                    + "\nAutor: " + listaPublicacao.get(i).getAutor()
                    + "\nEditora: " + listaPublicacao.get(i).getEditora()
                    + "\nStatus: " + listaPublicacao.get(i).getStatus() + "\n\n";

        }
        return isso;
    }

}
