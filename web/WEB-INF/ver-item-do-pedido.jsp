<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-ver-item-do-pedido.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% Integer numMesa = (Integer)request.getAttribute("numMesa");
   Integer numPedido = (Integer)request.getAttribute("numPedido");
%>

        <h1> Itens do pedido </h1>
            <table border="1px">  
                    <tr> 
                        <td> Produto </td>
                        <td> Quantidade </td>
                        <td> Valor </td>
                        <td> Opção 1 </td>
                        <td> Opção 2 </td>
                    </tr>
            <c:forEach items="${idp}" var="idp" varStatus="numero">
                    <tr>
                        <td> ${idp.item.nome} </td> 
                        <td> ${idp.quantidade}</td>
                        <td> R$${idp.quantidade * idp.item.valor}</td>
                        <td> <a href="editaritemdopedido.html?codigo=<%=numPedido%>&codigo2=<%=numMesa%>"> Excluir item do pedido </a> </td>
                        <td> <a href="alteraritemdopedido.html?codigo=<%=numPedido%>&codigo2=<%=numMesa%>"> Editar item do pedido </a> </td>
                    </tr>    
            </c:forEach>
            </table>
        <p> 
            <a href="adicionaritemdopedido.html?codigo=<%=numPedido%>&codigo2=<%=numMesa%>"> Adicionar Item ao Pedido </a>
        </p>            
        
<%@include file="jspf/rodape-ver-item-do-pedido.jspf"%>
