<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-controlador-listar.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <h1> Cardápio </h1>
        <ul>
            <c:forEach items="${itens}" var="itens">
                    <li> ${itens} </li>
            </c:forEach>
        </ul>
            
<%@include file="jspf/rodape-controlador-listar.jspf"%>