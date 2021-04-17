
package com.emergentes.control;

import com.emergentes.modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion=request.getParameter("op");
        Productos objper = new Productos();
        int id,pos;
        HttpSession ses = request.getSession();
        List<Productos> lista =(List<Productos>) ses.getAttribute("listaper");
    
switch (opcion){
    case"nuevo":
       //Enviar objeto a editar
       request.setAttribute("miobper",objper);
       request.getRequestDispatcher("editar.jsp").forward(request,response);
       break;
    case"editar":
    id=Integer.parseInt(request.getParameter("id"));
    //Obtener la posicion del elemento en la coleccion
    pos = buscarPorIndice(request,id);
    //Obtener el objeto
    objper=lista.get(pos);
    //Enviarlo para edicion
    request.setAttribute("miobper",objper);
    request.getRequestDispatcher("editar.jsp").forward(request,response);
    break;
    case"eliminar":
    //Obtener la posicion del elemento en la colleccion
    id=Integer.parseInt(request.getParameter("id"));
    pos = buscarPorIndice(request,id);
    if(pos>=0){
    lista.remove(pos);
   
}
//Actualizamos la lista debido a la eliminacion
     request.setAttribute("listaper",lista);
     response.sendRedirect("index.jsp");
     break;
     
     default:
     request.setAttribute("listaper",lista);
     response.sendRedirect("index.jsp");
    }
}
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          int id=Integer.parseInt(request.getParameter("id"));      
        HttpSession ses = request.getSession();
        ArrayList<Productos>lista =(ArrayList<Productos>)ses.getAttribute("listaper");
        Productos objper = new Productos();
        objper.setId(id);
        objper.setProductos(request.getParameter("productos"));
        objper.setPrecio(Integer.parseInt(request.getParameter("precio")));
        objper.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        System.out.println("El ID es"+id);
        if(id==0){
          //colocar el ID
          int idNuevo=obtenerId(request);
          objper.setId(idNuevo);
          
          lista.add(objper);
          System.out.println(objper.toString());
        }else{
            //edicion
            int pos=buscarPorIndice(request,id);
            lista.set(pos, objper);
            System.out.println(objper.toString());
        }
            System.out.println("Enviando as index");
            request.setAttribute("listaper",lista);
            response.sendRedirect("index.jsp");
        }
        
    private int buscarPorIndice(HttpServletRequest request, int id) {
          HttpSession ses = request.getSession();
          List<Productos> lista =(List<Productos>) ses.getAttribute("listaper");
          
          int pos = -1;
          
          if(lista !=null){
              for(Productos ele : lista){
                  ++pos;
                  if(ele.getId()==id){
                      break;
                  }
              }
          }
          return pos;
      }

    private int obtenerId(HttpServletRequest request) {
       HttpSession ses = request.getSession();
       ArrayList<Productos>lista =(ArrayList<Productos>)ses.getAttribute("listaper");
       //Conteo de Id desde 0
       int idn =0;
       for(Productos ele :lista){
           idn=ele.getId();
       }
       return idn+1;
    }
}
