/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Vector;

/**
 *
 * @author Laiza
 */
public class Data {

    private int dia, mes, ano;
    private int[] meses = new int[13];

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int diferenca(Data d1, Data d2) {//Arrumar
        int diferenca = 0, m1;
        if (d1.mes == d2.mes && d1.ano == d2.ano) {
            diferenca = d2.dia - d1.dia;
        }
        if (d1.ano == d2.ano && d1.mes < d2.mes) {
            diferenca =meses[d1.mes] - d1.dia + meses[d2.mes] - d2.dia;
            for(int i=d1.mes+1; i<d2.mes;i++){
                diferenca+=meses[i];
            }
        }

        return diferenca;
    }
}
