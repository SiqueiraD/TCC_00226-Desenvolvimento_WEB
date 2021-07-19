<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Cabecalho.html" %>
    </head>
    <body>
        <div class="container mt-2">
            
            <%@include file="Titulo.jsp" %>           
            <h4>Resposta</h4>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                boolean achou_visitante = false;
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("Nome")) {
                        out.println("<b>Login: </b> " + cookies[i].getValue());
                        out.println("<br>");
                        achou_visitante = true;
                    }
                }
                if (!achou_visitante) {
                    out.println("Sem cookies");
                    out.println("<br>");
                }
            } else {
                out.println("Sem cookies");
                out.println("<br>");
            }
        %>
             
        </div>
                   
        <%@include file="Scripts_basicos.html" %>  
    </body>
</html>