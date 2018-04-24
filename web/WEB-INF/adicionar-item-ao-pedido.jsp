<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="jspf/cabecalho-adicionar-item-ao-pedido.jspf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <h1> Itens </h1>
        <form method="post">    
            <p> Itens: </p>
            <select id="itens" name="itens">
            <c:forEach items="${itens}" var="itens">
                <option value="${itens.id}"> Item: ${itens.nome}, Tipo: ${itens.tipoItem}, Valor: ${itens.valor} </option>
            </c:forEach>
            </select>
            <p> Quantidade: </p>
            <input type="text" name="quantidade" id="quantidade"/>
            <p> Mesa </p>
            <input type="text" name="mesa" id="mesa" value="${numMesa}" />
            <p> Pedido </p>
            <input type="text" name="pedido" id="pedido" value="${numPedido}" />
            <p> <input type="hidden" name="operacaoAdicionarItem" value="incluir">
                <input type="submit" value="Adicionar"> </p>
        </form>            
        
<%@include file="jspf/rodape-adicionar-item-ao-pedido.jspf"%>
