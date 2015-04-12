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



public final class MCURegistrarPersona 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarRegistroPersona(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaNuevaPersona forma = (FormaNuevaPersona)form;

        ManejadorCiudades mr = new ManejadorCiudades();
        Collection resultado = mr.listarCiudades();

        forma.setCiudades( resultado );

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPersona");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward procesarRegistroPersonaCiudades(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaNuevaPersonaCiudades forma = (FormaNuevaPersonaCiudades)form;

        ManejadorCiudades mr = new ManejadorCiudades();
        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPersonaCiudades: buscando:"+forma.getciudadBuscar());
        }
        Collection resultado = mr.buscarCiudades(forma.getciudadBuscar());


        ManejadorEstados mr2 = new ManejadorEstados();
        Collection resultado2 = mr2.listarEstados();
        if(resultado==null||resultado2==null){
          if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPersonaCiudades:*** resultado nulo");
        }}else{
         if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPersonaCiudades:*** resultado ok");
        }

        }
        forma.setCiudades( resultado );
        forma.setEstados( resultado2 );

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPersonaCiudades");
        }

        return (mapping.findForward("exito"));
    }


    public ActionForward procesarRegistroPersona(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroPersona");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        
        // Se obtienen los datos para procesar el registro
        FormaNuevaPersona forma = (FormaNuevaPersona)form;

        Persona per = new Persona(forma.getNombres(),
                          forma.getApellidos(), forma.getDireccion(), forma.getTelefono(), forma.getidCiudad());

        ManejadorPersonas mr = new ManejadorPersonas();
        int resultado = mr.crearPersona(per);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:   
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombrePersonaYaExiste",
                                               forma.getNombres()));                
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

