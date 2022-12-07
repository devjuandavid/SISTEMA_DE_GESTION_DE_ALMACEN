package com.emergente.controlador;

import com.emergente.dao.ProveedorDAO;
import com.emergente.dao.ProveedorDAOimpl;
import com.emergente.modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProveedorControlador", urlPatterns = {"/ProveedorControlador"})
public class ProveedorControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Proveedor provee = new Proveedor();
            int id;
            ProveedorDAO dao = new ProveedorDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("proveedor", provee);
                    request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_proveedores"));
                    provee = dao.getById(id);
                    request.setAttribute("proveedor", provee);
                    request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_proveedor"));
                    dao.delete(id);
                    response.sendRedirect("ProveedorControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Proveedor> lista = dao.getAll();
                    request.setAttribute("proveedores", lista);
                    request.getRequestDispatcher("proveedores.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_proveedores"));
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String observaciones = request.getParameter("observaciones");

        Proveedor provee = new Proveedor();
        provee.setId_proveedores(id);
        provee.setNombre(nombre);
        provee.setDireccion(direccion);
        provee.setCiudad(ciudad);
        provee.setTelefono(telefono);
        provee.setCorreo(correo);
        provee.setObservaciones(observaciones);
        ProveedorDAO dao = new ProveedorDAOimpl();
        if (id == 0) {
            try {
                //nuevo registro

                dao.insert(provee);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            try {
                //edicion de registro
                dao.update(provee);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }

        }
        response.sendRedirect("ProveedorControlador");
    }

}
