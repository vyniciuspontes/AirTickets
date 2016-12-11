<%-- 
    Document   : newjsp
    Created on : 05/12/2016, 14:35:28
    Author     : vyniciuspontes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airfare List</title>
    </head>
    <body>
        
        <table>
        <!-- percorre contatos montando as linhas da tabela -->
        <c:forEach var="airfare" items="${airfareList}">
            <tr>
                <td>Type: ${airfare.airfareProfile.name}</td>
                <td>Seat: ${airfare.seatProfile.name}</td>
            </tr>
        </c:forEach>
            <c:forEach var="airportFlight" items="${airportFlights}">
                <tr>
                    <td>Type: ${airportFlight.airport.name}</td>
                    <td>Type: ${airportFlight.airportFlightProfile.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
