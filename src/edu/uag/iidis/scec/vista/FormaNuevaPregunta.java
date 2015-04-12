package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva Pregunta.
 *
 * @author Victor Ramos
 */
public final class FormaNuevaPregunta
        extends ValidatorForm {

    private Collection secciones;
    private Collection test;
    private int contador;
    private String pregunta;
    private Long idSeccion;
    private String  respuestaCorrecta;

    public void setTest(Collection test) {
        this.test = test;
        if (test != null) {
          this.contador = test.size();
        } else
          this.contador = -1;
    }

    public Collection getTest() {
        return (this.test);
    }

      public void setSecciones(Collection secciones) {
        this.secciones = secciones;
        if (secciones != null) {
          this.contador = secciones.size();
        } else
          this.contador = -1;
    }

    public Collection getSecciones() {
        return (this.secciones);
    }


    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return (this.pregunta);
    }


    public void setRespuestaCorrecta(String respuesta) {
        this.respuestaCorrecta = respuesta;
    }

    public String getRespuestaCorrecta() {
        return (this.respuestaCorrecta);
    }


    public void setidSeccion(Long id) {
        this.idSeccion = id;
    }

    public Long getidSeccion() {
        return (this.idSeccion);
    }

    
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        pregunta=null;
        respuestaCorrecta=null;
        idSeccion=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
