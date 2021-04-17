<%@page import="com.emergentes.modelo.Productos"%>
<%
Productos reg = (Productos)request.getAttribute("miobper");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de productos</h1>
        <form action="MainServlet"method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="test" name="id" value="<%=reg.getId() %>"size="2" readonly></td>
                    </rt>
                <tr>
                    <td>Productos</td>
                    <td><input type="test" name="productos" value="<%=reg.getProductos() %>"></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="test" name="precio" value="<%=reg.getPrecio() %>"></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="test" name="cantidad" value="<%=reg.getCantidad() %>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>

