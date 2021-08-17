/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Administradores;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdministradorDAO;

/**
 *
 * @author pedro
 */
@WebServlet(name = "Administrador", urlPatterns = {"/Administrador"})
public class AdministradorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String acao = (String) request.getParameter("acao");
        AdministradorDAO administradordao = new AdministradorDAO();

        if (ValidarLogin.verificaADM(request, response)) {
            if (acao != null) {
                switch (acao) {
                    case "logar":
                        RequestDispatcher rd = request.getRequestDispatcher("LoginAdmin.jsp");
                        rd.forward(request, response);
                        break;

                    case "cadastroUsuario":
                        break;

                    case "cadastroAdministrador":
                        if (cookies.length > 0) {
                            RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/Administrador.jsp");
                            mostrar.forward(request, response);
                        } else {
                            RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/LoginAdmin.jsp");
                            mostrar.forward(request, response);
                        }
                        break;

                    case "cadastroCategoria":
                        break;

                }
            } else {
                ArrayList<Administradores> listaAdmns = administradordao.getLista();
                request.setAttribute("listaAdmns", listaAdmns); 
                RequestDispatcher rd = request.getRequestDispatcher("Administrador.jsp");
                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("LoginAdmin.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        AdministradorDAO administradordao = new AdministradorDAO();

        String tipo = (String) request.getParameter("tipo");

        switch (tipo) {
            case "login":
                String login = (String) request.getParameter("login");
                String senha = (String) request.getParameter("senha");
                Boolean logado = administradordao.login(login, senha);

                if (logado) {
                    ValidarLogin.guardarADM(request, response, login);
//                    Cookie cookieNome = new Cookie("lgndm", login);
//                    response.addCookie(cookieNome);
                    RequestDispatcher rd = request.getRequestDispatcher("Categoria.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("Categoria.jsp");
                    rd.forward(request, response);
                }

                break;

            case "cadastroAdministrador":
                ValidarLogin.verificaADM(request, response);
                break;

        }

    }
}
