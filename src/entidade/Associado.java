/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;
import java.io.Serializable;

/**
 *
 * @author Laiza
 */
public class Associado {
    private int codigo;
    private String nome;
    private String endereco;
    private String email;
    private String status;
    private boolean temMulta;

    public Associado(int codigo, String nome, String endereco, String email, String status) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.status = status;
        this.temMulta = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTemMulta() {
        return temMulta;
    }

    public void setTemMulta(boolean temMulta) {
        this.temMulta = temMulta;
    }
    
    
    
    
    
}
