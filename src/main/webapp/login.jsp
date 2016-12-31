<%-- 
    Document   : login
    Created on : 28/12/2016, 20:22:44
    Author     : vyniciuspontes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            input{
                margin-bottom: 10px;
            }
        </style>
         
    </head>
    <body>
        <h1>Login</h1>
        <div>
            <form action="/AirTickets/Server/Service/LoginWS" method="post">
                Email:<br>
                <input type="email" name="email" placeholder="insira seu email"><br/>
                Senha:<br>
                <input type="password" name="password"><br/>
                <input type="submit" value="Entrar">
            </form>
            
            <p>${errorCode}</p>
        </div>
        
    </body>
</html>
