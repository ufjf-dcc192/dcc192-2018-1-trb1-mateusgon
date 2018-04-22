package br.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/controlador.html", "/funcionamento-mesas.html", "/controle-item.html",
"/ver-pedidos.html", "/fazer-pedido.html", "/remover-mesa.html", "/adicionar-mesa.html"})
public class ControladorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if ("/controlador.html".equals(request.getServletPath()))
       {
           listarInicio(request, response);           
       }
       else if("/controle-item.html".equals(request.getServletPath()))
       {
           controlarItem(request, response);
       }
       else if("/funcionamento-mesas.html".equals(request.getServletPath()))
       {
           controlarMesas(request, response);
       }
       else if("/ver-pedidos.html".equals(request.getServletPath()))
       {
           verPedidos(request, response);
       }
    }

    private void listarInicio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        List<Item> itens = ListaDeItens.getInstance();
        request.setAttribute("itens", itens);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/controlador-listar.jsp");
        despachante.forward(request, response);
    }

    private void controlarItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/controlador-item.jsp");
        despachante.forward(request, response);   
    }

    private void controlarMesas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mesas> mesas = ListaDeMesas.getInstance();
        request.setAttribute("mesas", mesas);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/controlador-mesas.jsp");
        despachante.forward(request, response);
    }

    private void verPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        codigo--;
        List<Mesas> mesas = ListaDeMesas.getInstance();
        List<Pedido> pedidos = mesas.get(codigo).getPedidos();
        request.setAttribute("pedidos", pedidos);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-pedidos.jsp");
        despachante.forward(request, response);
    }
}
