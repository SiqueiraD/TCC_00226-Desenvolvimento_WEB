/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Usuarios;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDAO;

/**
 *
 * @author danil
 */
@WebServlet(name = "Usuario", urlPatterns = {"/Usuario"})
public class UsuarioController extends HttpServlet {

    private ArrayList<Usuarios> lista;

    private void doList(HttpServletRequest request, HttpServletResponse response) {
        try {
            UsuarioDAO usuariodao = new UsuarioDAO();
            ArrayList<Usuarios> _lista = usuariodao.getLista();
            lista = _lista;
            request.setAttribute("listaUsuarios", lista);
            RequestDispatcher rd = request.getRequestDispatcher("Usuario.jsp");
            rd.forward(request, response);
        } catch (Exception e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = (String) request.getParameter("acao");
        UsuarioDAO usuariodao = new UsuarioDAO();
        Usuarios usua = new Usuarios();
        Integer id = 0;

        if (acao != null) {
            switch (acao) {
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    usua = usuariodao.getUsuarioPorID(id);

                    request.setAttribute("editar", true);
                    request.setAttribute("usuario", usua);

                    break;

                case "desativar":
                    id = Integer.parseInt(request.getParameter("id"));
                    usuariodao.alterarSituacao(id, false);

                    break;
                case "ativar":
                    id = Integer.parseInt(request.getParameter("id"));
                    usuariodao.alterarSituacao(id, true);

                    break;

            }
            doList(request, response);
        } else {
            doList(request, response);
        }
//        RequestDispatcher rd = request.getRequestDispatcher("Usuario.jsp");
//        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO usuariodao = new UsuarioDAO();
        String tipo = (String) request.getParameter("tipo");
        Usuarios usus = new Usuarios();
        switch (tipo) {
            case "cadastrar":

                usus.setNome(request.getParameter("nome"));
                usus.setCpf(request.getParameter("login"));
                usus.setSenha(request.getParameter("senha"));
                usus.setSuspenso("N");

                usuariodao.gravar(usus);
                doList(request, response);
                break;
            case "editar":
                String i = request.getParameter("id");
                usus = new Usuarios(Integer.parseInt(i.trim()));

                usus.setNome(request.getParameter("nome"));
                usus.setCpf(request.getParameter("login"));
                usus.setSenha(request.getParameter("senha"));
                usus.setSuspenso("N");

                usuariodao.gravar(usus);
                doList(request, response);
                break;
        }

    }

}
