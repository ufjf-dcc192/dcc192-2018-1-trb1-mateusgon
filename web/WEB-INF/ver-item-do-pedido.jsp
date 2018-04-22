<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-ver-pedidos.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% Integer numMesa = (Integer)request.getAttribute("numMesa");
   Integer numPedido = (Integer)request.getAttribute("numPedido");
%>

        <h1> Pedidos </h1>
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
                        <td> </td>
                        <td> </td>
                    </tr>    
            </c:forEach>
            </table>
                    
        
<%@include file="jspf/rodape-ver-pedidos.jspf"%>
