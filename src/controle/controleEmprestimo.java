/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.*;
import java.util.ArrayList;
import java.util.Calendar;

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
public class controleEmprestimo {

    ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
    Data hoje;

    

    public void fazerEmprestimo(Emprestimo novoEmprestimo) {
        listaEmprestimos.add(novoEmprestimo);

    }

    public void devolucao(int codigoAssociado, int ISBN, Data hoje) {

        //Achar livro
        int it = this.achaEmprestimo(codigoAssociado, ISBN);
        if (it > -1) {
            //acha a diferença de tempo
            int diferenca = hoje.diferenca(listaEmprestimos.get(it).getData(), hoje);

            //Verifica se tem MULTA
            if (diferenca > listaEmprestimos.get(it).getTempoMaximo()) {

            }
            //Exclui do Array
            listaEmprestimos.remove(it);

        }

    }

    public int achaEmprestimo(int codigo, int ISBN) {
        int iterador = -1;
        for (int i = 0; i < listaEmprestimos.size(); i++) {
            if (listaEmprestimos.get(i).getISBN() == ISBN && listaEmprestimos.get(i).getCodigoAssociado() == codigo) {
                iterador = i;
                break;
            }
        }
        return iterador;
    }

    public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("emprestimoLivros.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(out);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo Lista de Emprestimos não encontrado!");

        }
    }
    
    private void lerEmprestimos() {
        try {
            String nome = "emprestimosLivros.ser";
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            listaEmprestimos = (ArrayList<Emprestimo>) in.readObject();
            in.close();
        } catch (Exception ex) {
            listaEmprestimos = new ArrayList<>();
        }
    }
    
}
