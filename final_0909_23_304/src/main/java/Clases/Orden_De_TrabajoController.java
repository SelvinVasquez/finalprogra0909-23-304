package Clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Orden_De_TrabajoController {
    Orden_De_Trabajo[] tablaorden_de_trabajo;
    int indiceArray;
    private ConexionBaseDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public void abrirConexion(){
        conectorBD= new ConexionBaseDatos();
        conexion=conectorBD.conectar();
    }       
    
    public String guardarAlumno(Orden_De_Trabajo orden_de_trabajo){        
        String sql = "INSERT INTO orden_de_trabajo(id_orden, fecha, cliente, total, observaciones,tipo_orden_id_tipo) ";
             sql += " VALUES(?,?,?,?,?)";              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setInt(1, orden_de_trabajo.getId_orden());
            statement.setInt(2, orden_de_trabajo.getFecha());
            statement.setString(3, orden_de_trabajo.getCliente());
            statement.setInt(4, orden_de_trabajo.getTotal());
            statement.setString(5, orden_de_trabajo.getObservaciones());
                int resultado = statement.executeUpdate(); 
                if(resultado > 0){
                    return String.valueOf(resultado);
                }else{
                    return String.valueOf(resultado);
                }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    public void getAlumnos(StringBuffer respuesta){   
        String sql="SELECT orden_de_trabajo.id_orden, orden_de_trabajo.fecha, orden_de_trabajo.cliente, orden_de_trabajo.total, orden_de_trabajo.observaciones, tipo_orden.descripcion FROM orden_de_trabajo, tipo_orden WHERE orden_de_trabajo.tipo_orden_id_orden=tipo_orden.id_orden ORDER BY nombre asc";
        try{
        abrirConexion();
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if(result!=null){
                while (result.next()){
                respuesta.append("<tr>");//crear la fila y la etique td son las columnas
                respuesta.append("<td >").append(result.getString("id_orden")).append("</td>");
                respuesta.append("<td >").append(result.getString("fecha")).append("</td>");
                respuesta.append("<td >").append(result.getString("cliente")).append("</td>");
                respuesta.append("<td >").append(result.getString("total")).append("</td>");
                respuesta.append("<td >").append(result.getString("observaciones")).append("</td>");
                respuesta.append("<td >").append(result.getString("descripcion")).append("</td>");
                respuesta.append("<td id=\"").append(result.getString("id_orden"))
                        .append("\"  onclick=\"eliminarorden_de_trabajo(this.id);\">")
                        .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                +" <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }           
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public String eliminarOrden_De_Trabajo(int id_orden){        
        String sql = "DELETE FROM alumno WHERE id_orden="+id_orden;              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    // *** FUNCIONALIDAD PARA TRABAJAR CON ARRAYS ***
    public Orden_De_TrabajoController(){// Construcctor para trabar con arrays
        this.tablaorden_de_trabajo = new Orden_De_Trabajo[10];
        this.indiceArray=0;
    }
    
     public void guardarOrden_De_TrabajoEnArray(Orden_De_Trabajo orden_de_trabajo){
        this.tablaorden_de_trabajo[this.indiceArray]=orden_de_trabajo;  
        this.indiceArray=this.indiceArray+1;
        // procedimiento para almacenar en la Base de Datos
    }
    
    public Orden_De_Trabajo[] getOrden_De_TrabajoFromArray(){
        return this.tablaorden_de_trabajo;
    }

    public void guardarOrden_De_Trabajo(Orden_De_Trabajo orden_de_trabajo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void getOrden_de_trabajos(StringBuffer objetoRespuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}