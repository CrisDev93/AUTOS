package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Testgenerado.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Testgenerado extends ClaseBase 
        implements Serializable {

    private Long idp;
    private Long idt;
    private Long idr;
    private String pregunta;
    private String respuesta;

    public Testgenerado() {
    }
    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getIdp() {
        return this.idp;
    }

    public void setIdp(Long id) {
        this.idp = id;
    }

    public Long getIdt() {
        return this.idt;
    }

    public void setIdt(Long id) {
        this.idt = id;
    }
    /**
     * Regresa el nombres del rol.
     * @return String
     */
    public String getPregunta() {
        return this.pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return this.respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    
    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public Long getIdr() {
        return this.idr;
    }
    public void setIdr(Long id) {
        this.idr = id;
    }

   
}
