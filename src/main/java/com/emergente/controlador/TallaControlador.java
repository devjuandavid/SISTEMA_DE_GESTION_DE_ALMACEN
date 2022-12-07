package com.emergente.controlador;

import com.emergente.dao.TallaDAO;
import com.emergente.dao.TallaDAOimpl;
import com.emergente.modelo.Talla;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TallaControlador", urlPatterns = {"/TallaControlador"})
public class TallaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Talla tal = new Talla();
            int id;
            TallaDAO dao = new TallaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("talla", tal);
                    request.getRequestDispatcher("frmtalla.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_talla"));
                    tal = dao.getById(id);
                    request.setAttribute("talla", tal);
                    request.getRequestDispatcher("frmtalla.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_talla"));
                    dao.delete(id);
                    response.sendRedirect("TallaControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Talla> lista = dao.getAll();
                    request.setAttribute("tallas", lista);
                    request.getRequestDispatcher("tallas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_talla"));
        String medida = request.getParameter("medida");

        Talla tal = new Talla();
        tal.setId_talla(id);
        tal.setMedida(medida);
        TallaDAO dao = new TallaDAOimpl();
        if (id == 0) {
            try {
                //nuevo registro

                dao.insert(tal);

            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            try {
                //edicion de registro
                dao.update(tal);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }

        }
        response.sendRedirect("TallaControlador");
    }

}
