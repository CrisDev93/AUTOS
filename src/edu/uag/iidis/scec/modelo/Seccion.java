package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Seccion.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Seccion extends ClaseBase 
        implements Serializable {

    
    private Long idSeccion;
    private Long idTest;
    private String nombre;

    public Seccion() {
    }

    public Seccion(Long id){
        this.idSeccion = id;
    }

    public Seccion(Long idTest,String nombre){
        this.idTest=idTest;
        this.nombre=nombre;
    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.idSeccion;
    }

    public void setId(Long id) {
        this.idSeccion = id;
    }

    // ID Ciudad
    public Long getidTest() {
        return this.idTest;
    }

    public void setidTest(Long id) {
        this.idTest = id;
    }
    /**
     * Regresa el nombres del rol.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


   
}
