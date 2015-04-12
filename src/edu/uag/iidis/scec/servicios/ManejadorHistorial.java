package edu.uag.iidis.scec.servicios;

import java.util.Collection;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Historial;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.HistorialDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorHistorial {
    private Log log = LogFactory.getLog(ManejadorRoles.class);
    private HistorialDAO dao;

    public ManejadorHistorial() {
        dao = new HistorialDAO();
    }


    public Collection listarHistorial() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarHistorial(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarHistorial(Historial)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Historial historial = dao.buscarPorId(id, true);
            if (historial != null) {
              dao.hazTransitorio(historial);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearHistorial(ArrayList historiales) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarHistorial(Historial)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
               dao.hazPersistentes(historiales);

               resultado = 0; // Exito. Historial se creo satisfactoriamente.
            

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
