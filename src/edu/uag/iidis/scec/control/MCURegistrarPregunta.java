package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;



public final class MCURegistrarPregunta 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarRegistroPregunta(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaNuevaPregunta forma = (FormaNuevaPregunta)form;

        //ManejadorSecciones mr = new ManejadorSecciones();
       // Collection resultado = mr.listarSecciones();
        ManejadorTest mr2 = new ManejadorTest();
        Collection resultado2 = mr2.listarTest();

       // forma.setSeccion( resultado );
        forma.setTest(resultado2);
        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPregunta");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward procesarRegistroPreguntaSecciones(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaNuevaPreguntaSeccion forma = (FormaNuevaPreguntaSeccion)form;

        ManejadorSecciones mr = new ManejadorSecciones();
        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPreguntaSecciones: buscando:"+forma.getSeccionBuscar());
        }
        Collection resultado = mr.buscarSecciones(forma.getSeccionBuscar());


        ManejadorTest mr2 = new ManejadorTest();
        Collection resultado2 = mr2.listarTest();
        if(resultado==null||resultado2==null){
          if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPreguntaSecciones:*** resultado nulo");
        }}else{
         if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPreguntaSecciones:*** resultado ok");
        }

        }
        forma.setSecciones( resultado );
        forma.setTest( resultado2 );

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPreguntaSecciones");
        }

        return (mapping.findForward("exito"));
    }


    public ActionForward procesarRegistroPregunta(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroPregunta");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        
        // Se obtienen los datos para procesar el registro
        FormaNuevaPregunta forma = (FormaNuevaPregunta)form;
        Long aux=new Long("000");
        if(forma.getidSeccion()==null||forma.getPregunta()==null){
            log.debug("Nueva Pregunta:***Nulo");
        }else{log.debug("Nueva Pregunta:***OK");}
        Pregunta pregunta = new Pregunta(forma.getidSeccion(),aux,forma.getPregunta());

        ManejadorPreguntas mr = new ManejadorPreguntas();
        int resultado = mr.crearPregunta(pregunta);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:   
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.PreguntaYaExiste",
                                               forma.getPregunta()));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}

