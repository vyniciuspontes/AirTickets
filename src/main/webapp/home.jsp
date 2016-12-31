<%-- 
    Document   : home
    Created on : 30/12/2016, 16:08:18
    Author     : vyniciuspontes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <style>
            td,th{
                border: 1px solid #dddddd;
                padding: 8px;
            }
        </style>
    </head>
    <body>
        
        <h1>Bem vindo ${sessionScope.loginName}</h1>
        
        <div>
            <h2>Tickets</h2>
            <table>
                <c:forEach var="bookingAirport" items="${bookingAirportList}">
                    <tr>
                        <td>
                            <b>${bookingAirport.airports.get(0).name}
                                > ${bookingAirport.airports.get(1).name}</b><br/>
                            ${bookingAirport.booking.airfare.flight.departureTime}<br/>
                            ${bookingAirport.booking.airfare.airfareProfile.name}<br/>
                            Assento  ${bookingAirport.booking.airfare.seatProfile.name} -
                            ${bookingAirport.booking.seatCode}<br/>
                            ${bookingAirport.booking.passanger.firstName} ${bookingAirport.booking.passanger.lastName}
                            <br/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
