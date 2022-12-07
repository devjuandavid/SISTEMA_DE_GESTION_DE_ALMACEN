
package com.emergente.controlador;

import com.emergente.utiles.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        
        //verificar los datos
        
        Validate v = new Validate();
        
        if (v.checkUser(usuario, password)) {
            HttpSession ses=request.getSession();
            ses.setAttribute("login", "ok");
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
    }

    

}
