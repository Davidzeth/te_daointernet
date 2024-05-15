<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Internet"%>
<%
    Internet internet = (Internet) request.getAttribute("internet");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .contenedor {
                width: 300px; 
                margin: 0 auto; 
                padding: 20px; 
                border: 1px solid #ccc;
                text-align: center;
            }
            .titulo {
                text-align: center;
            }
        </style>   
    </head>
    <body>
        <div class="contenedor">
            <p>PRIMER PARCIAL TEM-742<br>
            Nombre: Deyvid Edilson Chambi Averanga<br>
            Carnet: 11080822</p>
        </div>
        <h1>Nuevo Registro</h1>
        <form action="InternetController" method="post">
            <input type="hidden" name="id" value="${internet.id}"/>
            <table>

                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${internet.nombre}"/></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="${internet.apellido}"/></td>
                </tr>
                <tr>
                    <td>Seminario</td>
                    <td><input type="text" name="seminario" value="${internet.seminario}"/></td>
                </tr>
                <tr>
                    <td>Confirmado</td>
                    <td><input type="checkbox" name="confirmado" <% if (internet.isConfirmado()) { %> checked <% }%>/></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="date" name="fecha" value="${internet.fecha}"/></td>
                    <!-- Cambiar el tipo de input a "date" si deseas una entrada de fecha nativa en el navegador -->
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
