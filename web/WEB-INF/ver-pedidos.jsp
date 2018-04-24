<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-ver-pedidos.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
            <c:forEach items="${pedidos}" var="pedido" varStatus="numero">
                    <tr>
                        <td> ${pedido} </td> 
                        <td> ${pedido.aberto}</td>
                        <td> ${pedido.fechado}</td>
                        <td> R$${pedido.valor}</td>
                        <c:choose>
                                <c:when test="${pedido.statusAberto}">
                                    <td> <a href="fecharpedido.html?codigo=${mesa.numero}"> Fechar Pedido </a> </td>
                                    <td>  <a href="itemdopedido.html?codigo=${pedido.numero}&codigo2=${mesa.numero}"> Ver itens </a> </td>
                                </c:when>
                                <c:when test="${!pedido.statusAberto}">
                                        <td> <a href="itemdopedido.html?codigo=${pedido.numero}&codigo2=${mesa.numero}"> Listar pedido </a> </td>
                                        <td>  <a href="funcionamento-mesas.html"> Voltar </a> </td>
                                </c:when>
                        </c:choose>
                    </tr>    
            </c:forEach>
            </table>
        <p> 
            <c:choose>
                <c:when test="${!ped.statusAberto}">
                    <form method="post">  
                    <input type="submit" value="Adicione um novo pedido"/>
                    <input type="hidden" value="${mesa.numero}" name="operacaoAdicionarPedido"/>
                    </form> 
                </c:when>
            </c:choose>
        </p>
                    
        
<%@include file="jspf/rodape-ver-pedidos.jspf"%>