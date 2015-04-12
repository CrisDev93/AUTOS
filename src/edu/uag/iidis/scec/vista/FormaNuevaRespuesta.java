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
public final class FormaNuevaRespuesta
        extends ValidatorForm {

    private Collection preguntas;
    private Collection test;
    private int contador;
    private String respuesta;
    private Long idPregunta;
    private boolean correcta;

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


    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return (this.respuesta);
    }


    public void setidPregunta(Long id) {
        this.idPregunta = id;
    }

    public Long getidPregunta() {
        return (this.idPregunta);
    }

    public void setCorrecta(boolean c){
        this.correcta=c;

    }

    public boolean getCorrecta(){
        return this.correcta;
    }
    
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        respuesta=null;
        idPregunta=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
