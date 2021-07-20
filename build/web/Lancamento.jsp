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
                <form method="GET" action="ValidarLogin" name="fvalida" >


                    <input type="hidden" name="id" >

                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" name="usuario" required size="30" maxlength="100" disabled="disabled" value=    "<% out.println(request.getAttribute("nomeUsuario")); %>">
                    </div>
                    <div class="form-group">
                        <label for="conta">Conta</label>
                        <input type="text" class="form-control" name="conta" required size="30" maxlength="100" disabled="disabled" value="<% out.println(request.getAttribute("contaLancamento")); %>">
                    </div>
                    <div class="form-group">
                        <label for="operacao">Operação</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="operacao" id="operacao1">
                            <label class="form-check-label" for="operacao1">
                              Crédito
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="operacao" id="operacao2" checked>
                            <label class="form-check-label" for="operacao2">
                              Débito
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="data">Data</label>
                        <input type="date" class="form-control" name="data" required size="30" maxlength="100" placeholder="Data do Lançamento">
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor</label>
                        <input type="text" class="form-control" name="valor" required size="30" maxlength="100" placeholder="Valor do Lançamento">
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descrição</label>
                        <input type="text" class="form-control" name="descricao" required size="30" maxlength="100" usuario >
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </div>
        </div>

        <%@include file="Scripts_basicos.html" %>
    </body>
</html>
