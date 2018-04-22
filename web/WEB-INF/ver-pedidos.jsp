<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-ver-pedidos.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <h1> Pedidos </h1>
        <ul>
            <c:forEach items="${pedidos}" var="pedidos" varStatus="numero">
                    
                    <li> ${pedidos} </li>
                    
            </c:forEach>
        </ul>
        
        
<%@include file="jspf/rodape-ver-pedidos.jspf"%>