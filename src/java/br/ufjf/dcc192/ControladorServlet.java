package br.ufjf.dcc192;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/controlador.html", "/funcionamento-mesas.html", "/controle-item.html",
"/ver-pedidos.html", "/fazer-pedido.html", "/itemdopedido.html", "/adicionaritemdopedido.html"})
public class ControladorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("operacaoAdicionarMesa") != null)
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
        else if (request.getParameter("operacaoRemoverMesa") != null)
        {
            response.setContentType("text/html;charset=UTF-8");
            int codigo = Integer.parseInt(request.getParameter("operacaoRemoverMesa"));
            codigo--;
            List<Mesas> mesas = ListaDeMesas.getInstance();
            mesas.remove(codigo);
            response.sendRedirect("funcionamento-mesas.html");
        }
        else if (request.getParameter("operacaoFecharPedido") != null)
        {
            int codigoMesa = Integer.parseInt(request.getParameter("operacaoFecharPedido"));
            response.setContentType("text/html;charset=UTF-8");
            List<Mesas> mesas = ListaDeMesas.getInstance();
            List<Pedido> pedidos = mesas.get(codigoMesa).getPedidos();
            for (Pedido pedido : pedidos) {
                if (pedido.getStatusAberto())
                {
                    pedido.setStatusAberto(false);
                    Calendar c = Calendar.getInstance();
                    Date data = c.getTime();
                    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");     
                    String str = fmt.format(data); 
                    pedido.setFechado(str);
                }
            }
            response.sendRedirect("funcionamento-mesas.html");
        }
        else if(request.getParameter("operacaoAdicionarPedido") != null)
        {
            response.setContentType("text/html;charset=UTF-8");
            boolean haMesa = false;
            int codigoMesa = Integer.parseInt(request.getParameter("operacaoAdicionarPedido"));
            List<Mesas> mesas = ListaDeMesas.getInstance();
            List<Pedido> pedidos = mesas.get(codigoMesa).getPedidos();
            for (Pedido pedido : pedidos) {
                if (pedido.getStatusAberto())
                {
                    haMesa = true;
                    response.sendRedirect("funcionamento-mesas.html");
                }
            }
            if (!haMesa)
            {
                Integer pAux = pedidos.get(pedidos.size()-1).getNumero();
                pAux++;
                Calendar c = Calendar.getInstance();
                Date data = c.getTime();
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");     
                String str = fmt.format(data);            
                Pedido p = new Pedido("Pedido " + pAux, pAux, true, str);
                pedidos.add(p);
            }
            response.sendRedirect("funcionamento-mesas.html");
            
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
       else if("/itemdopedido.html".equals(request.getServletPath()))
       {
           verItemDoPedido(request, response);
       }
       else if("/adicionaritemdopedido.html".equals(request.getServletPath()))
       {
           adicionarItemDoPedido(request, response);
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
        request.setAttribute("numMesa", codigo);
        codigo--;
        List<Mesas> mesas = ListaDeMesas.getInstance();
        List<Pedido> pedidos = mesas.get(codigo).getPedidos();
        request.setAttribute("pedidos", pedidos);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-pedidos.jsp");
        despachante.forward(request, response);
    }

    private void verItemDoPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int numPedido = Integer.parseInt(request.getParameter("codigo"));
       numPedido--;
       int numMesa = Integer.parseInt(request.getParameter("codigo2"));
       List<Mesas> mesas = ListaDeMesas.getInstance();
       List<Pedido> pedidos = mesas.get(numMesa).getPedidos();
       List<ItemDoPedido> idp = pedidos.get(numPedido).getItemDoPedido();
       request.setAttribute("numMesa", numMesa);
       request.setAttribute("numPedido", numPedido);
       request.setAttribute("idp", idp);
       RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-item-do-pedido.jsp");
       despachante.forward(request, response);
    }

    private void adicionarItemDoPedido(HttpServletRequest request, HttpServletResponse response) {
        int numPedido = Integer.parseInt(request.getParameter("codigo"));
        int numMesa = Integer.parseInt(request.getParameter("codigo2"));
        request.setAttribute("numMesa", numMesa);
        request.setAttribute("numPedido", numPedido);
        List<Item> itens = ListaDeItens.getInstance();
        request.setAttribute("itens", itens);
    }
}
