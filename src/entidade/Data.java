/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Laiza
 */
public class Data {

    private int dia, mes;
    private int[] meses = new int[13];

    public Data(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Data() {
        
        meses[1] = 31;
        meses[2] = 28;
        meses[3] = 31;
        meses[4] = 30;
        meses[5]= 31;
        meses[6]= 30;
        meses[7]= 31;
        meses[8]= 31;
        meses[9]= 30;
        meses[10]= 31;
        meses[11]= 30;
        meses[12]= 31;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    

    public int diferenca(Data d1, Data d2) {//A primeira precisa ser hj, a segunda o emprestimo
        int diferenca = 0;
        if (d1.mes == d2.mes && d1.dia > d2.dia) {//Mes igual data diff
            diferenca = d1.dia - d2.dia;
        }
        else if (d1.dia == d2.dia && d1.mes == d2.mes) {//Mesma data
        diferenca = 0;
        }
        else if ( d1.mes > d2.mes) {//Mes maior
            diferenca =meses[d1.mes] - d1.dia + d2.dia;
            for(int i= d1.mes+1; i<d2.mes;i++){
                diferenca+=meses[i];
            }
        }
       // if(diferenca <)
        JOptionPane.showMessageDialog(null, diferenca );
        return diferenca;
    }
}
