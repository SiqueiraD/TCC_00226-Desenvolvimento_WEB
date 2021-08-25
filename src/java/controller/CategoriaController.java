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
import aplicacao.Categorias;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoriaDAO;

@WebServlet(name = "Categoria", urlPatterns = {"/Categoria"})
public class CategoriaController extends HttpServlet {

    private ArrayList<Categorias> lista;

    private void doList(HttpServletRequest request, HttpServletResponse response) {
        try {
            CategoriaDAO categoriadao = new CategoriaDAO();
            ArrayList<Categorias> _lista = categoriadao.getLista();
            lista = _lista;
            request.setAttribute("listaCategorias", lista);
            RequestDispatcher rd = request.getRequestDispatcher("Categoria.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = (String) request.getParameter("acao");
        CategoriaDAO categoriadao = new CategoriaDAO();
        Categorias categ = new Categorias();
        Integer id = 0;

        if (acao != null) {
            switch (acao) {
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    categ = categoriadao.getCategoriaPorID(id);

                    request.setAttribute("editar", true);
                    request.setAttribute("categoria", categ);

                    break;

                case "deletar":
                    id = Integer.parseInt(request.getParameter("id"));
                    categoriadao.excluir(id);

                    break;
            }
            doList(request, response);
        }

        ArrayList<Categorias> listaCat = categoriadao.getLista();
        request.setAttribute("listaCat", listaCat);
        RequestDispatcher rd = request.getRequestDispatcher("Categoria.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriaDAO categoriadao = new CategoriaDAO();

        RequestDispatcher rd = request.getRequestDispatcher("Categoria.jsp");
        rd.forward(request, response);

    }

}
