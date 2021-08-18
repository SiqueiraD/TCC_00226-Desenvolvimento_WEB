<%-- 
    Document   : Administrador
    Created on : 19/07/2021, 22:26:09
    Author     : re92492
--%>

<%@page import="aplicacao.Administradores"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            <jsp:include page="AdministradorCadastro.jsp" />


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
                        ArrayList<Administradores> ListaAdministradores = (ArrayList<Administradores>) request.getAttribute("listaAdmns");
                        for (int i = 0; i < ListaAdministradores.size(); i++) {
                            Administradores aux = ListaAdministradores.get(i);
                    %>
                    <tr>
                        <th scope="row"><%=aux.getId()%></th>
                        <td><%=aux.getNome()%></td> 
                        <td><%=aux.getCpf()%></td> 
                        <td> 
                            <div>
                                <a type="submit" name="act" value="editar" class="btn btn-primary" href="Administrador?acao=editar&id=<%=aux.getId()%>">Editar</a>
                                <a type="submit" name="act" value="deletar" class="btn btn-danger" href="Administrador?acao=deletar&id=<%=aux.getId()%>">Deletar</a>
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
