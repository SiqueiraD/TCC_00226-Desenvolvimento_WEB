<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
                <form method="POST" action="ValidarLogin" name="fvalida" >


                    <input type="hidden" name="id" >

                    <div class="form-group">
                        <label for="login">Login</label>
                        <input type="text" class="form-control" name="login" required size="30" maxlength="100" placeholder="Seu Login">
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control"  name="senha" required size="3" maxlength="3" placeholder="Sua Senha">
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </div>
        </div>

        <%@include file="Scripts_basicos.html" %>
    </body>
</html>
