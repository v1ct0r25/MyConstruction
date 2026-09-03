package cl.myconstruction.controller;

import java.io.IOException;

import cl.myconstruction.dao.UsuarioDAO;
import cl.myconstruction.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        Usuario usuarioEncontrado =
                usuarioDAO.validarUsuario(usuario, password);

        if (usuarioEncontrado != null) {

            HttpSession session = request.getSession();

            session.setAttribute("usuario", usuarioEncontrado);

            response.sendRedirect(request.getContextPath() + "/inicio.jsp");

        } else {

            request.setAttribute(
                    "error",
                    "Usuario o contraseña incorrectos."
            );

            request.getRequestDispatcher("login.jsp")
                   .forward(request, response);
        }
    }
}