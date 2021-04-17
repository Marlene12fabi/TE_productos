<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Productos"%>
<%
 if(session.getAttribute("listaper")==null){
            ArrayList<Productos>la=new ArrayList<Productos>();
            session.setAttribute("listaper", la);
            } 
ArrayList<Productos>lista = (ArrayList<Productos>)session.getAttribute("listaper");
%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de productos</h1>
        <a href="MainServlet?op=nuevo">Nuevo registro</a>
        <table border="1"></table>
    <tr> 
        <th>Id</th>
        <th>Productos</th>
        <th>Precio</th>
        <th>Cantidad</th>
    </tr>
<%
    if (lista !=null){
        for (Productos item : lista){
%>
<tr>
    <td><%=item.getId() %></td
    <td><%=item.getProductos() %></td>
    <td><%=item.getPrecio() %></td>
    <td><%=item.getCantidad() %></td>
    <td><a href="MainServet?op=editar&id=<%=item.getId() %>">Editar</a></td>
    <td><a href="MainServet?op=eliminar&id=<%=item.getId() %>"
           onclick="return (confirm('Esta seguro de eliminar'))"
           >Eliminar</a></td>
</tr>
<%
    }
}
%>
      </table>
    </body>
</html>
