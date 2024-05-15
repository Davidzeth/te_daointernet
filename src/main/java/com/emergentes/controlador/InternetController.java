package com.emergentes.controlador;

import com.emergentes.dao.InternetDAO;
import com.emergentes.dao.InternetDAOimpl;
import com.emergentes.modelo.Internet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InternetController", urlPatterns = {"/InternetController"})
public class InternetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        InternetDAO dao = new InternetDAOimpl();

        Internet inter = new Internet();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("internet", inter);
                request.getRequestDispatcher("frminternet.jsp").forward(request, response);
                break;

            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    inter = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro" + ex.getMessage());
                }
                request.setAttribute("internet", inter);
                request.getRequestDispatcher("frminternet.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar" + ex.getMessage());

                }
                response.sendRedirect("InternetController");
                break;

            case "view":
                List<Internet> lista = new ArrayList<Internet>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(InternetController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("internet", lista);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String seminario = request.getParameter("seminario");
        boolean confirmado = Boolean.valueOf(request.getParameter("confirmado") != null);
        String fecha = request.getParameter("fecha");

        Internet inter = new Internet();

        inter.setId(id);
        inter.setNombre(nombre);
        inter.setApellido(apellido);
        inter.setSeminario(seminario);
        inter.setConfirmado(confirmado);
        inter.setFecha(fecha);

        InternetDAO dao = new InternetDAOimpl();

        if (id == 0) {
            try {
                //nuevo
                dao.insert(inter);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            try {
                //edicion
                dao.update(inter);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("InternetController");
    }
}
