<%-- 
    Document   : index
    Created on : 15/09/2021, 17:33:08
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css" media="all"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="//assets.locaweb.com.br/locastyle/2.0.6/stylesheets/locastyle.css">
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/3f3417947e.js" crossorigin="anonymous"></script>
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <div class="container-fluid" style="border: 0px;">
           
             <jsp:include page="template/menu.jsp"/>
            
             <jsp:include page="template/banner.jsp"/>
             <div id="content" style="height: auto">
                 <h1 style="margin: 10px;">Cadastrar Cliente</h1>
                 <form action="gerenciarCliente" method="POST">
                     <input type="hidden" name="idCliente" id="idCliente" >
                        <div class="mb-3">
                               
                               <label for="nome" class="form-label" required>Nome:</label>
                               <input type="text" class="form-control" name="nome" id="nome" required >
                               <label for="cpf" class="form-label" required>CPF:</label>
                               <input type="text" class="form-control cpf-mask" name="cpf" required placeholder="Ex.: 000.000.000-00">                               
                                <label for="email" class="form-label" required>Email:</label>
                               <input type="text" class="form-control" name="email" id="email" required placeholder="exemplo@email.com">
                               <label for="endereco" class="form-label" required>Endereço: </label>
                               <input type="text" class="form-control" name="endereco" id="endereco" required>
                               <label for="telefone" class="form-label" required>Telefone:</label>
                               <input type="text" class="form-control cel-sp-mask" name="telefone" required placeholder="Ex.: (00) 00000-0000">
                               
                             </div>
                             <button type="submit" class="btn btn-success"><i class="far fa-save"></i>&nbspCadastrar</button>
                             <a href="listarCliente.jsp"><button type="button" class="btn btn-danger"><i class="fas fa-ban"></i>&nbspCancelar</button></a>
                 </form>
                        </div>
                
             <jsp:include page="template/footer.jsp"/>
             
             
             
        </div>
        <script type="text/javascript" src="//code.jquery.com/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="//assets.locaweb.com.br/locastyle/2.0.6/javascripts/locastyle.js"></script>
        <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    </body>
</html>

