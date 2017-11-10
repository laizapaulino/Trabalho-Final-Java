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

    ArrayList<Publicacao> listaPublicacao = new ArrayList<>();

    public void cadastraPublicacao(Publicacao novaPublicacao) {
        listaPublicacao.add(novaPublicacao);
    }

    public String procura(int ISBN) {
        String  disp = "Publicações disponiveis:\n\n", empre = "Publicações NÃO disponiveis:\n\n";
        for (int i = 0; i < listaPublicacao.size(); i++) {
            if (listaPublicacao.get(i).getISBN() == ISBN && listaPublicacao.get(i).getStatus()=="Disponivel") {
                disp += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            }
            else if (listaPublicacao.get(i).getISBN() == ISBN && listaPublicacao.get(i).getStatus()=="Indisponivel") {
                empre += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            }
        }
        return disp +"\n\n\n"+empre;
    }

    public String procuraporTitulo(String titulo) {
        String  disp = "Publicações disponiveis:\n\n", empre = "Publicações NÃO disponiveis:\n\n";
        for (int i = 0; i < listaPublicacao.size(); i++) {
            if (listaPublicacao.get(i).getTitulo() == titulo && listaPublicacao.get(i).getStatus()=="Disponivel") {
                disp += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            }
            else if (listaPublicacao.get(i).getTitulo() == titulo && listaPublicacao.get(i).getStatus()=="Indisponivel") {
                empre += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            }
        }
        return disp +"\n\n\n"+empre;
    }
    
    public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("Publicacoes.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(listaPublicacao);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo Lista de Publicações não encontrado!");
        }
    }
    
    private void lerPublicaoes() {
        try {
            String nome = "Publicacoes.ser";
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            listaPublicacao = (ArrayList<Publicacao>) in.readObject();
            in.close();
        } catch (Exception ex) {
            listaPublicacao = new ArrayList<>();
        }
    }
    
}
