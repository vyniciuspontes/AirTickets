<%-- 
    Document   : index
    Created on : 03/12/2016, 19:55:14
    Author     : vyniciuspontes
--%>

<%@page import="com.vpontes.airtickets.model.generated.Passanger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <style>
        td,th{
            border: 1px solid #dddddd;
            padding: 8px;
        }
        input {
            margin: 5px;
        }
    </style>    
    <body>
        
        <div>
            <form action="PassangersRegistrationWS" method="post">
                <table>
            <% 
               //Passanger[] passangers = new Passanger[10]; 
               Integer count = (Integer) request.getSession().getAttribute("passangersNumber");
                       
               for(int i = 0; i < count; i++) {
            %>
                <tr>
                    <td>
                Nome:<% out.print("<input type='text' name='firstName'  value='' /></br>"); %>
                Sobrenome:<% out.print("<input type='text' name='lastName'  value='' /></br>"); %>
                Nacionalidade:<% out.print("<input type='text' name='nationality'  value='' /></br>"); %>
                Identidade:<% out.print("<input type='text' name='identity'  value='' /></br>"); %>
                Passaporte:<% out.print("<input type='text' name='passport'  value='' /></br>"); %>
                Deficiente:<% out.print("<input type='checkbox' name='deficient' value'" + i + "' /></br>"); %>
                Telefone: <% out.print("<input type='text' name='phone'  value='' /></br>"); %>
                Assento Ida: <% out.print("<input type='text' name='seatCodeGo' /></br>"); %>
                Assento Volta: <% out.print("<input type='text' name='seatCodeBack' /></br>"); %>
                <% } %>
                    </td>
                </tr>
                </table>
            <input type="hidden" name="passangersNumber" value="${sessionScope.passangersNumber}">
            <input type="hidden" name="airfareGoId" value="${sessionScope.airfareGoId}">
            <input type="hidden" name="airfareBackId" value="${sessionScope.airfareBackId}">
                <input type="submit" value="Submit" />
            </form>
        </div>
    </body>
</html>
