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
public final class FormaListadoPersonas
        extends ValidatorForm {

    private Collection ciudades;
    private int contador2;
    private Collection personas;
    private int contador;

    public void setCiudades(Collection ciudades) {
        this.ciudades = ciudades;
        if (ciudades != null) {
          this.contador2 = ciudades.size();
        } else
          this.contador2 = -1;
    }

    public Collection getCiudades() {
        return (this.ciudades);
    }

    public void setPersonas(Collection personas) {
        this.personas = personas;
        if (personas != null) {
          this.contador = personas.size();
        } else
          this.contador = -1;
    }

    public Collection getPersonas() {
        return (this.personas);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        personas=null;
        contador2=0;
        ciudades=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
