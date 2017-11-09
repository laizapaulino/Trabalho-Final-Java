/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.*;
import java.util.ArrayList;

/**
 *
 * @author Laiza
 */
public class controlePublicacao {

    ArrayList<Publicacao> listaPublicacao = new ArrayList<>();

    public void cadastraPublicacao(Publicacao novaPublicacao) {
        listaPublicacao.add(novaPublicacao);
    }

    public String procuraporISBN(int ISBN) {
        String estado = "Publicaç";
        for (int i = 0; i < listaPublicacao.size(); i++) {
            if (listaPublicacao.get(i).getISBN() == ISBN) {
                estado += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            }
        }
        return estado;
    }

    public String procuraporTitulo(String titulo) {
        String estado = "";
        for (int i = 0; i < listaPublicacao.size(); i++) {
            if (listaPublicacao.get(i).getTitulo() == titulo) {
                estado += "Exemplar\n\t" + listaPublicacao.get(i).getExemplar() + "\n" + listaPublicacao.get(i).getTitulo() + "\n" + listaPublicacao.get(i).getStatus();
            }
        }
        return estado;
    }
}
