/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Clases.Orden_De_TrabajoController;
import Clases.Orden_De_Trabajo;
import Clases.ConexionBaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author selvi
 */
@WebServlet(urlPatterns = {"NewServlet"})
public class NewServlet extends HttpServlet {
    Orden_De_Trabajo orden_de_trabajo;
    Orden_De_TrabajoController registroorden_de_trabajo;
    Orden_De_Trabajo[] orden_de_trabajoRegistrados;     
    private int id_ordenEliminar;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter respuesta = response.getWriter()) {    
            respuesta.write("");
           registroorden_de_trabajo=new Orden_De_TrabajoController();
           String control = request.getParameter("control");
           StringBuffer objetoRespuesta = new StringBuffer();
           if(control.toUpperCase().equals("GUARDAR")){
    //se crea el objeto alumnos con los datos recibidos del navegador a traves de la petición HTTP
               orden_de_trabajo=new Orden_De_Trabajo(
                Integer.parseInt(request.getParameter("id_orden")),
                    request.getParameter("fecha"),
                request.getParameter("cliente"),
                request.getParameter("total"),
                request.getParameter("observaciones"),
                Integer.parseInt(request.getParameter("tipo_orden")));                
                registroorden_de_trabajo.guardarOrden_De_Trabajo(orden_de_trabajo);//almacenarlo en BD                 
           }else if(control.toUpperCase().equals("ELIMINAR")){
               int id_ordenEliminar= Integer.parseInt(request.getParameter("id_orden"));
               registroorden_de_trabajo.eliminarOrden_De_Trabajo(id_ordenEliminar);
           }
                  
           registroorden_de_trabajo.getOrden_de_trabajos(objetoRespuesta);//consultar alumnos en la BD
           respuesta.write(objetoRespuesta.toString());             
                      
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}