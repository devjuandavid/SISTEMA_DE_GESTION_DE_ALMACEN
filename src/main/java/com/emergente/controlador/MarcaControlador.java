package com.emergente.controlador;

import com.emergente.dao.MarcaDAO;
import com.emergente.dao.MarcaDAOimpl;
import com.emergente.modelo.Marca;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MarcaControlador", urlPatterns = {"/MarcaControlador"})
public class MarcaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Marca marc = new Marca();
            int id;
            MarcaDAO dao = new MarcaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("marca", marc);
                    request.getRequestDispatcher("frmmarca.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_marcas"));
                    marc = dao.getById(id);
                    request.setAttribute("marca", marc);
                    request.getRequestDispatcher("frmmarca.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_marcas"));
                    dao.delete(id);
                    response.sendRedirect("MarcaControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Marca> lista = dao.getAll();
                    request.setAttribute("marcas", lista);
                    request.getRequestDispatcher("marcas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_marcas"));
        String nombre = request.getParameter("nombre");

        Marca marc = new Marca();
        marc.setId_marcas(id);
        marc.setNombre(nombre);
        MarcaDAO dao = new MarcaDAOimpl();
        if (id == 0) {
            try {
                //nuevo registro

                dao.insert(marc);

            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            try {
                //edicion de registro
                dao.update(marc);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }

        }
        response.sendRedirect("MarcaControlador");
    }

}
