package com.emergente.controlador;

import com.emergente.dao.EmpleadoDAO;
import com.emergente.dao.EmpleadoDAOimpl;
import com.emergente.dao.UsuarioDAO;
import com.emergente.dao.UsuarioDAOimpl;
import com.emergente.modelo.Empleado;
import com.emergente.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpleadoControlador", urlPatterns = {"/EmpleadoControlador"})
public class EmpleadoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmpleadoDAO dao = new EmpleadoDAOimpl();
            UsuarioDAO daoUsuario = new UsuarioDAOimpl();
            int id;
            List<Usuario> lista_usuarios = null;

            Empleado empleado = new Empleado();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_usuarios = daoUsuario.getAll();

                    request.setAttribute("lista_usuarios", lista_usuarios);

                    request.setAttribute("empleado", empleado);
                    request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_empleados"));
                    empleado = dao.getById(id);

                    lista_usuarios = daoUsuario.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);

                    request.setAttribute("empleado", empleado);
                    request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_empleados"));
                    dao.delete(id);
                    response.sendRedirect("EmpleadoControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Empleado> lista = dao.getAll();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("empleados.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_empleados"));
        String ci = request.getParameter("ci");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String numero = request.getParameter("numero");
        String telefono = request.getParameter("telefono");
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        

        Empleado empleado = new Empleado();

        empleado.setId_empleados(id);
        empleado.setCi(ci);
        empleado.setNombre(nombre);
        empleado.setApellidos(apellidos);
        empleado.setDireccion(direccion);
        empleado.setNumero(numero);
        empleado.setTelefono(telefono);
        empleado.setId_usuario(id_usuario);


        if (id == 0) {
            //Nuevo
            EmpleadoDAO dao = new EmpleadoDAOimpl();
            try {
                // Nuevo registro
                dao.insert(empleado);
                response.sendRedirect("EmpleadoControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            EmpleadoDAO dao = new EmpleadoDAOimpl();
            try {
                dao.update(empleado);
                response.sendRedirect("EmpleadoControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
    }

}
