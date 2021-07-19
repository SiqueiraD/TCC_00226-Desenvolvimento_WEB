package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidarLogin", urlPatterns = {"/ValidarLogin"})
public class ValidarLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("LoginForm.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if ((login.equals("111")) && (senha.equals("111"))) // verifica os dados
        {  // retorna para o formulario de login

            // Cria  o objeto Cookie
            Cookie cookieNome = new Cookie("Nome", login);

            //Adiciona os Cookies no reponse
            response.addCookie(cookieNome);
            response.sendRedirect("Sucesso.jsp");

        } else {

            request.setAttribute("mensagem", "Usuário não identificado");
            RequestDispatcher rd = request.getRequestDispatcher("LoginForm.jsp");
            rd.forward(request, response);

        }
    }

}
