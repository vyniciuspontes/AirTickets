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
        <style>
        td,th{
            border: 1px solid #dddddd;
            padding: 8px;
        }
        .radio{
            border: 0px;
        }
        div {
            margin: 10px;
        }
    </style>  
    </head>
    <body>
        <form action="SaveAirfareWS" method="post">

        <div>
            <h1>${param.originAirport} > ${param.destinationAirport} </h1>
        </div>
        
        <div>
            <table>
                <tr>
                    <td>Tipo</td>
                    <td>Assento</td>
                    <td>Saida</td>
                    <td>Chegada</td>
                    <td>Preço</td>
                </tr>

            <c:forEach var="airfare" items="${airfareGoList}">
                <tr>
                    <td>
                       ${airfare.airfareProfile.name}
                    </td>
                    <td>${airfare.seatProfile.name}</td>
                    <td>${airfare.flight.departureTime}
                    </td>
                    <td>${airfare.flight.arrivalTime}
                    </td>
                    <td>${airfare.price}
                    </td>
                    <td class="radio" >
                         <input type="radio" name="goGroup" value="${airfare.id}"><br/>
                    </td>
                </tr>
            </c:forEach>
            </table>
        <input type="submit" style="position: absolute; left: -9999px"/>
        </div>
            
        <div>
            <h1>${param.destinationAirport} > ${param.originAirport}</h1>
        </div>
        
        <div>
                
            
            <table>
                <tr>
                    <td>Tipo</td>
                    <td>Assento</td>
                    <td>Saida</td>
                    <td>Chegada</td>
                    <td>Preço</td>
                </tr>
            <c:forEach var="airfare" items="${airfareBackList}">
                <tr>
                    <td>
                     ${airfare.airfareProfile.name}
                    </td>
                    <td>${airfare.seatProfile.name}</td>
                    <td>${airfare.flight.departureTime}
                    </td>
                    <td>${airfare.flight.arrivalTime}
                    </td>
                    <td>${airfare.price}
                    </td>
                    <td class="radio" >
                         <input type="radio" name="backGroup" value="${airfare.id}"><br/>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </div>
        <input type="hidden" name="passangersNumber" value="${param.passangersNumber}">
        <input type="submit" name="Submit">
        </form>
    </body>
</html>
