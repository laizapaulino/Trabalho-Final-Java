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

    ArrayList<Associado> listaAssociado;
    final String nome = "associados.ser";

    public controleAssociado() {
        this.listaAssociado = new ArrayList<>();
        lerAssociados();
    }

    public void cadastraAssociado(Associado novoAssociado) {
        listaAssociado.add(novoAssociado);
    }

    public Associado procuraAssociado(int cod) {
        for (int i = 0; i < listaAssociado.size(); i++) {
            if (listaAssociado.get(i).getCodigo() == cod) {
                return listaAssociado.get(i);
            }
        }
        return null;
    }

    public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream(nome);
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(listaAssociado);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo Associado não encontrado!");
        }
    }

    public String retornaPorStatus(String Status) {
        String x = "Listando " + Status+"\n";
        //System.out.println("----" + listaAssociado.size() + "---" + listaAssociado.get(0).getStatus() + " " + Status);
        for (int i = 0; i < listaAssociado.size(); i++) {
            if (listaAssociado.get(i).getStatus().equalsIgnoreCase(Status) == true) {
                x +="\n"+ listaAssociado.get(i).toString();
                // x += "\n\nCodigo: " + listaAssociado.get(i).getCodigo() + "\nNome: " + listaAssociado.get(i).getNome()
                //       + "\nEndereço: " + listaAssociado.get(i).getEndereco() + "\nEmail: " + listaAssociado.get(i).getEmail() + "\nMulta: ";
               

            }
        }
        return x;
    }

    public void lerAssociados() {
        try {
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            listaAssociado = (ArrayList<Associado>) in.readObject();
            in.close();
        } catch (Exception ex) {
            listaAssociado = new ArrayList<>();
        }
    }

}
