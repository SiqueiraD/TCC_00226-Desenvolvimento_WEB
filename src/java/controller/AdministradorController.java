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
    
    private ArrayList<Administradores> lista;
    
    private void doList(HttpServletRequest request, HttpServletResponse response) {
        try {
            AdministradorDAO administradordao = new AdministradorDAO();
            ArrayList<Administradores> listaAdmns = administradordao.getLista();
            lista = listaAdmns;
            request.setAttribute("listaAdmns", lista);
            RequestDispatcher rd = request.getRequestDispatcher("Administrador.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = (String) request.getParameter("acao");
        AdministradorDAO administradordao = new AdministradorDAO();
        
        if (ValidarLogin.verificaADM(request, response)) {
            if (acao != null) {
                switch (acao) {
                    case "editar":
                        Integer id = Integer.parseInt(request.getParameter("id"));
                        Administradores admin = administradordao.getAdministradorPorID(id);
                        
                        request.setAttribute("editar", true);
                        request.setAttribute("admin", admin);
                        
                        doList(request, response);
                        break;
                    
                    case "cadastroUsuario":
                        break;
                    
                    case "cadastroAdministrador":
                        break;
                    
                    case "cadastroCategoria":
                        break;
                    
                }
            } else {
                doList(request, response);
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
                    doList(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("Categoria.jsp");
                    rd.forward(request, response);
                }
                
                break;
            
            case "cadastroAdministrador":
                if (ValidarLogin.verificaADM(request, response)) {
                    Administradores administrador = new Administradores();
                    
                    administrador.setNome(request.getParameter("nome"));
                    administrador.setCpf(request.getParameter("login"));
                    administrador.setSenha(request.getParameter("senha"));
                    
                    administradordao.gravar(administrador);
                    doList(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("LoginAdmin.jsp");
                    rd.forward(request, response);
                }
                // TODO codigo cadastro
                break;
            case "editarAdministrador":
                if (ValidarLogin.verificaADM(request, response)) {
                    Administradores administrador = new Administradores();
                    
                    administrador.setNome(request.getParameter("nome"));
                    administrador.setCpf(request.getParameter("login"));
                    administrador.setSenha(request.getParameter("senha"));
                    
                    String i = request.getParameter("id");
                    administrador.setId(Integer.parseInt(i.trim()));
                    administradordao.gravar(administrador);
                    doList(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("LoginAdmin.jsp");
                    rd.forward(request, response);
                }
                break;
        }
    }
}
