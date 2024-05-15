<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Internet"%>
<%
    List<Internet> internet = (List<Internet>)request.getAttribute("internet");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP AVISOS</title>
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
        <h1>Listado de avisos</h1>
        <p><a href="InternetController?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Seminario</th>
                <th>Confirmado</th>
                <th>Fecha inscripción</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${internet}">
            <tr>
                <td>${item.id}</td>
                <td>${item.nombre}</td>
                <td>${item.apellido}</td>
                <td>${item.seminario}</td>
                <td>${item.confirmado}</td>
                <td>${item.fecha}</td>
                <td><a href="InternetController?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="InternetController?action=delete&id=${item.id}">Eliminar</a></td>
            </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
