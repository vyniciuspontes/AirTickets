<%-- 
    Document   : checkin
    Created on : 31/12/2016, 15:56:43
    Author     : vyniciuspontes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check-in</title>
        <style>
            td,th{
                border: 1px solid #dddddd;
                padding: 8px;
            }
        </style>
    </head>
    <body>
        <h1>Check-in</h1>
        
        <form action="/AirTickets/Server/Service/HomeInformationWS" method="post">
            Passaporte: <input type="number" name="passportNumber">
            <input type="submit" name="form" value="Pesquisar">
        </form>
        
        <c:if test="${requestScope.bookingAirportList != null}">
            
                <table>
                    <c:forEach var="bookingAirport" items="${bookingAirportList}">
                        <tr>
                            <td>
                            <form action="/AirTickets/Server/Service/SaveAndPrintWS" method="post">
                                <b>${bookingAirport.airports.get(0).name}
                                    > ${bookingAirport.airports.get(1).name}</b><br/>
                                ${bookingAirport.booking.airfare.flight.departureTime}<br/>
                                ${bookingAirport.booking.airfare.airfareProfile.name}<br/>
                                Assento  ${bookingAirport.booking.airfare.seatProfile.name} -
                                <input type="text" name="newSeatCode" value="${bookingAirport.booking.seatCode}"> <br/>
                                ${bookingAirport.booking.passanger.firstName} ${bookingAirport.booking.passanger.lastName}
                                <br/>
                                <input type="hidden" name="passangerId" value="${bookingAirport.booking.id.passangerId}">
                                <input type="hidden" name="airfareId" value="${bookingAirport.booking.id.airfareId}">
                                <input type="submit" name="otherForm" value="Salvar e Imprimir">
                            </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                
        </c:if>
        
    </body>
</html>
