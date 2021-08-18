/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danil
 */
@WebServlet(name = "Conta", urlPatterns = {"/Conta"})
public class ContaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("nomeUsuario", "Leo Cruz");
        RequestDispatcher rd = request.getRequestDispatcher("Conta.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String mensagem;

        try {

            mensagem = (String) request.getParameter("banco");
            RequestDispatcher rd = request.getRequestDispatcher("Conta.jsp");
            rd.forward(request, response);

        } catch (IOException | ServletException e) {
            mensagem = "Erro ao gravar usuário!";
//            request.setAttribute("mensagem", mensagem);
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
//            rd.forward(request, response);

            String nome = (String) request.getAttribute("banco");
            RequestDispatcher rd = request.getRequestDispatcher("Conta.jsp");
            rd.forward(request, response);
        }

    }
}
