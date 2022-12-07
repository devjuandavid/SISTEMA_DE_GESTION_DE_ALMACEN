package com.emergente.controlador;

import com.emergente.dao.UsuarioDAO;
import com.emergente.dao.UsuarioDAOimpl;
import com.emergente.dao.VentaDAO;
import com.emergente.dao.VentaDAOimpl;
import com.emergente.modelo.Usuario;
import com.emergente.modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            VentaDAO dao = new VentaDAOimpl();
            UsuarioDAO daoUsuario = new UsuarioDAOimpl();
            int id;
            List<Usuario> lista_usuarios = null;

            Venta venta = new Venta();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_usuarios = daoUsuario.getAll();

                    request.setAttribute("lista_usuarios", lista_usuarios);

                    request.setAttribute("venta", venta);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_ventas"));
                    venta = dao.getById(id);

                    lista_usuarios = daoUsuario.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);

                    request.setAttribute("venta", venta);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_ventas"));
                    dao.delete(id);
                    response.sendRedirect("VentaControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Venta> lista = dao.getAll();
                    request.setAttribute("ventas", lista);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_ventas"));
        String cliente = request.getParameter("cliente");
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

        Venta vent = new Venta();

        vent.setId_ventas(id);
        vent.setCliente(cliente);
        vent.setDescripcion(descripcion);
        vent.setFecha(convierteFecha(fecha));
        vent.setId_usuario(id_usuario);

        if (id == 0) {
            //Nuevo
            VentaDAO dao = new VentaDAOimpl();
            try {
                // Nuevo registro
                dao.insert(vent);
                response.sendRedirect("VentaControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            VentaDAO dao = new VentaDAOimpl();
            try {
                dao.update(vent);
                response.sendRedirect("VentaControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
    }

    public Date convierteFecha(String fecha) {
        Date fechaBD = null;

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechaTMP;
        try {

            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return fechaBD;
    }
}
