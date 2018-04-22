package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/controlador.html"})
public class ControladorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if ("/controlador.html".equals(request.getServletPath()))
       {
           listarInicio(request, response);           
       }
       else if("/controle-item.html".equals(request.getServletPath()))
       {
           
       }
       else if("/funcionamento-pedido.html".equals(request.getServletPath()))
       {
           
       }
    }

    private void listarInicio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/controlador-listar.jsp");
        despachante.forward(request, response);
    }
}
