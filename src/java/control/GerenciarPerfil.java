/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


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
import model.Perfil;
import model.PerfilDAO;

/**
 *
 * @author Vitor e Arthur
 */
@WebServlet(name = "GerenciarPerfil", urlPatterns = {"/gerenciarPerfil"})
public class GerenciarPerfil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método para alterar o perfil
        
       PrintWriter out = response.getWriter();
    
       String acao= request.getParameter("acao"); //passa o parametro de ação
       String idPerfil = request.getParameter("idPerfil");
       
       String mensagem;
       
       Perfil perfil= new Perfil();
       PerfilDAO pdao= new PerfilDAO();
       
       
       
       if(acao.equals("alterar")){ //verifica se o ação é igual a alterar
           perfil.setIdPerfil(Integer.parseInt(idPerfil));
           
           Perfil perfilAlterado;
           try {
               perfilAlterado = pdao.getCarregarPorId(perfil);
               
              if(perfilAlterado.getIdPerfil()>0){
               RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alterarPerfil.jsp");
               request.setAttribute("perfilAlterado", perfilAlterado);
               
               dispatcher.forward(request, response);
              }   
           } catch (SQLException ex) {
               mensagem="Perfil não encontrado!";
               out.println("<script type='text/javascript'> "+"alert('"+mensagem+"');"+
               "location.href='listarPerfil.jsp';</script>");
           }
           
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // Método para adicionar o perfil
     
       PrintWriter out = response.getWriter();
       
       String nome = request.getParameter("nome");
       String idPerfil = request.getParameter("idPerfil");
       String mensagem;
   
       Perfil perfil= new Perfil();
       
       if(!idPerfil.isEmpty()){
           perfil.setIdPerfil(Integer.parseInt(request.getParameter("idPerfil")));
       }
       
       perfil.setNome(nome);
       
       
       PerfilDAO pdao= new PerfilDAO();
       
        try {
            pdao.gravar(perfil);
            mensagem="Perfil cadastrado com sucesso!";
        } catch (SQLException ex) {
            mensagem="Erro ao tentar cadastrar usuário";
        }
       
       
       out.println("<script type='text/javascript'> "+"alert('"+mensagem+"');"+
               "location.href='listarPerfil.jsp';</script>");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
