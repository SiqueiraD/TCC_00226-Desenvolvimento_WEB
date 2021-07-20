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
@WebServlet(name = "Lancamento", urlPatterns = {"/Lancamento"})
public class LancamentoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("nomeUsuario", "Leo Cruz"); 
        request.setAttribute("contaLancamento", "12303-7"); 
        RequestDispatcher rd = request.getRequestDispatcher("Lancamento.jsp");
        rd.forward(request, response);
    }
}
