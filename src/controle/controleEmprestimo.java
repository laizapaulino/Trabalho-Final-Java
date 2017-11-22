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
    
     
     public int devolucao2( int ISBN, int n) throws Exception {

        //Achar livro
        int it = this.achaEmprestimo(n, ISBN);
        if (it > -1) {
            Date hj = new Date();
            Emprestimo emprestimo = listaEmprestimos.get(it);
            

            //listaEmprestimos.get(it).getExemplar().setStatus("Disponivel");
            int dia = emprestimo.getDataa().getTime().getDate();
            int mes = emprestimo.getDataa().getTime().getMonth();

            int diferenca;
            diferenca = hoje.diferenca(new Data(hj.getDate(), hj.getMonth() + 1), new Data(dia, mes + 1));
            JOptionPane.showMessageDialog(null, "Foi");
            
            emprestimo.getExemplar().setStatus("Disponivel");
//Verifica se tem MULTA
            int x = diferenca - listaEmprestimos.get(it).getTempoMaximo();
            if (x > 0) {
                controleAssociado a = new controleAssociado();
                a.procuraAssociado(listaEmprestimos.get(it).getCodigoAssociado()).valorMulta += x;
                a.procuraAssociado(listaEmprestimos.get(it).getCodigoAssociado()).setTemMulta(true);
                a.serializar();
                JOptionPane.showMessageDialog(null, "Multa de R$ " + (diferenca - listaEmprestimos.get(it).getTempoMaximo()));
                
            } else {
                JOptionPane.showMessageDialog(null, "Sem multa");
            }
            //Exclui do Array
            //verificaLivroExisteDisponivel(listaEmprestimos.get(it).getExemplar().getNumero(), listaEmprestimos.get(it).getISBN()).setStatus("Disponivel");
            //OExemplar(listaEmprestimos.get(it).getISBN())
            
           
            System.out.print(listaEmprestimos.get(it).getExemplar().getStatus()
                    + " -- linha128");

            
                        listaEmprestimos.remove(it);
            this.serializar(); return 0;

        }
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar devolução");return 1;
        
    }
     
    public String listaEmprestimos() {
        String x = "";
        //System.out.println("----" + listaAssociado.size() + "---" + listaAssociado.get(0).getStatus() + " " + Status);
        for (int i = 0; i < listaEmprestimos.size(); i++) {
            x += listaEmprestimos.get(i).toString();
            // x += "\n\nCodigo: " + listaAssociado.get(i).getCodigo() + "\nNome: " + listaAssociado.get(i).getNome()
            //       + "\nEndereço: " + listaAssociado.get(i).getEndereco() + "\nEmail: " + listaAssociado.get(i).getEmail() + "\nMulta: ";

        }
        
        return x;
    }
    
    public void fazerEmprestimo(Emprestimo novoEmprestimo) {
        try {
            
            listaEmprestimos.add(novoEmprestimo);
            novoEmprestimo.getExemplar().setStatus("Indisponivel");
            //  a.mudastatus(novoEmprestimo.getISBN(), novoEmprestimo.getExemplar().getNumero(), "Indisponivel");
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
    
   
    
   
    public int achaEmprestimo(int n, int ISBN) {
        int iterador = -1;
        for (int i = 0; i < listaEmprestimos.size(); i++) {
            if (listaEmprestimos.get(i).getExemplar().getNumero() == n && listaEmprestimos.get(i).getISBN() == ISBN) {
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
