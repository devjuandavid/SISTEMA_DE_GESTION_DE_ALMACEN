package com.emergente.controlador;

import com.emergente.dao.CompraDAO;
import com.emergente.dao.CompraDAOimpl;
import com.emergente.dao.UsuarioDAO;
import com.emergente.dao.UsuarioDAOimpl;
import com.emergente.modelo.Compra;
import com.emergente.modelo.Usuario;
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

@WebServlet(name = "CompraControlador", urlPatterns = {"/CompraControlador"})
public class CompraControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CompraDAO dao = new CompraDAOimpl();
            UsuarioDAO daoUsuario = new UsuarioDAOimpl();
            int id;
            List<Usuario> lista_usuarios = null;

            Compra compra = new Compra();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_usuarios = daoUsuario.getAll();

                    request.setAttribute("lista_usuarios", lista_usuarios);

                    request.setAttribute("compra", compra);
                    request.getRequestDispatcher("frmcompra.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_compras"));
                    compra = dao.getById(id);

                    lista_usuarios = daoUsuario.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);

                    request.setAttribute("compra", compra);
                    request.getRequestDispatcher("frmcompra.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_compras"));
                    dao.delete(id);
                    response.sendRedirect("CompraControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Compra> lista = dao.getAll();
                    request.setAttribute("compras", lista);
                    request.getRequestDispatcher("compras.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_compras"));
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        Double cantidad = Double.parseDouble(request.getParameter("cantidad")) ;
        int precio = Integer.parseInt(request.getParameter("precio"));
        Double total = Double.parseDouble(request.getParameter("total"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        

        Compra compra = new Compra();

        compra.setId_compras(id);
        compra.setDescripcion(descripcion);
        compra.setFecha(convierteFecha(fecha));
        compra.setCantidad(cantidad);
        compra.setPrecio(precio);
        compra.setTotal(total);
        compra.setId_usuario(id_usuario);


        if (id == 0) {
            //Nuevo
            CompraDAO dao = new CompraDAOimpl();
            try {
                // Nuevo registro
                dao.insert(compra);
                response.sendRedirect("CompraControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            CompraDAO dao = new CompraDAOimpl();
            try {
                dao.update(compra);
                response.sendRedirect("CompraControlador");
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
