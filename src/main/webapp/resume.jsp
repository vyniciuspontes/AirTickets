<%-- 
    Document   : showSelectedTickets
    Created on : 27/12/2016, 19:54:07
    Author     : vyniciuspontes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selected Airfares</title>
    </head>
    <body>
        
        <h1>Resumo</h1>
        <h2>Ida</h2>
        <p>${originAirport.name} > ${destinationAirport.name} (${originAirfare.airfareProfile.name}) - R$${originAirfare.price} x${passangersNumber}</p>
        <p>Taxa de Embarque: R$${originAirport.boardingFee} - x${passangersNumber}</p>
        <hr>
        <h2>Volta</h2>
        <p>${destinationAirport.name} > ${originAirport.name} (${destinationAirfare.airfareProfile.name}) - R$${destinationAirfare.price} x${passangersNumber}</p>
        <p>Taxa de Embarque: R$${destinationAirport.boardingFee} - x${passangersNumber}</p>
        <hr>
        <p>Total: R$ ${requestScope.totalPrice}</p>
        
        
        
        <form action="PaymentWS" method="post">
            Cartao de Credito <input type="number" name="creditCardNumber">
            <input type="submit">
        </form>
    </body>
</html>
