<%-- 
    Document   : Categoria
    Created on : 19/07/2021, 22:54:36
    Author     : re92492
--%>
<%@page import="aplicacao.Categorias"%>
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

     
            <div class="col-6 mt-5">

                <%
                    if (request.getAttribute("mensagem") != null) {
                         String mensagem = (String) request.getAttribute("mensagem");
                       %>
                        <div class="alert alert-danger" role="alert">
                            <%= mensagem%>
                        </div>
                <%  }%>  
                
                <jsp:include page="CategoriaCadastro.html" />
                
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">NOME</th>
                            <th scope="col">DESCRIÇÃO</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Categorias> ListaCategorias = (ArrayList<Categorias>) request.getAttribute("listaCategorias");
                            for (int i=0; i < ListaCategorias.size(); i++){
                                Categorias aux = ListaCategorias.get(i);
                            
                        %>
                        <tr>
                            <th scope="row"><%=aux.getId()%></th>
                            <td><%=aux.getDescricao()%>
                            <td>
                                <div>
                                    <a type="submit" class="btn btn-primary" href="Categoria?acao=editar&id=<%=aux.getId()%>">Editar</a>
                                    <a type="submit" class="btn btn-primary" href="Categoria?acao=deletar&id=<%=aux.getId()%>">Deletar</a>
                                </div>
                            </td>
                            
                        </tr>
                        
                        <%
                           }
                        %>

                        
                    </tbody>
                </table>
                 
            </div>
        </div>

        <%@include file="Scripts_basicos.html" %>
    </body>
</html>
