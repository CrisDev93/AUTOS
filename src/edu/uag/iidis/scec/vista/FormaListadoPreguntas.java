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
public final class FormaListadoPreguntas
        extends ValidatorForm {

    private Collection secciones;
    private int contador2;
    private Collection preguntas;
    private int contador;

    public void setSecciones(Collection secciones) {
        this.secciones = secciones;
        if (secciones != null) {
          this.contador2 = secciones.size();
        } else
          this.contador2 = -1;
    }

    public Collection getSecciones() {
        return (this.secciones);
    }

    public void setPreguntas(Collection preguntas) {
        this.preguntas = preguntas;
        if (preguntas != null) {
          this.contador = preguntas.size();
        } else
          this.contador = -1;
    }

    public Collection getPreguntas() {
        return (this.preguntas);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        preguntas=null;
        contador2=0;
        secciones=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
