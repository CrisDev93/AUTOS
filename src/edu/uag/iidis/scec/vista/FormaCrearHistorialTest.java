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
public final class FormaCrearHistorialTest
        extends ValidatorForm {

    private Collection historiatest;
    private int contador;
    private Long valor;


    public void setHistoriatest(Collection historiatest) {
        this.historiatest = historiatest;
        if (historiatest != null) {
          this.contador = historiatest.size();
        } else
          this.contador = -1;
    }

    public Collection getHistoriatest() {
        return (this.historiatest);
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
        historiatest=null;
        valor=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
