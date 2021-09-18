
package model;

import java.util.ArrayList;

/**
 * Java Bean
 * @author Vitor
 */
public class Cliente {
    
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;
    
    public Cliente(){
        
    }

    public Cliente(int id,String name) {
        this.idCliente=id;
        this.nome=name;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
  
    
    
    
    
}
