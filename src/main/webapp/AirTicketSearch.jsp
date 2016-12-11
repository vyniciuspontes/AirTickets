<%-- 
    Document   : AirTicketSearch
    Created on : 05/12/2016, 13:44:30
    Author     : vyniciuspontes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Air Tickets</title>
    </head>
    <body>
        <form action="adicionaContato">
            Nome: <input type="text" name="nome" /><br/>
            E-mail: <input type="text" name="email" /><br />
            Endereço: <input type="text" name="endereco" /><br />
            Data Nascimento: <input type="text" name="dataNascimento" /><br />
            <input type="submit" value="Gravar" />
        </form>
    </body>
</html>
