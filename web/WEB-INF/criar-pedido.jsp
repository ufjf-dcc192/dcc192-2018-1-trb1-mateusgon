<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-criar-pedido.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<% Integer codigo = (Integer)request.getAttribute("codigo"); %>

        <h1> Pedido </h1>
        <table>
            <c:forEach items="${itens}" var="itens" varStatus="numero">
                <tr> <td> ${itens} </td> 
                <td> <label>  <input name="quantidade ${numero.count}" /> </label>  </td> </tr>
            </c:forEach>
        </table>        
        <form method="post"> <input type="submit" value="Registrar Itens"/> 
        <input type="hidden" value="<%=codigo%>" name="operacaoRegistrarItem"/> </form>
        
<%@include file="jspf/rodape-criar-pedido.jspf"%>