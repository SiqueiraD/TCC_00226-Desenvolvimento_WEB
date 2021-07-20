<%-- 
    Document   : Categoria
    Created on : 19/07/2021, 22:54:36
    Author     : re92492
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Cabecalho.html" %>
    </head>
    <body>
        <div class="container mt-2">

            <jsp:include page="MenuNavbar.html" />

            <h4>Login</h4> 
            <div class="col-6 mt-5">

                <%
                    if (request.getAttribute("mensagem") != null) {
                         String mensagem = (String) request.getAttribute("mensagem");
                       %>
                        <div class="alert alert-danger" role="alert">
                            <%= mensagem%>
                        </div>
                <%  }%>    
                <form method="GET" action="ValidarLogin" name="fvalida" >


                    <input type="hidden" name="id" >

                    <div class="form-group">
                        <label for="desc">Descrição</label>
                        <input type="text" class="form-control" name="desc" required size="30" maxlength="100" placeholder="Descrição">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Adicionar</button>
                </form>
            </div>
        </div>

        <%@include file="Scripts_basicos.html" %>
    </body>
</html>
