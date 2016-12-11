<%-- 
    Document   : searchAirtickets
    Created on : 05/12/2016, 15:45:06
    Author     : vyniciuspontes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pesquisa de passagens</h1>
        <form action="Server/Service/AirfareWS" method="post">
            Aeroporto de origem: <input type="text" name="originAirport"><br/>
            Aeroporto de partida: <input type="text" name="destinationAirport"><br/>
            Número de pessoas: <input type="number" name="passangersNumber"><br/>
            Date de Ida <input type="date" name="goDate"><br/>
            Date de Volta <input type="date" name="backDate">
            <input type="submit" name="Submit">
        </form>
    </body>
</html>
