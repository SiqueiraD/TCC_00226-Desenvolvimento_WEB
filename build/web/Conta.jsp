<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Cabecalho.html" %>
    </head>
    <body>


        <div class="container mt-3 container-bg-gray p-5">

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
                <form method="POST" action="Conta" name="fvalida" >


                    <input type="hidden" name="id" >

                    
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" name="usuario" required size="30" maxlength="100" disabled="disabled" value="<% out.println(request.getAttribute("nomeUsuario")); %>">
                    </div>
                    
                    <p></p>
                    <div class="form-group">
                        <label for="banco">Banco</label>
                        <input type="text" class="form-control" name="banco" required size="30" maxlength="100" placeholder="Seu Banco">
                    </div>
                    <div class="form-group">
                        <label for="agencia">Agencia</label>
                        <input type="text" class="form-control" name="agencia" required size="30" maxlength="100" placeholder="Agencia da sua conta">
                    </div>
                    <div class="form-group">
                        <label for="conta">Conta</label>
                        <input type="text" class="form-control" name="conta" required size="30" maxlength="100" placeholder="Conta com dígito">
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </div>
        </div>

        <%@include file="Scripts_basicos.html" %>
    </body>
</html>
