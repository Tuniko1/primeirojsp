/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import factory.ConexaoFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Vitor e Arthur
 */
@WebServlet(name = "GerenciarCliente", urlPatterns = {"/gerenciarCliente"})
public class GerenciarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método para alterar o cliente
        
       PrintWriter out = response.getWriter();
    
       String acao= request.getParameter("acao"); //passa o parametro de ação
       String idCliente = request.getParameter("idCliente");
       
       String mensagem;
       
       Cliente cliente= new Cliente();
       ClienteDAO cdao= new ClienteDAO();
       
       
       
       if(acao.equals("alterar")){ //verifica se o ação é igual a alterar
           cliente.setIdCliente(Integer.parseInt(idCliente));
           
           Cliente clienteAlterado;
           try {
               clienteAlterado = cdao.getCarregarPorId(cliente);
               
              if(clienteAlterado.getIdCliente()>0){
               RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alterarCliente.jsp");
               request.setAttribute("clienteAlterado", clienteAlterado);
               
               dispatcher.forward(request, response);
              }   
           } catch (SQLException ex) {
               mensagem="Cliente não encontrado!";
               out.println("<script type='text/javascript'> "+"alert('"+mensagem+"');"+
               "location.href='listarPerfil.jsp';</script>");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(GerenciarCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método para adicionar o cliente
     
       PrintWriter out = response.getWriter();
       
       String nome = request.getParameter("nome");
       String idCliente = request.getParameter("idCliente");
       String email= request.getParameter("email");
       String cpf= request.getParameter("cpf");
       String telefone= request.getParameter("telefone");
       String endereco= request.getParameter("endereco");
       String mensagem="";
   
       Cliente cliente= new Cliente();
       
       if(!idCliente.isEmpty()){
           cliente.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
       }
       
       cliente.setNome(nome);
       cliente.setEmail(email);
       cliente.setEndereco(endereco);
       cliente.setCpf(cpf);
       cliente.setTelefone(telefone);
       
       ClienteDAO cdao= new ClienteDAO();
       
        try {
            cdao.gravar(cliente);
            mensagem="Cliente cadastrado com sucesso!";
        } catch (SQLException ex) {
            mensagem="Erro ao tentar cadastrar cliente ";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       out.println("<script type='text/javascript'> "+"alert('"+mensagem+"');"+
               "location.href='listarCliente.jsp';</script>");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
