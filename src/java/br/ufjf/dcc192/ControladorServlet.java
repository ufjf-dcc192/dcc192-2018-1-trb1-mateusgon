package br.ufjf.dcc192;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/controlador.html", "/funcionamento-mesas.html", "/fecharpedido.html",
"/ver-pedidos.html", "/fazer-pedido.html", "/itemdopedido.html", "/adicionaritemdopedido.html", "/cardapio.html", "/erro.html"})
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
            Boolean exclusaoLiberada = false;
            response.setContentType("text/html;charset=UTF-8");
            int codigo = Integer.parseInt(request.getParameter("operacaoRemoverMesa"));
            codigo--;
            List<Mesas> mesas = ListaDeMesas.getInstance();
            List<Pedido> pedidos = mesas.get(codigo).getPedidos();
            Integer tamanho = pedidos.size();
            tamanho--;
            if (pedidos.get(tamanho).getStatusAberto())
            {
                response.sendRedirect("erro.html");
            }
            else
            {
                mesas.remove(codigo);
                response.sendRedirect("funcionamento-mesas.html");
            }            
        }
        else if(request.getParameter("operacaoAdicionarPedido") != null)
        {
            response.setContentType("text/html;charset=UTF-8");
            boolean haMesa = false;
            int codigoMesa = Integer.parseInt(request.getParameter("operacaoAdicionarPedido"));
            codigoMesa--;
            List<Mesas> mesas = ListaDeMesas.getInstance();
            List<Pedido> pedidos = mesas.get(codigoMesa).getPedidos();
            for (Pedido pedido : pedidos) {
                if (pedido.getStatusAberto())
                {
                    haMesa = true;
                }
            }
            if (!haMesa)
            {
                Integer numP = pedidos.size();
                numP--;
                Integer pAux = pedidos.get(numP).getNumero();
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
        else if(request.getParameter("operacaoAdicionarItem") != null)
        {
           Integer numMesa = Integer.parseInt(request.getParameter("mesa"));
           Integer numPedido = Integer.parseInt(request.getParameter("pedido"));
           Integer idItem = Integer.parseInt(request.getParameter("itens"));
           Integer qtdd = Integer.parseInt(request.getParameter("quantidade"));
           numMesa--;
           Mesas m = ListaDeMesas.getInstance().get(numMesa);
           Pedido p = m.getPedidos().get(numPedido);
           if (p.getStatusAberto())
           {
                Item i = ListaDeItens.getInstance().get(idItem);
                ItemDoPedido idp = new ItemDoPedido(i, qtdd);
                p.getItemDoPedido().add(idp);
                Double valor = i.getValor() * qtdd + p.getValor();
                p.setValor(valor);
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
       else if("/cardapio.html".equals(request.getServletPath()))
       {
           listarInicio(request, response);
       }
       else if("/fecharpedido.html".equals(request.getServletPath()))
       {
           fecharPedido(request, response);  
       }
       else if("/erro.html".equals(request.getServletPath()))
       {
           listarErro(request, response);
       }
    }

    private void listarInicio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        List<Item> itens = ListaDeItens.getInstance();
        request.setAttribute("itens", itens);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/controlador-listar.jsp");
        despachante.forward(request, response);
    }

    private void controlarMesas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mesas> mesas = ListaDeMesas.getInstance();
        request.setAttribute("mesas", mesas);
        Double valor = calcularRendimento(mesas);
        request.setAttribute("valor", valor);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/controlador-mesas.jsp");
        despachante.forward(request, response);
    }

    private void verPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        codigo--;
        List<Mesas> mesas = ListaDeMesas.getInstance();
        Mesas m = mesas.get(codigo);
        request.setAttribute("mesa", m);
        List<Pedido> pedidos = mesas.get(codigo).getPedidos();
        request.setAttribute("pedidos", pedidos);
        int tam;
        tam = pedidos.size();
        tam--;
        Pedido p = pedidos.get(tam);
        request.setAttribute("ped", p);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-pedidos.jsp");
        despachante.forward(request, response);
    }

    private void verItemDoPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int numPedido = Integer.parseInt(request.getParameter("codigo"));
       int numMesa = Integer.parseInt(request.getParameter("codigo2"));
       numMesa--;
       List<Mesas> mesas = ListaDeMesas.getInstance();
       Mesas m = mesas.get(numMesa);
       List<Pedido> pedidos = mesas.get(numMesa).getPedidos();
       Pedido p = pedidos.get(numPedido);
       List<ItemDoPedido> idp = pedidos.get(numPedido).getItemDoPedido();
       request.setAttribute("mesa", m);
       request.setAttribute("pedido", p);
       request.setAttribute("idp", idp);
       RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-item-do-pedido.jsp");
       despachante.forward(request, response);
    }

    private void adicionarItemDoPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numPedido = Integer.parseInt(request.getParameter("codigo"));
        int numMesa = Integer.parseInt(request.getParameter("codigo2"));
        request.setAttribute("numMesa", numMesa);
        request.setAttribute("numPedido", numPedido);
        List<Item> itens = ListaDeItens.getInstance();
        request.setAttribute("itens", itens); 
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/adicionar-item-ao-pedido.jsp");
        despachante.forward(request, response);
    }

    private Double calcularRendimento(List<Mesas> mesas) {
        Double valor = 0.0;
        for (Mesas mesa : mesas) {
            for (Pedido pedido: mesa.getPedidos())
            {
                valor = valor + pedido.getValor();
            }
        }
        return valor;
    }

    private void fecharPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigoMesa = Integer.parseInt(request.getParameter("codigo"));
        codigoMesa--;
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
        int contador;
        contador = pedidos.size();
        contador--;
        List<ItemDoPedido> idp = pedidos.get(contador).getItemDoPedido();
        request.setAttribute("idp", idp);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/listar-pedido-fechado.jsp");
        despachante.forward(request, response);
    }

    private void listarErro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(404);
    }
}
