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
        <title>JSP Page</title>
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
            <form action="/AirTickets/Service">
                <table>
            <% 
               //Passanger[] passangers = new Passanger[10]; 
                       
               for(int i = 0; i < 10; i++) {
            %>
                <tr>
                    <td>
                Nome:<% out.print("<input type='text' name='firstName'  value='" + i + "' /></br>"); %>
                Sobrenome:<% out.print("<input type='text' name='lastName'  value='" + i + "' /></br>"); %>
                Nacionalidade:<% out.print("<input type='text' name='nationality'  value='" + i + "' /></br>"); %>
                Identidade:<% out.print("<input type='text' name='identity'  value='" + i + "' /></br>"); %>
                Passaporte:<% out.print("<input type='text' name='passport'  value='" + i + "' /></br>"); %>
                Deficiente:<% out.print("<input type='checkbox' name='deficient'  value='" + false + "' /></br>"); %>
            <% } %>
                    </td>
                </tr>
                </table>
                <input type="submit" value="Submit" />
            </form>
        </div>
    </body>
</html>
