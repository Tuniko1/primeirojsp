
package model;

/**
 * Java Bean
 * @author Vitor
 */
public class Perfil {
    
    private int idPerfil;
    private String nome;
    
    public Perfil(){
        
    }

    public Perfil(int id,String name) {
        this.idPerfil=id;
        this.nome=name;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
