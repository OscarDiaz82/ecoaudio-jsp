package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Medico;
import model.Usuario;
import repository.MedicoRepository;
import repository.UsuarioRepositoryimpl;

@WebServlet("/respuesta")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cedula = request.getParameter("cedula");
        String password = request.getParameter("password");

        Usuario usuario = new Usuario();
        UsuarioRepositoryimpl repository = new UsuarioRepositoryimpl();

        usuario = repository.getByCedula(cedula);
        
        request.setAttribute("nombre", usuario.getNombre());
        
        if (usuario.getCedula().equals(cedula) && usuario.getPassword().equals(password)) {
            request.getRequestDispatcher("respuesta.jsp").forward(request, response);
        }
    }
}
