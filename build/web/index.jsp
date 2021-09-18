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
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/3f3417947e.js" crossorigin="anonymous"></script>
        <title>Página Inicial</title>
    </head>
    <body>
        <div class="container-fluid" style="border: 0px;">
           
              <jsp:include page="template/menu.jsp"/>
            
             <jsp:include page="template/banner.jsp"/>
             <div id="content" style="height: 400px">
                 <h1 style="margin: 10px;">Página Inicial</h1>
                 
                 
                 
             </div>
             
             
             <jsp:include page="template/footer.jsp"/>
             
             
             
        </div>
        
    </body>
</html>

