/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import entidade.Associado;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Laiza
 */
public class controleAssociado {

    ArrayList<Associado> listaAssociado = new ArrayList<>();

    public void cadastraAssociado(Associado novoAssociado) throws Exception {
        if (getAssociado(novoAssociado.getCodigo()) != null) {
            throw new Exception("Associado já cadastrado!");
        }
        
        listaAssociado.add(novoAssociado);
    }

    public controleAssociado() {
        lerAssociados();
    }
    

    public Associado getAssociado(int cod) {
        for (int i=0; i<listaAssociado.size(); i++){
            if (listaAssociado.get(i).getCodigo() == cod)
                return listaAssociado.get(i);
        }
        return null;
    }
    
    public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("associados.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(listaAssociado);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo Associado não encontrado!");
        }
    }
    
    private void lerAssociados() {
        try {
            String nome = "associados.ser";
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            listaAssociado = (ArrayList<Associado>) in.readObject();
            in.close();
        } catch (Exception ex) {
            listaAssociado = new ArrayList<>();
        }
    }
    
}
