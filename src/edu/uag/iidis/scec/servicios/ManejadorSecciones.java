package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Seccion;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.SeccionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorSecciones {
    private Log log = LogFactory.getLog(ManejadorRoles.class);
    private SeccionDAO dao;

    public ManejadorSecciones() {
        dao = new SeccionDAO();
    }


    public Collection listarSecciones() {
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

    public Collection buscarSecciones(String seccionBuscar) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">***Buscar Seccion:"+seccionBuscar);
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorNombre(seccionBuscar);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection buscarSeccionesTest(Long seccionBuscar) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">***Buscar Seccion:"+seccionBuscar);
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorTest(seccionBuscar);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarSeccion(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarSeccion(Seccion)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Seccion seccion = dao.buscarPorId(id, true);
            if (seccion != null) {
              dao.hazTransitorio(seccion);
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

    public int crearSeccion(Seccion seccion) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarSeccion(Seccion)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeSeccion(seccion.getNombre())) {
               resultado = 1; // Excepción. El nombre de Seccion ya existe
            } else {

               dao.hazPersistente(seccion);

               resultado = 0; // Exito. El Seccion se creo satisfactoriamente.
            }

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
