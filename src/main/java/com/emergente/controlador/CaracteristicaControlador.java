package com.emergente.controlador;

import com.emergente.dao.CaracteristicaDAO;
import com.emergente.dao.CaracteristicaDAOimpl;
import com.emergente.modelo.Caracteristica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CaracteristicaControlador", urlPatterns = {"/CaracteristicaControlador"})
public class CaracteristicaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Caracteristica caract = new Caracteristica();
            int id;
            CaracteristicaDAO dao = new CaracteristicaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("caracteristica", caract);
                    request.getRequestDispatcher("frmcaracteristica.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_caracteristica"));
                    caract = dao.getById(id);
                    request.setAttribute("caracteristica", caract);
                    request.getRequestDispatcher("frmcaracteristica.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_caracteristica"));
                    dao.delete(id);
                    response.sendRedirect("CaracteristicaControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Caracteristica> lista = dao.getAll();
                    request.setAttribute("caracteristicas", lista);
                    request.getRequestDispatcher("caracteristicas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_caracteristica"));
        String tipo = request.getParameter("tipo");

        Caracteristica caract = new Caracteristica();
        caract.setId_caracteristica(id);
        caract.setTipo(tipo);
        
        CaracteristicaDAO dao = new CaracteristicaDAOimpl();
        if (id == 0) {
            try {
                //nuevo registro

                dao.insert(caract);

            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            try {
                //edicion de registro
                dao.update(caract);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }

        }
        response.sendRedirect("CaracteristicaControlador");
    }

}
