/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danil
 */
@WebServlet(name = "ValidarLogin", urlPatterns = {"/ValidarLogin"})
public class ValidarLogin extends HttpServlet {

    public static void guardarADM(HttpServletRequest request, HttpServletResponse response,
            String s) {
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            String hash = new BigInteger(1, m.digest()).toString(16);
            
//            Cookie cookieNome = new Cookie("lgndm", hash);
//            response.addCookie(cookieNome);

            HttpSession session = request.getSession();
            session.setAttribute("lgndm", hash);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ValidarLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean verificaADM(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String hash = (String) session.getAttribute("lgndm");
        if(hash != null){
            // TODO: validacao do hash
            return true;
        }
        return false;
    }
}
