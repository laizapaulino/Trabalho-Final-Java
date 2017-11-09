/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import entidade.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author Laiza
 */
public class controleEmprestimo {
    
    ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
    Calendar hoje = new GregorianCalendar();

    
    
     
    public void fazerEmprestimo(Emprestimo novoEmprestimo){
        listaEmprestimos.add(novoEmprestimo);
        
        
    }
    
    public void devolucao(int codigoAssociado, int ISBN){
        this.hoje.setTime(new Date());
//Achar livro
        //Verificar se há multa
        //Excluir do Array
        int it = this.achaEmprestimo(codigoAssociado, ISBN);
        if(it > -1){
            if(listaEmprestimos.get(it).getData().compareTo( hoje) > listaEmprestimos.get(it).getTempoMaximo()){
                //Multa
            }
            
            listaEmprestimos.remove(it);
        }
        
        
    }
    
    public int achaEmprestimo(int codigo, int ISBN){
        int iterador = -1;
        for (int i = 0; i<listaEmprestimos.size();i++){
            if(listaEmprestimos.get(i).getISBN() == ISBN && listaEmprestimos.get(i).getCodigoAssociado() == codigo){
                iterador = i;
                break;
            }
        }
        return iterador;
    }
}
