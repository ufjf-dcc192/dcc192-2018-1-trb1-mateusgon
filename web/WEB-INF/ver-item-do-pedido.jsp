<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-ver-item-do-pedido.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                        <c:choose>
                                <c:when test="${pedido.statusAberto}">
                                    <td> <a href="removeritemdopedido.html?codigo=${pedido.numero}&codigo2=${mesa.numero}"> Excluir item do pedido </a> </td>
                                    <td> <a href="alteraritemdopedido.html?codigo=${pedido.numero}&codigo2=${mesa.numero}"> Editar item do pedido </a> </td>
                                </c:when>
                                <c:when test="${!pedido.statusAberto}">
                                        <td> Pedido fechado </td>
                                        <td>  <a href="funcionamento-mesas.html"> Voltar </a> </td>
                                </c:when>
                        </c:choose>
                    </tr>    
            </c:forEach>
            </table>
        <p> 
            <c:choose>
                <c:when test="${pedido.statusAberto}">
                    <a href="adicionaritemdopedido.html?codigo=${pedido.numero}&codigo2=${mesa.numero}"> Adicionar Item ao Pedido </a>
                </c:when>
            </c:choose>
        </p>            
        
<%@include file="jspf/rodape-ver-item-do-pedido.jspf"%>
