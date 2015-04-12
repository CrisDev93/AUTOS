package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaListadoSeccionesOpcion
        extends ValidatorForm {

    private Collection seccion;
    private int contador;
    private Long valor;


    public void setSeccion(Collection seccion) {
        this.seccion = seccion;
        if (seccion != null) {
          this.contador = seccion.size();
        } else
          this.contador = -1;
    }

    public Collection getSeccion() {
        return (this.seccion);
    }
  
    public int getContador() {
        return (this.contador);
    }

    public Long getValor() {
        return (this.valor);
    }

    public void setValor(Long valor) {
         this.valor = valor;
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        valor = null;
        seccion=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
