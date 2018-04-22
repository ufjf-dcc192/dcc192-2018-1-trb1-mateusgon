package br.ufjf.dcc192;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/controlador.html", "/funcionamento-mesas.html", "/controle-item.html",
"/ver-pedidos.html", "/fazer-pedido.html",})
public class ControladorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("operacaoFecharPedido") == null && request.getParameter("operacaoRemoverMesa") == null)
        {            
            response.setContentType("text/html;charset=UTF-8");
            int numMesa;
            List<Mesas> mesas = ListaDeMesas.getInstance();
            if (mesas.size() > 0)
            {
                numMesa = mesas.get((mesas.size()-1)).getNumero();
                numMesa++;
            }
            else
            {
                numMesa = 1;
            }
            Mesas mesa = new Mesas("Mesa " + numMesa, numMesa);
            mesas.add(mesa);
            response.sendRedirect("funcionamento-mesas.html");
        }
        else if (request.getParameter("operacaoFecharPedido") == null)
        {
            response.setContentType("text/html;charset=UTF-8");
            int codigo = Integer.parseInt(request.getParameter("operacao"));
            System.out.println(codigo);
            codigo--;
            List<Mesas> mesas = ListaDeMesas.getInstance();
            mesas.remove(codigo);
            response.sendRedirect("funcionamento-mesas.html");
        }
        else if (request.getParameter("operacaoRemoverMesa") == null)
        {
            
        }
    
    }

    
    
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
       else if("/fazer-pedido.html".equals(request.getServletPath()))
       {
           fazerPedido(request, response);
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

    private void fazerPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        codigo--;
        List<Mesas> mesas = ListaDeMesas.getInstance();
        List<Pedido> pedidos = mesas.get(codigo).getPedidos();
        if (pedidos == null)
        {
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-pedidos.jsp");
            despachante.forward(request, response);
        }
        else
        {
            for (Pedido pedido : pedidos) {
                if (pedido.getStatusAberto() == true)
                {
                    request.setAttribute("pedido", pedido);
                }
            }
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-pedidos.jsp");
            despachante.forward(request, response);
        }
    }
    

}
