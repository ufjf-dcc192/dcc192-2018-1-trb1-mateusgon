<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-controlador-mesas.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <h1> Mesas </h1>
        <table border="1px">
            <tr>
                <td> Mesas </td>
                <td> Ver pedidos </td>
                <td> Remover mesa </td>
            </tr>
            <c:forEach items="${mesas}" var="mesas" varStatus="numero">
            </tr>        
                    <td> ${mesas} </td>
                    <td> <a href="ver-pedidos.html?codigo=${mesas.numero}"> Ver pedidos </a> </td>
                    <td> 
                        <form method="post"> 
                            <input type="submit" value="Remover mesa"/> 
                            <input type="hidden" value="${mesas.numero}" name="operacaoRemoverMesa"/>
                        </form> 
                    </td>
            </tr>         
            </c:forEach>
        </table>
        <p> 
            <form method="post">
            Adicionar Mesa:  
            <input type="submit" value="Clique aqui"/>
            <input type="hidden" value="${numero.count}" name="operacaoAdicionarMesa"/>
            </form> 
        </p>
        <p> Total Faturado: R$${valor}  </p>
        
<%@include file="jspf/rodape-controlador-mesas.jspf"%>