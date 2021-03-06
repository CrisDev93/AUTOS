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



public final class MCUListarPersonas 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarListarPersonas(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarPersonas");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoPersonas forma = (FormaListadoPersonas)form;

        ManejadorPersonas mr = new ManejadorPersonas();
        Collection resultado = mr.listarPersonas();

        ManejadorCiudades mr2 = new ManejadorCiudades();
        Collection resultado2 = mr2.listarCiudades();

        forma.setCiudades( resultado2 );

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setPersonas( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurri� un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }

    public ActionForward solicitarOrdNombres(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaListadoPersonasOrdenar forma = (FormaListadoPersonasOrdenar)form;

        ManejadorPersonas mr = new ManejadorPersonas();

        if (log.isDebugEnabled()) {
            log.debug(">var1: "+forma.getOrdenar()+" >var2: "+forma.getTipo());
        }

        Collection resultado = mr.listarPersonasOrd(forma.getOrdenar(), forma.getTipo());

        ManejadorCiudades mr2 = new ManejadorCiudades();
        Collection resultado2 = mr2.listarCiudades();

        forma.setCiudades( resultado2 );

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setPersonas( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurri� un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }
}