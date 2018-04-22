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
                    //
                    <a href="fechar-pedido.html?codigo=${numero.count}"> Fechar conta </a>
                    //
                    <a href="remover-mesa.html?codigo=${numero.count}"> Remover mesa </a>
            </c:forEach>
        </ul>
        <p> <a href="adicionar-mesa.html"> Adicionar uma mesa </a> </p>
        <p> <a href="total-faturado.html"> Total Faturado </a> </p>    
<%@include file="jspf/rodape-controlador-mesas.jspf"%>