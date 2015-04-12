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
public final class FormaCrearTest
        extends ValidatorForm {

    private Collection test;
    private int contador;
    private Long valor;
    private Long[] preguntas=new Long[9];
    private Long[] respuestas=new Long[9];
    private String name;
    private Long idTest;

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
  
    public int getContador() {
        return (this.contador);
    }

    public Long getValor() {
        return (this.valor);
    }

    public void setValor(Long valor) {
         this.valor = valor;
    }

    public Long[] getRespuestas(){
        return this.respuestas;
    }
    public void setRespuestas(Long[] respuestas){
        this.respuestas=respuestas;
    }

    public Long[] getPreguntas(){
        return this.preguntas;
    }
    public void setPreguntas(Long[] preguntas){
        this.preguntas=preguntas;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Long getidTest(){
       return this.idTest;
    }

    public void setidTest(Long idTest){
            this.idTest=idTest;
    }
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        test=null;
        valor=null;
        respuestas=new Long[9];
        preguntas=new Long[9];
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
