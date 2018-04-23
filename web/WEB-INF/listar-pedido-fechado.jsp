<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-ver-item-do-pedido.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <h1> Itens do pedido </h1>
            <table border="1px">  
                    <tr> 
                        <td> Produto </td>
                        <td> Quantidade </td>
                        <td> Valor </td>
                    </tr>
            <c:forEach items="${idp}" var="idp" varStatus="numero">
                    <tr>
                        <td> ${idp.item.nome} </td> 
                        <td> ${idp.quantidade}</td>
                        <td> R$${idp.quantidade * idp.item.valor}</td>
                    </tr>    
            </c:forEach>
            </table>
        
<%@include file="jspf/rodape-ver-item-do-pedido.jspf"%>