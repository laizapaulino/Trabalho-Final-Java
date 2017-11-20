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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laiza
 */
public class controleEmprestimo {

    String nome = "emprestimos.ser";
    public ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
    Data hoje = new Data();

    public controleEmprestimo() {
        this.lerEmprestimos();
    }

    public void fazerEmprestimo(Emprestimo novoEmprestimo) {
        try {
            listaEmprestimos.add(novoEmprestimo);
            controleExemplar a = new controleExemplar();
            a.mudastatus(novoEmprestimo.getISBN(), novoEmprestimo.getExemplar().getNumero(), "Indisponivel");
            this.serializar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO EMPRESTIMO");
        }

    }

    public Exemplar verificaLivroExisteDisponivel(int numeroEx, int ISBN) {
        controleExemplar e = new controleExemplar();
        for (int i = 0; i < e.listaExemplar.size(); i++) {
            if (e.listaExemplar.get(i).getNumero() == numeroEx && e.listaExemplar.get(i).getISBN() == ISBN && e.listaExemplar.get(i).getStatus().equalsIgnoreCase("Disponivel")) {
                return e.listaExemplar.get(i);
            }
        }

        return null;
    }

    public boolean verificaEmprestimoAss(int matricula) {
        for (int i = 0; i < listaEmprestimos.size(); i++) {
            if (listaEmprestimos.get(i).getCodigoAssociado() == matricula) {
                return true;
            }
        }
        return false;
    }

    public Associado verificaAssoc(int matricula) {
        controleAssociado a = new controleAssociado();

        return a.procuraAssociado(matricula);
    }

    public void devolucao(int codigoAssociado, int ISBN) throws Exception {

        //Achar livro
        int it = this.achaEmprestimo(codigoAssociado, ISBN);
        if (it > -1) {
            Date hj = new Date();
            Emprestimo em = listaEmprestimos.get(it);

            int dia = em.getDataa().getTime().getDate();
            int mes = em.getDataa().getTime().getMonth();
            JOptionPane.showMessageDialog(null, dia + " " + mes);

            //acha a diferença de tempo
            int diferenca;
            diferenca = hoje.diferenca(new Data(hj.getDate(), hj.getMonth() + 1), new Data(dia, mes + 1));

            //Verifica se tem MULTA
            int x = diferenca - listaEmprestimos.get(it).getTempoMaximo();
            if (x > 0) {
                controleAssociado a = new controleAssociado();
                a.procuraAssociado(codigoAssociado).valorMulta += x;
                a.procuraAssociado(codigoAssociado).setTemMulta(true);
                a.serializar();
                JOptionPane.showMessageDialog(null, "Multa de R$ " + (diferenca - listaEmprestimos.get(it).getTempoMaximo()));

            } else {
                JOptionPane.showMessageDialog(null, "Sem multa");
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
            FileOutputStream arquivo = new FileOutputStream(nome);
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(this.listaEmprestimos);
            out.flush();
            out.close();
            arquivo.close();
            //System.out.print("alou2\n");
        } catch (Exception exc) {
            throw new Exception("Arquivo não encontrado!");
        }
    }

    public void lerEmprestimos() {
        try {
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            this.listaEmprestimos = (ArrayList<Emprestimo>) in.readObject();
            in.close();
        } catch (Exception ex) {
            //System.out.print("alou\n");
            this.listaEmprestimos = new ArrayList<>();
        }
    }
}
