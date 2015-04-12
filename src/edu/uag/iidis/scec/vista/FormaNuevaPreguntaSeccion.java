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
public final class FormaNuevaPreguntaSeccion
        extends ValidatorForm {
    private Collection secciones;
    private Collection test;
    private int contador;
    private String seccionBuscar;

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

    public void setSeccionBuscar(String seccionBuscar) {
        this.seccionBuscar = seccionBuscar;
    }

    public String getSeccionBuscar() {
        return (this.seccionBuscar);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        seccionBuscar=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
