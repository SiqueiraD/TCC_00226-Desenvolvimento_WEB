/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author re92492
 */


import aplicacao.Administradores;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Categoria", urlPatterns = {"/Categoria"})
public class CategoriaController extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO = categoriadao = new CategoriaDAO();
        
        
       ArrayList<Categorias> listaCat = categoriadao.getLista();
       request.setAttribute("listaCat", listaCat); 
       RequestDispatcher rd = request.getRequestDispatcher("Categoria.jsp");
       rd.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        CategoriaDAO = categoriadao = new CategoriaDAO();

        RequestDispatcher rd = request.getRequestDispatcher("Categoria.jsp");
        rd.forward(request, response);
        
    }
    
    
}