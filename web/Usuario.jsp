





<%@page import="aplicacao.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Cabecalho.html" %>
    </head>

    <body>


        <div class="container mt-3 container-bg-gray p-5">

            <jsp:include page="MenuNavbar.html" />

            <%
                if (request.getAttribute("mensagem") != null) {
                    String mensagem = (String) request.getAttribute("mensagem");
            %>
            <div class="alert alert-danger" role="alert">
                <%= mensagem%>
            </div>
            <%  }%>  


            <jsp:include page="UsuarioCadastro.jsp" />

            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">NOME</th>
                        <th scope="col">CPF</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Usuarios> ListaUsuarios = (ArrayList<Usuarios>) request.getAttribute("listaUsuarios");
                        for (int i = 0; i < ListaUsuarios.size(); i++) {
                            Usuarios aux = ListaUsuarios.get(i);
                    %>
                    <tr>
                        <th scope="row"><%=aux.getId()%></th>
                        <td><%=aux.getNome()%></td> 
                        <td><%=aux.getCpf()%></td> 
                        <td> 
                            <div>
                                <a type="submit" class="btn btn-primary" href="Usuario?acao=editar&id=<%=aux.getId()%>">Editar</a>
                                <% if (aux.getSuspenso().equals("N")) {%>
                                <a type="submit"  class="btn btn-danger" href="Usuario?acao=desativar&id=<%=aux.getId()%>">Desativar</a>
                                <% } else {%>
                                <a type="submit"  class="btn btn-success" href="Usuario?acao=ativar&id=<%=aux.getId()%>">Ativar</a>
                                <% }%>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

        </div>

        <%@include file="Scripts_basicos.html" %>
    </body>
</html>
