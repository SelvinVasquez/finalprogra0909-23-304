package Clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author selvi
 */
public class Orden_De_Trabajo {
    private int id_orden;
    private int fecha;
    private String cliente;
    private int total;
    private String observaciones;
    
    public Orden_De_Trabajo(int id_orden, int fecha, String cliente, int total, String observaciones){
        this.id_orden=id_orden;
        this.fecha=fecha;
        this.cliente=cliente;
        this.total=total;
        this.observaciones=observaciones;
    }

    public Orden_De_Trabajo(int parseInt, String parameter, String parameter0, String parameter1, String parameter2, int parseInt0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
