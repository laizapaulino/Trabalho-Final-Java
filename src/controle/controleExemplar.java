/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import  entidade.Exemplar;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        for(int i=0;i<listaExemplar.size();i++){
            if(listaExemplar.get(i).getISBN()==ISBN){
                return listaExemplar.get(i);
            }
        }
        return null;
    }
    
        public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("listaExemplar.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(listaExemplar);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo Lista Exemplar não encontrado!");
        }
    }

    private void lerExemplar() {
        try {
            String nome = "listaExemplar.ser";
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            listaExemplar = (ArrayList<Exemplar>) in.readObject();
            in.close();
        } catch (Exception ex) {
            listaExemplar = new ArrayList<>();
        }
    }
}
