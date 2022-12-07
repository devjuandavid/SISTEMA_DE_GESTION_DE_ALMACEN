package com.emergente.controlador;

import com.emergente.dao.ProductoDAO;
import com.emergente.dao.ProductoDAOimpl;
import com.emergente.dao.Producto_tallaDAO;
import com.emergente.dao.Producto_tallaDAOimpl;
import com.emergente.dao.TallaDAO;
import com.emergente.dao.TallaDAOimpl;
import com.emergente.modelo.Producto;
import com.emergente.modelo.Producto_talla;
import com.emergente.modelo.Talla;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Producto_tallaControlador", urlPatterns = {"/Producto_tallaControlador"})
public class Producto_tallaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Producto_tallaDAO dao = new Producto_tallaDAOimpl();
            ProductoDAO daoProducto = new ProductoDAOimpl();
            TallaDAO daoTalla = new TallaDAOimpl();
            int id;
            List<Producto> lista_productos = null;
            List<Talla> lista_tallas = null;

            Producto_talla protal = new Producto_talla();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_productos = daoProducto.getAll();
                    lista_tallas = daoTalla.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_tallas", lista_tallas);
                    request.setAttribute("producto_talla", protal);
                    request.getRequestDispatcher("frmproducto_talla.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_producto_talla"));
                    protal = dao.getById(id);

                    lista_productos = daoProducto.getAll();
                    lista_tallas = daoTalla.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_tallas", lista_tallas);

                    request.setAttribute("producto_talla", protal);
                    request.getRequestDispatcher("frmproducto_talla.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_producto_talla"));
                    dao.delete(id);
                    response.sendRedirect("Producto_tallaControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Producto_talla> lista = dao.getAll();
                    request.setAttribute("producto_tallas", lista);
                    request.getRequestDispatcher("producto_tallas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_producto_talla"));
        int id_talla = Integer.parseInt(request.getParameter("id_talla"));
        int id_producto = Integer.parseInt(request.getParameter("id_producto"));

        Producto_talla protal = new Producto_talla();

        protal.setId_producto_talla(id);
        protal.setId_producto(id_producto);
        protal.setId_talla(id_talla);

        if (id == 0) {
            //Nuevo
            Producto_tallaDAO dao = new Producto_tallaDAOimpl();
            try {
                // Nuevo registro
                dao.insert(protal);
                response.sendRedirect("Producto_tallaControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            Producto_tallaDAO dao = new Producto_tallaDAOimpl();
            try {
                dao.update(protal);
                response.sendRedirect("Producto_tallaControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
    }

}
