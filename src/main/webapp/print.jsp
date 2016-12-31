<%-- 
    Document   : print
    Created on : 31/12/2016, 19:25:31
    Author     : vyniciuspontes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Imprimir Bilhete</title>
        <style>
            td,th{
                border: 1px solid #dddddd;
                padding: 8px;
            }
        </style>
    </head>
    <body>
        <h1>Boa Viagem ${bookingAirport.booking.passanger.firstName} !</h1>
        <table>
        <tr>
            <td>
                <b>${bookingAirport.airports.get(0).name}
                    > ${bookingAirport.airports.get(1).name}</b><br/>
                ${bookingAirport.booking.airfare.flight.departureTime}<br/>
                ${bookingAirport.booking.airfare.airfareProfile.name}<br/>
                Assento  ${bookingAirport.booking.airfare.seatProfile.name} - ${bookingAirport.booking.seatCode}<br/>
                ${bookingAirport.booking.passanger.firstName} ${bookingAirport.booking.passanger.lastName}
                <br/>
            </form>
            </td>
        </tr>
        </table>
    </body>
</html>
