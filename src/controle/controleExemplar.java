/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import  entidade.Exemplar;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Laiza
 */
public class controleExemplar {
    ArrayList<Exemplar>listaExemplar = new ArrayList<>(); ;

    public controleExemplar() {
        this.lerExemplar();
    }
    
    public void cadastraExemplar(Exemplar novoExemplar){
        listaExemplar.add(novoExemplar);
    }
    
    public Exemplar procuraExemplar(int ISBN){
        Exemplar x = null;
        for(int i=0;i<listaExemplar.size();i++){
            if(listaExemplar.get(i).getISBN()==ISBN){
                x= listaExemplar.get(i);
                break;
            }
        }
        return x;
    }

    public String getListaExemplar() {
        String isso = "";
        for(int i=0;i<listaExemplar.size();i++){
            isso += "ISBN: "+listaExemplar.get(i).getISBN()+
                    "\nNumero de sequencia:"+listaExemplar.get(i).getNumero()+
                    "\nPreço: "+listaExemplar.get(i).getPreco()+"\n\n";
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
            System.out.print("alou2\n");
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
        } catch (Exception ex) {System.out.print("alou\n");
            listaExemplar = new ArrayList<>();
        }
    }
}
