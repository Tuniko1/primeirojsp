/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Perfil;

/**
 *
 * @author Vitor
 */
public class PerfilDAO {
    
   
    public ArrayList<Perfil> getLista(){
        try{
        String sql = "SELECT idperfil, nome FROM perfil ";
        ArrayList<Perfil> perfis = new ArrayList();
        
        Connection con = ConexaoFactory.conectar();
        PreparedStatement enviar = con.prepareStatement(sql);
        ResultSet lista= enviar.executeQuery();
        
        while(lista.next()){
            Perfil profile = new Perfil();
            profile.setIdPerfil(lista.getInt("idperfil"));
            profile.setNome(lista.getString("nome"));
            perfis.add(profile);
        }
        
        con.close();
        return perfis;
        
        }catch(SQLException ex){
            System.out.println("Falha a listar dados, motivo: "+ex.getMessage());
            
            return null;
        }
       
    }
    
   
    public boolean gravar(Perfil perfil) throws SQLException{
       
        

            Connection con = ConexaoFactory.conectar();
            PreparedStatement enviar;

            if(perfil.getIdPerfil()==0){
                String sql = "INTO perfil(nome) VALUES (?)";    
                enviar = con.prepareStatement(sql);

                enviar.setString(1, perfil.getNome());
                enviar.execute();
                con.close();
            }else{
                String sql = "UPDATE perfil SET nome=?  WHERE idperfil = (?)";    
                enviar = con.prepareStatement(sql);

                enviar.setString(1, perfil.getNome());
                enviar.setInt(2, perfil.getIdPerfil());
                enviar.execute();
                con.close();
            }
                return true;

      
    }
    
    /**
     *
     * @param idPerfil
     * @return
     */
    public boolean deletar(int idPerfil){
        try{
            Connection con = ConexaoFactory.conectar();
            PreparedStatement enviar;
            String sql = "DELETE FROM perfil WHERE idperfil=?";
            enviar=con.prepareStatement(sql);
            
            enviar.setInt(1, idPerfil);
            enviar.executeUpdate();
            
            con.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Erro ao tentar excluir dados, motivo: "+ex.getMessage());
            return false;
        }
        
    
    }
    
    /**
     *
     * @param p
     * @return
     */
    public Perfil getCarregarPorId(Perfil perfil) throws SQLException{
        
        
      
            Connection con = ConexaoFactory.conectar();
            PreparedStatement enviar;
            String sql = "SELECT idperfil, nome FROM perfil WHERE idperfil=?";
            
            enviar=con.prepareStatement(sql);
            enviar.setInt(1, perfil.getIdPerfil());
            ResultSet rs=enviar.executeQuery();
            
            if(rs.next()==false){
                System.out.println("Nenhum perfil cadastrado com esse ID!");
            }else{
                perfil.setIdPerfil(rs.getInt("idperfil"));
                perfil.setNome(rs.getString("nome"));
            }
            con.close();
            
            return perfil;
           
    }
}
