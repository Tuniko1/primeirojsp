<%-- 
    Document   : index
    Created on : 15/09/2021, 17:33:08
    Author     : Vitor
--%>


<%@page import="factory.ConexaoFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.ArrayList"
        import="model.Cliente"
        import="model.ClienteDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="bootstrap/bootstrap.css" type="text/css" media="all"/>
        <link rel="stylesheet" href="css/fontawesome.css" type="text/css" media="all"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="datatables/dataTables.bootstrap4.css"/>
        <script src="https://kit.fontawesome.com/3f3417947e.js" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <title>Clientes</title>
    </head>
    <body>
        <div class="container-fluid">
           
           
             <jsp:include page="template/menu.jsp"/> 
            
             <jsp:include page="template/banner.jsp"/>
             
             <div id="content" style="height: auto; margin: 10px;">
                    
                 <h1 style="margin: 10px;">Listar Clientes</h1>
                    <div class="row h-10 justify-content-center align-items-center" >  
                   
                        <div class="col-10">    
                            <a href="cadastrarCliente.jsp"><button type="button" class="btn btn-success">Novo Cliente</button></a><br><br>
                            <div class="table-dark">
                                   <table class="table" id="listarPerfil">
                                         <thead >
                                              <tr>
                                                  <th>Código</th>
                                                  <th>Nome</th>
                                                  <th>CPF</th>
                                                  <th>Email</th>
                                                  <th>Endereço</th>
                                                  <th>Telefone</th>
                                                  <th>Ações</th>

                                              </tr>

                                          </thead>

                                          <tbody>
                                              <jsp:useBean class="model.ClienteDAO" id="cdao"/>
                                              <c:forEach var="c" items="${cdao.lista}" >
                                                  <tr class="text-black">
                                                      <td>${c.idCliente}</td>
                                                      <td>${c.nome}</td>
                                                      <td>${c.cpf}</td>
                                                      <td>${c.email}</td>
                                                      <td>${c.endereco}</td>
                                                      <td>${c.telefone}</td>
                                                      <td class="text-center">
                                                          <a href="gerenciarCliente?acao=alterar&idPerfil=${c.idCliente}" class="btn btn-primary btn-lg" role="button" style="float:left">
                                                              <i class="fas fa-pencil-alt"></i>&nbsp Alterar</a>
                                                              
                                                          <a href="" class="btn btn-danger btn-lg" role="button" style="float:left">   
                                                              <i class="fas fa-trash-alt"></i>&nbsp Deletar</td></a>


                                                  </tr>
                                                                              %>
                                                  </c:forEach>

                                          </tbody>
                                       

                                   </table>
                                              
                                   <script src="js/jquery-3.6.0.min.js"></script>   
                                   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                                   <script src="datatables/jquery.dataTables.js"></script>            
                                   <script src="datatables/dataTables.bootstrap4.js"></script> 
                                   <script>
                          $(document).ready(function(){
                                        $("#listarPerfil").dataTable({
                                        "bJQueryUI": true,
                                        "lengthMenu": [[5, 10, 20, 25, -1], [5, 10, 20, 25, "All"]],
                                        "oLanguage": {
                                        "sProcessing":"Processando..",
                                        "sLengthMenu":"Mostrar _MENU_ registros",
                                        "sZeroRecords": "Não foram encontrados resultados",
                                        "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                                        "sInfoEmpty":"Mostrando de 0 até 0 de 0 registros",
                                        "sInfoFiltered": "",
                                        "sInfoPostFix": "",
                                        "sSearch": "Pesquisar: ",
                                        "sUrl": "",
                                        "oPaginate": {
                                            "sFirst":"Primeiro",
                                            "sPrevious": "Anterior",
                                            "sNext": "Próximo",
                                            "sLast": "Último"
                                        }
                                        
                                    }
                                 });
                                });
             
                                       
                                       
                                       
                                       
                  </script> 
                            
                            </div>

                        </div>                           

                    </div>                             
                </div>

                    <jsp:include page="template/footer.jsp"/>

             
        </div>
        
    </body>
</html>

