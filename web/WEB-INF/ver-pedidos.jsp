<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-ver-pedidos.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% Integer codigo = (Integer)request.getAttribute("numMesa");
   codigo--;
%>

        <h1> Pedidos </h1>
            <table border="1px">  
                    <tr> 
                        <td> Nome </td>
                        <td> Data de abertura </td>
                        <td> Data de fechamento </td>
                        <td> Valor do pedido </td>
                        <td> Opção 1 </td>
                        <td> Opção 2 </td>
                    </tr>
            <c:forEach items="${pedidos}" var="pedidos" varStatus="numero">
                    <tr>
                        <td> ${pedidos} </td> 
                        <td> ${pedidos.aberto}</td>
                        <td> ${pedidos.fechado}</td>
                        <td> R$${pedidos.valor}</td>
                        <td> 
                            <form method="post"> 
                                <input type="submit" value="Fechar pedido"/> 
                                <input type="hidden" value="<%=codigo%>" name="operacaoFecharPedido"/>
                            </form>
                        </td>
                        <td>  <a href="itemdopedido.html?codigo=${numero.count}&codigo2=<%=codigo%>"> Ver itens </a> </td>
                    </tr>    
            </c:forEach>
            </table>
        <p> 
            <form method="post">  
            <input type="submit" value="Adicione um novo pedido"/>
            <input type="hidden" value="<%=codigo%>" name="operacaoAdicionarPedido"/>
            </form> 
        </p>
                    
        
<%@include file="jspf/rodape-ver-pedidos.jspf"%>