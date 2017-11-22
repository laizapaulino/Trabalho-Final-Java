/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Exemplar;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Laiza
 */
public class controleExemplar {

    public ArrayList<Exemplar> listaExemplar = new ArrayList<>();

    public controleExemplar() {
        this.lerExemplar();
    }

    public void cadastraExemplar(Exemplar novoExemplar) {
        listaExemplar.add(novoExemplar);
    }

    public Exemplar procuraExemplar(int ISBN) {
       // Exemplar x = null;
        for (int i = 0; i < listaExemplar.size(); i++) {
            if (listaExemplar.get(i).getISBN() == ISBN && listaExemplar.get(i).getStatus().equalsIgnoreCase("Disponivel")) {
                return listaExemplar.get(i);
                
            }
        }
        return null;
    }
    public Exemplar procuraExemplar2(int ISBN, int numeroseq) {
       // Exemplar x = null;
        for (int i = 0; i < listaExemplar.size(); i++) {
            if (listaExemplar.get(i).getISBN() == ISBN && listaExemplar.get(i).getNumero() == numeroseq) {
                return listaExemplar.get(i);
                
            }
        }
        return null;
    }


    public String procuraporTitulo(String titulo) {
        String disp = "Exemplares de " + titulo + " disponiveis:\n\n", empre = "Exemplares NÃO disponiveis:\n\n";
        for (int i = 0; i < listaExemplar.size(); i++) {
            if (listaExemplar.get(i).getPublicacao().getTitulo().equalsIgnoreCase(titulo) && listaExemplar.get(i).getStatus().equalsIgnoreCase("Disponivel")) {
                disp += "\n" + listaExemplar.get(i);
            } else if (listaExemplar.get(i).getPublicacao().getTitulo().equalsIgnoreCase(titulo) && listaExemplar.get(i).getStatus().equalsIgnoreCase("Indisponivel")) {
                empre += "\n" + listaExemplar.get(i);
            }
        }
        return disp + "\n\n\n" + empre;
    }

    public String procuraporISBN(int ISBN) {//System.out.print("---"+this.listaPublicacao.get(0).getStatusEmprestado());
        String disp = "Exemplares de ISBN " + ISBN + " disponiveis:\n\n", empre = "Exemplares NÃO disponiveis:\n\n";
        for (int i = 0; i < listaExemplar.size(); i++) {
            if (listaExemplar.get(i).getPublicacao().getISBN() == ISBN && listaExemplar.get(i).getStatus().equalsIgnoreCase("Disponivel")) {
                disp += "\n" + listaExemplar.get(i);
            } else if (listaExemplar.get(i).getPublicacao().getISBN() == ISBN && listaExemplar.get(i).getStatus().equalsIgnoreCase("Indisponivel")) {
                empre += "\n" + listaExemplar.get(i);
            }
        }
        return disp + "\n\n" + empre;
    }

    public void mudastatus(int isbn, int numeroEx, String status) {
        try {
            for (int i = 0; i < listaExemplar.size(); i++) {

                if (listaExemplar.get(i).getISBN() == isbn && listaExemplar.get(i).getNumero() == numeroEx) {

                    listaExemplar.get(i).setStatus(status);
                    // System.out.print("-- foi--" + listaExemplar.get(i).getStatus());
                    break;
                }
            }
            this.serializar();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "COntrole Exemplarmuda status");
        }

    }

    public String getListaExemplar() {
        String isso = "";
        for (int i = 0; i < listaExemplar.size(); i++) {
            isso += listaExemplar.get(i).toString()+"\n\n";
        }
        return isso;
    }

    public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("exemplar.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(listaExemplar);
            out.flush();
            out.close();
            arquivo.close();
            //System.out.print("alou2\n");
        } catch (Exception exc) {
            throw new Exception("Arquivo Lista de Exemplares não encontrado!");
        }
    }

    public void lerExemplar() {
        try {
            String nome = "exemplar.ser";
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            listaExemplar = (ArrayList<Exemplar>) in.readObject();
            in.close();
        } catch (Exception ex) {
            //System.out.print("alou\n");
            listaExemplar = new ArrayList<>();
        }
    }
}
