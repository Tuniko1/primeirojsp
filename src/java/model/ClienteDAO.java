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
import model.Cliente;

/**
 *
 * @author Vitor
 */
public class ClienteDAO {
    
    /**
     *
     * @return
     * @throws ClassNotFoundException
     */
    public ArrayList<Cliente> getLista() throws ClassNotFoundException{
        try{
            String sql = "SELECT idCliente, nome, cpf, email, endereco, telefone FROM Cliente ";
            ArrayList<Cliente> clientes = new ArrayList();

            Connection con = ConexaoFactory.conectar();
            PreparedStatement enviar = con.prepareStatement(sql);
            ResultSet lista= enviar.executeQuery();

            while(lista.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(lista.getInt("idperfil"));
                cliente.setNome(lista.getString("nome"));
                cliente.setCpf(lista.getString("cpf"));
                cliente.setEmail(lista.getString("email"));
                cliente.setEndereco(lista.getString("endereco"));
                cliente.setTelefone(lista.getString("telefone"));
                clientes.add(cliente);
            }

            con.close();
            return clientes;

        }catch(SQLException ex){
            System.out.println("Falha a listar clientes, motivo: "+ex.getMessage());
            
            return null;
        }
       
    }
    
    /**
     *
     * @param cliente
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean gravar(Cliente cliente) throws SQLException, ClassNotFoundException{
       
        

            Connection con = ConexaoFactory.conectar();
            PreparedStatement enviar;

            if(cliente.getIdCliente()==0){
                String sql = "INSERT INTO cliente(nome,cpf,email,endereco,telefone) VALUES (?,?,?,?,?)";    
                enviar = con.prepareStatement(sql);

                enviar.setString(1, cliente.getNome());
                enviar.setString(2, cliente.getCpf());
                enviar.setString(3, cliente.getEmail());
                enviar.setString(4, cliente.getEndereco());
                enviar.setString(5, cliente.getTelefone());
                enviar.execute();
                con.close();
            }else{
                String sql = "UPDATE cliente SET nome=?,endereco=?,telefone=?  WHERE idperfil = (?)";    
                enviar = con.prepareStatement(sql);

                enviar.setString(1, cliente.getNome());
                enviar.setString(2, cliente.getEndereco());
                enviar.setString(3, cliente.getTelefone());
                enviar.setInt(4, cliente.getIdCliente());
                enviar.execute();
                con.close();
            }
                return true;

      
    }
    
    /**
     *
     * @param idCliente
     * @return
     * @throws java.lang.ClassNotFoundException
     */
    public boolean deletar(int idCliente) throws ClassNotFoundException{
        try{
            Connection con = ConexaoFactory.conectar();
            PreparedStatement enviar;
            String sql = "DELETE FROM cliente WHERE idCliente=?";
            enviar=con.prepareStatement(sql);
            
            enviar.setInt(1, idCliente);
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
     * @param cliente
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Cliente getCarregarPorId(Cliente cliente) throws SQLException, ClassNotFoundException{
        
        
      
            Connection con = ConexaoFactory.conectar();
            PreparedStatement enviar;
            String sql = "SELECT idCliente, nome, cpf, email, endereco, telefone FROM cliente  WHERE idCliente=?";
            
            enviar=con.prepareStatement(sql);
            enviar.setInt(1, cliente.getIdCliente());
            ResultSet rs=enviar.executeQuery();
            
            if(rs.next()==false){
                System.out.println("Nenhum perfil cadastrado com esse ID!");
            }else{
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            con.close();
            
            return cliente;
           
    }
}
