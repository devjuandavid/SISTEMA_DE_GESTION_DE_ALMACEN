package com.emergente.controlador;

import com.emergente.dao.CompraDAO;
import com.emergente.dao.CompraDAOimpl;
import com.emergente.dao.ProveedorDAO;
import com.emergente.dao.ProveedorDAOimpl;
import com.emergente.dao.TipoDAO;
import com.emergente.dao.TipoDAOimpl;
import com.emergente.modelo.Compra;
import com.emergente.modelo.Proveedor;
import com.emergente.modelo.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TipoControlador", urlPatterns = {"/TipoControlador"})
public class TipoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TipoDAO dao = new TipoDAOimpl();
            ProveedorDAO daoProveedor = new ProveedorDAOimpl();
            CompraDAO daoCompra = new CompraDAOimpl();
            int id;
            List<Proveedor> lista_proveedores = null;
            List<Compra> lista_compras = null;

            Tipo tip = new Tipo();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_proveedores = daoProveedor.getAll();
                    lista_compras = daoCompra.getAll();
                    request.setAttribute("lista_proveedores", lista_proveedores);
                    request.setAttribute("lista_compras", lista_compras);
                    request.setAttribute("tipo", tip);
                    request.getRequestDispatcher("frmtipo.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_tipo"));
                    tip = dao.getById(id);

                    lista_proveedores = daoProveedor.getAll();
                    lista_compras = daoCompra.getAll();
                    request.setAttribute("lista_proveedores", lista_proveedores);
                    request.setAttribute("lista_compras", lista_compras);

                    request.setAttribute("tipo", tip);
                    request.getRequestDispatcher("frmtipo.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_tipo"));
                    dao.delete(id);
                    response.sendRedirect("TipoControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Tipo> lista = dao.getAll();
                    request.setAttribute("tipos", lista);
                    request.getRequestDispatcher("tipos.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id_tipo"));
        String nombre = request.getParameter("nombre");
        String detalle = request.getParameter("detalle");
        int id_proveedores = Integer.parseInt(request.getParameter("id_proveedores"));
        int id_compras = Integer.parseInt(request.getParameter("id_compras"));

        Tipo tip = new Tipo();

        tip.setId_tipo(id);
        tip.setNombre(nombre);
        tip.setDetalle(detalle);
        tip.setId_compras(id_compras);
        tip.setId_proveedores(id_proveedores);

        if (id == 0) {
            //Nuevo
            TipoDAO dao = new TipoDAOimpl();
            try {
                // Nuevo registro
                dao.insert(tip);
                response.sendRedirect("TipoControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            TipoDAO dao = new TipoDAOimpl();
            try {
                dao.update(tip);
                response.sendRedirect("TipoControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
    }

}
