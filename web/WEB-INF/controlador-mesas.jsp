<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-controlador-mesas.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <h1> Mesas </h1>
        <ul>
            <c:forEach items="${mesas}" var="mesas" varStatus="numero">
                    
                    <li> ${mesas} </li>
                    <a href="ver-pedidos.html?codigo=${numero.count}"> Ver pedidos </a>
                    //
                    <a href="fazer-pedido.html?codigo=${numero.count}"> Fazer pedido </a>
                    <form method="post"> <input type="submit" value="Fechar pedido em aberto"/> 
                    <input type="hidden" value="${numero.count}" name="operacaoFecharPedido"/>
                    </form>
                    <form method="post"> <input type="submit" value="Remover mesa"/> 
                    <input type="hidden" value="${numero.count}" name="operacaoRemoverMesa"/>
                    </form>
                    
            </c:forEach>
        </ul>
        <p> 
            <form method="post">
            Adicionar Mesa:  
            <input type="submit" value="Clique aqui"/>
            </form> 
        </p>
        <p> Total Faturado:  </p>
        
<%@include file="jspf/rodape-controlador-mesas.jspf"%>